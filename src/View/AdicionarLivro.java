package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controller.ControleLivro;
import Controller.JTextAreaSomenteTexto;
import Controller.JTextAreaTudo;
import Controller.JTextFieldTudo;
import Controller.JtextFieldSomenteLetras;
import Controller.JtextFieldSomenteNumeros;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import model.EnumCategoria;
import javax.swing.JTextArea;

public class AdicionarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfISBN;
	private JTextField tfEditora;
	private JTextField tfPreco;
	private JTextField tfPaginas;
	private JTextField tfData;

	/**
	 * Create the frame.
	 */
	public AdicionarLivro() {
		setResizable(false);
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
		
		JComboBox cbFormato = new JComboBox();
		cbFormato.setModel(new DefaultComboBoxModel(new String[] {"Brochura", "Capa dura"}));
		cbFormato.setBounds(84, 271, 225, 20);
		contentPane.add(cbFormato);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(EnumCategoria.values()));
		cbCategoria.setBounds(84, 95, 225, 20);
		contentPane.add(cbCategoria);
		
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
		
		tfTitulo = new JTextFieldTudo();
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
		
		tfPreco = new JtextFieldSomenteNumeros();
		tfPreco.setBounds(84, 246, 86, 20);
		contentPane.add(tfPreco);
		tfPreco.setColumns(10);
		
		tfPaginas = new JtextFieldSomenteNumeros();
		tfPaginas.setBounds(84, 296, 86, 20);
		contentPane.add(tfPaginas);
		tfPaginas.setColumns(10);
		
		JTextArea tfResumo = new JTextAreaSomenteTexto();
		tfResumo.setBounds(84, 148, 450, 90);
		contentPane.add(tfResumo);
		
		JTextArea tfIndice = new JTextAreaTudo();
		tfIndice.setBounds(84, 349, 450, 68);
		contentPane.add(tfIndice);
		
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
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] valores = new String[8];
				valores[0] = tfTitulo.getText();
				valores[1] = tfAutor.getText();
				valores[2] = tfISBN.getText();
				valores[3] = tfEditora.getText();
				valores[4] = tfResumo.getText();
				valores[5] = tfPreco.getText();
				valores[6] = tfPaginas.getText();
				valores[7] = tfIndice.getText();		
				
				boolean vazio = true;	
				for(int i = 0; i < valores.length; i++){
					if(valores[i] != null && !valores[i].trim().isEmpty() && !tfTitulo.getText().trim().equals("") && !tfAutor.getText().trim().equals("") &&
							!tfISBN.getText().trim().equals("") && !tfEditora.getText().trim().equals("") && !tfResumo.getText().trim().equals("") &&
							!tfPreco.getText().trim().equals("") && !tfPaginas.getText().trim().equals("") &&
							!tfData.getText().trim().equals("") && !tfIndice.getText().trim().equals("") && !tfData.getText().equals("  /  /    ")  ){
						vazio = false; 
					}
				}	
				if(!vazio) {
					ControleLivro cl = new ControleLivro();
					try {
						cl.adicionarLivro( tfTitulo.getText(), tfAutor.getText(), tfISBN.getText(), cbCategoria.getSelectedItem().toString(),
								tfEditora.getText(), tfResumo.getText(), tfPreco.getText(), cbFormato.getSelectedItem().toString(), 
								tfPaginas.getText(), tfData.getText(), tfIndice.getText() );
						JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso.");
						
					} catch (ParseException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao adicionar o livro.");
						
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
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
				tfEditora.setText("");
				tfResumo.setText("");
				tfPreco.setText("");
				tfPaginas.setText("");
				tfData.setText("");
				tfIndice.setText("");
			}
		});
		btnLimpar.setBounds(455, 427, 89, 23);
		contentPane.add(btnLimpar);
		

	}
}
