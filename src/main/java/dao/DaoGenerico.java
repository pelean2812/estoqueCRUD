package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entidades.Produto;
import jpaUtil.JPAUtil;

public class DaoGenerico<E> {
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	public void cadastrarDao(E entidade) {
		em.getTransaction().begin();	
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<E> retornaProdutosDao(E entidade){
		em.getTransaction().begin();
		List<E> retorno = em.createQuery("from "+ entidade.getClass().getName()).getResultList();
		em.getTransaction().commit();
		
		return retorno;
	}
	
	public Produto buscaIDDao(Long id) {		
		Produto prod = new Produto();
		prod = em.find(Produto.class, id);
		return prod;
	}
	
	public void editarDao(E entidade) {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
	}
	
	public void removerDao(Long id) {
		Produto prod = new Produto();
		prod = em.find(Produto.class, id);
		
		em.getTransaction().begin();
		em.remove(prod);
		em.getTransaction().commit();
	}
}
