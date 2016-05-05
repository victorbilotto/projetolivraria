package Controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAOCarrinho;
import DAO.DAOCarrinhoImpl;
import DAO.DAOLivro;
import DAO.DAOLivroImpl;
import model.Carrinho;
import model.Item;
import model.Livro;

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
	
	public void populaTabela(JTable tabela, JLabel lblTotalCalculado)
	{
		Carrinho carrinho = new Carrinho();
		DAOCarrinho dao = new DAOCarrinhoImpl();
		carrinho.setItens(dao.pesquisaCarrinho());
		
		tabela.setModel(new DefaultTableModel(

				new Object[][] {
				},
				new String[] {
						"ISBN", "Titulo", "Autor", "Editora", "Categoria", "Valor (R$)", "Quantidade"
				}
				));
		if(carrinho.getItens().size()<=0){
			JOptionPane.showMessageDialog(null, "Nenhum livro encontrado");
		}
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		if(modelo.getRowCount() > 0 ){
			modelo.setRowCount(0);
		}
		
		float valorFinal = 0;
		for(Item i: carrinho.getItens()){
			Object[] objeto = new Object[7];
			objeto[0] = i.getLivro().getISBN();
			objeto[1] = i.getLivro().getTitulo();
			objeto[2] = i.getLivro().getAutor();
			objeto[3] = i.getLivro().getEditora();
			objeto[4] = i.getLivro().getCategoria();
			objeto[5] = i.getLivro().getPreco();
			objeto[6] = i.getQuantidade();
			modelo.addRow(objeto);
			valorFinal = (float) (valorFinal + ( i.getQuantidade() * i.getLivro().getPreco()));
		}
		
		lblTotalCalculado.setText(String.valueOf(valorFinal));
		
	}

	public void deletaLivro(String escolhido) {
		DAOCarrinho dao = new DAOCarrinhoImpl();
		dao.excluiItem(escolhido);
	}

	public void updateQuantidade(String value, String lblIsbn) {
		DAOCarrinho dao = new DAOCarrinhoImpl();
		dao.updateQuantidade(value, lblIsbn);
	}

	public void deletaLivroAntigo() {
		DAOCarrinho dao = new DAOCarrinhoImpl();
		dao.deletaAntigo();
	}
	
}
