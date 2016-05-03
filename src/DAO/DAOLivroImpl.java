package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Connection.DataBaseConnection;

import java.sql.*;

import model.Livro;

public class DAOLivroImpl implements DAOLivro{
	
	
	final String pesqPorNome = "SELECT * FROM livro where titulo like ?";
	final String pesqPorTitulo = "titulo like ?";
	final String pesqPorCategoria = "categoria like ?";
	final String pesqPorAutor = "autor like ?";
	final String pesqPorEditora = "editora like ?";
	final String pesqStmt = "SELECT * FROM livro where ";
	final String insert ="INSERT INTO livro" +
			"(titulo, autor, ISBN, categoria, editora, resumo, preco, formatoLivro, numPaginas, dataPublicacao, indice) " +
			"values (?,?,?,?,?,?,?,?,?,?,?)";
	final String atualiza ="UPDATE livro SET" +
			" titulo = ?," +
			" autor = ?," +
			" categoria = ?," +
			" editora = ?," +
			" resumo = ?," +
			" preco = ?," +
			" formatoLivro = ?,"+
			" numPaginas = ?,"+
			" dataPublicacao =?,"+
			" indice = ?"+
			" WHERE ISBN = ?";
	final String pesquisaUnica = "SELECT * FROM livro where isbn like ?";
	
	@Override
	public List<Livro> pesquisarTitulo(String titulo) {
		List<Livro> lista = new ArrayList<Livro>();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			PreparedStatement stm = con.prepareStatement( pesqPorNome );
			stm.setString(1, "%" + titulo +"%");
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Livro l = new Livro();
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				l.setISBN(rs.getString("ISBN"));
				l.setCategoria(rs.getString("categoria"));
				l.setEditora(rs.getString("editora"));
				l.setResumo(rs.getString("resumo"));
				l.setPreco((Double.parseDouble( rs.getString( "preco" ))));
				l.setFormatoLivro(rs.getString("formatoLivro"));
				l.setNumPaginas(Integer.parseInt(rs.getString("numPaginas")));
				l.setDataPublicacao(rs.getDate("dataPublicacao"));
				l.setIndice(rs.getString("indice"));
				lista.add( l );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}

	@Override
	public List<Livro> pesquisarAutor(String autor) {
		List<Livro> lista = new ArrayList<Livro>();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			PreparedStatement stm = con.prepareStatement( pesqStmt + pesqPorAutor );
			stm.setString(1, "%" + autor +"%");
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Livro l = new Livro();
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				l.setISBN(rs.getString("ISBN"));
				l.setCategoria(rs.getString("categoria"));
				l.setEditora(rs.getString("editora"));
				l.setResumo(rs.getString("resumo"));
				l.setPreco((Double.parseDouble( rs.getString( "preco" ))));
				l.setFormatoLivro(rs.getString("formatoLivro"));
				l.setNumPaginas(Integer.parseInt(rs.getString("numPaginas")));
				l.setDataPublicacao(rs.getDate("dataPublicacao"));
				l.setIndice(rs.getString("indice"));
				lista.add( l );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}
	
	
	@Override
	public List<Livro> pesquisarEditora(String editora) {
		List<Livro> lista = new ArrayList<Livro>();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			PreparedStatement stm = con.prepareStatement( pesqStmt + pesqPorEditora );
			stm.setString(1, "%" + editora +"%");
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Livro l = new Livro();
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				l.setISBN(rs.getString("ISBN"));
				l.setCategoria(rs.getString("categoria"));
				l.setEditora(rs.getString("editora"));
				l.setResumo(rs.getString("resumo"));
				l.setPreco((Double.parseDouble( rs.getString( "preco" ))));
				l.setFormatoLivro(rs.getString("formatoLivro"));
				l.setNumPaginas(Integer.parseInt(rs.getString("numPaginas")));
				l.setDataPublicacao(rs.getDate("dataPublicacao"));
				l.setIndice(rs.getString("indice"));
				lista.add( l );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}

	@Override
	public List<Livro> pesquisarCategoria(String categoria) {
		
		List<Livro> lista = new ArrayList<Livro>();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			PreparedStatement stm = con.prepareStatement( pesqStmt + pesqPorCategoria );
			stm.setString(1, "%" + categoria +"%");
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Livro l = new Livro();
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				l.setISBN(rs.getString("ISBN"));
				l.setCategoria(rs.getString("categoria"));
				l.setEditora(rs.getString("editora"));
				l.setResumo(rs.getString("resumo"));
				l.setPreco((Double.parseDouble( rs.getString( "preco" ))));
				l.setFormatoLivro(rs.getString("formatoLivro"));
				l.setNumPaginas(Integer.parseInt(rs.getString("numPaginas")));
				l.setDataPublicacao(rs.getDate("dataPublicacao"));
				l.setIndice(rs.getString("indice"));
				lista.add( l );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}

