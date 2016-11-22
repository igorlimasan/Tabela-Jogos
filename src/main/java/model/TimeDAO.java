package model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TimeDAO {
	ConectionFactory conectionFactory = new ConectionFactory();
	private EntityManager manager ;
	
	/**
	 * Método insere um objeto ou atualiza caso ele já exista
	 * @param Time time
	 * @return Long id
	 */
	
	public Long salvar(Time time)
	{
		manager = conectionFactory.getEntityManager();
		try{
			
		
			manager.getTransaction().begin();
			if(time.getId() == null) manager.persist(time);
			else time = manager.merge(time);
			manager.getTransaction().commit();
			System.out.println("Id do Time: "+ time.getId());
		}
		finally {
			manager.close();
		}
		
		
		
		return time.getId();
	}
	
	public Time buscarTimePorId(Long id)
	{
		manager = conectionFactory.getEntityManager();
		manager.getTransaction().begin();
		Time time = null;
		
		time = manager.find(Time.class, id);
		manager.close();
		
		return time;
		
	}

}
