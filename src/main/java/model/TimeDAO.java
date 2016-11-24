package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	public List<Time> todosTimes(){
		manager = conectionFactory.getEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Time> query = manager.createQuery("from Time t",Time.class);
		return query.getResultList();
	}
	
	public StringBuilder nomesTimes (){
		StringBuilder sb = new StringBuilder();
		List<Time> times = todosTimes();
		for (Time t : times){
			System.out.println(t.getNome());
			sb.append(t.getNome());
			sb.append(" ");
		}
		System.out.println("Times totais "+sb.toString());
		return sb;
		
		
	}

}
