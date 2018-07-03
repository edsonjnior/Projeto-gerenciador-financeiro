/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.enums;

/**
 *
 * @author junior
 */
public enum PeriodosRepetir {
    SEMANAL("Semanal", 7),
    QUINZENAL("Quinzenal", 15),
    MENSAL("Mensal", 30);
    
    
    private final String descricao;
    private final Integer dias;

    private PeriodosRepetir(String descricao, Integer dias) {
        this.descricao = descricao;
        this.dias = dias;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getDias() {
        return dias;
    }
    
}
