public class pilhacomfila{
	public static void main(String[]args)throws Exception{
		PilhaF pilha = new PilhaF();
		for(int i=0;i<6;i++){
			int x=((i+1)*10);//define a variavel x que sera inserida na pilha 
			pilha.empilhar(x);
			MyIO.println(i+1+" Elemento a entrar: "+(x));
		}
		pilha.organiza();
		pilha.mostrar();
		int j=1;
		for(boolean i=true;i;i=!pilha.f1.isVazia(),j++){
			MyIO.println(j+" Elemento a sair: " +pilha.desempilhar());//mostra a remocao dos elementos da pilha 
		}
	}
}
class PilhaF{
	Fila f1;//Pilha
	Fila f2;//Fila 
	public PilhaF(){
		f1=new Fila();
		f2=new Fila();
	}
	public void empilhar(int x)throws Exception{
		f1.inserir(x);//insere o elemento x em f1
	}
	public int desempilhar()throws Exception{
		return f1.remover();
	}
	public void organiza()throws Exception{
		int temp;
		if(!f1.isVazia()){
			temp=f1.remover();//remove da fila e salva e temp
			f2.inserir(temp);//insere temp na fila secundaria , se quisermos somente uma pilha esse passo nao eh necessario.
			organiza();//chama o metodo recursivamente 
			f1.inserir(temp);//utilizando da pilha de recursividade eh feita a insercao novamente pra invertemos a ordem da fila para que vire uma pilha 
		}
	}
	public void mostrar(){
		MyIO.println("FILA");
		f2.mostrar();
		MyIO.println("PILHA");
		f1.mostrar();
	}
}