	@Override
	public void adicionarLivro(Livro l) {
		try {
			Connection con =  DataBaseConnection.getConnection();
				
			PreparedStatement stm = con.prepareStatement( insert );			
			stm.setString(1, l.getTitulo());
			stm.setString(2, l.getAutor());
			stm.setString(3, l.getISBN());
			stm.setString(4, l.getCategoria());
			stm.setString(5, l.getEditora());
			stm.setString(6, l.getResumo());
			stm.setDouble(7, l.getPreco());
			stm.setString(8, l.getFormatoLivro());
			stm.setInt(9, l.getNumPaginas());
			stm.setDate(10, new java.sql.Date(l.getDataPublicacao().getTime()));
			stm.setString(11, l.getIndice());
			
			stm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		

	}

	@Override
	public void atualizar(Livro l) {
		try {
			Connection con =  DataBaseConnection.getConnection();
			
			PreparedStatement stm = con.prepareStatement( atualiza );			
			stm.setString(1, l.getTitulo());
			stm.setString(2, l.getAutor());
			stm.setString(3, l.getCategoria());
			stm.setString(4, l.getEditora());
			stm.setString(5, l.getResumo());
			stm.setDouble(6, l.getPreco());
			stm.setString(7, l.getFormatoLivro());
			stm.setInt(8, l.getNumPaginas());
			stm.setDate(9, new java.sql.Date(l.getDataPublicacao().getTime()));
			stm.setString(10, l.getIndice());
			stm.setString(11, l.getISBN());
			stm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		

		
	}


	@Override
	public void remover(String isbn) {
		try {
			Connection con =  DataBaseConnection.getConnection();

			final String delete  ="DELETE FROM livro WHERE isbn =(?)";

			PreparedStatement stm = con.prepareStatement( delete );
			stm.setString(1, isbn );
			
			stm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Livro pesquisa(String isbn){
		Connection con = DataBaseConnection.getConnection();
		Livro l = new Livro();
		PreparedStatement pt;
		try {
			pt =  con.prepareStatement(pesquisaUnica);
			pt.setString(1, isbn);
			ResultSet rs = pt.executeQuery();
			while(rs.next()){
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				l.setISBN(rs.getString("ISBN"));
				l.setCategoria(rs.getString("categoria"));
				l.setEditora(rs.getString("editora"));
				l.setResumo(rs.getString("resumo"));
				l.setPreco((Double.parseDouble( rs.getString( "preco" ))));
				l.setFormatoLivro(rs.getString("formatoLivro"));
				l.setNumPaginas(Integer.parseInt(rs.getString("numPaginas")));
				l.setDataPublicacao(rs.getDate("dataPublicacao"));
				l.setIndice(rs.getString("indice"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Livro> pesquisarLivro(String[] valores) {
		
		List<Livro> lista = new ArrayList<Livro>();
		Connection con = DataBaseConnection.getConnection();
		
		try {
			String stmtPesq = pesqStmt;
			boolean[] contar = new boolean[4];
			int qtdStmt = 0;
			
			for(int i = 0; i < valores.length; i++){
				if(valores[i] != null && !valores[i].isEmpty()) {
					contar[i] = true;
					qtdStmt++;
					if(i > 0){
						if(contar[i-1])
							stmtPesq += ", ";
					}
					switch(i){
						case 0:
							stmtPesq += pesqPorTitulo;
							break;
						case 1:
							stmtPesq += pesqPorAutor;
							break;
						case 2:
							stmtPesq += pesqPorEditora;
							break;
						case 3: 
							stmtPesq += pesqPorCategoria;
							break;
					}
				} else {
					contar[i] = false;
				}
			}
			
			
			PreparedStatement stm = con.prepareStatement( stmtPesq );
			for(int i = 0; i < qtdStmt; i++) {
				for(int j = 0; j < valores.length; j++) {
					if(contar[j]){
						stm.setString(i+1, "%" + valores[j] + "%");
						contar[j] = false;
						break;
					}
				}
			}
			
			ResultSet rs = stm.executeQuery();
			while( rs.next() ){
				Livro l = new Livro();
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				l.setISBN(rs.getString("ISBN"));
				l.setCategoria(rs.getString("categoria"));
				l.setEditora(rs.getString("editora"));
				l.setResumo(rs.getString("resumo"));
				l.setPreco((Double.parseDouble( rs.getString( "preco" ))));
				l.setFormatoLivro(rs.getString("formatoLivro"));
				l.setNumPaginas(Integer.parseInt(rs.getString("numPaginas")));
				l.setDataPublicacao(rs.getDate("dataPublicacao"));
				l.setIndice(rs.getString("indice"));
				lista.add( l );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return lista;
	}

}
