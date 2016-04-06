package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControleLivro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class AdicionarLivro extends JFrame {

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
					AdicionarLivro frame = new AdicionarLivro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdicionarLivro() {
		setTitle("Adicionar Livro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(84, 20, 450, 20);
		contentPane.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(84, 45, 450, 20);
		contentPane.add(tfAutor);
		tfAutor.setColumns(10);
		
		tfISBN = new JTextField();
		tfISBN.setBounds(84, 70, 225, 20);
		contentPane.add(tfISBN);
		tfISBN.setColumns(10);
		
		tfCategoria = new JTextField();
		tfCategoria.setBounds(84, 95, 225, 20);
		contentPane.add(tfCategoria);
		tfCategoria.setColumns(10);
		
		tfEditora = new JTextField();
		tfEditora.setBounds(84, 120, 450, 20);
		contentPane.add(tfEditora);
		tfEditora.setColumns(10);
		
		tfResumo = new JTextField();
		tfResumo.setBounds(84, 145, 450, 90);
		contentPane.add(tfResumo);
		tfResumo.setColumns(10);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(84, 246, 86, 20);
		contentPane.add(tfPreco);
		tfPreco.setColumns(10);
		
		tfFormato = new JTextField();
		tfFormato.setBounds(84, 271, 225, 20);
		contentPane.add(tfFormato);
		tfFormato.setColumns(10);
		
		tfPaginas = new JTextField();
		tfPaginas.setBounds(84, 296, 86, 20);
		contentPane.add(tfPaginas);
		tfPaginas.setColumns(10);
		
		tfData = new JTextField();
		tfData.setBounds(84, 321, 86, 20);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		tfIndice = new JTextField();
		tfIndice.setBounds(84, 346, 450, 70);
		contentPane.add(tfIndice);
		tfIndice.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControleLivro cl = new ControleLivro();

				try {
					cl.adicionarLivro( tfTitulo.getText(), tfAutor.getText(), tfISBN.getText(), tfCategoria.getText(),
							tfEditora.getText(), tfResumo.getText(), tfPreco.getText(), tfFormato.getText(), 
							tfPaginas.getText(), tfData.getText(), tfIndice.getText() );
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdicionar.setBounds(10, 427, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfTitulo.setText("");
				tfAutor.setText("");
				tfISBN.setText("");
				tfCategoria.setText("");
				tfEditora.setText("");
				tfResumo.setText("");
				tfPreco.setText("");
				tfFormato.setText("");
				tfPaginas.setText("");
				tfData.setText("");
				tfIndice.setText("");
			}
		});
		btnLimpar.setBounds(455, 427, 89, 23);
		contentPane.add(btnLimpar);
	}
}
