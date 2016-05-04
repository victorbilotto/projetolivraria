package DAO;

import model.Carrinho;
import model.Item;

public interface DAOCarrinho {

	public boolean adicionarCarrinho(Carrinho c);
	public boolean pesquisarItem(String titulo);
	public Item retornaItem(String titulo);
}
