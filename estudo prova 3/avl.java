public class avl{
	
}
class arvAVL{
	No raiz;
	arvAVL(){
		raiz = null;
	}
	public void inserir(int x){
		raiz = inserir(raiz,x);
	}
	public No inserir(No i,int x){
		if(i==null){
			i = new No(x);
		}
		else if(x<i.elemento){
			i.esq=inserir(i.esq,x);
		}
		else if(x>i.elemento){
			i.dir=inserir(i.esq,x);
		}
		i = balancear(i);
		return i;
	}

	/*
	 *
	 *	O metodo percorre a estrutura , e verifica se há algum no com o fator enviado como parametro
	 *
	*/
	public int qtosFator(int fator){
		return qtosFator(raiz,fator);
	}
	private int qtosFator(No i , int fator){
		int resp = 0;
		if(i!=null){
			if(i.fator == fator)resp ++;
			resp += qtosFator(i.esq,fator);
			resp += qtosFator(i.dir,fator);
		}
		return resp;
	}
	/*
	 *
	 *	O metodo percorre a estrutura , e verifica se há algum no com o fator enviado como parametro
	 *
	*/
	public boolean hasFator(int fator){
		return hasFator(raiz,fator);
	}
	private boolean hasFator(No i,int fator){
		boolean resp = false;
		if(i!=null){
			if(i.fator == fator){
				resp = true;
			}
			else{
				resp = hasFator(i.esq,fator);
				if(!resp){
					resp = hasFator(i.dir,fator);
				} 
			}
		}
		return resp;
	}
	/*
	 *
	 *	O metodo percorre a estrutura , e imprime o elemento do no , e o fator do no 
	 *
	*/
	public void mostrarPrintFator(){
		mostrarPrintFator(raiz);
	}
	private void mostrarPrintFator(No i){
		if(i!=null){
			mostrarPrintFator(i.esq);
			System.out.println("Elemento = "+i.elemento + "Fator =" + i.fator);
			mostrarPrintFator(i.dir);
		}
	}
	
	
	public No balancear(No i){
		int fator = getAltura(i.dir) - getAltura(i.esq);
		i.fator = fator;
		if(fator==2){
			//se positivo , olha o filho da direita
			int fatorfilho = getAltura(i.dir.dir) - getAltura(i.dir.esq);
			//sinal inverso , dupla
			if(fatorfilho==-1){
				i = rotDuplaDirEsq(i);
			}
			//sinal igual , simples
			else{
				i = rotSimplesEsq(i);
			}
		}
		else if(fator ==-2){
			//se negativo , olha o filho da esquerda
			int fatorfilho = getAltura(i.esq.dir) - getAltura(i.esq.esq);
			//sinal inverso,dupla
			if(fatorfilho==1){
				i = rotDuplaEsqDir(i);
			}
			else{
				i = rotSimplesDir(i);
			}
		}
		return i;
	}
	public int getAltura(No i){
		int resp=0;
		if(i!=null){
			resp=1+Math.max(getAltura(i.esq),getAltura(i.dir));
		}
		return 0;
	}
	public No rotSimplesEsq(No i){
		No idir = i.dir;
		No idiresq = i.dir.esq;
		
		idir.esq = i;
		i.dir = idiresq;
		
		return idir;
	}
	public No rotSimplesDir(No i){
		No iesq  = i.esq;
		No iesqdir = i.esq.dir;
		
		iesq.dir = i;
		i.esq = iesqdir;
		
		return iesq;
	}
	public No rotDuplaDirEsq(No i){
		i.dir = rotSimplesDir(i.dir);
		i = rotSimplesEsq(i);
		return i;
	}
	public No rotDuplaEsqDir(No i){
		i.esq = rotSimplesEsq(i.esq);
		i = rotSimplesDir(i);
		return i;
	}
}
class No{
	No esq;
	No dir;
	int fator;
	int elemento;
	No(int elemento){
		this.elemento = elemento;
		this.fator=0;
	}
}