/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.jpa;

import br.com.juniordev.gerfina.models.Conta;
import br.com.juniordev.gerfina.models.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author junior
 */

public class ContaDao extends Dao<Conta> implements Serializable{

    private static final long serialVersionUID = 8708676186985558293L;

    @PersistenceContext(unitName = "APP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContaDao() {
        super(Conta.class);
    }
 
    public List<Conta> listarContasOrderAsc(){
        TypedQuery<Conta> query = em.createQuery("From Conta c order by c.descricao", Conta.class);
        return query.getResultList();
    }
    
}
