package DAO;

import java.util.List;

import javax.swing.JLabel;

import model.Carrinho;
import model.Item;

public interface DAOCarrinho {

	public boolean adicionarCarrinho(Carrinho c);
	public boolean pesquisarItem(String titulo);
	public Item retornaItem(String titulo);
	public List<Item> pesquisaCarrinho();
	public void excluiItem(String escolhido);
	public void updateQuantidade(String value, String lblIsbn);
	public void deletaAntigo();
}
