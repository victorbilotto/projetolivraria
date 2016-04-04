package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOLivro;
import DAO.DAOLivroImpl;
import model.Livro;

public class ControleLivro {

	 
	public void adicionarLivro(String titulo, String autor, String ISBN, String categoria, String editora,
			String resumo, String preco, String formato, String paginas, String data, String indice) throws ParseException{
		
		Livro l = new Livro();
		l.setTitulo(titulo);
		l.setAutor(autor);
		l.setISBN(ISBN);
		l.setCategoria(categoria);
		l.setEditora(editora);
		l.setResumo(resumo);
		l.setPreco(Double.parseDouble(preco));
		l.setFormatoLivro(formato);
		l.setNumPaginas(Integer.parseInt(paginas));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date date = new java.sql.Date(format.parse(data).getTime());
		l.setDataPublicacao(date);
		l.setIndice(indice);
		DAOLivro dao = new DAOLivroImpl();
		dao.adicionarLivro(l);
	}
	
	public List<Livro> pesquisarLivros(String nome){
		List<Livro> lista = new ArrayList<Livro>();
		DAOLivro dao = new DAOLivroImpl();
		lista = dao.pesquisarTitulo(nome);
		
		return lista;
		
	}
}
