/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eoh.test.eohejb;

import eoh.test.cicjpa.Entity;
import eoh.test.cicjpa.Cic;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author henry
 */
@Stateless
@LocalBean
public class CicBean {

    @PersistenceContext(name = "CicJPA")
    EntityManager em;
    
    static final Logger log = Logger.getLogger("eoh.test.eohejb.CicBean");

    public Cic getCic(Long id) {
        if (id == null || id == 0) {
            return null;
        }

        Query rs = em.createQuery("Select c FROM Cic c WHERE c.id =:id ");
        rs.setParameter("id", id);

        Cic cic = null;

        try {
            cic = (Cic) rs.getSingleResult();
        } catch (Exception e) {}

        return cic;
    }

    public Cic addCic(Cic cic) {
        if (cic == null) {
            return null;
        }

        if (cic.getEntity() != null && cic.getEntity().getEmail() != null) {

            Query rs = em.createQuery("Select e FROM Entity e WHERE e.email = :email ");
            rs.setParameter("email", cic.getEntity().getEmail());

            try {
                Entity entity = (Entity) rs.getSingleResult();
                cic.setEntity(entity);
            } catch (Exception e) {}
        } else {
            return null;
        }

        try {
            em.persist(cic);
            em.flush();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }

        return cic;
    }

}
