package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import Controller.ControleCarrinho;
import Controller.ControleLivro;
import model.EnumCategoria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class PesquisarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfEditora;
	@SuppressWarnings("rawtypes")
	private JComboBox cbCategoria;
	private JTable tabelaLivros;
	private JScrollPane scrollPane;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PesquisarLivro() {
		setTitle("Pesquisar Livro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setBounds(10, 11, 65, 14);
		contentPane.add(lblTtulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setToolTipText("Digite o t\u00EDtulo do livro a ser pesquisado.");
		tfTitulo.setBounds(78, 8, 305, 20);
		contentPane.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 45, 59, 14);
		contentPane.add(lblAutor);
		
		tfAutor = new JTextField();
		tfAutor.setToolTipText("Digite o nome do autor do livro a ser pesquisado.");
		tfAutor.setBounds(78, 42, 240, 20);
		contentPane.add(tfAutor);
		tfAutor.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] valores = new String[4];
				valores[0] = tfTitulo.getText();
				valores[1] = tfAutor.getText();
				valores[2] = tfEditora.getText();
				valores[3] = cbCategoria.getSelectedItem().toString();
				boolean vazio = true;
				for(int i = 0; i < valores.length; i++)
					if(valores[i] != null && !valores[i].isEmpty())
						vazio = false;
				if(!vazio) {
					ControleLivro cl = new ControleLivro();
					cl.pesquisarLivros(valores, tabelaLivros);
				} else {
					JOptionPane.showMessageDialog(null, "Preencha pelo menos um campo.");
				}
			}
		});
		btnPesquisar.setBounds(10, 97, 100, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modelo = (DefaultTableModel) tabelaLivros.getModel();
				if(modelo.getRowCount() > 0 ){
					modelo.setRowCount(0);
				}
				tfTitulo.setText("");
				tfAutor.setText("");
				tfEditora.setText("");
				cbCategoria.setSelectedIndex(0);
			}
		});
		btnLimpar.setBounds(308, 97, 100, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(594, 97, 100, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setBounds(457, 11, 59, 14);
		contentPane.add(lblEditora);
		
		tfEditora = new JTextField();
		tfEditora.setToolTipText("Digite o nome da editora do livro a ser pesquisado.");
		tfEditora.setBounds(526, 8, 168, 20);
		contentPane.add(tfEditora);
		tfEditora.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(457, 45, 72, 14);
		contentPane.add(lblCategoria);
		
		cbCategoria = new JComboBox();
		cbCategoria.setToolTipText("Escolha a categoria do livro a ser pesquisado.");
		cbCategoria.setModel(new DefaultComboBoxModel(new String[] {""}));
		EnumCategoria[] enumc = EnumCategoria.values();
		for(EnumCategoria e: enumc){
			cbCategoria.addItem(e);
		}
		cbCategoria.setBounds(526, 42, 168, 20);
		contentPane.add(cbCategoria);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 152, 684, 209);
		contentPane.add(scrollPane);
		
		tabelaLivros = new JTable();
		tabelaLivros.setFillsViewportHeight(true);
		tabelaLivros.setModel(new DefaultTableModel(
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
		tabelaLivros.getColumnModel().getColumn(0).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(222);
		tabelaLivros.getColumnModel().getColumn(1).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(89);
		tabelaLivros.getColumnModel().getColumn(2).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(85);
		tabelaLivros.getColumnModel().getColumn(3).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabelaLivros.getColumnModel().getColumn(4).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(4).setPreferredWidth(64);
		scrollPane.setViewportView(tabelaLivros);
		
		JButton btnAdicionarAoCarrinho = new JButton("Adicionar ao carrinho");
		btnAdicionarAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdicionarAoCarrinho.setEnabled(false);
				ControleCarrinho cc = new ControleCarrinho();
				String tituloLivro = "";
				for(int i = 0; i < tabelaLivros.getColumnCount(); i++){
					if (tabelaLivros.getColumnName(i) == "Titulo"){
						tituloLivro = tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), i).toString();
						break;
					}
				}
				if(!cc.verificaItem(tituloLivro)){
					try {
						AdicionarAoCarrinho addCarrinho = new AdicionarAoCarrinho(tituloLivro);
						addCarrinho.setVisible(true);
					} catch (Exception exp) {
						exp.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Item j� foi adicionado!");
				}
			}
		});
		btnAdicionarAoCarrinho.setEnabled(false);
		btnAdicionarAoCarrinho.setBounds(290, 372, 158, 23);
		contentPane.add(btnAdicionarAoCarrinho);
		
		tabelaLivros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tabelaLivros.getRowCount() > 0 && tabelaLivros.getSelectedRowCount() == 1) {
					btnAdicionarAoCarrinho.setEnabled(true);
				} else {
					btnAdicionarAoCarrinho.setEnabled(false);
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(tabelaLivros.getRowCount() > 0 && tabelaLivros.getSelectedRowCount() == 1) {
					btnAdicionarAoCarrinho.setEnabled(true);
				} else {
					btnAdicionarAoCarrinho.setEnabled(false);
				}
			}
		});
		tabelaLivros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(tabelaLivros.getRowCount() > 0 && tabelaLivros.getSelectedRowCount() == 1) {
					btnAdicionarAoCarrinho.setEnabled(true);
				} else {
					btnAdicionarAoCarrinho.setEnabled(false);
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(tabelaLivros.getRowCount() > 0 && tabelaLivros.getSelectedRowCount() == 1) {
					btnAdicionarAoCarrinho.setEnabled(true);
				} else {
					btnAdicionarAoCarrinho.setEnabled(false);
				}
			}
		});
	}
}
