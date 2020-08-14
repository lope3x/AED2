public class mostrar{
	/**
	 *	Matriz de Arv
	 */
	public void MostrarMatArv(CelulaQ inicio){
		for(CelulaQ i = inicio;i!=null;i=i.inf){
			for(CelulaQ j=i;j!=null;j=j.dir){
				MostrarMatArv(j.raiz);
			}
		}
	}
	private void MostrarMatArv(No i){
		if(i!=null){
			MostrarMatArv(i.esq);
			print(i.elemento);
			MostrarMatArv(i.dir);
		}
	}
	/**
	 *  Arv de Matriz
	 */
	public void MostrarArvMat(No i){
		if(i!=null){
			MostrarArvMat(i.esq);
			MostrarArvMat(i.dir);
			MostrarArvMat(i.inicio);
		}
	}
	private void MostrarArvMat(CelulaQ inicio){
		for(CelulaQ i=inicio;i!=null;i=i.inf){
			for(CelulaQ j=i;j!=null;j=j.dir){
				printf(j.elemento);
			}
		}
	}
	/**
	 *	Mat de Lista 
	 */
	public void MostrarMatLista(CelulaQ inicio){
		for(CelulaQ i=inicio;i!=null;i=i.inf){
			for(CelulaQ j=i;j!=null;j=j.dir){
				MostrarMatLista(j.primeiro);
			}
		}
	}
	private void MostrarMatLista(Celula primeiro){
		for(Celula i=primeiro.prox;i!=null;i=i.prox){
			print(i.elemento);
		}
	}
	/**
	 *	Lista de Mat
	 */
	public void MostrarListaMat(Celula primeiro){
		for(Celula i = primeiro.prox;i!=null;i=i.prox){
			MostrarListaMat(i.inicio);
		}
	}
	private void MostrarListaMat(CelulaQ inicio){
		for(CelulaQ i=inicio;i!=null;i=i.inf){
			for(CelulaQ j=i;j!=null;j=j.dir){
				print(j.elemento);
			}
		}
	}
	/**
	 *	Mat de Lista
	 */
	public void MostrarMatLista(CelulaQ inicio){
		for(CelulaQ i=inicio;i!=null;i=i.inf){
			for(CelulaQ j=i;j!=null;j=j.dir){
				MostrarMatLista(j.primeiro);
			}
		}
	}
	private void MostrarMatLista(Celula primeiro){
		for(Celula i=primeiro.prox;i!=null;i=i.prox){
			printf(i.elemento);
		}
	}
	/**
	 *	Mat de Pilha
	 */
	public void MostrarMatPilha(CelulaQ inicio){
		for(CelulaQ i = inicio;i!=null;i=i.inf){
			for(CelulaQ j=i;j!=null;j=j.dir){
				MostrarMatPilha(j.topo);
			}
		}
	}
	private void MostrarMatPilha(Celula topo){
		for(Celula i=topo;i!=null;i=i.prox){
			print(i.elemento);
		}
	}
	/**
	 *	Pilha de Mat
	 */
	public void MostrarPilhaMat(Celula topo){
		for(Celula i=topo;i!=null;i=i.prox){
			MostrarPilhaMat(i.inicio);
		}
	}
	private void MostrarPilhaMat(CelulaQ inicio){
		for(CelulaQ i=inicio;i!=null;i=i.inf){
			for(CelulaQ j=i;j!=null;j=j.dir){
				printf(j.elemento);
			}
		}
	}
	/**
	 *	Arv de Pilha
	 */
	public void MostrarArvPilha (No i){
		if(i!=null){
			MostrarArvPilha(i.esq);
			MostrarArvPilha(i.topo);
			MostrarArvPilha(i.dir);
		}
	}
	private void MostrarArvPilha(Celula topo){
		for(Celula i=topo;i!=null;i=i.prox){
			printf(i.elemento);
		}
	}
	/**
	 *	Pilha de Arv
	 */
	public void MostrarPilhaArv(Celula topo){
		for(Celula i=topo;i!=null;i=i.prox){
			MostrarPilhaArv(i.raiz);
		}
	}
	private void MostrarPilhaArv(No i){
		if(i!=null){
			MostrarPilhaArv(i.esq);
			printf(i.elemento);
			MostrarPilhaArv(i.dir);
		}
	}
	/**
	 *	Arv de Lista
	 */
	public void MostrarArvLista(No i){
		if(i!=null){
			MostrarArvLista(i.esq);
			MostrarArvLista(i.primeiro);
			MostrarArvLista(i.dir);
		}
	}
	private void MostrarArvLista(Celula primeiro){
		for(Celula i=primeiro.prox;i!=null;i=i.prox){
			print(i.elemento);
		}
	}
	/**
	 *	Lista de Arv
	 */
	public void MostraListaArv(Celula primeiro){
		for(Celula i=primeiro.prox;i!=null;i=i.prox){
			MostrarListaArv(i.raiz);
		}
	}
	private void MostrarListaArv(No i){
		if(i!=null){
			MostrarListaArv(i.esq);
			printf(i.elemento);
			MostrarListaArv(i.dir);
		}
	}
	/**
	 *	Pilha de Lista
	 */
	public void MostrarPilhaLista(Celula topo){
		for(Celula i=topo;i!=null;i=i.prox){
			for(Celula j=i.primeiro.prox;j!=null;j=j.prox){
				printf(j.elemento);
			}
		}
	}
	/**
	 *	Lista de Pilha
	 */
	public void MostrarListaPilha(Celula primeiro){
		for(Celula i= primeiro.prox;i!=null;i=i.prox){
			for(Celula j=i.topo;j!=null;j=j.prox){
				printf(j.elemento);
			}
		}
	}
}
