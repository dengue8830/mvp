package com.amla.examen2.model.service;

import com.amla.examen2.model.dao.EmpleadoDao;
import com.amla.examen2.model.dao.impl.EmpleadoDaoImpl;
import com.amla.examen2.model.vo.Empleado;

public class EmpleadoService {
    protected EmpleadoDao empleadoDao;

    public EmpleadoService(){
        empleadoDao = new EmpleadoDaoImpl();
    }

    public Empleado getEmpleadoLogueado(){
        return empleadoDao.getEmpleadoLogueado();
    }
}
