package com.amla.examen2.model.service;

import com.amla.examen2.model.vo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private static List<Cliente> clientes;

    static {
        clientes = new ArrayList<>();
        clientes.add(new Cliente(clientes.size()+1, "Carrefour Bs As", "Bs As - Avellaneda 54"));
        clientes.add(new Cliente(clientes.size()+1, "Hiper Comodir", "Jujuy - Monteagudo 1326"));
    }

    //TODO: no deben ser estaticos, usar inyeccion de dependencias
    public static List<Cliente> getClientes(){
        return clientes;
    }

    public static void addCliente(String nombre, String direccion) {
        clientes.add(new Cliente(clientes.size()+1, nombre, direccion));
    }
}
