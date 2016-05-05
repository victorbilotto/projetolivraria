package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.DAOLivro;
import DAO.DAOLivroImpl;
import View.AlterarLivroObjeto;
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
	@SuppressWarnings("serial")
	public void pesquisarLivros(String[] valores, JTable tabela){
		
		DAOLivro dao = new DAOLivroImpl();
		List<Livro> listaLivro = dao.pesquisarLivro(valores);
		
		tabela.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Titulo", "Autor", "Editora", "Categoria", "Valor (R$)"	
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(222);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(89);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(85);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(4).setResizable(false);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(64);
		
		if(listaLivro.size()<=0){
			JOptionPane.showMessageDialog(null, "Nenhum livro encontrado, faça uma nova busca");
		}
		
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		if(modelo.getRowCount() > 0 ){
			modelo.setRowCount(0);
		}
		
		for(Livro l: listaLivro){
			Object[] objeto = new Object[5];
			
			objeto[0] = l.getTitulo();
			objeto[1] = l.getAutor();
			objeto[2] = l.getEditora();
			objeto[3] = l.getCategoria();
			objeto[4] = l.getPreco();
			
			modelo.addRow(objeto);
		}
	}
	
	public void excluirLivro(String isbn){
		DAOLivro dao = new DAOLivroImpl();
		dao.remover(isbn);
	}
	
	public void alterar(int codigoId, String titulo, String autor, String ISBN, String categoria, String editora,
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
		dao.atualizar(l, codigoId);
		}
	
	public void popularTabela(String[] valores, JTable tabelaLivros){

		DAOLivro dao = new DAOLivroImpl();
		List<Livro> listaLivro = dao.pesquisarLivro(valores);
		
		tabelaLivros.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"ISBN", "Titulo", "Autor", "Editora", "Categoria"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		tabelaLivros.getColumnModel().getColumn(0).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(1).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(2).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(3).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(4).setResizable(false);
		
		if(listaLivro.size()<=0){
			JOptionPane.showMessageDialog(null, "Nenhum livro encontrado, faça uma nova busca");
		}
		
		DefaultTableModel modelo = (DefaultTableModel) tabelaLivros.getModel();
		if(modelo.getRowCount() > 0 ){
			modelo.setRowCount(0);
		}
		
		
		for(Livro l: listaLivro){
			Object[] objeto = new Object[5];
			objeto[1] = l.getTitulo();
			objeto[0] = l.getISBN();
			objeto[2] = l.getAutor();
			objeto[3] = l.getEditora();
			objeto[4] = l.getCategoria();
			modelo.addRow(objeto);
		}
		
	}
	
	public void populaTabela(String titulo, JTable tabela)
	{
		
		tabela.setModel(new DefaultTableModel(

				new Object[][] {
				},
				new String[] {
					"Titulo", "ISBN", "Autor", "Editora"
				}
				));
		DAOLivro dao = new DAOLivroImpl();
		List<Livro> listaLivro = dao.pesquisarTitulo(titulo);
		if(listaLivro.size()<=0){
			JOptionPane.showMessageDialog(null, "Nenhum livro encontrado");
		}
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
		
	}
	public void alteraEscolhido(String isbn) throws ParseException{
		DAOLivro dao = new DAOLivroImpl();
		Livro l = new Livro();
		l = dao.pesquisa(isbn);
		
		SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
		String result = out.format(in.parse(String.valueOf(l.getDataPublicacao())));  
		

		AlterarLivroObjeto al = new AlterarLivroObjeto(l.getId(), l.getTitulo(), l.getAutor(), l.getISBN(), l.getCategoria()
				,l.getEditora(), l.getResumo(), l.getPreco(), l.getFormatoLivro(), l.getNumPaginas(), result, l.getIndice());
		al.setVisible(true);
	}
}
