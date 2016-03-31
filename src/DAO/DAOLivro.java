package DAO;

import java.util.List;

import model.Livro;

public interface DAOLivro {

	public List<Livro> pesquisarTitulo(String titulo);
	public List<Livro> pesquisarAutor(String autor);
	public List<Livro> pesquisarEditora(String editora);
	public List<Livro> pesquisarCategoria(String categoria);
	public void adicionarLivro(Livro l);
}
