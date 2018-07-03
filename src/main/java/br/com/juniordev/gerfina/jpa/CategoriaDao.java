/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.jpa;

import br.com.juniordev.gerfina.models.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author junior
 */

public class CategoriaDao extends Dao<Categoria> implements Serializable{

    private static final long serialVersionUID = 8708676186985558293L;

    @PersistenceContext(unitName = "APP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaDao() {
        super(Categoria.class);
    }
 
    public List<Categoria> listarCategoriasOrderAsc(){
        TypedQuery<Categoria> query = em.createQuery("From Categoria c order by c.descricao", Categoria.class);
        return query.getResultList();
    }
}
