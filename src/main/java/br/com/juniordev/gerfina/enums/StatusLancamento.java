/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.enums;

import javax.persistence.Enumerated;

/**
 *
 * @author junior
 */

public enum StatusLancamento {
    PAGO("Pago"),
    ABERTO("Em aberto");
    
    private String descricao;

    private StatusLancamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
