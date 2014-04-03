/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Diplome;
import bean.Emploiprecedent;
import bean.Employe;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sara
 */
@Stateless
@LocalBean
public class EmployeFacade extends AbstractFacade<Employe> implements EmployeFacadeLocal {
    @PersistenceContext(unitName = "testEGRH-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeFacade() {
        super(Employe.class);
    }
    
    @Override
    public List<Emploiprecedent> loadEmploiPrecedents(Employe e){
        Query q=em.createQuery("SELECT  e FROM Emploiprecedent e WHERE e.employe.id="+e.getId());
        return q.getResultList();
        
    }
     @Override
    public List<Diplome> loadDiplomes(Employe e){
        Query q=em.createQuery("SELECT  d FROM Diplome d WHERE d.employe.id="+e.getId());
        return q.getResultList();
        
    }
}
