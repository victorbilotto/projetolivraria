package View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import Controller.ControleCarrinho;

import javax.swing.event.ChangeEvent;

import java.awt.EventQueue;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class AdicionarAoCarrinho extends JFrame {
	

	private JPanel contentPane;


	public AdicionarAoCarrinho(String titulo) {
		setTitle("Adicionar ao Carrinho");
		setResizable(false);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnSelecione = new JTextPane();
		txtpnSelecione.setBackground(SystemColor.control);
		txtpnSelecione.setEditable(false);
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setBold(sas, true);
		int tituloLength = titulo.length();
		txtpnSelecione.setText("Selecione a quantidade do livro \"" + titulo + "\" para ser adicionado ao Carrinho de Compras");
		txtpnSelecione.getStyledDocument().setCharacterAttributes(33, tituloLength, sas, false);
		txtpnSelecione.setBounds(10, 11, 274, 53);
		contentPane.add(txtpnSelecione);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setBounds(111, 75, 69, 20);
		contentPane.add(spinner);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControleCarrinho cc = new ControleCarrinho();
				if(Integer.parseInt(spinner.getValue().toString()) > 0){
					cc.adicionarItem(titulo, Integer.parseInt(spinner.getValue().toString()));
					dispose();
				}
			}
		});
		btnAdicionar.setBounds(10, 127, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(195, 127, 89, 23);
		contentPane.add(btnCancelar);
		
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner.getValue().toString()) > 0){
					btnAdicionar.setEnabled(true);
				} else {
					btnAdicionar.setEnabled(false);
				}
			}
		});
	}
}
