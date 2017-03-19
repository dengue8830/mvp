package com.amla.examen2.model.service;

import com.amla.examen2.model.vo.Empleado;

public class EmpleadoService {

    private static Empleado empleadoLogueado = new Empleado(1, "David", "Rearte");

    public static Empleado getEmpleadoLogueado(){
        return empleadoLogueado;
    }
}
