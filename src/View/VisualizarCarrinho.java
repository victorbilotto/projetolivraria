package View;

import java.awt.EventQueue;

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
import DAO.DAOCarrinho;
import DAO.DAOCarrinhoImpl;
import model.Carrinho;
import model.EnumCategoria;
import model.Item;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class VisualizarCarrinho extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarCarrinho frame = new VisualizarCarrinho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	private JTable tabelaLivros;
	private JScrollPane scrollPane;
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VisualizarCarrinho() {
		
		setTitle("Carrinho");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 11, 684, 310);
		contentPane.add(scrollPane);
		
		tabelaLivros = new JTable();
		tabelaLivros.setFillsViewportHeight(true);
		tabelaLivros.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ISBN", "Titulo", "Autor", "Editora", "Categoria", "Valor (R$)", "Quantidade"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaLivros.getColumnModel().getColumn(1).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(222);
		tabelaLivros.getColumnModel().getColumn(2).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(89);
		tabelaLivros.getColumnModel().getColumn(3).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(3).setPreferredWidth(85);
		tabelaLivros.getColumnModel().getColumn(4).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabelaLivros.getColumnModel().getColumn(5).setResizable(false);
		tabelaLivros.getColumnModel().getColumn(5).setPreferredWidth(64);
		scrollPane.setViewportView(tabelaLivros);
		
		ControleCarrinho cc = new ControleCarrinho();
		
		JLabel lblTotalCalculado = new JLabel("");
		lblTotalCalculado.setBounds(581, 332, 113, 14);
		contentPane.add(lblTotalCalculado);
		
		cc.deletaLivroAntigo();
		cc.populaTabela(tabelaLivros, lblTotalCalculado);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "COMPRA CONFIRMADA");
			}
		});
		btnConfirmar.setBounds(10, 376, 106, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(605, 376, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selecionada = tabelaLivros.getSelectedRow();
				if (selecionada == -1) {
				    return; 
				}
				String ISBN = tabelaLivros.getValueAt(selecionada, 0).toString();
				String Titulo = tabelaLivros.getValueAt(selecionada, 1).toString();
				String Preco = tabelaLivros.getValueAt(selecionada, 5).toString();
				String Quantidade = tabelaLivros.getValueAt(selecionada, 6).toString();
				try {
					AlterarProdutoCarrinho apc = new AlterarProdutoCarrinho(ISBN, Titulo, Preco, Quantidade, tabelaLivros, lblTotalCalculado	);
					apc.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAlterar.setBounds(237, 376, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleCarrinho cc = new ControleCarrinho();
				int selecionada = tabelaLivros.getSelectedRow();
				if (selecionada == -1) {
				    return; 
				}
				String escolhido = tabelaLivros.getValueAt(selecionada, 0).toString();
				try {
					cc.deletaLivro(escolhido);
					cc.populaTabela(tabelaLivros, lblTotalCalculado);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(336, 376, 89, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(545, 332, 46, 14);
		contentPane.add(lblTotal);
		
		
		
		
	}
}
