package com.adorno.modelo.populaters;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.adorno.modelo.Maquina;
import com.adorno.modelo.ModeloSlot;
import com.adorno.modelo.Periodo;
import com.adorno.modelo.Programa;
import com.adorno.modelo.om.ObjectMother;
import com.adorno.modelo.repositories.MaquinaRepository;
import com.adorno.modelo.repositories.ModeloSlotRepository;
import com.adorno.modelo.repositories.PeriodoRepository;
import com.adorno.modelo.repositories.ProgramaRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class Populate {
	ObjectMother om = new ObjectMother();
	@Autowired
	ProgramaRepository programaRepository;
	@Autowired
	ModeloSlotRepository modeloSlotRepository;
	@Autowired
	MaquinaRepository maquinaRepository;
	@Autowired
	PeriodoRepository periodoRepository;
	
	
	@PostConstruct
	public void populate() {
		List<Programa> crearListaProgramas = om.crearListaProgramas();
		programaRepository.saveAll(crearListaProgramas);
		List<ModeloSlot> crearListaModelosSlot = om.crearListaModelosSlot();
		modeloSlotRepository.saveAll(crearListaModelosSlot);
		List<Maquina> crearListaMaquinas = om.crearListaMaquinas();
		maquinaRepository.saveAll(crearListaMaquinas);
		List<Maquina> maquinas = maquinaRepository.findAll();
		Maquina maquina = maquinas.get(0);
		List<Programa> programas = programaRepository.findAll();
		Periodo periodo = om.crearPeriodo(LocalDate.now(),programas.get(0),maquina);
		periodoRepository.save(periodo);
		maquina.addPeriodo(periodo,1000l,400l)
			.ifPresent(periodo2 
					-> periodoRepository.save(periodo2));
		maquinaRepository.save(maquina);
		//
		Periodo periododos = om.crearPeriodo(LocalDate.now(),programas.get(0),maquina);
		periodoRepository.save(periododos);
		maquina.addPeriodo(periododos,2000l,100l)
		.ifPresent(periodo2 
				-> periodoRepository.save(periodo2));
		maquinaRepository.save(maquina);
	}
}
