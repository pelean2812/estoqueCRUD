package managedBean;

import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import dao.DaoGenerico;
import entidades.Produto;

@RequestScoped
@ManagedBean(name = "produtoBean")
public class ProdutoBean {

	private Produto p = new Produto();
	private DaoGenerico<Produto> dg = new DaoGenerico<Produto>();
	
	public String cadastrar() {
		dg.cadastrarDao(p);
		p = new Produto();
		return "";
	}
	
	public List<Produto> mostrarProdutos(){
		return dg.retornaProdutosDao(p);
	}
	
	public String editar(Long id) {
		Produto prod = new Produto();
		prod = dg.buscaIDDao(id);
		
		Map<String, Object> mapaSessao = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		mapaSessao.put("produto", prod);
		
		return "/faces/telaEdit.xhtml";
	}
	
	public String atualizar(Produto prod) {
		dg.editarDao(prod);
		return "/faces/index.xhtml";
	}
	
	public String remover(Long id) {
		dg.removerDao(id);
		
		return "/faces/index.xhtml";
	}
	
	public Produto getP() {
		return p;
	}
	public void setP(Produto p) {
		this.p = p;
	}
	
	public DaoGenerico<Produto> getDg() {
		return dg;
	}
	public void setDg(DaoGenerico<Produto> dg) {
		this.dg = dg;
	}
	
}