package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControleLivro;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExcluirLivro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTable tabelaLivros;
	private JButton btnExcluir;

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
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 11, 533, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleLivro cl = new ControleLivro();				
				cl.pesquisarLivros(tfNome.getText());
				
			}
		});
		btnPesquisar.setBounds(584, 10, 89, 23);
		contentPane.add(btnPesquisar);
		
		tabelaLivros = new JTable();
		tabelaLivros.setBounds(10, 61, 663, 325);
		contentPane.add(tabelaLivros);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleLivro cl = new ControleLivro();	
				int selecionada = tabelaLivros.getSelectedRow();
				if (selecionada == -1) {
				    return; 
				}
				String isbn = tabelaLivros.getValueAt(selecionada, 2).toString();	
				cl.excluirLivro( isbn );
				JOptionPane.showMessageDialog(null, "Usuário excluido");
			}
		});
		btnExcluir.setBounds(10, 411, 89, 23);
		contentPane.add(btnExcluir);
	}
}
