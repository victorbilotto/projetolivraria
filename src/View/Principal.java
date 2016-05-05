package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setResizable(false);
		setTitle("Projeto Livraria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionarLivro = new JButton("Adicionar Livro");
		btnAdicionarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AdicionarLivro addLivro = new AdicionarLivro();
							addLivro.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAdicionarLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdicionarLivro.setBounds(10, 11, 170, 40);
		contentPane.add(btnAdicionarLivro);
		
		JButton btnAlterarLivro = new JButton("Alterar Livro");
		btnAlterarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AlterarLivroPesquisa altLivro = new AlterarLivroPesquisa();
							altLivro.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAlterarLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAlterarLivro.setBounds(254, 11, 170, 40);
		contentPane.add(btnAlterarLivro);
		
		JButton btnExcluirLivro = new JButton("Excluir livro");
		btnExcluirLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ExcluirLivro excLivro = new ExcluirLivro();
							excLivro.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnExcluirLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluirLivro.setBounds(10, 86, 170, 40);
		contentPane.add(btnExcluirLivro);
		
		JButton btnPesquisarLivro = new JButton("Pesquisar Livro");
		btnPesquisarLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPesquisarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PesquisarLivro pesqLivro = new PesquisarLivro();
							pesqLivro.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnPesquisarLivro.setBounds(254, 86, 170, 40);
		contentPane.add(btnPesquisarLivro);
		
		JButton btnVisualizarCarrinho = new JButton("Visualizar Carrinho");
		btnVisualizarCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VisualizarCarrinho viewCarrinho = new VisualizarCarrinho();
							viewCarrinho.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnVisualizarCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVisualizarCarrinho.setBounds(10, 161, 170, 40);
		contentPane.add(btnVisualizarCarrinho);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(254, 161, 170, 40);
		contentPane.add(btnSair);
	}
}
