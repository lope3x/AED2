public class principal{
	public static void main(String[]args){
		int repete = MyIO.readInt();
		int linhas,colunas;
		for(int i=0;i<repete;i++){
			linhas = MyIO.readInt();
			colunas = MyIO.readInt();
			MatrizDinamica m1= new MatrizDinamica(colunas,linhas);
			m1.preenche();
			linhas = MyIO.readInt();
			colunas = MyIO.readInt();
			MatrizDinamica m2= new MatrizDinamica(colunas,linhas);
			m2.preenche();
			Arvore a;
			a = insereArvore(m1);
			MyIO.println("m1 em ordem");
			a.mostrarCentral();
			a = insereArvore(m2);
			MyIO.println("m2 em ordem");
			a.mostrarCentral();
		}
	}
	public static Arvore insereArvore(MatrizDinamica m){
		Arvore a = new Arvore();
		for(Celula i = m.inicio;i!=null;i=i.inf){
			for(Celula j = i;j!=null;j=j.dir){
				a.inserir(j.elemento);
			}
		}
		return a;
	}
}
class Arvore{
	No raiz;
	Arvore(){
		raiz=null;
	}
	//insercao na arv lg(n)
	public void inserir(int x){
		raiz = inserir(raiz,x);
	}
	public No inserir(No i , int x){
		if(i==null){
			i = new No(x);
		}
		else if(x<i.elemento){
			i.esq=inserir(i.esq,x);
		}
		else if(x>i.elemento){
			i.dir=inserir(i.dir,x);
		}
		//REPETIDO FICAM A ESQUERDA
		else if(x == i.elemento){
			i.esq=inserir(i.esq,x);
		}
		return i;
	}
	public void mostrarCentral(){
		mostrarCentral(raiz);
		MyIO.println("");
	}
	public void mostrarCentral(No i){
		if(i!=null){
			mostrarCentral(i.esq);
			System.out.print(i.elemento+" ");
			mostrarCentral(i.dir);
		}
	}
}
class No{
	No esq;
	No dir;
	int elemento;
	No(int elemento){
		this.elemento=elemento;
		esq=dir=null;
	}
}
class MatrizDinamica{
	Celula inicio;
	MatrizDinamica(int c,int l){
		inicio = new Celula();
		Celula old = inicio;
		Celula aux=inicio;
		Celula tmp;
		Celula a;
		Celula b;
		for(int i=0;i<c;i++){
			if(i==0){
				for(int j=1;j<l;j++){
					tmp=new Celula();
					tmp.esq=old;
					old.dir=tmp;
					old=tmp;
				}
			}
			else{
				old=new Celula();
				old.sup=aux;
				aux.inf=old;
				a=aux.dir;
				for(int j=1;j<l;j++){
					b=new Celula();
					old.dir=b;
					b.esq=old;
					a.inf=b;
					b.sup=a;
					old=b;
					a=a.dir;
				}
				aux=aux.inf;
			}
		}
	}
	public void mostrar(){
		for(Celula i=inicio;i!=null;i=i.inf){
			for(Celula j=i;j!=null;j=j.dir){
				MyIO.print(j.elemento+" ");
			}
			MyIO.println("");
		}
	}
	public void preenche(){
		for(Celula i=inicio;i!=null;i=i.inf){
			for(Celula j=i;j!=null;j=j.dir){
				int x = MyIO.readInt();
				j.elemento=x;
			}
		}
	}
}
class Celula{
	Celula dir;
	Celula esq;
	Celula sup;
	Celula inf;
	int elemento;
	Celula(int x){
		dir=null;
		esq=null;
		inf=null;
		sup=null;
		elemento=x;
	}
	Celula(){
		dir=null;
		esq=null;
		inf=null;
		sup=null;
	}
}