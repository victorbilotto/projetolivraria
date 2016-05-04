package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.DataBaseConnection;
import model.Carrinho;
import model.Item;
import model.Livro;

public class DAOCarrinhoImpl implements DAOCarrinho {

	final String pesqCarrinho = "SELECT * FROM carrinho INNER JOIN livro ON livro.ISBN = carrinho.ISBN WHERE livro.titulo LIKE ?";
	final String pesqItem = "SELECT * FROM livro WHERE titulo LIKE ?";
	final String addCarrinho = "INSERT INTO carrinho (ISBN, qtdItem, expiracao) values (?, ?, ?)"; 
	
	@Override
	public boolean adicionarCarrinho(Carrinho c) {
		try {
			Connection con =  DataBaseConnection.getConnection();
				
			PreparedStatement stm = con.prepareStatement( addCarrinho );
			for(Item i: c.getItens()){
				stm.setString(1, i.getLivro().getISBN());
				stm.setInt(2, i.getQuantidade());
				stm.setTimestamp(3, c.getExpiracao());
				stm.executeUpdate();
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	@Override
	public boolean pesquisarItem(String titulo) {
		List<Carrinho> lista = new ArrayList<Carrinho>();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			PreparedStatement stm = con.prepareStatement( pesqCarrinho );
			stm.setString(1, titulo);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				Carrinho c = new Carrinho();
				c.setExpiracao(rs.getTimestamp("expiracao"));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(lista.isEmpty())
			return false;
		
		return true;
	}

	@Override
	public Item retornaItem(String titulo) {
		Item item = new Item();
		Connection con = DataBaseConnection.getConnection();
		try {
			PreparedStatement stm = con.prepareStatement( pesqItem );
			stm.setString(1, titulo);
			ResultSet rs = stm.executeQuery();
			Livro livro = new Livro();
			while(rs.next()){
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setISBN(rs.getString("ISBN"));
				livro.setCategoria(rs.getString("categoria"));
				livro.setEditora(rs.getString("editora"));
				livro.setResumo(rs.getString("resumo"));
				livro.setPreco((Double.parseDouble( rs.getString( "preco" ))));
				livro.setFormatoLivro(rs.getString("formatoLivro"));
				livro.setNumPaginas(Integer.parseInt(rs.getString("numPaginas")));
				livro.setDataPublicacao(rs.getDate("dataPublicacao"));
				livro.setIndice(rs.getString("indice"));
			}
			item.setLivro(livro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

}
