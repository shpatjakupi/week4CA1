package facades;

import entities.Students;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

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
    public static StudentsFacade getStudentsFacade(EntityManagerFactory _emf) {
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
    public Students getStudentsById(int id) {
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
   @Override 
   public Students addStudents(Students student){
        try {
            EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(student);
                em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } return student;
    }
    
     @Override
    public void populateStudents() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Students.deleteAllRows").executeUpdate();
            em.persist(new Students(1, "bro", "farveblind"));
            em.persist(new Students(2, "janss", "gennemsigtig"));
            em.persist(new Students(3, "jens", "sort"));
            em.persist(new Students(4, "ole", "rød"));
            em.persist(new Students(5, "bo", "gul"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
 

}
