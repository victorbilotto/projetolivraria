package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.Livro;

public class DAOLivroImpl implements DAOLivro{
	
	static String stringConexao = "Data Source=NOMEPC;" +
            "Initial Catalog=NOMEBANCO;" +
            "Trusted_Connection=yes";

	
	@Override
	public List<Livro> pesquisarTitulo(String titulo) {
		List<Livro> lista = new ArrayList<Livro>();	
        Livro l = new Livro();
        SqlConnection conn = new SqlConnection();
        conn.ConnectionString = stringConexao;
        String sql = "select * from materia where titulo like " +titulo;
        SqlCommand cmd = new SqlCommand(sql, conn);
        conn.Open();
        SqlDataReader reader;
        reader = cmd.ExecuteReader();
        while (reader.NextResult())
        {
        	
        	l.setTitulo(reader.GetString(0));
        	l.setAutor(reader.GetString(1));
        	l.setISBN(reader.GetString(2));
        	l.setCategoria(reader.GetString(3));
        	l.setEditora(reader.GetString(4));
        	l.setResumo(reader.GetString(5));
        	l.setPreco(reader.GetDouble(6));
        	l.setFormatoLivro(reader.GetString(7));
        	l.setNumPaginas(reader.GetInt32(8));
        	l.setDataPublicacao(reader.GetDate(9));
        	l.setIndice(reader.GetString(10));
            
        	lista.add(l);
        }
		
		return lista;
	}

	@Override
	public List<Livro> pesquisarAutor(String autor) {
		List<Livro> lista = new ArrayList<Livro>();	
        Livro l = new Livro();
        SqlConnection conn = new SqlConnection();
        conn.ConnectionString = stringConexao;
        String sql = "select * from materia where autor like " +autor;
        SqlCommand cmd = new SqlCommand(sql, conn);
        conn.Open();
        SqlDataReader reader;
        reader = cmd.ExecuteReader();
        while (reader.NextResult())
        {
        	
        	l.setTitulo(reader.GetString(0));
        	l.setAutor(reader.GetString(1));
        	l.setISBN(reader.GetString(2));
        	l.setCategoria(reader.GetString(3));
        	l.setEditora(reader.GetString(4));
        	l.setResumo(reader.GetString(5));
        	l.setPreco(reader.GetDouble(6));
        	l.setFormatoLivro(reader.GetString(7));
        	l.setNumPaginas(reader.GetInt32(8));
        	l.setDataPublicacao(reader.GetDate(9));
        	l.setIndice(reader.GetString(10));
            
        	lista.add(l);
        }
		
		return lista;
	}

	@Override
	public List<Livro> pesquisarEditora(String editora) {
		List<Livro> lista = new ArrayList<Livro>();	
        Livro l = new Livro();
        SqlConnection conn = new SqlConnection();
        conn.ConnectionString = stringConexao;
        String sql = "select * from materia where editora like " + editora;
        SqlCommand cmd = new SqlCommand(sql, conn);
        conn.Open();
        SqlDataReader reader;
        reader = cmd.ExecuteReader();
        while (reader.NextResult())
        {
        	
        	l.setTitulo(reader.GetString(0));
        	l.setAutor(reader.GetString(1));
        	l.setISBN(reader.GetString(2));
        	l.setCategoria(reader.GetString(3));
        	l.setEditora(reader.GetString(4));
        	l.setResumo(reader.GetString(5));
        	l.setPreco(reader.GetDouble(6));
        	l.setFormatoLivro(reader.GetString(7));
        	l.setNumPaginas(reader.GetInt32(8));
        	l.setDataPublicacao(reader.GetDate(9));
        	l.setIndice(reader.GetString(10));
            
        	lista.add(l);
        }
		
		return lista;
	}

	@Override
	public List<Livro> pesquisarCategoria(String categoria) {
		List<Livro> lista = new ArrayList<Livro>();	
        Livro l = new Livro();
        SqlConnection conn = new SqlConnection();
        conn.ConnectionString = stringConexao;
        String sql = "select * from materia where categoria like " + categoria;
        SqlCommand cmd = new SqlCommand(sql, conn);
        conn.Open();
        SqlDataReader reader;
        reader = cmd.ExecuteReader();
        while (reader.NextResult())
        {
        	
        	l.setTitulo(reader.GetString(0));
        	l.setAutor(reader.GetString(1));
        	l.setISBN(reader.GetString(2));
        	l.setCategoria(reader.GetString(3));
        	l.setEditora(reader.GetString(4));
        	l.setResumo(reader.GetString(5));
        	l.setPreco(reader.GetDouble(6));
        	l.setFormatoLivro(reader.GetString(7));
        	l.setNumPaginas(reader.GetInt32(8));
        	l.setDataPublicacao(reader.GetDate(9));
        	l.setIndice(reader.GetString(10));
            
        	lista.add(l);
        }
		
		return lista;
	}

}
