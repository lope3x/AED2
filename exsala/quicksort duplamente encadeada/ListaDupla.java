/**
 * Lista dupla dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class ListaDupla {
	private CelulaDupla primeiro;
	private CelulaDupla ultimo;

	/**
	 * Construtor da classe que cria uma lista dupla sem elementos (somente no cabeca).
	 */
	public ListaDupla() {
		primeiro = new CelulaDupla();
		ultimo = primeiro;
	}

	/**
	 * Insere um elemento na primeira posicao da lista.
	 * @param x int elemento a ser inserido.
	 */
	public void inserirInicio(int x) {
		CelulaDupla tmp = new CelulaDupla(x);

		tmp.ant = primeiro;
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if(primeiro == ultimo){
			ultimo = tmp;
		}else{
			tmp.prox.ant = tmp;
		}
		tmp = null;
	}

	/**
	 * Insere um elemento na ultima posicao da lista.
	 * @param x int elemento a ser inserido.
	 */
	public void inserirFim(int x) {
		ultimo.prox = new CelulaDupla(x);
		ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
	}

	/**
	 * Remove um elemento da primeira posicao da lista.
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public int removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

		CelulaDupla tmp = primeiro;
		primeiro = primeiro.prox;
		int resp = primeiro.elemento;
		tmp.prox = primeiro.ant = null;
		tmp = null;
		return resp;
	}

	/**
	 * Remove um elemento da ultima posicao da lista.
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public int removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 
		int resp = ultimo.elemento;
		ultimo = ultimo.ant;
		ultimo.prox.ant = null;
		ultimo.prox = null;
		return resp;
	}

	/**
	 * Insere um elemento em uma posicao especifica considerando que o 
	 * primeiro elemento valido esta na posicao 0.
	 * @param x int elemento a ser inserido.
	 * @param pos int posicao da insercao.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public void inserir(int x, int pos) throws Exception {

		int tamanho = tamanho();

		if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
		} else if (pos == 0){
			inserirInicio(x);
		} else if (pos == tamanho){
			inserirFim(x);
		} else {
			// Caminhar ate a posicao anterior a insercao
			CelulaDupla i = primeiro;
			for(int j = 0; j < pos; j++, i = i.prox);

			CelulaDupla tmp = new CelulaDupla(x);
			tmp.ant = i;
			tmp.prox = i.prox;
			tmp.ant.prox = tmp.prox.ant = tmp;
			tmp = i = null;
		}
	}

	/**
	 * Remove um elemento de uma posicao especifica da lista
	 * considerando que o primeiro elemento valido esta na posicao 0.
	 * @param posicao Meio da remocao.
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public int remover(int pos) throws Exception {
		int resp;
		int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

		} else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
		} else if (pos == 0){
			resp = removerInicio();
		} else if (pos == tamanho - 1){
			resp = removerFim();
		} else {
			// Caminhar ate a posicao anterior a insercao
			CelulaDupla i = primeiro.prox;
			for(int j = 0; j < pos; j++, i = i.prox);

			i.ant.prox = i.prox;
			i.prox.ant = i.ant;
			resp = i.elemento;
			i.prox = i.ant = null;
			i = null;
		}

		return resp;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
		System.out.print("[ "); // Comeca a mostrar.
		for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] "); // Termina de mostrar.
	}
	public void mostrarAdap(CelulaDupla esq,CelulaDupla dir) {
		System.out.print("[ "); // Comeca a mostrar.
		for (CelulaDupla i = esq; i != dir; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] "); // Termina de mostrar.
	}
	/**
	 * Mostra os elementos da lista de forma invertida 
	 * e separados por espacos.
	 */
	public void mostrarInverso() {
		System.out.print("[ ");
		for (CelulaDupla i = ultimo; i != primeiro; i = i.ant){
			System.out.print(i.elemento + " ");
		}
		System.out.println("] "); // Termina de mostrar.
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(int x) {
		boolean resp = false;
		for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
			if(i.elemento == x){
				resp = true;
				i = ultimo;
			}
		}
		return resp;
	}
	public void quicksort(){
		quicksort(primeiro.prox,ultimo,0,tamanho()-1);
	}
	public void quicksort(CelulaDupla esq,CelulaDupla dir,int posesq,int posdir){
		CelulaDupla i=esq, j=dir;
		int posi=posesq,posj=posdir;
		int pivo=dir.elemento;//seta pivo como ultimo elemento
		while(posi<=posj){
			while(i.elemento<pivo){
				i=i.prox;
				posi++;
			}
			while(j.elemento>pivo){
				j=j.ant;
				posj--;
			}
			if(posi<=posj){
				swap(i,j);
				i=i.prox;
				posi++;
				j=j.ant;
				posj--;
			}
		}
		if(posesq<posj) quicksort(esq,j,posesq,posj);
		if(posi<posdir) quicksort(i,dir,posi,posdir);
	}
	
	/*
	public static void quicksort() {
      quicksort(0, n-1);
	}
	private static void quicksort(int esq, int dir) {
        int i = esq, j = dir;
        int pivo = array[(dir+esq)/2];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j);
        if (i < dir)  quicksort(i, dir);
    }*/
/*
	public CelulaDupla particao(CelulaDupla esq,CelulaDupla dir){
		int x = dir.elemento;//pivo
		CelulaDupla i = esq.ant;
		for(CelulaDupla j=esq;j!=dir;j=j.prox){
			if(j.elemento<=x){
				i=(i==null) ? esq : i.prox;
				int temp=i.elemento;//3 linhas swap
				i.elemento=j.elemento;
				j.elemento=temp;
			}
		}
		i=(i==null) ? esq : i.prox;
		int temp = i.elemento;//3 linhas swap
		i.elemento = dir.elemento;
		dir.elemento=temp;
		return i;
		
	}
	public void quicksort(CelulaDupla esq,CelulaDupla dir){
		if(dir!=null&&esq!=dir&&esq!=dir.prox){
			CelulaDupla tmp= particao(esq,dir);
			quicksort(esq,tmp.ant);
			quicksort(tmp.prox,dir);
		}
		
	}
	public void quicksort(){
		quicksort(primeiro,ultimo);
	}*/

	/*
	/**
		VERFICA SE A CELULA I ESTA "A ESQUERDA" DA CELULA J NA LISTA DUPLA
		@param CelulaDupla j celula "a direita"
		@param CelulaDupla i celula "a esquerda"
	
	public boolean menorque(CelulaDupla j, CelulaDupla i){
		boolean resp=false;
		for(CelulaDupla c = j;c!=primeiro;c=c.ant){
			System.out.println(c.elemento);
			if(c==i){
				return true;

			}
		}
		return resp;
	}*/
	public void swap(CelulaDupla i, CelulaDupla j){
		int tmp = j.elemento;
		j.elemento=i.elemento;
		i.elemento=tmp;	
	}
	/*
	public static void quicksort() {
      quicksort(0, n-1);
	}
	private static void quicksort(int esq, int dir) {
        int i = esq, j = dir;
        int pivo = array[(dir+esq)/2];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j);
        if (i < dir)  quicksort(i, dir);
    }*/
	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * @return resp int tamanho
	 */
	public int tamanho() {
		int tamanho = 0; 
		for(CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++);
		return tamanho;
	}
}
