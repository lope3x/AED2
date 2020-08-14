public class TabelaDeAvl{
	public static void main(String[]args){
		AVL[] vet= new AVL[11];
		for(int i=0;i<11;i++){
			vet[i]=new AVL();
		}
		int x;
		x=10;
		inserir(x,vet);
		mostrar(vet);
	}
	public static void inserir(int x,AVL[] vet){
		vet[x%11].inserir(x);
	}
	public static void mostrar(AVL[] vet){
		for(int i=0;i<11;i++){
			vet[i].MostrarCentral();
		}
	}
}
class AVL{
	No raiz;
	int cmp;
	AVL(){
		raiz = null;
		cmp=0;
	}
	public void inserir(int x){
		raiz = inserir(x,raiz);
	}
	private No inserir(int x,No i){
		if(i==null){
			i=new No(x);
		}
		else if(x>i.elemento){
			i.dir = inserir(x,i.dir);
		}
		else if(x<i.elemento){
			i.esq = inserir(x,i.esq);
		}
		i=balancear(i);
		return i;
	}
	public boolean pesquisar(int x){
		MyIO.print(" raiz ");
		return pesquisar(x,raiz);
	}
	private boolean pesquisar(int x,No i){
		boolean resp;
		cmp++;
		if(i==null){
			resp = false;
		}
		else if(x>i.elemento){
			cmp++;
			MyIO.print("dir ");
			resp=pesquisar(x, i.dir);
		}
		else if(x<i.elemento){
			cmp++;
			MyIO.print("esq ");
			resp = pesquisar(x,i.esq);
		}
		else{
			resp=true;
		}
		return resp;
	}
	public void MostrarCentral(){
		MostrarCentral(raiz);
	}
	private void MostrarCentral(No i){
		if(i!=null){
			MostrarCentral(i.esq);
			MyIO.println(i.elemento);
			MostrarCentral(i.dir);
		}
	}
	private No balancear(No i){
		if(i!=null){
			int fator = i.getNivel(i.dir) -  i.getNivel(i.esq);
			//balanceada
			if(Math.abs(fator)<=1){
				i = i.setNivel(); 
			}
			//desbalanceada para direita
			else if(fator==2){
				int fatorpai = i.getNivel(i.dir.dir) - i.getNivel(i.dir.esq);
				if(fatorpai == -1){
					//rotacao dupla para dir
					i.dir = rotacaoDir(i.dir);
				}
				i = rotacaoEsq(i);
			}
			//desbalanceada para esquerda fator = -2
			else{
				int fatorpai = i.getNivel(i.esq.dir) - i.getNivel(i.esq.esq);
				if(fatorpai == 1){
					//rotacao dupla para dir
					i.esq = rotacaoEsq(i.esq);
				}
				i = rotacaoDir(i);
			}
		}
		return i;
	}
	private No rotacaoEsq(No i){
		No noDir = i.dir;
		No noDirEsq = noDir.esq;
		
		noDir.esq = i;
		i.dir = noDirEsq;
		
		i.setNivel();
		noDir.setNivel();
		
		return noDir;
	}
	private No rotacaoDir(No i){
		No noEsq = i.esq;
		No noEsqDir = noEsq.dir;
		
		noEsq.dir = i;
		i.esq = noEsqDir;
		
		i.setNivel();
		noEsq.setNivel();
		
		return noEsq;
	}
}
class No{
	No esq;
	No dir;
	int elemento;
	int nivel;
	No(int x){
		this(x,null,null,1);
	}
	No(int x,No esq, No dir,int nivel){
		this.esq=esq;
		this.dir=dir;
		elemento=x;
		this.nivel=nivel;
	}
	public No setNivel() {
      this.nivel = 1 + Math.max(getNivel(esq),getNivel(dir));
      return this;
	}
 
	// Retorna o número de níveis a partir de um vértice 
	public static int getNivel(No no) {
      return (no == null) ? 0 : no.nivel;
	}
}

