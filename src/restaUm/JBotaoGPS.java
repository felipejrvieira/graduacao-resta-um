package restaUm;

import javax.swing.JButton;

public class JBotaoGPS extends JButton{

	private static final long serialVersionUID = 7120880313721167293L;
	private int lin;
	private int col;
	
	public JBotaoGPS(int l,int c){
		lin = l;
		col = c;
	}
	public void setLinha(int l){
		lin = l;
	}
	public void setColuna(int c){
		col = c;
	}
	public int getLinha(){
		return lin;
	}
	public int getColuna(){
		return col;
	}

}
