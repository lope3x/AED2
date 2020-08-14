public class trie{
	public static void main(String[]args){
		arvTrie t = new arvTrie();
		t.inserir("sapo");
		t.inserir("sapato");
		t.inserir("lalala");
		t.inserir("vrau");
		t.inserir("vra");
		System.out.println(t.pesquisar("sapo"));
		System.out.println(t.pesquisar("sapato"));
		System.out.println(t.pesquisar("lala"));
		t.mostrar();
	}
}
class arvTrie{
	No raiz;
	public arvTrie(){
		raiz = new No((char)0,false);	
	}
	public void inserir(String s){
		raiz.array[No.hash(s.charAt(0))] = inserir(raiz.array[No.hash(s.charAt(0))],s,0); 
	}
	private No inserir(No i,String s,int n){
		if(i==null){
			i=new No(s.charAt(n),(n==s.length()-1) ? true :false);
		}
		if(!i.folha&&n != s.length()-1){
			i.array[No.hash(s.charAt(n+1))] = inserir(i.array[No.hash(s.charAt(n+1))],s,n+1);	
		}
		return i;
	}
	public boolean pesquisar(String s){
		return pesquisar(raiz.array[No.hash(s.charAt(0))],s,0);	
	}
	private boolean pesquisar(No i,String s,int n){
		boolean resp = false;
		if(i!=null){
			if(!i.folha&&n!=s.length()-1){
				resp = pesquisar(i.array[No.hash(s.charAt(n+1))],s,n+1);	
			}
			else if(i.folha&&n==s.length()-1){
				resp = true;
				
			}		
		}	
		return resp;
	}
	public void mostrar(){
		mostrar(raiz,"");
	}
	private void mostrar(No i,String s){
		if(!i.folha){
			for(int k = 0;k<i.tam;k++){
				if(i.array[k]!=null){
						mostrar(i.array[k],s+i.letra);
				}
			}
		}
		else {
			System.out.println(s+i.letra);
		}
	}
}
class No{
	char letra;
	No[] array;
	boolean folha;
	int tam = 256;
	public No(char letra,boolean folha){
		this.letra = letra;
		this.folha = folha;
		array = new No[tam];
		for(int i = 0;i<tam;i++){
			array[i]=null;		
		}
	}
	public static int hash(char letra){
		return (int)letra;
	}
}
