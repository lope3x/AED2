public class an{
	
}
class arvAN{
	No raiz;
	/*
	 *
	 *	O metodo percorre a estrutura , e printa todos o nos do tipo4
	 *
	*/
	public void printaTipo4(){
		printaTipo4(raiz);
	}
	private void printaTipo4(No i){
		if(i!=null){
			if(isTipo4(i))System.out.println(i.elemento);
			printaTipo4(i.esq);
			printaTipo4(i.dir);
		}
	}
	/*
	 *
	 *	O metodo percorre a estrutura , e verifica quantos nos do tipo 4 existem
	 *
	*/
	public int qtosTipo4(){
		return qtosTipo4(raiz);
	}
	private int qtosTipo4(No i){
		int resp = 0;
		if(i!=null){
			if(isTipo4(i))resp++;
			resp+=qtosTipo4(i.esq);
			resp+=qtosTipo4(i.dir);
		}
		return resp;
	}
	/*
	 *
	 *	O metodo percorre a estrutura , e verifica se há algum no com o tipo 4
	 *
	*/
	public boolean hasTipo4(){
		return hasTipo4(raiz);
	}
	private boolean hasTipo4(No i){
		boolean resp = false;
		if(i!=null){
			resp = isTipo4(i);
			if(!resp){
				resp = hasTipo4(i.esq);
				if(!resp){
					resp = hasTipo4(i.dir);
				}
			}
		}
		return resp;
	}
	public boolean isTipo4(No i){
		return(i.esq!=null&&i.dir!=null&&i.esq.cor&&i.dir.cor);
	}
}
class No{
	No esq;
	No dir;
	int elemento;
	boolean cor;//true preto false branco
	No(int elemento,boolean cor){
		this.elemento = elemento;
		this.cor = cor;
	}
}