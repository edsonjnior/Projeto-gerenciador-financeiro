/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.controllers;

import br.com.juniordev.gerfina.jpa.CategoriaDao;
import br.com.juniordev.gerfina.models.Categoria;
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
public class CategoriaBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(CategoriaBean.class.getName());
    private static final long serialVersionUID = 9072714338380390190L;

    @Inject
    private CategoriaDao categoriaDao;
    private Categoria categoria;


    public CategoriaBean() {
        novaCategoria();
    }

    public void novaCategoria() {
        this.categoria = new Categoria();
    }

    public void salvar() {
    }

    public Categoria salvarComRetorno() {
        try {
            if (categoria.getId() != null) {
                // atualizar
            } else {
                categoriaDao.create(categoria);
            }
            return categoria;
        } catch (Exception e) {
            LOG.severe("Erro ao tentar salvar categoria.");
        }
        
        return null;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
