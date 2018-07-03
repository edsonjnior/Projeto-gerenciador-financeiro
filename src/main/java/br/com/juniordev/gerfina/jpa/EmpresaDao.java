/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.jpa;

import br.com.juniordev.gerfina.models.Empresa;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author junior
 */

public class EmpresaDao extends Dao<Empresa> implements Serializable {

    private static final long serialVersionUID = 5877490274861534730L;


    @PersistenceContext(unitName = "APP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaDao() {
        super(Empresa.class);
    }
    
}
