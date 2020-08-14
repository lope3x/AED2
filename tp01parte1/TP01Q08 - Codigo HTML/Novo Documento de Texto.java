import java.io.*;
import java.net.URL;
public class TP01Q08{
	public static void main(String[]args){
		String endereco = "http://maratona.crc.pucminas.br/series/Friends.html";
		try{
			URL url= new URL(endereco);  
           	BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream())); 
			MyIO.readLine(url.openStream());
			int i=0;
			String linha;
			int br=0;
			int table=0;
			int consoantes=0;
			char c;
			int x1=0;int x2=0;int x3=0;int x4=0;int x5=0;int x6=0;int x7=0;int x8=0;int x9=0;int x10=0;int x11=0;int x12=0;
			int x13=0;int x14=0;int x15=0;int x16=0;int x17=0;int x18=0;int x19=0;int x20=0;int x21=0;int x22=0;
			while ((linha = reader.readLine()) != null){
					br+=searchbr(linha);
					table+=searchtable(linha);
					MyIO.println(i);
					x1+=searchx1(linha);
			}
			MyIO.print("a("+x1+")");
		}
		catch(IOException e){
			System.err.println(e);
		}
	}
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
			if(s.charAt(i)=="160"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx7(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="130"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx8(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="213"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx9(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="162"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx10(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="163"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx11(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="133"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx12(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="138"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx13(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="141"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx14(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="149"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx15(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="151"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx16(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="198"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx17(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="228"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx18(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="131"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx19(String s){int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="136"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx20(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="140"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx21(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="147"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchx22(String s){
		int resp=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=="150"){
				resp++;
			}
		}
		return resp;
	}
	public static int searchbr(String s){
		int resp=0;
		if(i+3<s.length()){
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='<'&&s.charAt(i+1)=='b'&&s.charAt(i+2)=='r'&&s.charAt(i+3)=='>'){
					resp++;
				}
			}
		}
		return resp;
	}
	public static int searchtable(String s){
		int resp=0;
		if(i+6<s.length()){
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='<'&&s.charAt(i+1)=='t'&&s.charAt(i+2)=='a'&&s.charAt(i+3)=='b'&&s.charAt(i+4)=='l'&&s.charAt(i+5)=='e'&&s.charAt(i+6)=='>'){
					resp++;
				}
			}
		}	
		return resp;
	}
	/*
		Autor: Gabriel Lopes Ferreira
		Parametros: str
		Data de Modificação:01/02/2019
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
		Parametros: str1, str2
		Data de Modificação:31/01/2019
		O metodo compara duas Strings e verifica se as mesesma são iguais
		retornando um valor boolean
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