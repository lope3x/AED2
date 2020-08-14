public class conversoes{
	//Matriz para Arvore
	public No MatToArv(Celula inicio){
		Arvore arv = new Arvore();
		for(Celula i= inicio;i!=null;i=i.inf){
			for(Celula j = i; j!=null;j=j.dir){
				arv.inserir(j.elemento);
			}
		}
		return arv.raiz;
	}
	//Arvore para Matriz
	
}