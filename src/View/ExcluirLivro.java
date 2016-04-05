package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControleLivro;
import model.Livro;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ExcluirLivro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JButton btnExcluir;
	private JTable tabelaLivros;
	private JScrollPane sp_tbl_livro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirLivro frame = new ExcluirLivro();
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
	public ExcluirLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ControleLivro cl = new ControleLivro();
		
		tfNome = new JTextField();
		tfNome.setBounds(65, 11, 478, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleLivro cl = new ControleLivro();	
				cl.populaTabela(tfNome.getText(), tabelaLivros);
				
			}
		});
		btnPesquisar.setBounds(584, 10, 89, 23);
		contentPane.add(btnPesquisar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleLivro cl = new ControleLivro();	
				int selecionada = tabelaLivros.getSelectedRow();
				if (selecionada == -1) {
				    return; 
				}
				String isbn = tabelaLivros.getValueAt(selecionada, 1).toString();	
				cl.excluirLivro( isbn );
				JOptionPane.showMessageDialog(null, "Livro excluido com sucesso");
			}
		});
		btnExcluir.setBounds(10, 411, 89, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 14, 46, 14);
		contentPane.add(lblTitulo);
		
		sp_tbl_livro = new JScrollPane();
		sp_tbl_livro.setBounds(10, 39, 659, 367);
		contentPane.add(sp_tbl_livro);
		
		tabelaLivros = new JTable();
		sp_tbl_livro.setViewportView(tabelaLivros);
		tabelaLivros.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "ISBN", "Autor", "Editora"
			}
		));
		
	}
}
