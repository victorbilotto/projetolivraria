package Controller;

import java.awt.event.KeyEvent;

import javax.swing.JTextArea;

public class JTextAreaTudo extends JTextArea{
	private int maximoCaracteres=-1;
	public JTextAreaTudo(){
		  super();
	        addKeyListener(new java.awt.event.KeyAdapter() {
	            @Override
	            public void keyTyped(java.awt.event.KeyEvent evt) {
	                jTextFieldKeyTyped(evt);}});
	}

	private void jTextFieldKeyTyped(KeyEvent evt) {
		String caracteres="[]^~�`/?+=-_@#$%�&*";
		if(caracteres.contains(evt.getKeyChar()+"")){
			evt.consume();
		}
		if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
			evt.consume();
			setText(getText().substring(0,getMaximoCaracteres()));
		}
		
	}
	
	public int getMaximoCaracteres() {
        return maximoCaracteres;
	}
	public void setMaximoCaracteres(int maximoCaracteres) {
		 this.maximoCaracteres = maximoCaracteres;
    }
}
