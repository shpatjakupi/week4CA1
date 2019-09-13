/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Joke;
import entities.Students;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Younes
 */
public class JokesFacade implements IjokesFacade {
    
    private static JokesFacade instance;
    private static EntityManagerFactory emf;
    
    private JokesFacade(){}
    
    
    public static JokesFacade getCA1Facade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokesFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Joke> getAllJokes() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Jokes.getAll").getResultList();
    }

    @Override
    public Joke getJokeById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Joke.class, id);
    }

    @Override
    public List<Joke> getJokeByReference(String reference) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Joke> tq = em.createNamedQuery("Joke.getByReference", Joke.class);
        tq.setParameter("reference", "%" + reference + "%");
        return tq.getResultList();
    }

    @Override
    public List<Joke> getJokeByType(String type) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Joke> tq = em.createNamedQuery("Joke.getByType", Joke.class);
        tq.setParameter("type", "%" + type + "%");
        return tq.getResultList();
    }

    @Override
    public Joke getRandomJoke() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
