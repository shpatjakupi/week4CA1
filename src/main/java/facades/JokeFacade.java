/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Joke;
import DTO.JokeDTO;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Younes
 */
public class JokeFacade implements IjokesFacade {
    
    private static JokeFacade instance;
    private static EntityManagerFactory emf;
    
    private JokeFacade(){}
    
    
    public static JokeFacade getJokeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    @Override
    public List<JokeDTO> getAllJokes() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("JokeDTO.getAll").getResultList();
    }

    @Override
    public JokeDTO getJokeById(int id) {
        EntityManager em = emf.createEntityManager();
        return new JokeDTO (em.find(Joke.class, id));
    }

    @Override
    public List<JokeDTO> getJokeByReference(String reference) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<JokeDTO> tq = em.createNamedQuery("JokeDTO.getByReference", JokeDTO.class);
        tq.setParameter("reference", "%" + reference + "%");
        return tq.getResultList();
    }

    @Override
    public List <JokeDTO> getJokeByType(String type) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<JokeDTO> tq = em.createNamedQuery("Joke.getByType", JokeDTO.class);
        tq.setParameter("type", "%" + type + "%");
        return tq.getResultList();
    }

    @Override
    public JokeDTO getRandomJoke() {
        List<JokeDTO> jokeList = getAllJokes();
        Random rand = new Random();
        return jokeList.get(rand.nextInt(jokeList.size()));
    }
    
    @Override
    public Joke addJoke(Joke joke){
        try {
            EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(joke);
                em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } return joke;
    }
    
    
        @Override
    public void populateJokes() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            em.persist(new Joke(1, "Today at the bank, an old lady asked me to help check her balance. So I pushed her over.", "pun.me", "Old lady"));
            em.persist(new Joke(2, "My boss told me to have a good day.. so I went home.", "pun.me", "Boss"));
            em.persist(new Joke(3, "The other day, my wife asked me to pass her lipstick but I accidentally passed her a glue stick. She still isn't talking to me.", "pun.me", "Wife"));
            em.persist(new Joke(4, "What do you call a guy with a rubber toe? Roberto.", "pun.me", "Words"));
            em.persist(new Joke(5, "I lost some weight last month. But now it found me again. ", "short-funny.com", "Dad"));
            em.persist(new Joke(6, "I tell you what always catches my eye. Short people with an umbrella.", "short-funny.com", "Quotes"));
            em.persist(new Joke(7, "Wouldn’t exercise be more fun if calories screamed while you burned them?", "short-funny.com", "Quotes"));
            em.persist(new Joke(8, "Always borrow money from a pessimist. He won’t expect it back.", "short-funny.com", "Quotes"));
            em.persist(new Joke(9, "If I promise to miss you, will you go, like, really far away?", "thoughtcatalog.com", "Sarcasm"));
            em.persist(new Joke(10, "Hear that? It’s the sound of you not talking for once.", "thoughtcatalog.com", "Sarcasm"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    
}
