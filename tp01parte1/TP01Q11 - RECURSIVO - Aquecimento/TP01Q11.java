public class TP01Q11{
	public static void main(String[]args){
		entradaeSaidaRecursivo();
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		@param str string a ser verificada
		O metodo verifica quantas letras maiusculas há em uma string
	*/
	public static int contaLetrasMaiusculasRecursivo(String str){
		return contaLetrasMaiusculasRecursivo(str,0);
	}
	public static int contaLetrasMaiusculasRecursivo(String str,int i){
		int resp=0;
		if(i<str.length()){
			if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
				resp++;
			}
			resp+=contaLetrasMaiusculasRecursivo(str,i+1);	
		}
		return resp;
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		@date 07/02/2019
		@param str1 primeira string para comparação
		@param str2 segunda string para comparação
		O metodo verifica se duas strings são iguais
	*/
	public static boolean equalsRecursivo(String str1,String str2){
		boolean isEquals=false;
		if(mesmoTamanho(str1,str2)){
			isEquals=equalsRecursivo(str1,str2,0);
		}
		return isEquals;
	}
	public static boolean equalsRecursivo(String str1,String str2,int i){
		boolean isEquals;
		if(i==str1.length()){
			isEquals=true;
		}
		else{
			if(str1.charAt(i)!=str2.charAt(i)){
				isEquals=false;
			}
			else{
				isEquals=equalsRecursivo(str1,str2,i+1);
			}
		}
		return isEquals;
	}
	public static boolean mesmoTamanho(String str1,String str2){
		return (str1.length()==str2.length());
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		O metodo faz a leitura a partir da entrada padrão, faz a chamada do metodo contaLetrasMaiusculasRecursivo
		e imprime o resultado pela saida padrão
	*/
	public static void entradaeSaidaRecursivo(){
		String input=MyIO.readLine();
		if(!equalsRecursivo(input,"FIM")){
			MyIO.println(contaLetrasMaiusculasRecursivo(input));
			entradaeSaidaRecursivo();
		}
	}
}
