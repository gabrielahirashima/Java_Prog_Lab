package br.uel.labprog.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import br.uel.labprog.model.Produto;

@Named
@SessionScoped
public class CarrinhoController implements Serializable{

	List<Produto> listaCarrinho;
	
	public List<Produto> getListaCarrinho() {
		return listaCarrinho;
	}

	public void setListaCarrinho(List<Produto> lista) {
		this.listaCarrinho = lista;
	}
	
	public void adicionarCarrinho(Produto produto) {
		
		if (!listaCarrinho.contains(produto)) {
			listaCarrinho.add(produto);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Produto adicionado ao carrinho"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("! Produto já foi adicionado ao carrinho !"));
		}	
		
	}
	
	public void remover(Produto produto) {
		
		listaCarrinho.remove(produto);
		
	}


	@PostConstruct
	public void init() {
		listaCarrinho = 
				new ArrayList<Produto>();
	}
}
