/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.controllers;

import br.com.juniordev.gerfina.jpa.PessoaDao;
import br.com.juniordev.gerfina.models.Pessoa;
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
public class PessoaBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(PessoaBean.class.getName());
    private static final long serialVersionUID = 8279593110100662524L;

    @Inject
    private PessoaDao pessoaDao;
    private Pessoa pessoa;


    public PessoaBean() {
        novaPessoa();
    }

    public void novaPessoa() {
        this.pessoa = new Pessoa();
    }

    public void salvar() {
    }

    public Pessoa salvarComRetorno() {
        try {
            if (pessoa.getId() != null) {
                // atualizar
            } else {
                pessoaDao.create(pessoa);
            }
            return pessoa;
        } catch (Exception e) {
            LOG.severe("Erro ao tentar salvar pessoa.");
        }
        
        return null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
