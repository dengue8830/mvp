package com.amla.examen2.dto;

/**
 * Created by dengue8830 on 3/17/17.
 */

public class DatePickerDTO {
    private int diaDelMes;
    private int mesDelAno;
    private int ano;

    public DatePickerDTO(int diaDelMes, int mesDelAno, int ano) {
        this.diaDelMes = diaDelMes;
        this.mesDelAno = mesDelAno;
        this.ano = ano;
    }

    public int getDiaDelMes() {
        return diaDelMes;
    }

    public void setDiaDelMes(int diaDelMes) {
        this.diaDelMes = diaDelMes;
    }

    public int getMesDelAno() {
        return mesDelAno;
    }

    public void setMesDelAno(int mesDelAno) {
        this.mesDelAno = mesDelAno;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
