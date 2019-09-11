package facades;

import entities.Students;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class StudentsFacade {

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
    
//    @Override
    public long getStudentCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(s) FROM Students s").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }

//    @Override
    public List<Students> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Students.getAll").getResultList();
    }

//    @Override
    public List<Students> getStudentsByName(String name) {
       EntityManager em = emf.createEntityManager();
        TypedQuery<Students> tq = em.createNamedQuery("Students.getByName", Students.class);
        tq.setParameter("name", "%" + name + "%");
        return tq.getResultList();
    }

//    @Override
    public Students getStudentsById(long id) {
       EntityManager em = emf.createEntityManager();
       return em.find(Students.class, id);
    }

//    @Override
    public List<Students> getStudentsByColor(String color) {
       EntityManager em = emf.createEntityManager();
        TypedQuery<Students> tq = em.createNamedQuery("Students.getByColor", Students.class);
        tq.setParameter("color", "%" + color + "%");
        return tq.getResultList();
    }
    
    ///////////////
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
    
//    public int count() {
//        return allStudents().size();
//    }
    
    public void populate(){
        addStudents(new Students(1, "Jens", "rød"));
        addStudents(new Students(2, "Hans", "rød"));
        addStudents(new Students(3, "Bent", "rød"));
        addStudents(new Students(4, "Boerge", "rød"));
    }
    
    
    public static void main(String[] args) {
        StudentsFacade sf = getStudentsFacade(EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE));
        sf.populate();
        
        List<Students> students = sf.getAllStudents();
        System.out.println(students);
    }

}
