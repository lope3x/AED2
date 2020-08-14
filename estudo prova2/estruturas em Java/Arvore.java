public class Arvore{
	public static void main(String[]args){
		
	}
}
class Tree{
	No raiz;
	public Tree(){
		raiz = null;
	}
	public void inserir(int x){
		raiz = inserir(raiz,x);
	}
	private No inserir(No i,int x){
		if(i==null){
			i=new No(x);
		}
		else if(x<i.elemento){
			i.esq = inserir(i.esq,x);
		}
		else if(x>i.elemento){
			i.dir = inserir(i.dir,x);
		}
		return i;
	}
	public void mostrarCentral(){
		mostrarCentral(raiz);
	}
	private void mostrarCentral(No i){
		if(i!=null){
			mostrarCentral(i.esq);
			System.out.println(i.elemento);
			mostrarCentral(i.dir);
		}
	}
	public boolean pesquisar(int x){
		return pesquisar(raiz,x);
	}
	private boolean pesquisar(No i,int x){
		boolean resp;
		if(i==null){
			resp=false;
		}
		else if(x==i.elemento){
			resp=true;
		}
		else if(x<i.elemento){
			resp=pesquisar(i.esq,x);
		}
		else{
			resp=pesquisar(i.dir,x);
		}
		return resp;
	}
	public void remover(int x){
		raiz = remover(raiz,x);
	}
	private No remover(No i,int x){
		if(x<i.elemento){
			i.esq = remover(i.esq,x);
		}
		else if(x>i.elemento){
			i.dir = remover(i.dir,x);
		}
		else if(i.dir==null){
			i = i.esq;
		}
		else if(i.esq==null){
			i = i.dir;
		}
		else {
			i.esq = anterior(i,i.esq);
		}
		return i;
	}
	private No anterior(No i,No j){
		if(j.dir==null){
			i.elemento=j.elemento;
			j=j.esq;
		}
		else{
			j.dir = anterior(i,j.dir);
		}
		return j;
	}
}
class No{
	No esq;
	No dir;
	int elemento;
	public No(int elemento){
		this.elemento=elemento;
		esq = null;
		dir = null;
	}
}