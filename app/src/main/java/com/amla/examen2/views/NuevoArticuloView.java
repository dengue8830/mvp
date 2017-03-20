package com.amla.examen2.views;

public interface NuevoArticuloView {
    void mostrarErrorPrecioVacio();
    void mostrarErrorPrecioInvalido();
    void mostrarErrorSoloDosDecimales();
    void mostrarErrorPrecioNegativo();
    void mostrarErrorPrecioCero();
    void mostrarErrorNombreVacio();
    void articuloCreado();
    void errorAlCrearArticulo();
}
