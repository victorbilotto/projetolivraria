package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controller.ControleLivro;
import Controller.JtextFieldSomenteLetras;
import Controller.JtextFieldSomenteNumeros;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AlterarLivroObjeto extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfISBN;
	private JTextField tfCategoria;
	private JTextField tfEditora;
	private JTextField tfResumo;
	private JTextField tfPreco;
	private JTextField tfFormato;
	private JTextField tfPaginas;
	private JTextField tfData;
	private JTextField tfIndice;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarLivroObjeto frame = new AlterarLivroObjeto(null, null, null,null, null, null,0.0, 
																			null, 0,null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	String data;
	
	public AlterarLivroObjeto(String titulo, String autor, String ISBN, String categoria, String editora,
			String resumo, double preco, String formato, int paginas, Date date, String indice) {
		setTitle("Adicionar Livro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		ControleLivro cl = new ControleLivro();
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 23, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblAutores = new JLabel("Autor(es):");
		lblAutores.setBounds(10, 48, 64, 14);
		contentPane.add(lblAutores);
		
		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setBounds(10, 73, 46, 14);
		contentPane.add(lblISBN);
		
		JLabel lblCategorias = new JLabel("Categoria(s):");
		lblCategorias.setBounds(10, 98, 75, 14);
		contentPane.add(lblCategorias);
		
		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setBounds(10, 123, 46, 14);
		contentPane.add(lblEditora);
		
		JLabel lblResumo = new JLabel("Resumo:");
		lblResumo.setBounds(10, 148, 46, 14);
		contentPane.add(lblResumo);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(10, 249, 46, 14);
		contentPane.add(lblPreco);
		
		JLabel lblFormato = new JLabel("Formato:");
		lblFormato.setBounds(10, 274, 46, 14);
		contentPane.add(lblFormato);
		
		JLabel lblNumPaginas = new JLabel("Paginas:");
		lblNumPaginas.setBounds(10, 299, 46, 14);
		contentPane.add(lblNumPaginas);
		
		JLabel lblDataPublicacao = new JLabel("Data:");
		lblDataPublicacao.setBounds(10, 324, 46, 14);
		contentPane.add(lblDataPublicacao);
		
		JLabel lblIndice = new JLabel("Indice:");
		lblIndice.setBounds(10, 349, 46, 14);
		contentPane.add(lblIndice);
		
		tfTitulo = new JtextFieldSomenteLetras();
		tfTitulo.setBounds(84, 20, 450, 20);
		contentPane.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		tfAutor = new  JtextFieldSomenteLetras();
		tfAutor.setBounds(84, 45, 450, 20);
		contentPane.add(tfAutor);
		tfAutor.setColumns(10);
		
		tfISBN = new  JtextFieldSomenteNumeros();
		tfISBN.setBounds(84, 70, 225, 20);
		contentPane.add(tfISBN);
		tfISBN.setColumns(10);
		
		tfEditora = new  JtextFieldSomenteLetras();
		tfEditora.setBounds(84, 120, 450, 20);
		contentPane.add(tfEditora);
		tfEditora.setColumns(10);
		
		tfResumo = new  JtextFieldSomenteLetras();
		tfResumo.setBounds(84, 145, 450, 90);
		contentPane.add(tfResumo);
		tfResumo.setColumns(10);
		
		tfPreco = new JtextFieldSomenteNumeros();
		tfPreco.setBounds(84, 246, 86, 20);
		contentPane.add(tfPreco);
		tfPreco.setColumns(10);
		
		tfPaginas = new JtextFieldSomenteNumeros();
		tfPaginas.setBounds(84, 296, 86, 20);
		contentPane.add(tfPaginas);
		tfPaginas.setColumns(10);
		
		try {
		MaskFormatter data = new MaskFormatter("##/##/####");
		tfData = new JFormattedTextField(data);
		tfData.setBounds(84, 321, 86, 20);
		contentPane.add(tfData);
		tfData.setColumns(10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tfIndice = new JtextFieldSomenteLetras();
		tfIndice.setBounds(84, 346, 450, 70);
		contentPane.add(tfIndice);
		tfIndice.setColumns(10);
		
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				ControleLivro cl = new ControleLivro();

				cl.alterar( tfTitulo.getText(), tfAutor.getText(), tfISBN.getText(), tfCategoria.getText(),
						tfEditora.getText(), tfResumo.getText(), tfPreco.getText(), tfFormato.getText(), 
						tfPaginas.getText(), tfData.getText(), tfIndice.getText() );
			}
		});
		btnAlterar.setBounds(10, 427, 89, 23);
		contentPane.add(btnAlterar);
	}
	
}
