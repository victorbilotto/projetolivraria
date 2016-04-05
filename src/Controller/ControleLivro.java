package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.DAOLivro;
import DAO.DAOLivroImpl;
import View.AlterarLivro;
import model.Livro;

public class ControleLivro extends JFrame{
	
	private JTable tabela;

	List<Livro> lista = new ArrayList<Livro>();

	 
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			l.setDataPublicacao(sdf.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		l.setIndice(indice);
		DAOLivro dao = new DAOLivroImpl();
		dao.adicionarLivro(l);
	}
	public List<Livro> pesquisarLivros(String nome){
		
		DAOLivro dao = new DAOLivroImpl();
		lista = dao.pesquisarTitulo(nome);
		
		return lista;
		
	}
	
	public void excluirLivro(String isbn){
		DAOLivro dao = new DAOLivroImpl();
		dao.remover(isbn);
	}
	
	public void alterar(String titulo, String autor, String ISBN, String categoria, String editora,
			String resumo, String preco, String formato, String paginas, String data, String indice)
		{
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			l.setDataPublicacao(sdf.parse(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l.setIndice(indice);
		DAOLivro dao = new DAOLivroImpl();
		dao.atualizar(l);
		}
	
	public JTable populaTabela(String titulo)
	{
		DAOLivro dao = new DAOLivroImpl();
		List<Livro> listaLivro = dao.pesquisarTitulo(titulo);
		tabela = new JTable();
		tabela.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Titulo", "ISBN", "Autor", "Editora"
				}
				));
		
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		if(modelo.getRowCount() > 0 ){
			modelo.setRowCount(0);
		}
		
		for(Livro l: listaLivro){
			Object[] objeto = new Object[4];
			objeto[0] = l.getTitulo();
			objeto[1] = l.getISBN();
			objeto[2] = l.getAutor();
			objeto[3] = l.getEditora();
			modelo.addRow(objeto);
		}
		
		return tabela;
	}
	public void alteraEscolhido(String isbn){
		DAOLivro dao = new DAOLivroImpl();
		Livro l = new Livro();
		l = dao.pesquisa(isbn);
		AlterarLivro al = new AlterarLivro();
		al.setVisible(true);
	}
}