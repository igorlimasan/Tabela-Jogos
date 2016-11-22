package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class ConectionFactory {
	@PersistenceUnit
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
