import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.*;
public class tp01p2q01{
	public static void main(String[]args){
		long tempoInicio = System.currentTimeMillis();
		/*Arq.openRead("presidente/Artur_Bernardes.html");
		String resp="";
		for(int i=0;i<500;i++){
			resp+=Arq.readLine();
		}
		char[] s= convertToChar(resp);
		for(int i=0;i<s.length;i++){
			//script small span spun
			if(s[i]=='<'&&s[i+1]=='s'){
				s=apagaTag(s,i);
				i=0;
			}
			/*if(s[i]=='<'&&s[i+1]=='t'){
				s=apagaTag(s,i);
				i=0;
			}*/
/*
		}
		for(int i=0;i<s.length;i++){
			if(s[i]=='<'){
				s=apagaResto(s,i);
				i=0;
			}
		}
		String saida="";
		for(int i=0;i<s.length;i++){
			saida+=s[i];
		}
		saida=saida.replaceAll(" ","");
		saida=saida.replaceAll("	","");
		char[] saidaa=new char[saida.length()];
		String out="";
		for(int i=0;i<saida.length();i++){
			saidaa[i]=saida.charAt(i);
			if(saidaa[i]=='.'){
				saidaa[i]=(char)32;
			}
			out+=saidaa[i];
		}*/
		Presidente teste = new Presidente();
		teste.lePresidente();
		MyIO.println(teste.getId());
		MyIO.println(teste.getNome());
		MyIO.println(teste.getIdade());
		MyIO.println((int)teste.getPaginaTam());
		System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
	}//CHAVE DE BUSCA IDADE &#160;anos) 2 I ANTES É A IDADE 
}
class Presidente extends ReadPresidente{
	private int id;//ID OK
	private String nome;//NOME OK
	private int idade;//IDADE OK
	private LocalDateTime dataNascimento;
	private String localNascimento;
	private LocalDateTime inicioMandato;
	private LocalDateTime fimMandato;
	private LocalDateTime dataMorte;
	private String localMorte;
	private String antecessor;
	private String sucessor;
	private String vice;
	private String pagina;
	private long paginaTam;

