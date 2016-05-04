package model;

import java.sql.Timestamp;
import java.util.List;

public class Carrinho {

	private Timestamp expiracao;
	private List<Item> itens;
	private double total;
	
	public Timestamp getExpiracao() {
		return expiracao;
	}
	public void setExpiracao(Timestamp expiracao) {
		this.expiracao = expiracao;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
