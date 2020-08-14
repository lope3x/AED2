public class TP01Q05{
	public static void main(String[]args){
		entradaeSaida();
	}
	/*
	   @author Gabriel Lopes Ferreira
	   @date 12/02/2019
	   @version 1.0
	   @since 1.0
	   O metodo faz a leitura dos valores e da expressão logica pela entrada padrão
	   e em seguida a percorre fazendo a chamada dos metodos necessários para resolve-lá
	   */
	public static void entradaeSaida(){
		int n=MyIO.readInt();
		int[] valores =new int[n];
		int valor;
		char op;
		char[] exp;
		while(n!=0){
			for(int i=0;i<n;i++){
				valor=MyIO.readInt();
				valores[i]=valor;
			}
			String ex=MyIO.readLine();
			exp=convertToChar(ex);
			exp=alteraValor(exp,valores);
			for(int i=exp.length-1;i>=0;i--){
				if(exp[i]=='('){
					op=exp[i-1];
					switch(op){
						case 't':
							exp=not(exp,i);
							break;
						case 'd':
							exp=and(exp,i);
							break;
						case 'r':
							exp=or(exp,i);
							break;
						default:

					}
					i=exp.length-1;
				}
			}
			for(int i=0;i<exp.length;i++){
				if(exp[i]=='V')MyIO.println("1");
				if(exp[i]=='F')MyIO.println("0");
			}
			n=MyIO.readInt();
			valores =new int[n];

		}
	}
	/*
	   @author Gabriel Lopes Ferreira
	   @date 12/02/2019
	   @version 1.0
	   @since 1.0
	   @param s , valores
	   @return s
	   O metodo recebe um array de char com a expressão logioca e um array de inteiro com os valores das váriaveis
	   em seguida o metodo substitui as variaveis pelos valores lógicos correspondetes no array de valores sendo 
	   1 = V e 0 = F
	   */
	public static char[] alteraValor(char[] s, int[]valores){
		char a='F';char b='F';char c='F';char d='F';char e='F';
		if(valores.length==2){
			if(valores[0]==1)a='V';
			if(valores[1]==1)b='V';
		}
		if(valores.length==3){
			if(valores[0]==1)a='V';
			if(valores[1]==1)b='V';
			if(valores[2]==1)c='V';

		}
		if(valores.length==4){
			if(valores[0]==1)a='V';
			if(valores[1]==1)b='V';
			if(valores[2]==1)c='V';
			if(valores[3]==1)d='V';		
		}
		if(valores.length==5){
			if(valores[0]==1)a='V';
			if(valores[1]==1)b='V';
			if(valores[2]==1)c='V';
			if(valores[3]==1)d='V';
			if(valores[4]==1)e='V';
		}
		for(int i=0;i<s.length;i++){
			if(s[i]=='A')s[i]=a;
			if(s[i]=='B')s[i]=b;
			if(s[i]=='C')s[i]=c;
			if(s[i]=='D')s[i]=d;
			if(s[i]=='E')s[i]=e;

		}
		return s;
	}
	/*
	   @author Gabriel Lopes Ferreira
	   @date 12/02/2019
	   @version 1.0
	   @since 1.0
	   @param s 
	   @return convertido
	   O metodo recebe uma string e a converte para um arrya de char
	   */
	public static char[] convertToChar(String s){
		char[] convertido=new char[s.length()];
		for(int i=0;i<s.length();i++){
			convertido[i]=s.charAt(i);
		}
		return convertido;
	}
	/*
	   @author Gabriel Lopes Ferreira
	   @date 12/02/2019
	   @version 1.0
	   @since 1.0
	   @param s , posnot
	   @return s
	   O metodo recebe um array de char e a posição do '(' da expressão
	   e em seguida percorre o array para inverter o valor logico da expressão
	   */
	public static char[] not(char[] s,int posnot){
		boolean encontrou=true;
		int para=0;
		int pos=0;
		for(int i=posnot;i<=s.length&&encontrou;i++){
			if(s[i]==')'){
				encontrou=false;
				s[i]='.';
				para=i;
				i=s.length-1;
			}
			if(encontrou&&s[i]=='F'||s[i]=='V'){
				if(s[i]=='V'){
					s[i]='F';
				}
				else{
					s[i]='V';
				}
				pos=i;
			}
		}
		s[posnot-1]='.';//apaga t
		s[posnot-2]='.';//apaga o
		s[posnot-3]='.';//apaga n
		s[posnot]='.';//apaga(
		for(int i=posnot+1;i<para;i++){
			if(s[i]!='F'&&s[i]!='V'){
				s[i]='.';
			}	
		}
		return s;
	}
	/*
	   @author Gabriel Lopes Ferreira
	   @date 12/02/2019
	   @version 1.0
	   @since 1.0
	   @param s , posand
	   @return s
	   O metodo recebe um array de char e a posição do '(' da expressão
	   e em seguida percorre o array realizando a operação logica AND
	   */
	public static char[] and(char[] s, int posand){
		boolean encontrou=true;
		int para=-1;
		int pos;
		int pula=-1;
		boolean ehfalse=true;
		for(int i=posand;i<s.length&&encontrou;i++){
			if(s[i]==')'){
				encontrou=false;
				s[i]='.';
				if(ehfalse)s[i-1]='V';
				if(ehfalse)pula=i-1;
				para=i;
				i=s.length-1;
			}
			if(encontrou&&s[i]=='F'&&ehfalse){
				pula=i;
				ehfalse=false;

			}
		}
		s[posand-1]='.';//apaga d
		s[posand-2]='.';//apaga n
		s[posand-3]='.';//apaga a
		s[posand]='.';//apaga(
		for(int i=posand+1;i<para;i++){
			if(s[i]!='F'&&s[i]!='V'&&i!=pula){
				s[i]='.';	
			}
			if(s[i]=='V'&&!ehfalse&&i!=pula){
				s[i]='.';
			}
			if(i!=pula&&s[i]=='F'){
				s[i]='.';
			}
			if(ehfalse&&i!=pula){
				s[i]='.';
			}

		}
		return s;
	}
	/*
	   @author Gabriel Lopes Ferreira
	   @date 12/02/2019
	   @version 1.0
	   @since 1.0
	   @param s , posor
	   @return s
	   O metodo recebe um array de char e a posição do '(' da expressão
	   e em seguida percorre o array realizando a operação logica OR
	   */
	public static char[] or(char[] s,int posor){
		boolean encontrou=true;
		int para=-1;
		int pos;
		int pula=-1;
		boolean ehtrue=false;
		for(int i=posor;i<s.length&&encontrou;i++){
			if(s[i]==')'){
				encontrou=false;//
				s[i]='.';//
				if(!ehtrue)s[i-1]='F';
				para=i;
				if(!ehtrue)para=i-1;
				i=s.length-1;
			}
			if(encontrou&&s[i]=='V'&&!ehtrue){
				pula=i;//
				ehtrue=true;//
			}
		}
		s[posor-1]='.';//apaga r
		s[posor-2]='.';//apaga o
		s[posor]='.';//apaga(

		for(int i=posor+1;i<para;i++){
			if(ehtrue&&s[i]=='V'&&i==pula){

			}
			else{
				if(ehtrue&&s[i]=='V'&&i!=pula){
					s[i]='.';
				}
				else{
					if(ehtrue&&s[i]=='F'){
						s[i]='.';
					}
					else{
						s[i]='.';
					}

				}
			}

		}
		return s;
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
