public class TP01Q06{
	public static void main(String[]args){
		String input=MyIO.readLine();
		do{

			if(isVogal(input))MyIO.print("SIM ");
			else MyIO.print("NAO ");
			if(isConsoant(input))MyIO.print("SIM ");
			else MyIO.print("NAO ");
			if(isInt(input))MyIO.print("SIM ");
			else MyIO.print("NAO ");
			if(isReal(input)||isInt(input))MyIO.print("SIM");
			else MyIO.print("NAO");
			MyIO.print("\n");
			input=MyIO.readLine();
		}while(!Equals(input,"FIM"));
	}
	/*
		Autor: Gabriel Lopes Ferreira
		Parametros: str
		Data de Modificação:04/02/2019
		O metodo recebe uma string e verifica se a mesma
		é inteiramente composta por letras vogais
	*/
	public static boolean isVogal(String str){
		char ch;
		boolean vogal=true;
		for(int i=0;i<str.length();i++){
			ch=str.charAt(i);
			if(ch!='A'&&ch!='a'&&ch!='E'&&ch!='e'&&ch!='I'&&ch!='i'&&ch!='O'&&ch!='o'&&ch!='U'&&ch!='u'){
				vogal=false;
			}
		}
		return vogal;
	}
	/*
		Autor: Gabriel Lopes Ferreira
		Parametros: str
		Data de Modificação:04/02/2019
		O metodo recebe uma string e verifica se a mesma
		é inteiramente composta por letras consoantes
	*/
	public static boolean isConsoant(String str){
		char ch;
		boolean consoant=true;
		for(int i=0;i<str.length();i++){
			ch=str.charAt(i);
			if(ch<'A'||ch>'Z'&&ch<'a'||ch>'z'){
				consoant=false;
			}
			if(ch=='A'||ch=='a'||ch=='E'||ch=='e'||ch=='I'||ch=='i'||ch=='O'||ch=='o'||ch=='U'||ch=='u'){
				consoant=false;
			}
		}
		return consoant;
	}
	/*
		Autor: Gabriel Lopes Ferreira
		Parametros: str
		Data de Modificação:04/02/2019
		O metodo recebe uma string e verifica se a mesma
		é um numero inteiro
	*/
	public static boolean isInt(String str){
		boolean isint=true;
		int vlr;
		for(int i=0;i<str.length();i++){
			vlr=str.charAt(i);
			if(vlr<48||vlr>57){
				isint=false;
			}
		}
		return isint;

	}
	/*
		Autor: Gabriel Lopes Ferreira
		Parametros: str
		Data de Modificação:04/02/2019
		O metodo recebe uma string e verifica se a mesma
		é um numero real
	*/
	public static boolean isReal(String str){
		boolean isreal;
		int vlr;
		int virgulaouponto=0;
		for(int i=0;i<str.length();i++){
			vlr=str.charAt(i);
			if(vlr==44||vlr==46){
				virgulaouponto++;
			}
			else if(vlr<48||vlr>57){
				return false;
			}

		}
		if(virgulaouponto==1){
			isreal=true;
		}
		else{
			isreal=false;
		}
		return isreal;
	}
	/*
		@author Gabriel Lopes Ferreira
		@date 04/02/2019
		@version 1.0
		@since 1.0
		@param str1 , str 2
		@return isEquals
		O metodo recebe duas Strings e verifica se as duas são iguais
	*/
	public static boolean Equals(String str1, String str2){
		boolean isEquals=true;
		if(str1.length()==str2.length()){
			for(int i =0;i<str1.length();i++){
				if(str1.charAt(i)!=str2.charAt(i)){
					isEquals=false;
				}
			}
		}
		else{
			isEquals=false;
		}
		return isEquals;
	}
}