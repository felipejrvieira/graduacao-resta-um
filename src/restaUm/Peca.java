package restaUm;

public class Peca {
	private int posL;
	private int posC;
	public Peca(int x, int y){
		posL = x;
		posC = y;
	}
	public String toString(){
		return "O";
	}
	public int obterL(){
		return posL;
	}
	public int obterC(){
		return posC;
	}
	public void atribuir(int l, int c){
		posL = l;
		posC = c;
	}
}
