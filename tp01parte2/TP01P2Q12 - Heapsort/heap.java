public class heap extends Geracao{
	static int comparacoes=0;
	static int movimentacoes=0;
	public static void main(String[]args){
		gera(10);
		decrescente();
		//MyIO.println("ARRAY ORIGINAL");
		//mostrar();
		//MyIO.println("FORMATO DE HEAP");
		//buildHeap(n-1);
		//mostrar();
		long comeco = now();
		insercao();
		mostrar();
		MyIO.println("Comparacoes Padrao "+comparacoes);
		comparacoes=0;
		long fim = now();
		decrescente();
		binaryInsercao();
		mostrar();
		MyIO.println("Comparacoes Binary "+comparacoes);
		//if(isOrdenado())MyIO.println("ORDENADO");
		//else MyIO.println("NAO ORDENOU");
			//mostrar();
		//MyIO.println("Comparacoes"+comparacoes);
		//MyIO.println("Movimentacoes"+movimentacoes);
		//System.out.println("Tempo para ordenar: " + (fim-comeco)/1000.0 + " s.");
	}
	//recebe o tamanho do heap
	public static void buildHeap(int tamheap){
		//k numero de elementos organizados em forma de heap
		//comeca como 1 pq o primeiro elementos 0 ja esta em heap 
		//heap em 0 pai =(i-1)/2 filho esq 2i+1 filho dir 2i+2
		for(int k=0;k<tamheap;k++){
			for(int i=k+1;i>=-0;i=(i-1)/2){
				comparacoes++;
				if(array[i]>array[(i-1)/2]){
					swap(i,(i-1)/2);
					movimentacoes++;
				}
				else{
					i=-1;
				}
			} 
		}	
	}
	//recebe o tamanho do heap
	public static void reBuildHeap(int tamheap){
		//comparar irmãos
		//k eh o pai
		int filho;//sempre sera o maior filho
		int pai=0;
		for(int k = 0;k<=(tamheap-2)/2;){
			comparacoes++;
			if(array[(2*k)+1]>array[(2*k)+2]||(2*k)+1==tamheap){
				filho=(2*k)+1;
			}	
			else{ 
				filho=(2*k)+2;
			}
			comparacoes++;
			if(array[k]<array[filho]){
				swap(k,filho);
				movimentacoes++;
				k=filho;
			}
			else{
				k=tamheap;
			}
			pai=k;
		}
	}
	public static void heapsort(){
		int ultimo=n;
		buildHeap(ultimo-1);
		for(int i=0;i<n;i++){
			swap(n-1-i,0);
			movimentacoes++;
			ultimo-=1;
			reBuildHeap(ultimo-1);
		}
	}
	public static int binarySearch(int esq, int dir,int x){
		int resp;
		while(esq<=dir){
			int meio=(esq+dir)/2;
			comparacoes++;
			if(array[meio]==x){
				resp=meio;
				dir=esq-1;
			}
			else if(x>array[meio]){
				esq=meio+1;
			}
			else{
				dir=meio-1;
			}
		}
		resp=esq;
		return resp;
	}
	public static void binaryInsercao(){
		for(int i=1;i<n;i++){
			int j=i-1;
			int selec=array[i];
			int loc=binarySearch(0,j,selec);
			for(;j>=loc;j--){
				array[j+1]=array[j];	
			}
			array[loc]=selec;

		}	
	}
	public static void insercao(){
		for(int i=1;i<n;i++){
			int j=i-1;
			for(;j>=0;j--){
				comparacoes++;
				if(array[j+1]<array[j]){
					int tmp=array[j+1];
					array[j+1]=array[j];
					array[j]=tmp;
				}
				else{
					j=-1;
				}
			}

		}	
	}
}
