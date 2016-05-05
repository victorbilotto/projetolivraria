package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;

import Controller.ControleCarrinho;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AlterarProdutoCarrinho extends JFrame{
	public AlterarProdutoCarrinho(String ISBN, String Titulo, String Preco, String Quantidade, JTable tabelaLivros, JLabel lblTotalCalculado) {
		setResizable(false);
		setTitle("Alterar Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 229);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(10, 36, 46, 14);
		getContentPane().add(lblIsbn);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(10, 61, 46, 14);
		getContentPane().add(lblPreo);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 86, 73, 14);
		getContentPane().add(lblQuantidade);
		
		JLabel tituloLivro = new JLabel(Titulo);
		tituloLivro.setBounds(88, 11, 331, 14);
		getContentPane().add(tituloLivro);
		
		JLabel lblIsbnLivro = new JLabel(ISBN);
		lblIsbnLivro.setBounds(88, 36, 331, 14);
		getContentPane().add(lblIsbnLivro);
		
		JLabel lblPrecoLivro = new JLabel(Preco);
		lblPrecoLivro.setBounds(88, 61, 331, 14);
		getContentPane().add(lblPrecoLivro);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(84, 83, 51, 20);
		getContentPane().add(spinner);
		spinner.setValue(Integer.parseInt(Quantidade));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleCarrinho cc = new ControleCarrinho();
				cc.updateQuantidade(spinner.getValue().toString(), lblIsbnLivro.getText());
				cc.populaTabela(tabelaLivros, lblTotalCalculado);
			}
		});
		btnAlterar.setBounds(10, 164, 89, 23);
		getContentPane().add(btnAlterar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(330, 164, 89, 23);
		getContentPane().add(btnFechar);
	}
}
