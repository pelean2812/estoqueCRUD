package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entidades.Produto;
import jpaUtil.JPAUtil;

public class ProdutoDAO {
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	public void cadastrarDao(Produto p) {
		em.getTransaction().begin();	
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Produto> retornaProdutosDao(){
		em.getTransaction().begin();
		List<Produto> retorno = em.createQuery("from Produto").getResultList();
		em.getTransaction().commit();
		
		return retorno;
	}
	
	public Produto buscaIDDao(Long id) {		
		Produto prod = new Produto();
		prod = em.find(Produto.class, id);
		return prod;
	}
	
	public void editarDao(Produto p) {
		em.getTransaction().begin();
		em.merge(p);
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
