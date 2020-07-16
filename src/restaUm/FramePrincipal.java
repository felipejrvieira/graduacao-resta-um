package restaUm;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FramePrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -2783086598815510755L;
	private JBotaoGPS botoes[];
	private boolean selecionado = false;
	private int linha;
	private int coluna;
	private Tabuleiro jogo;
	
	public FramePrincipal(){
		super("RESTA-UM FOREVER");
		setLayout(new GridLayout(9,9));
		botoes = new JBotaoGPS[45];
		int k = 0;
		for(int i = 0; i<9;i++)
			for (int j = 0; j<9;j++){
				if((j>2 && j<6)||(i>2 && i<6)){
					botoes[k]= new JBotaoGPS(i,j);
					botoes[k].addActionListener(this);
					add(botoes[k++]);
				}
				else{
					add(new JPanel());
				}
			}
		jogo = new Tabuleiro();
		mostrarImagem();
	}
	
	public void mostrarImagem(){
		Icon imagem = new ImageIcon(getClass().getResource("peca.png"));
		int k = 0;
		for(int i = 0; i<9;i++)
			for (int j = 0; j<9;j++){
				if((j>2 && j<6)||(i>2 && i<6)){
					if (jogo.localizar(botoes[k].getLinha(), botoes[k].getColuna())!=null)
						botoes[k].setIcon(imagem);
					else
						botoes[k].setIcon(null);
					k++;
				}
			}
	}
	
	public void actionPerformed(ActionEvent e){
		for(int i = 0; i<botoes.length;i++){
			if(botoes[i] == e.getSource()){
				if (!selecionado){
					linha = botoes[i].getLinha();
					coluna = botoes[i].getColuna();
					if (jogo.localizar(linha, coluna) != null)
						selecionado = true;
					else
						JOptionPane.showMessageDialog(null,"Jogada Inv�lida","Aviso!",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					if (!jogo.movimentacao(botoes[i].getLinha(), botoes[i].getColuna(), jogo.localizar(linha, coluna)))
						JOptionPane.showMessageDialog(null,"Jogada Inv�lida","Aviso!",JOptionPane.INFORMATION_MESSAGE);
					else{
						System.out.println(jogo);
						mostrarImagem();
					}
					selecionado = false;
				}
				if (jogo.fimDeJogo()){
					JOptionPane.showMessageDialog(null,"Fim de Jogo!","Aviso!",JOptionPane.INFORMATION_MESSAGE);
					for(int k = 0; k<botoes.length;k++)
						botoes[k].setEnabled(false);
				}
				break;
			}
		}
	}
}
