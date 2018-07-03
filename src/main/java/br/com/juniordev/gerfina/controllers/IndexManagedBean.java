/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.controllers;

import br.com.juniordev.gerfina.jpa.PessoaDao;
import br.com.juniordev.gerfina.models.Endereco;
import br.com.juniordev.gerfina.models.Pessoa;
import br.com.juniordev.gerfina.models.Telefone;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author junior
 */
@Named(value = "indexMB")
@ViewScoped
public class IndexManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PessoaDao pessoaDao;
    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> todasPessoas;
    private Endereco endereco;
    private Telefone telefone;
    private Date data;

    public IndexManagedBean() {
        endereco = new Endereco();
        telefone = new Telefone();
    }

    @PostConstruct
    public void init() {
        todasPessoas = pessoaDao.findAll();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getTodasPessoas() {
        return todasPessoas;
    }

    public void setTodasPessoas(List<Pessoa> todasPessoas) {
        this.todasPessoas = todasPessoas;
    }

    public void adicionarNumeroPessoa() {
        telefone.setPessoa(pessoa);
        pessoa.getTelefones().add(telefone);

        telefone = new Telefone();
    }

    public void salvar() {
        try {
            pessoaDao.create(pessoa);
        } catch (Exception ex) {
            Logger.getLogger(IndexManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void fool() {
        Arrays.asList();
        Integer[] a = new Integer[]{1, 2, 3};
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void testeData() {
        if (data != null) {
            System.out.println(data);
        }
    }

}
