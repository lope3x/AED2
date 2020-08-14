public class ex1{
	public static void main(String[]args){
		Arvore a1 = new Arvore();
		Arvore a2 = new Arvore();
		Arvore a3;
		a1.inserir(9);
		a2.inserir(2);
		a1.inserir(1);
		a2.inserir(7);
		a1.inserir(4);
		a2.inserir(3);
		a1.inserir(5);
		a2.inserir(6);
		a1.inserir(8);
		a2.inserir(0);
		System.out.println("A1");
		a1.mostrarCentral();
		System.out.println("A2");
		a2.mostrarCentral();
		System.out.println("A3");
		Arvore a4 = new Arvore();
		a3 = new Arvore(a4.merge(a1.raiz,a2.raiz));
		a3.mostrarCentral();
		//System.out.println(a.soma());
		//System.out.println(a.contaMultiplo4());
		//System.out.println(a.hasMultiplo4());

	}
}
class Arvore{
	No raiz;
	Arvore(){
		raiz=null;
	}
	Arvore(No raiz){
		this.raiz=raiz;
	}
	public void inserir(int x){
		raiz=inserir(x,raiz);
	}
	private No inserir(int x,No i){
		if(i==null){
			i = new No(x);
		}
		else if(x<i.elemento){
			i.esq=inserir(x,i.esq);
		}
		else if(x>i.elemento){
			i.dir=inserir(x,i.dir);
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
	public int soma(){
		return soma(raiz);
	}
	private int soma(No i){
		int resp = 0;
		if(i!=null){
			resp+=soma(i.esq);
			resp+=soma(i.dir);
			resp+=i.elemento;
		}
		return resp;
	}
	public int contaMultiplo4(){
		System.out.print("raiz ");
		return contaMultiplo4(raiz);
	}
	private int contaMultiplo4(No i){
		int resp=0;
		if(i!=null){
			if(i.elemento%4==0){
				resp++;
			}
			System.out.print("esq ");
			resp+=contaMultiplo4(i.esq);
			System.out.print("dir ");
			resp+=contaMultiplo4(i.dir);
		}
		return resp;
	}
	public boolean hasMultiplo4(){
		System.out.print("raiz ");
		return hasMultiplo4(raiz);
	}
	private boolean hasMultiplo4(No i){
		boolean resp=false;
		if(i!=null){
			if(i.elemento%4!=0){
				System.out.print("dir ");	
				resp = hasMultiplo4(i.dir);
				if(!resp){
					System.out.print("esq ");
					resp = hasMultiplo4(i.esq);
				}
			}
			else{
				resp=true;
			}
		}
		return resp;
	}
	public No merge(No r1,No r2){
		Arvore a3 = new Arvore();
		a3.raiz = merge(r1,r2,a3.raiz);
		return a3.raiz;
	}
	private No merge(No r1,No r2,No r3){
		r3 =  merge1(r1,r3);
		r3 = merge2(r2,r3);
		return r3;
	}
	private No merge1(No r1,No r3){
		if(r1!=null){
			r3 = inserir(r1.elemento,r3);
			/*r3 =*/ merge1(r1.esq,r3);
			/*r3 =*/ merge1(r1.dir,r3);
		}
		return r3;
	}
	private No merge2(No r2,No r3){
		if(r2!=null){
			r3 = inserir(r2.elemento,r3);
			/*r3 = */merge2(r2.esq,r3);
			/*r3 =*/ merge2(r2.dir,r3);
		}
		return r3;
	}
}
class No{
	No esq;
	No dir;
	int elemento;
	No(int x){
		elemento=x;
		esq=null;
		dir=null;
	}
}
