import java.util.Random;
public class arvore{
	public static void main(String[]args){
		//Random gerador = new Random();
		Tree t = new Tree();
		/*for(int i = 0;i<1000;i++){
			t.inserir(Math.abs(gerador.nextInt()%2));
		}*/
		t.inserir(7);
		t.inserir(3);
		t.inserir(11);
		/*t.inserir(1);
		t.inserir(5);
		t.inserir(9);
		t.inserir(12);
		t.inserir(0);
		t.inserir(2);
		t.inserir(4);
		t.inserir(6);
		t.inserir(8);
		t.inserir(10);
		t.inserir(13);
		t.inserir(14);
		t.inserir(1);*/
		
		System.out.println(t.ehCompleta());
		//t.mostrarPos();
	}
}
class No{
	No esq;
	No dir;
	int elemento;
	No(int elemento){
		this.elemento=elemento;
		this.esq=null;
		this.dir=null;
	}
}
class Tree{
	No raiz;
	public void inserir(int x){
		raiz=inserir(x,raiz);
	}
	public No inserir(int x,No i){
		if(i==null){
			i= new No(x);
		}
		else if(x<i.elemento){
			i.esq = inserir(x,i.esq);
		}
		else if(x>i.elemento){
			i.dir = inserir(x,i.dir);
		}
		return i;
	}/*
	public boolean ehCompleta(){
		return ehcompleta(raiz);
	}
	/**
	*	O metodo se utiliza do metodo getAltura , para comparar se a altura da direita e da esquerda
	*	de cada No eh igual , caso não seja , a árvore não é completa.
	*//*
	private boolean ehCompleta(No i){
		boolean resp = true;
		if(i!=null&&resp){
			resp =ehCompleta(i.esq);
			if(resp){
				resp = ehCompleta(i.dir);
			}
			if(resp&&getAltura(i.esq)!=getAltura(i.dir)){
				resp=false;
			}
		}
		return resp;
	}
	private boolean ehcompleta(No i){
		boolean resp=true;
		if(i!=null){
			resp  = (getAltura(i.esq) != getAltura(i.dir)) ? false :true ;
			if(resp){
				resp = ehcompleta(i.esq);
				if(resp){
					resp =  ehcompleta(i.dir);
				}
			}
		}
		return resp;
	}*/
	public int getAltura(){
		return getAltura(raiz);
	}
	private int getAltura(No i){
		int resp = 0;
		if(i!=null){
			int a = getAltura(i.esq);
			int b = getAltura(i.dir);
			resp = (a>b) ? a+1 : b+1;
		}
		return resp;
	}
	public boolean ehCompleta(){
		return ehCompleta(raiz);
	}
	private boolean ehCompleta(No i){
		boolean resp =true;
		if(i!=null){
			if(getAltura(i.esq)!=getAltura(i.dir)){
				resp =false;
				// n eh completa
			}
			else{
				resp = ehCompleta(i.esq);
				if(resp){
					resp = ehCompleta(i.dir);
				}
			}
		}
		return resp;
	}
	public void mostrarPos(){
		mostrarPos(raiz);		
	}
	private void mostrarPos(No i){
		if(i!=null){
			mostrarPos(i.esq);
			mostrarPos(i.dir);
			System.out.printf("%d\n",i.elemento);
		}
	}
}