	public void setId(int id){
		this.id=id;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setIdade(int idade){
		this.idade=idade;
	}
	public void setDataNascimento(){

	}
	public void setPaginaTam(long paginaTam){
		this.paginaTam=paginaTam;
	}
	public int getId(){
		return this.id;
	}
	public String getNome(){
		return this.nome;
	}
	public int getIdade(){
		return this.idade;
	}
	public long getPaginaTam(){
		return this.paginaTam;
	}
	//string S= nome arq presidente
	public void lePresidente(){
		Arq.openRead("presidente/Itamar_Franco.html","ISO-8859-1");//NOME DO ARQUIVO SERA RECBIDO POR PARAMETRO
		String resp="";
		for(int i=0;i<500;i++){
			resp+=Arq.readLine();
		}
		char[] s=convertToChar(resp);
		/*for(int i=0;i<s.length;i++){
			if(s[i]=='<'&&s[i+1]=='/'&&s[i+2]=='a'&&s[i-2]>=48&&s[i-2]<=57){
				s[i-1]='.';
				i=s.length;
			}
		}*/
		for(int i=0;i<s.length;i++){
			//script small span spun
			if(s[i]=='<'&&s[i+1]=='s'){
				s=apagaTag(s,i);
				i=0;
			}
			/*if(s[i]=='<'&&s[i+1]=='t'){
				s=apagaTag(s,i);
				i=0;
			}*/

		}
		for(int i=0;i<s.length;i++){
			if(s[i]=='<'){
				s=apagaResto(s,i);
				i=0;
			}
		}
		/*for(int i=0;i<s.length;i++){
			if(s[i]=='&'&&s[i+1]=='&'){
				s=apagaLixo(s,i);
				i=0;
			}
		}*/
		String saida="";
		for(int i=0;i<s.length;i++){
			saida+=s[i];
		}
		saida=saida.replaceAll("º&#32;","");
		saida=saida.replaceAll("&#32;","");
		saida=saida.replaceAll("\u00BA","");
		saida=saida.replaceAll("\u00C2","");
		saida=saida.replaceAll("\u00AA","");
		saida=saida.replaceAll(" ","");
		saida=saida.replaceAll("	","");
		saida=saida.replaceAll("&#160;","");
		saida=saida.replaceAll("&#","");
		saida=saida.replaceAll(";","");
		char[] saidaa=new char[saida.length()];
		String out="";
		/*for(int i=0;i<saidaa.length;i++){
			if(saidaa[i]=='<'&&saidaa[i+1]=='/'&&saidaa[i+2]=='a'&&saidaa[i-2]>=48&&saidaa[i-2]<=57){
				saidaa[i-1]='.';
				i=saidaa.length;
			}
		}*/
		for(int i=0;i<saida.length();i++){
			saidaa[i]=saida.charAt(i);
			if(saidaa[i]=='.'||saidaa[i]=='('||saidaa[i]==')'){
				saidaa[i]=(char)32;
			}
			out+=saidaa[i];
		}
		//STRING OUT ESTa PRONTA PARA A BUSCA 
		Arq.openWrite("temp.dat","ISO-8859-1");
		Arq.print(out);
		Arq.close();
		try{
			Scanner read = new Scanner(new File("temp.dat"),"ISO-8859-1");
			Arq.openWrite("presidente.dat","ISO-8859-1");
			String temp=read.next();
			do{
				temp=read.next();
				Arq.println(temp);
			}while(read.hasNext());
			//Arq.close();
			//read.close();
		}
		catch(Exception e){
			
		}
		Arq.openRead("presidente/Itamar_Franco.html","ISO-8859-1");//NOME DO ARQUIVO SERA RECBIDO POR PARAMETRO
		String pegatam=Arq.readAll();
		Arq.close();
		setPaginaTam((long)pegatam.length());
		setId(searchId());
		setNome(searchNome());
		setIdade(searchIdade());
	}//FIM LE PRESIDENTE
	//Arq.openRead(tmp/presidente.zip,"UTF-8");
}
class ReadPresidente{
	public static char[] convertToChar(String s){
		char[] convertido = new char[s.length()];
		for(int i=0;i<s.length();i++){
			convertido[i]=s.charAt(i);
		}
		return convertido;
	}
	//RECEBE A POS DO < DO <title>
	public static char[] apagaTag(char[] s, int postag){
		int c=0;
		for(int i=postag;i<s.length;i++){
			if(s[i]=='>'){
				c++;
				if(c==2){
					s[i]='.';
					i=s.length;;

				}
				else{
					s[i]=(char)32;
				}
			}
			else{
				s[i]=(char)32;
			}


		}
		return s;
	}
	public static char[] apagaResto(char[] s, int pos){
		for(int i=pos;i<s.length;i++){
			if(s[i]=='>'){
				s[i]='.';
				i=s.length;
			}
			else{
				s[i]=(char)32;
			}
		}
		return s;
	}
	/*public static char[] apagaLixo(char[] s, int pos){
		for(int i=pos;i<s.length;i++){
			if(s[i]=='2'){
				s[i]='.';
				i=s.length;
			}
			else{
				MyIO.print("APAGOU");
				s[i]=(char)32;
			}
		}
		return s;
	}*/
	/*public static int searchId(String s){
		int id;
		//23
		//PRE 7
		String resp="";
		for(int i=0;i<s.length();i++){
			if(s.charAt(i+7)=='e'&&s.charAt(i+6)=='r'&&s.charAt(i+5)=='P'){
				resp+=s.charAt(i-1);
				resp+=s.charAt(i);
				i=s.length();
			}
		}
		id=Integer.parseInt(resp);
		return id;
	}*/
	public static int searchId(){
		String nomearq="presidente.dat";
		Arq.openRead(nomearq);
		String anterior="";
		String atual="";
		String resp="";
		int id;
		do{
			atual = Arq.readLine();
			if(atual.equals("PresidentedoBrasil")){
				resp=anterior;
			}
			anterior=atual;
		}while(Arq.hasNext());
		id=Integer.parseInt(resp);
		return id;
	}
	public static String searchNome(){
		Arq.openRead("presidente.dat");
		String entrada="";
		String resp="";
		do{
			entrada=Arq.readLine();
			if(entrada.equals("Nomecompleto")){
				resp=colocaespaco(Arq.readLine());
			}
		}while(Arq.hasNext());
		return resp;
	}
	public static int searchIdade(){
		Arq.openRead("presidente.dat");
		String entrada="";
		String resp="";
		int idade=0;
		do{
			entrada=Arq.readLine();
			if(entrada.length()==6){
				if(entrada.charAt(2)=='a'&&entrada.charAt(3)=='n'&&entrada.charAt(4)=='o'&&entrada.charAt(5)=='s'){
					resp+=entrada.charAt(0);
					resp+=entrada.charAt(1);
				}
			}
		}while(Arq.hasNext());
		idade=Integer.parseInt(resp);
		return idade;
	}
	public static String colocaespaco(String s){
		String resp="";
		boolean de=true;
		boolean jafoi=true;
		boolean deanterior=true;
		int c=0;
		for(int i=0;i<s.length();i++){
			resp+=s.charAt(i);
			jafoi=true;
			deanterior=de;
			de=true;
			if(i+3<s.length()){//deMelo
				if(Character.isUpperCase(s.charAt(i+1))||s.charAt(i+1)=='d'&&s.charAt(i+2)=='a'&&Character.isUpperCase(s.charAt(i+3))){
						resp+=" ";
						jafoi=false;
				}
				if(jafoi&&s.charAt(i+1)=='d'&&s.charAt(i+2)=='e'&&Character.isUpperCase(s.charAt(i+3))){
						resp+=" ";
						de=false;
				}
				if(resp.equals("Artur da Costa")||resp.equals("Francisco Rosa")){
					resp+=" ";
				}
				
			}
		}
		return resp;
	}
}
