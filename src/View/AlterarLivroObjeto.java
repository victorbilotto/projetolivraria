package View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controller.ControleLivro;
import model.EnumCategoria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AlterarLivroObjeto extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfISBN;
	private JTextField tfEditora;
	private JTextField tfResumo;
	private JTextField tfPreco;
	private JTextField tfPaginas;
	private JTextField tfData;
	private JTextField tfIndice;

	
	String data;
	
	public AlterarLivroObjeto(int id, String titulo, String autor, String ISBN, String categoria, String editora,
			String resumo, double preco, String formato, int paginas, String result, String indice) {
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
		
		JComboBox cbFormato = new JComboBox();
		cbFormato.setModel(new DefaultComboBoxModel(new String[] {"Brochura", "Capa dura"}));
		cbFormato.setBounds(84, 271, 225, 20);
		contentPane.add(cbFormato);
		cbFormato.setSelectedItem(formato);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(EnumCategoria.values()));
		cbCategoria.setBounds(84, 95, 225, 20);
		contentPane.add(cbCategoria);
		cbCategoria.setSelectedItem(categoria);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(84, 20, 450, 20);
		contentPane.add(tfTitulo);
		tfTitulo.setColumns(10);
		tfTitulo.setText(titulo);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(84, 45, 450, 20);
		contentPane.add(tfAutor);
		tfAutor.setColumns(10);
		tfAutor.setText(autor);
		
		tfISBN = new JTextField();
		tfISBN.setBounds(84, 70, 225, 20);
		contentPane.add(tfISBN);
		tfISBN.setColumns(10);
		tfISBN.setText(ISBN);

		
		tfEditora = new JTextField();
		tfEditora.setBounds(84, 120, 450, 20);
		contentPane.add(tfEditora);
		tfEditora.setColumns(10);
		tfEditora.setText(editora);
		
		tfResumo = new JTextField();
		tfResumo.setBounds(84, 145, 450, 90);
		contentPane.add(tfResumo);
		tfResumo.setColumns(10);
		tfResumo.setText(resumo);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(84, 246, 86, 20);
		contentPane.add(tfPreco);
		tfPreco.setColumns(10);
		tfPreco.setText(String.valueOf(preco));
		
		tfPaginas = new JTextField();
		tfPaginas.setBounds(84, 296, 86, 20);
		contentPane.add(tfPaginas);
		tfPaginas.setColumns(10);
		tfPaginas.setText(String.valueOf(paginas));
		
		tfData = new JTextField(String.valueOf(result));
		tfData.setBounds(84, 321, 86, 20);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		tfIndice = new JTextField();
		tfIndice.setBounds(84, 346, 450, 70);
		contentPane.add(tfIndice);
		tfIndice.setColumns(10);
		tfIndice.setText(indice);

		int codigoId = id;
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				ControleLivro cl = new ControleLivro();				
				try{
					cl.alterar( codigoId, tfTitulo.getText(), tfAutor.getText(), tfISBN.getText(), cbCategoria.getSelectedItem().toString(),
							tfEditora.getText(), tfResumo.getText(), tfPreco.getText(), cbFormato.getSelectedItem().toString(), 
							tfPaginas.getText(), tfData.getText(), tfIndice.getText() );
					JOptionPane.showMessageDialog(null,  "Livro alterado com sucesso");
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,  "Falha ao alterar livro");
				}
			}
		});
		btnAlterar.setBounds(10, 427, 89, 23);
		contentPane.add(btnAlterar);
		

	}
}
