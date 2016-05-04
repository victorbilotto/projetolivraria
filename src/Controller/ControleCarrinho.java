package Controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.DAOCarrinho;
import DAO.DAOCarrinhoImpl;
import model.Carrinho;
import model.Item;

public class ControleCarrinho {

	public boolean verificaItem(String titulo){
		DAOCarrinhoImpl dao = new DAOCarrinhoImpl();
		return dao.pesquisarItem(titulo);
	}
	
	public void adicionarItem(String titulo, int quantidade) {
		DAOCarrinho dao = new DAOCarrinhoImpl();
		List<Item> itens = new ArrayList<Item>();
		Carrinho carrinho = new Carrinho();
		Item item = dao.retornaItem(titulo);
		item.setQuantidade(quantidade);
		item.setSubtotal(item.getLivro().getPreco() * item.getQuantidade());
		itens.add(item);
		carrinho.setItens(itens);
		carrinho.setExpiracao(new Timestamp(System.currentTimeMillis()));
		carrinho.setTotal(carrinho.getTotal() + item.getSubtotal());
		if(dao.adicionarCarrinho(carrinho)){
			JOptionPane.showMessageDialog(null, "Item adicionado ao carrinho com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar item");
		}
		
	}
	
}
