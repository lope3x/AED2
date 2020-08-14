public class doidona{
	public static void main(String[]args){
		
	}
	
}
class doido{
	int[] t1;
	int[] t3;
	final int NULO = -1;
	int tamTabt1;
	int tamReservat1;
	No raizT2,raizT3;
	Celula primeiroT2,ultimoT2;
	doido (){
		tamTabt1 = 10;
		tamReservat1 = 3;
		tamTabt3 = 10;
		tamReservat3 = 1;
		t1 = new int[tamTabt1+tamReservat1];
		t3 = new int[tamTabt3+tamReservat3];
		for(int i = 0;i<tamTabt1;i++){
			t1[i] = NULO;
		}
		for(int i = 0;i<tamTabt2;i++){
			t2[i] = NULO;
		}
		primeiroT2 = ultimoT2 = new Celula();
		raizT2 = raizT3 =null;
	}
	public void inserir(int x){
		int pos = hashT1(x);
		if(t1[pos]==NULO){
			t1[pos]=x;
		}
		else{
			pos = hashT2(x);
			if(pos == 0){
				inserirT3(x);
			}
			else if(pos==1){
				inserirLista(x);
			}
			else if(pos==2){
				raizT2 = inserirArvore(x,raizT2);
			}
		}
	}
	private void inserirT3(int x){
		int pos = hashT3(x);
		if(t3[pos] == NULO){
			t3[pos] = x;
		}
		else if(t3[reHashT3(x)] == NULO){
			t3[reHashT3(x)] = NULO;
		}
		else{
			raizT2 = inserirArvore(x,raizT3);
		}
	}
	public int hashT1(int x){
		return x%tamTabt1;
	}
	public int hashT2(int x){
		return x%tamReservat1;
	}
	public int hashT3(int x){
		return x%tamTabt3;
	}
	public int reHashT3(int x){
		x++;
		return x%tamTabt3;
	}
	public No inserirArvore(int x,No i){
		if(i==null){
			i = new No(x);
		}
		else if(elemento>i.elemento){
			i = inserirArvore(x,i.dir);
		}
		else if(elemento<i.elemento){
			i= inserirArvore(x,i.esq);
		}
		return i;
	}
	public void inserirLista(int x){
		Celula tmp = new Celula(x);
		ultimoT2.prox =tmp;
		ultimoT2 = tmp;
		tmp =null;
	}
	public boolean pesquisar(int x){
		int pos = hashT1(x);
		boolean resp = false;
		if(t1[pos] == x){
			resp = true;
		}
		else if(hashT2(x)==0){
			pos = hashT3(x);
			if(t3[pos] ==x){
				resp=true;
			}
			else if(t3[reHashT3(x)]==x){
				resp = true;
			}
			else{
				resp = pesquisarArv(raizT3,x);
			}	
		}
		else if(hashT2(x)==1){
			resp = pesquisarLista(primeiroT2,x);
		}
		else if(hashT2(x)==2){
			resp = pesquisarArv(raizT2,x);
		}
		return resp;
	}
	private boolean pesquisarLista(Celula primeiro,int x){
		boolean resp = false;
		for(Celula i=primeiro.prox;i!=null;i=i.prox){
			if(i.elemento==x){
				resp = true;
				i = null;
			}
		}
		return resp;
	}
	private boolean pesquisarArv(No i,int x){
		boolean resp=false;;
		if(i==null){
			resp = false;
		}
		else if(i.elemento == x){
			resp =true;
		}
		else if(x<i.elemento){
			resp = pesquisarArv(i.esq,x);
		}
		else if(x>i.elemento){
			resp = pesquisarArv(i.dir,x);
		}
		return resp;
	}
	public void mostrar(){
		for(int i=0;i<tamTab;i++){
			if(t1[i]!=NULO)
				print(t1[i]);
		}
		for(int i=0;i<tamT3;i++){
			if(t3[i]!=NULO)
				print(t3[i]);
		}
		mostrarCentral(raizT3);
		for(Celula i = primeiroT2;i!=null;i=i.prox){
			print(i.elemento);
		}
		mostrarCentral(raizT2);
	}
}

class No{
	int elemento;
	No esq;
	No dir;
	No(int elemento){
		this.elemento = elemento;
	}
}
class Celula{
	int elemento;
	Celula prox;
	Celula(int elemento){
		this.elemento = elemento;
	}
}
