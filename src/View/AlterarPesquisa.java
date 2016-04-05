package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControleLivro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarPesquisa extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTable tabelaLivros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarPesquisa frame = new AlterarPesquisa();
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
	public AlterarPesquisa() {
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
				cl.pesquisarLivros(tfTitulo.getText());
				tabelaLivros.revalidate();
			}
		});
		btnPesquisar.setBounds(510, 7, 89, 23);
		contentPane.add(btnPesquisar);
		
		tabelaLivros = new JTable();
		tabelaLivros.setBounds(10, 47, 589, 289);
		contentPane.add(tabelaLivros);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleLivro cl = new ControleLivro();
				int selecionada = tabelaLivros.getSelectedRow();
				if (selecionada == -1) {
				    return; 
				}
				String escolhido = tabelaLivros.getValueAt(selecionada, 2).toString();
				
				cl.alteraEscolhido(escolhido);
			}
		});
		btnAlterar.setBounds(10, 370, 89, 23);
		contentPane.add(btnAlterar);
	}

}
