package com.adorno.modelo.om;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.adorno.modelo.FechaFin;
import com.adorno.modelo.Maquina;
import com.adorno.modelo.ModeloSlot;
import com.adorno.modelo.Periodo;
import com.adorno.modelo.Programa;
import com.adorno.modelo.TipoHardware;

public class ObjectMother {

    public static Maquina crearMaquina(String codigoReferencia, LocalDate fechaCreacion, TipoHardware tipoHardware) {
        return new Maquina(codigoReferencia, fechaCreacion, tipoHardware);
    }

    public static ModeloSlot crearModeloSlot(String nombre, TipoHardware tipoHardware) {
        return new ModeloSlot(nombre, tipoHardware);
    }

    public static Periodo crearPeriodo(LocalDate fechaInicio,Programa programa, Maquina maquina) {
        Periodo periodo = new Periodo(fechaInicio, programa,maquina);
        return periodo;
    }

    public static Programa crearPrograma(String nombre, int porcentajePremiosMaximo) {
        return new Programa(nombre, porcentajePremiosMaximo);
    }

    public static List<Maquina> crearListaMaquinas() {
        List<Maquina> maquinas = new ArrayList<>();
        maquinas.add(crearMaquina("REF00000001", LocalDate.of(2023, 1, 15), TipoHardware.A));
        maquinas.add(crearMaquina("REF00000002", LocalDate.of(2023, 3, 20), TipoHardware.B));
        maquinas.add(crearMaquina("REF00000003", LocalDate.of(2023, 5, 10), TipoHardware.C));
        return maquinas;
    }

    public static List<ModeloSlot> crearListaModelosSlot() {
        List<ModeloSlot> modelos = new ArrayList<>();
        modelos.add(crearModeloSlot("SlotA1", TipoHardware.A));
        modelos.add(crearModeloSlot("SlotB2", TipoHardware.B));
        modelos.add(crearModeloSlot("SlotC3", TipoHardware.C));
        return modelos;
    }

    public static List<Periodo> crearListaPeriodos(Programa programa,Maquina maquina) {
        List<Periodo> periodos = new ArrayList<>();
        periodos.add(crearPeriodo(LocalDate.of(2023, 1, 1), programa,maquina));
        periodos.add(crearPeriodo(LocalDate.of(2023, 2, 1), programa,maquina));
        periodos.add(crearPeriodo(LocalDate.of(2023, 3, 1),  programa,maquina));
        return periodos;
    }

    public static List<Programa> crearListaProgramas() {
        List<Programa> programas = new ArrayList<>();
        programas.add(crearPrograma("Programa1", 25));
        programas.add(crearPrograma("Programa2", 30));
        programas.add(crearPrograma("Programa3", 35));
        return programas;
    }

    public static Maquina crearMaquinaConHistorico(String codigoReferencia, LocalDate fechaCreacion, TipoHardware tipoHardware) {
        Maquina maquina = new Maquina(codigoReferencia,fechaCreacion,tipoHardware);
        List<Periodo> periodos = crearListaPeriodos(crearPrograma("Programa1", 25),maquina);
        maquina.setHistorico(periodos);
        return maquina;
    }

}