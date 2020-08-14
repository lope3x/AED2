public class conversoes{
	/**
		Matriz para Arvore
		@param CelulaQuadrupla inicio aponta para o incio de uma Matriz
		@return No arv.raiz retorna uma raiz de uma arvore
	*/
	public No MatToArv(CelulaQuadrupla inicio){
		Arvore arv = new Arvore();
		for(CelulaQuadrupla i= inicio;i!=null;i=i.inf){
			for(CelulaQuadrupla j = i; j!=null;j=j.dir){
				arv.inserir(j.elemento);
			}
		}
		return arv.raiz;
	}
	/**
		Arvore to Mat
		@param  Celula primeiro recebe o primeiro de uma Lista
		@return CelulaQuadrupla retorna o inicio de uma Matriz
	*/
	public CelulaQuadrupla ArvToMat(No raiz){
		Matriz m  = new Matriz();
		m =  ArvToMat(raiz,m);
		return m.inciio;
	}
	private Matriz ArvToMat(No i,Matriz m){
		if(i!=null){
			m = ArvToMat(i.esq,m);
			m.inserirMat(i.elemento,m.inicio);
			m = ArvToMat(i.dir,m);
		}
		return m;
	}
	/**
		Matriz para Lista
		@param CelulaQuadrupla inicio  aponta para o incio de uma Matriz
		@return Celula l.primeiro retorna o primeiro de uma lista
	*/
	public Celula MatToLista(CelulaQuadrupla inicio){
		Lista l = new Lista();
		for(CelulaQuadrupla i = inicio; i!=null;i.inf){
			for(CelulaQuadrupla j = i; j!=null;j.dir){
				l.inserir(j.elemento);
			}
		}
		return l.primeiro;
	}
	/**
		Lista to Mat
		@param  Celula primeiro recebe o primeiro de uma Lista
		@return CelulaQuadrupla retorna o inicio de uma Matriz
	*/
	public CelulaQuadrupla ListaToMat(Celula primeiro){
		Matriz m = new Matriz();
		for(Celula i = primeiro.prox;i!=null;i=i.prox){
			inserirMat(i.elemento,m.inicio);
		}
		return m.inicio;
	}
	/**
		Matriz to Pilha
		@param CelulaQuadrupla inicio recebe o inicio de uma Matriz
		@return Celula topo retorna o topo de uma pilha
	*/
	public Celula MatToPilha(CelulaQuadrupla inicio){
		Pilha p = new Pilha();
		for(CelulaQuadrupla i = inicio; i!=null;i.inf){
			for(CelulaQuadrupla j = i; j!=null;j.dir){
				p.empilhar(j.elemento);
			}
		}
		return p.topo;
	}
	/**
		Pilha to Mat
		@param Celula topo topo de uma 
		@return CelulaQuadrupla inicio de uma matriz
	*/
	public CelulaQuadrupla PilhaToMat(Celula topo){
		Matriz m = new Matriz();
		for(Celula i = topo;i!=null;i.prox){
			inserirMat(i.elemento,m.inicio);
		}
	}
	/**
		Arv to Pilha
		@param No raiz raiz de uma arvore
		@return Celula topo topo de uma pilha
	*/
	public Celula ArvToPilha(No raiz){
		Pilha p = new Pilha();
		p = ArvToPilha(raiz,p);
		return p.topo;
	}
	private Pilha ArvToPilha(No i,Pilha p){
		if(i!=null){
			p = ArvToPilha(raiz,p);
			p.empilhar = i.elemento;
			p = ArvToPilha(raiz,p);
		}
		return p;
	}
	/**
		Pilha to Arv
		@param Celula topo topo de uma pilha
		@return No raiz raiz de uma arvore
	*/
	public No PilhaToArv(Celula topo){
		Arvore arv = new Arvore();
		for(Celula i = topo ;i!=null;i.prox){
			arv.inserir(i.elemento);
		}
		return arv.raiz;
	}
	/**
		Arv to Lista
		@param No raiz raiz de uma arvore
		@return Celula primeiro primeiro elemento de uma Lista
	*/
	public Celula ArvToLista(No raiz){
		Lista l = new Lista();
		l = ArvToLista(raiz,l.inicio);
		return l.inicio;
	}
	private Lista ArvToLista(No i, Lista l){
		if(i!=null){
			l = ArvToLista(i.esq,l);
			l.inserir(i.elemento);
			l = ArvToLista(i.dir,l);
		}
		return l;
	}
	/**
		Lista to Arv
		@param Celula primeiro primeiro elemento de uma lista
		@return No raiz raiz de uma arvore
	*/
	public No ListaToArv(Celula primeiro){
		Arvore arv  = new Arvore();
		for(Celula i = primeiro.prox;i!=null;i=i.prox){
			arv.inserir(i.elemento);
		}
		return arv.raiz;
	}
	/**
		Pilha to Lista
		@param Celula topo topo de uma Pilha
		@return Celula primeiro primeiro elemento de uma lista
	*/
	public Celula PilhaToLista(Celula topo){
		Lista l = new Lista();
		for(Celula i = topo;i!=null;i=i.prox){
			l.inserir(i.elemento);
		}
		return l.primeiro;
	}
	/**
		Lista to Pilha
		@param Celula primeiro primeiro elemento de uma lista
		@return Celula topo topo de uma Pilha
	*/
	public Celula ListaToPilha(Celula primeiro){
		Pilha p = new Pilha();
		for(Celula i = primeiro.prox;i!=null;i=i.prox){
			p.empilhar(i.elemento);
		}
		return p.primeiro;
	}
	//INSERIR MATRIZ
	//metodo da classe matriz
	public void inserirMat(int elemento,CelulaQuadrupla inicio){
		boolean aux=true;
		for(CelulaQuadrupla i = inicio;aux&&i!=null,i=i.inf){
			for(CelulaQuadrupla j = i;aux&&j!=null;j=j.dir){
				if(j.elemento==null){
					j.elemento=elemento;
					aux=false;
				}

			}
		}
	}
}
