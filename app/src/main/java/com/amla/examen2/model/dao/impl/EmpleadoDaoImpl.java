package com.amla.examen2.model.dao.impl;

import com.amla.examen2.model.dao.EmpleadoDao;
import com.amla.examen2.model.db.BD;
import com.amla.examen2.model.vo.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao {
    @Override
    public Empleado getEmpleadoLogueado(){
        return BD.getEmpleadoLogueado();
    }
}
