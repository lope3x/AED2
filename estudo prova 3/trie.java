public class trie{
	
}
class arvTrie{
	No raiz;
	
	public void mostrar(){
		mostrar(raiz,"");
	}
	private void mostrar(No i,String s){
		if(i.ehFolha){
			System.out.println(s+i.letra);
		}
		else{
			for(int k = 0;k<i.array.length;k++){
				if(i.array[k]!=null){
					mostrar(i.array[k],s+i.letra);
				}
			}
		}
	}
	
	
	
	/*
	 *
	 * O metodo percorre a arvore e conta quantas letras igual a letra enviada por parametro há na arv
	 *
	*/
	public int contaLetras(char letra){
		return contaLetras(raiz,letra);
	}
	private int contaLetras(No i,char letra){
		int resp = 0;
		if(i.letra==letra){
			resp++;
		}
		for(int k=0;k<i.array.length;k++){
			if(i.array[k]!=null){
				resp+=contaLetras(i.array[k],letra);
			}
		}
		return resp;
	}
	/*
	 *
	 * O metodo percorre a arvore e conta quantas palavrar existem na mesma
	 *
	*/
	public int contaPalavras(){
		return contaPalavras(raiz);
	}
	private int contaPalavras(No i){
		int resp = 0;
		if(i.ehFolha){
			resp++;
		}
		else{
			for(int k=0;k<i.array.length;k++){
				if(i.array[k]!=null){
					resp+=contaPalavras(i.array[k]);
				}
			}
		}
		return resp;
	}
}
class No{
	No[] array;
	char letra;
	boolean ehFolha;
	No(char letra,boolean ehFolha){
		this.letra=letra;
		this.ehFolha = ehFolha;
	}
	public static int hash(char letra){
		return (int)letra;
	}
}