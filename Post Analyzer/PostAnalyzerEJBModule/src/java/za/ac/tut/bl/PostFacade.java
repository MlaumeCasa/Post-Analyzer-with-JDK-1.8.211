/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import org.ac.tut.ai.AI;
import za.ac.tut.entities.Post;
//import org.ac.tut.ai.AI;

/**
 *
 * @author Tk
 */
@Stateless
public class PostFacade extends AbstractFacade<Post> implements PostFacadeLocal {

    @PersistenceContext(unitName = "PostAnalyzerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }
}