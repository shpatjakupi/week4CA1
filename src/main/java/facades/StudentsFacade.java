package facades;

import entities.Students;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class StudentsFacade implements IstudentsFacade{

    private static StudentsFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private StudentsFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static StudentsFacade getCA1Facade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StudentsFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    @Override
    public long getStudentCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(s) FROM Students s").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }

    @Override
    public List<Students> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Students.getAll").getResultList();
    }

    @Override
    public List<Students> getStudentsByName(String name) {
       EntityManager em = emf.createEntityManager();
        TypedQuery<Students> tq = em.createNamedQuery("Students.getByName", Students.class);
        tq.setParameter("name", "%" + name + "%");
        return tq.getResultList();
    }

    @Override
    public Students getStudentsById(long id) {
       EntityManager em = emf.createEntityManager();
       return em.find(Students.class, id);
    }

    @Override
    public List<Students> getStudentsByColor(String color) {
       EntityManager em = emf.createEntityManager();
        TypedQuery<Students> tq = em.createNamedQuery("Students.getByColor", Students.class);
        tq.setParameter("color", "%" + color + "%");
        return tq.getResultList();
    }

}
