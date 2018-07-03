/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.controllers;

import br.com.juniordev.gerfina.jpa.ContaDao;
import br.com.juniordev.gerfina.models.Conta;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author junior
 */
@Named
@ViewScoped
public class ContaBean implements Serializable {

    private static final long serialVersionUID = 5144664774739798452L;
    private static final Logger LOG = Logger.getLogger(ContaBean.class.getName());

    @Inject
    private ContaDao contaDao;

    private Conta conta;

    public ContaBean() {
        novaConta();
    }

    public void novaConta() {
        this.conta = new Conta();
    }

    public void salvar() {
    }

    public Conta salvarComRetorno() {
        try {
            if (conta.getId() != null) {
                // atualizar
            } else {
                contaDao.create(conta);
            }
            return conta;
        } catch (Exception e) {
            LOG.severe("Erro ao tentar salvar conta.");
        }
        
        return null;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
