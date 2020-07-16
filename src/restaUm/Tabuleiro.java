package restaUm;

public class Tabuleiro {
	private Peca[] pecas;
	public Tabuleiro(){
		int k = 0;
		pecas = new Peca[44];
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(((j>2 && j<6)||(i>2 && i<6))&&((i!=4)||(j!=4)))
					pecas[k++] = new Peca(i,j);	
	}
	public Peca localizar(int l,int c){
		for(int i=0;i<pecas.length;i++)
			if(pecas[i]!=null)
				if((pecas[i].obterL()==l)&&(pecas[i].obterC()==c))
					return pecas[i];
		return null;
	}
	private void destruir(int l,int c){
		for(int i=0;i<pecas.length;i++)
			if(pecas[i]!=null)
				if((pecas[i].obterL()==l)&&(pecas[i].obterC()==c)){
					pecas[i]=null;
					break;
				}
	}
	public boolean movimentacao(int i,int j, Peca ativa){
		if((((i>-1)&&(i<9))&&((j>-1)&&(j<9)))&&((((i>2)&&(i<6))||((j>2)&&(j<6))))){
			if(localizar(i,j)==null){
				if((ativa.obterL()==i)){
					if((j-ativa.obterC())==2)
						if(localizar(ativa.obterL(),ativa.obterC()+1)!=null){
							destruir(ativa.obterL(),ativa.obterC()+1);
							ativa.atribuir(i, j);
							return true;
						}
					if((j-ativa.obterC())==-2)
						if(localizar(ativa.obterL(),ativa.obterC()-1)!=null){
							destruir(ativa.obterL(),ativa.obterC()-1);
							ativa.atribuir(i, j);
							return true;
						}
				}
				if((ativa.obterC()==j)){
					if((i-ativa.obterL())==2)
						if(localizar(ativa.obterL()+1,ativa.obterC())!=null){
							destruir(ativa.obterL()+1,ativa.obterC());
							ativa.atribuir(i, j);
							return true;
						}
					if((i-ativa.obterL())==-2)
						if(localizar(ativa.obterL()-1,ativa.obterC())!=null){
							destruir(ativa.obterL()-1,ativa.obterC());
							ativa.atribuir(i, j);
							return true;
						}
				}
			}
		}
		return false;
	}
	public boolean fimDeJogo(){
		for(int i=0;i<pecas.length;i++)
			if(pecas[i]!=null){
				if((localizar(pecas[i].obterL()-1,pecas[i].obterC())!=null)&&
				   (localizar(pecas[i].obterL()-2,pecas[i].obterC())==null)&&
				   (espacoJogavel(pecas[i].obterL()-2,pecas[i].obterC()))) 
					return false;
				if((localizar(pecas[i].obterL()+1,pecas[i].obterC())!=null)&&
				   (localizar(pecas[i].obterL()+2,pecas[i].obterC())==null)&&
				   (espacoJogavel(pecas[i].obterL()+2,pecas[i].obterC()))) 
					return false;
				if((localizar(pecas[i].obterL(),pecas[i].obterC()-1)!=null)&&
				   (localizar(pecas[i].obterL(),pecas[i].obterC()-2)==null)&&
				   (espacoJogavel(pecas[i].obterL(),pecas[i].obterC()-2))) 
					return false;
				if((localizar(pecas[i].obterL(),pecas[i].obterC()+1)!=null)&&
				   (localizar(pecas[i].obterL(),pecas[i].obterC()+2)==null)&&
				   (espacoJogavel(pecas[i].obterL(),pecas[i].obterC()+2))) 
					return false;
			}
		return true;
	}
	private boolean espacoJogavel(int l, int c){
		return ((l>2 && l<6)||(c>2 && c<6));
	}
	public String toString(){
		boolean desenhou;
		String saida = new String();
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				desenhou = false;
				for(int k = 0;k<pecas.length;k++){
					if (pecas[k]!=null)
						if((pecas[k].obterL()==i) && (pecas[k].obterC()==j)){
							saida+=pecas[k];
							desenhou = true;
							break;	
						}
				}
				if(!desenhou)
					saida+=" ";
			}
				saida+="\n";
		}
		return saida;
	}
}