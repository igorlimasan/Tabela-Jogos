package model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JogoDAO {
	
	private ConectionFactory conectionFactory = new ConectionFactory();
	private EntityManager manager;
	/**
	 * Método insere um objeto ou atualiza caso ele já exista
	 * @param jogo
	 * @return Long id
	 */
	
	public Long salvar(Jogo jogo)
	{
		manager = conectionFactory.getEntityManager();
		manager.getTransaction().begin();
		if(jogo.getId() == null) manager.persist(jogo);
		else jogo = manager.merge(jogo);
		manager.getTransaction().commit();
		System.out.println("Id do Jogo: "+ jogo.getId());
		manager.close();
		
		return jogo.getId();
	}
	
	public Jogo buscarJogoPorId(Long id)
	{
		manager = conectionFactory.getEntityManager();
		Jogo jogo = null;
		manager.getTransaction().begin();
		jogo = manager.find(Jogo.class, id);
		manager.close();
		
		return jogo;
		
	}

}
