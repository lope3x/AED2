public class mergesortmain{
	public static void main(String[]args){
		ordena merge = new ordena();
		merge.aleatorio();
		MyIO.println("Array desordenado");
		merge.mostrar();
		long i = merge.now();
	    merge.mergesort();
		long f= merge.now();
		MyIO.println("Array ordenado TEMPO PARA ORDENAR "+(i-f)/1000.0);
		merge.mostrar();
	}
}
class ordena extends Geracao{
	public ordena(){
		super();
	}
	public void mergesort(){
		mergesort(0,n-1);
	}
	public void mergesort(int inicio, int fim){
		int meio;
		if(inicio<fim){
			meio=(inicio+fim)/2;
			mergesort(inicio,meio);
			mergesort(meio+1,fim);
			merge(inicio,meio,fim);
		}
	}
	//vetor auxiliar com tamanho do vetor ori , ou seja fim-inicio+1
	//rodar os dois vetores ao msm tempo
	//
	public void merge(int inicio, int meio, int fim){
		int tamanho=(fim-inicio)+1;
		int[] temp = new int[tamanho];
		int p1=inicio;//inicio do primeiro vetor acaba em meio
		int p2=meio+1;//inicio do segundo vetor acaba em fim
		boolean fim1=false , fim2=false;
		for(int i=0;i<tamanho;i++){
			if(!fim1&&!fim2){
				if(array[p1]<array[p2]){
					temp[i]=array[p1++];
				}
				else{
					temp[i]=array[p2++];
				}
				if(p1>meio)fim1=true;
				if(p2>fim)fim2=true;
			}
			else{
				if(!fim1){
					temp[i]=array[p1++];
				}
				else if(!fim2){
					temp[i]=array[p2++];
				}
			}
		}
		//copia para o original
		for(int i=0,j=inicio;i<tamanho;i++,j++){
			array[j]=temp[i];
		}
	}
}