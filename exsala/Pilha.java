class Pilha{
	private int[] array;
	private int n;

	public Pilha () {
		this(6);
	}
	public Pilha(int tam){
		array = new int[tam];
		n=0;
	}
	public void inserirFim(int x) throws Exception {

		//validar insercao
		if(n >= array.length){
			throw new Exception("Erro ao inserir!");
		}

		array[n] = x;
		n++;
	}
	public int removerFim() throws Exception {

		//validar remocao
		if (n == 0) {
			throw new Exception("Erro ao remover!");
		}

		return array[--n];
	}
	public void mostrar (){
		System.out.print("[ ");
		for(int i = 0; i < n; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
	}
	public void mostrarRec (){
		System.out.print("[ ");
		mostrarRec(0);
		System.out.println("]");
	}

	public void mostrarRec(int i){
		if(i < n){
			System.out.print(array[i] + " ");
			mostrarRec(i + 1);
		}
	}
	public void mostrarRecCimaBaixo(){
		System.out.print("[ ");
		mostrarRecCimaBaixo(n-1);
		System.out.println("]");
	}
	public void mostrarRecCimaBaixo(int i){
		if(i>0){
			System.out.print(array[i] + " ");
			mostrarRecCimaBaixo(i-1);	
		}
	}
	public boolean pbRec(int x){
		return pbRec(0,n-1,x);
	}
	public boolean pbRec(int esq,int dir,int x){
		if(esq<=dir){
			int meio=(esq+dir)/2;
			int ct=x.compareTo(meio);
			boolean resp=false;
			if(ct==0){
				esq=dir+1;
				resp=true;
			}
			else if(ct>0){
				resp=pbRec(meio+1,dir,x);
			}
			else{
				resp=pbRec(esq,meio-1,x);
			}
		}
		return resp;
	}
}
