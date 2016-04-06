package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControleLivro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AlterarLivroPesquisa extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTable tabelaLivros;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarLivroPesquisa frame = new AlterarLivroPesquisa();
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
	public AlterarLivroPesquisa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 11, 46, 14);
		contentPane.add(lblTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(50, 8, 450, 20);
		contentPane.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleLivro cl = new ControleLivro();				
				cl.populaTabela(tfTitulo.getText(), tabelaLivros);
				
			}
		});
		btnPesquisar.setBounds(510, 7, 89, 23);
		contentPane.add(btnPesquisar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 589, 289);
		contentPane.add(scrollPane);
		
		tabelaLivros = new JTable();
		tabelaLivros.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "ISBN", "Autor", "Editora"
			}
		));
		tabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(298);
		tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(123);
		tabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(95);
		tabelaLivros.getColumnModel().getColumn(3).setPreferredWidth(106);
		scrollPane.setViewportView(tabelaLivros);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleLivro cl = new ControleLivro();
				int selecionada = tabelaLivros.getSelectedRow();
				if (selecionada == -1) {
				    return; 
				}
				String escolhido = tabelaLivros.getValueAt(selecionada, 1).toString();
				cl.alteraEscolhido(escolhido);
			}
		});
		btnAlterar.setBounds(10, 370, 89, 23);
		contentPane.add(btnAlterar);
	}

}
