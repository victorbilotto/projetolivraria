package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.DAOLivro;
import DAO.DAOLivroImpl;
import model.Livro;

public class ControleLivro implements TableModel{

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
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date date = new java.sql.Date(format.parse(data).getTime());
		l.setDataPublicacao(date);
		l.setIndice(indice);
		DAOLivro dao = new DAOLivroImpl();
		dao.adicionarLivro(l);
	}
	
	public List<Livro> pesquisarLivros(String nome){
		
		DAOLivro dao = new DAOLivroImpl();
		lista = dao.pesquisarTitulo(nome);
		
		
		return getLivros();
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) { 
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return String.class;
		default : return String.class;
	}
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) { 
		case 0 : return "Titulo";
		case 1 : return "ISBN";
		case 2 : return "Editora";
		case 3 : return "Autor";
		default : return "";
	}

	}

	@Override
	public int getRowCount() {
		return getLivros().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Livro l = getLivros().get( rowIndex );
		switch (columnIndex) { 
			case 0 : return l.getTitulo();
			case 1 : return l.getISBN();
			case 2 : return l.getEditora();
			case 3 : return l.getAutor();
			default : return "";
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Livro> getLivros(){
		return lista;
	}
	
	public void excluirLivro(String isbn){
		DAOLivro dao = new DAOLivroImpl();
		dao.remover(isbn);
	}
}
