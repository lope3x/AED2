import java.io.*;
import java.net.URL;
import java.nio.charset.*;
import java.util.Scanner;
public class TP01Q08{
	public static void main(String[]args){
		MyIO.setCharset("UTF-8");
		try{
			String nomesite=MyIO.readLine();
			String endereco=MyIO.readString();
			int i=0;
			String linha;
			int br=0;
			int table=0;
			int consoantes=0;
			int x1=0;int x2=0;int x3=0;int x4=0;int x5=0;int x6=0;int x7=0;int x8=0;int x9=0;int x10=0;int x11=0;int x12=0;
			int x13=0;int x14=0;int x15=0;int x16=0;int x17=0;int x18=0;int x19=0;int x20=0;int x21=0;int x22=0;
			int A=0;int E=0;int I=0;int O=0;int U=0;
			URL url;
			BufferedReader reader;
			
			do{
				url= new URL(endereco);
				reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName("UTF-8")));
				x1=0; x2=0; x3=0; x4=0; x5=0; x6=0; x7=0; x8=0; x9=0; x10=0; x11=0; x12=0;
				x13=0; x14=0; x15=0; x16=0; x17=0; x18=0; x19=0; x20=0; x21=0; x22=0;i=0;br=0;table=0;consoantes=0;
				while ((linha = reader.readLine()) != null){
						br+=searchbr(linha);
						table+=searchtable(linha);
						consoantes+=searchConsoant(linha);
						x1+=searchx1(linha);
						x2+=searchx2(linha);
						x3+=searchx3(linha);
						x4+=searchx4(linha);
						x5+=searchx5(linha);
						x6+=searchx6(linha);
						x7+=searchx7(linha);
						x8+=searchx8(linha);
						x9+=searchx9(linha);
						x10+=searchx10(linha);
						x11+=searchx11(linha);
						x12+=searchx12(linha);
						x13+=searchx13(linha);
						x14+=searchx14(linha);
						x15+=searchx15(linha);
						x16+=searchx16(linha);
						x17+=searchx17(linha);
						x18+=searchx18(linha);
						x19+=searchx19(linha);
						x20+=searchx20(linha);
						x21+=searchx21(linha);
						x22+=searchx22(linha);
					}
					for(int c=0;c<table;c++){
						consoantes-=3;
						x1--;
						x2--;
					}
					for(int c=0;c<br;c++){
						consoantes-=2;
					}
					MyIO.print("a("+x1+") ");
					MyIO.print("e("+x2+") ");
					MyIO.print("i("+x3+") ");
					MyIO.print("o("+x4+") ");
					MyIO.print("u("+x5+") ");
					MyIO.print((char)225+"("+x6+") ");
					MyIO.print((char)233+"("+x7+") ");
					MyIO.print((char)237+"("+x8+") ");
					MyIO.print((char)243+"("+x9+") ");
					MyIO.print((char)250+"("+x10+") ");
					MyIO.print((char)224+"("+x11+") ");
					MyIO.print((char)232+"("+x12+") ");
					MyIO.print((char)236+"("+x13+") ");
					MyIO.print((char)242+"("+x14+") ");
					MyIO.print((char)249+"("+x15+") ");
					MyIO.print((char)227+"("+x16+") ");
					MyIO.print((char)245+"("+x17+") ");
					MyIO.print((char)226+"("+x18+") ");
					MyIO.print((char)234+"("+x19+") ");
					MyIO.print((char)238+"("+x20+") ");
					MyIO.print((char)244+"("+x21+") ");
					MyIO.print((char)251+"("+x22+") ");
					MyIO.print("consoante("+consoantes+") ");
					MyIO.print("<br>("+br+") ");
					MyIO.print("<table>("+table+") ");
					MyIO.println(nomesite);
					nomesite=MyIO.readLine();
					if(!Equals(nomesite,"FIM")){
						endereco=MyIO.readLine();
					}
				}while(!Equals(nomesite,"FIM")); 
			}
			catch(IOException e){
			System.err.println(e);
			}
	}
	/*
		Os metodos a seguir recebem uma string e a percorrem
	    procurando certos caracteres, e em seguida retornam um valor int
		com a quantidade de caracteres encontrados na string	       
	 */
	public static int searchx1(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='a'){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx2(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='e'){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx3(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='i'){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx4(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='o'){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx5(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='u'){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx6(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==225){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx7(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==233){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx8(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==237){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx9(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==243){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx10(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==250){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx11(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==224){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx12(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==232){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx13(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==236){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx14(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==242){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx15(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==249){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx16(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==227){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx17(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==245){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx18(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==226){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx19(String s){int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==234){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx20(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==238){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx21(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==244){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx22(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==251){
				resp++;
			}
		}
		return resp;
	}
	/*
		@author Gabriel Lopes Ferreira
		@param s string para a busca
		@version 1.0
		@since 1.0
		O metodo percorre a string e procura o padrao <br>
	 */
	public static int searchbr(String s){
		int resp=0;
			for(int i=0;i<s.length();i++){
				if(i+3<s.length()&&s.charAt(i)=='<'&&s.charAt(i+1)=='b'&&s.charAt(i+2)=='r'&&s.charAt(i+3)=='>'){
					resp++;
				}
			}
		return resp;
	}
	/*
		@author Gabriel Lopes Ferreira
	    @version 1.0
		@since 1.0
		@param s String usada para a verificação
		O metodo percorre a string e procura pelo padrão <table>	
	 */
	public static int searchtable(String s){
		int resp=0;
			for(int i=0;i<s.length();i++){
				if(i+6<s.length()&&s.charAt(i)=='<'&&s.charAt(i+1)=='t'&&s.charAt(i+2)=='a'&&s.charAt(i+3)=='b'&&s.charAt(i+4)=='l'&&s.charAt(i+5)=='e'&&s.charAt(i+6)=='>'){
					resp++;
				}
			}
		return resp;
	}
	/*
		@author Gabriel Lopes Ferreira
		@version 1.0
		@since 1.0
		@param s String usada para verificação
		O metodo percorre a String procura quantas consoantes há na string
	*/
	public static int searchConsoant(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
				if(s.charAt(i)>='a'&&s.charAt(i)<='z'&&isConsoant(s.charAt(i))){
				resp++;
			}
		}
		return resp;
	}
	/*
		@author Gabriel Lopes Ferreira
		@version 1.0
		@since 1.0
		@param c um char usado na verificação
		O metodo verifica se a letra recebida é uma consoante
	*/
	public static boolean isConsoant(char ch){
		boolean consoant=true;
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
				consoant=false;
			}
		return consoant;
	}
	public static int contaletras(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='A'||s.charAt(i)>='Z'||s.charAt(i)>='a'||s.charAt(i)>='z'){
				resp++;
			}
		}
		return resp;
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
