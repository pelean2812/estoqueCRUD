package managedBean;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.ProdutoDAO;
import entidades.Produto;

@RequestScoped
@ManagedBean(name = "produtoBean")
public class ProdutoBean {

	private Produto p = new Produto();
	private ProdutoDAO dg = new ProdutoDAO();
	
	public String cadastrar() {
		dg.cadastrarDao(p);
		p = new Produto();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MENSAGEM: ", "Produto cadastrado com sucesso!"));
		
		return "";
	}
	
	public List<Produto> mostrarProdutos(){
		return dg.retornaProdutosDao();
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
	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MENSAGEM: ", "Produto atualizado com sucesso!"));
		
		return "/faces/index.xhtml";
	}
	
	public String remover(Long id) {
		dg.removerDao(id);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MENSAGEM: ", "Produto removido com sucesso!"));
		
		return "/faces/index.xhtml";
	}
	
	public Produto getP() {
		return p;
	}
	public void setP(Produto p) {
		this.p = p;
	}
	
	public ProdutoDAO getDg() {
		return dg;
	}
	public void setDg(ProdutoDAO dg) {
		this.dg = dg;
	}
	
}