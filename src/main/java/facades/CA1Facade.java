package facades;

import entities.CA1;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CA1Facade {

    private static CA1Facade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private CA1Facade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CA1Facade getCA1Facade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CA1Facade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getRenameMeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(c) FROM CA1 c").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }

}
