import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.nio.charset.*;
import java.nio.*;

public class tp01p2q03{
	public static void main(String[]args){
		try{
			entrada();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	/*
		@author Gabriel Lopes
		@since 1.0
		@version 1.0
		O metodo le a entrada padrao e faz as operacoes de insercao de remocao 
	*/
	public static void entrada()throws Exception{
		String input=MyIO.readLine();
		//input=UTF8toISO(input);
		String pag;
		Presidente teste;
		int pos=0;
		Pilha presidentes = new Pilha();
		Presidente tmp;
		Presidente removido;
		do{
			teste = new Presidente();
			teste.lePresidente(input);
			teste.setPagina(input);
			presidentes.empilhar(teste.getClone());
			input=MyIO.readLine();
			//if(!input.contains("FIM"))input=UTF8toISO(input);
		}while(!input.contains("FIM"));
		int n=MyIO.readInt();
		for(int i=0;i<n;i++){
				input=MyIO.readString();
				if(input.equals("I")){
					input=MyIO.readLine();
					//input=UTF8toISO(input);
					tmp= new Presidente();
					tmp.lePresidente(input);
					tmp.setPagina(input);
					presidentes.empilhar(tmp.getClone());
					tmp=null;
				}
				if(input.equals("R")){
					removido=presidentes.desempilhar();
					MyIO.println("(R) "+removido.getNome());
					removido=null;
				}
		}
		presidentes.mostrar();
	}
	/*	
		@author Gabriel Lopes
		@version 1.0
		@since 1.0
		@param str String para conversao
		@return String ja convertida
		
		O metodo converte uma string de utf-8 para iso-8859-1
		
	*/
	/*public static String UTF8toISO(String str){
        Charset utf8charset = Charset.forName("UTF-8");
        Charset iso88591charset = Charset.forName("ISO-8859-1");

        ByteBuffer inputBuffer = ByteBuffer.wrap(str.getBytes());

        // decode UTF-8
        CharBuffer data = utf8charset.decode(inputBuffer);

        // encode ISO-8559-1
        ByteBuffer outputBuffer = iso88591charset.encode(data);
        byte[] outputData = outputBuffer.array();

        return new String(outputData);
    	}*/
}
/*
	@author Gabriel Lopes
	@version 1.0
	@date 21/02/2019
*/
class Pilha {
	private Presidente[] array;
	private int n;
	/*
		@author Gabriel Lopes
		@version 1.0
		@since 1.0
		Construtor da classe
	*/
	public Pilha(){
		this(38);
	}
	/*
		@author Gabriel Lopes
		@version 1.0
		@since 1.0
		@param int tam Tamanho do array
		Construtor da classe
	*/
	public Pilha(int tam){
		array = new Presidente[tam];
		n=0;
	}
	/*
		@author Gabriel Lopes
		@version 1.0
		@since 1.0
		@param Presidente x objeto a ser inserido da pilha
		O metodo recebe um objeto e o insere na pilha
		
	*/
	public void empilhar(Presidente x)throws Exception{
		if(n>=array.length)throw new Exception("Erro ao inserir Array Full");
		array[n]=x;
		n++;
	}
	/*
		@author Gabriel Lopes
		@version 1.0
		@since 1.0
		@return Presidente array[--n] objeto a ser inserido da pilha
		O metodo remove um objeto da pilha e o retorna 
		
	*/
	public Presidente desempilhar()throws Exception{
		if(n==0)throw new Exception("Erro ao remover Array Vazio");
		return array[--n];
	}
	/*
		@author Gabriel Lopes
		@version 1.0
		@since 1.0
		O metodo exibe as informacoes de cada elemento da Pilha
		
	*/
	public void mostrar()throws Exception{
		if(n==0)throw new Exception("Erro ao mostrar Array Vazio");
		Presidente print = new Presidente();
		for(int i=0;i<n;i++){
			MyIO.print("["+i+"] ");
			print.printPresidente(array[i]);
		}
	}
}
class Presidente implements Cloneable{
	private int id;//OK
	private String nome;//OK
	private int idade;//OK
	private LocalDate dataNascimento;//OK
	private String localNascimento;//OK
	private LocalDate inicioMandato;//ok
	private LocalDate fimMandato;//ok
	private LocalDate dataMorte;//ok
	private String localMorte;//ok
	private String antecessor;//ok
	private String sucessor;//ok
	private String vice;//ok
	private String pagina;
	private long paginaTam;//pag tam ok
	
	public Presidente(){
		this.setId(0);
		this.setNome("a");
		this.setIdade(0);
		this.setDataNascimento(LocalDate.of(0001,01,01));
		this.setLocalNascimento("a");
		this.setInicioMandato(LocalDate.of(0001,01,01));
		this.setFimMandato(LocalDate.of(0001,01,01));
		this.dataMorte=null;
		this.setLocalMorte("a");
		this.setAntecessor("a");
		this.setSucessor("");
		this.setVice("a");
		this.setPagina("a");
		this.setPaginaTam(0);
	}
	public Presidente(int id, String nome, int idade, LocalDate dataNascimento, String localNascimento, LocalDate inicioMandato, LocalDate fimMandato, LocalDate dataMorte, String localMorte, String antecessor, String sucessor,String vice,String pagina, long paginaTam){
		this.setId(id);
		this.setNome(nome);
		this.setIdade(idade);
		this.setDataNascimento(dataNascimento);
		this.setLocalNascimento(localNascimento);
		this.setInicioMandato(inicioMandato);
		this.setFimMandato(fimMandato);
		this.setDataMorte(dataMorte);
		this.setLocalMorte(localMorte);
		this.setAntecessor(antecessor);
		this.setSucessor(sucessor);
		this.setVice(vice);
		this.setPagina(pagina);
		this.setPaginaTam(paginaTam);
	}
	/*
		Abaixo estao os metodos sets e gets da classe
	*/
	public void setId(int id){
		this.id=id;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setIdade(int idade){
		this.idade=idade;
	}
	public void setDataNascimento(LocalDate dataNascimento){
		this.dataNascimento=dataNascimento;
	}
	public void setLocalNascimento(String localNascimento){
		this.localNascimento=localNascimento;
	}
	public void setInicioMandato(LocalDate inicioMandato){
		this.inicioMandato=inicioMandato;
	}
	public void setFimMandato(LocalDate fimMandato){
		this.fimMandato=fimMandato;
	}
	public void setDataMorte(LocalDate dataMorte){
		this.dataMorte=dataMorte;
	}
	public void setLocalMorte(String localMorte){
		this.localMorte=localMorte;
	}
	public void setAntecessor(String antecessor){
		this.antecessor=antecessor;
	}
	public void setSucessor(String sucessor){
		this.sucessor=sucessor;
	}
	public void setVice(String vice){
		this.vice=vice;
	}
	public void setPagina(String pagina){
		this.pagina=pagina;
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
	public LocalDate getDataNascimento(){
		return this.dataNascimento;
	}
	public String getLocalNascimento(){
		return this.localNascimento;
	}
	public LocalDate getInicioMandato(){
		return this.inicioMandato;
	}
	public LocalDate getFimMandato(){
		return this.fimMandato;
	}
	public LocalDate getDataMorte(){
		return this.dataMorte;
	}
	public String getLocalMorte(){
		return this.localMorte;
	}
	public String getAntecessor(){
		return this.antecessor;
	}
	public String getSucessor(){
		return this.sucessor;
	}
	public String getVice(){
		return this.vice;
	}
	public String getPagina(){
		return this.pagina;
	}
	public long getPaginaTam(){
		return this.paginaTam;
	}
	Presidente getClone(){
		try {
            return (Presidente) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println (" Cloning not allowed. " );
            return this;
        }
	}
	public int getMes(String entrada){
		int mes=0;
		if(entrada.endsWith("janeiro"))mes=1;
		if(entrada.endsWith("fevereiro"))mes=2;
		CharSequence cs="mar";
		if(entrada.contains(cs))mes=3;
		if(entrada.endsWith("abril"))mes=4;
		if(entrada.endsWith("maio"))mes=5;
		if(entrada.endsWith("junho"))mes=6;
		if(entrada.endsWith("julho"))mes=7;
		if(entrada.endsWith("agosto"))mes=8;
		if(entrada.endsWith("setembro"))mes=9;
		if(entrada.endsWith("outubro"))mes=10;
		if(entrada.endsWith("novembro"))mes=11;
		if(entrada.endsWith("dezembro"))mes=12;
		return mes;
	}
	public static String removeTags(String s){
      String resp = "";
      for (int i = 0; i < s.length(); i++){

         //Perguntas: (1) Pq o while abaixo? (2) Pq as clausulas do while abaixo nao podem ser invertidas?
         while(i < s.length() && s.charAt(i) == '<'){
            for (i++; s.charAt(i) != '>'; i++);
            i++;

            //Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo?
            while(i < s.length() && s.charAt(i) == '&'){
               for (i++; s.charAt(i) != ';'; i++);
               i++;
            }
         }

         //Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo?
         while(i < s.length() && s.charAt(i) == '&'){
            for (i++; s.charAt(i) != ';'; i++);
            i++;
            resp += ' ';
         }

         //Perqunta: Pq nao colocamos apenas resp += s.charAt(i)?
         if(i < s.length()){
            resp += s.charAt(i);
         }
      }

      while(resp.length() > 0 && resp.charAt(0) == ' '){
         resp = resp.substring(1);
      }
      return resp;
   }
   public void lePresidente(String nomeArquivo){
	  String linha = "";
      int dia, mes, ano;

      //Abrir o arquivo para leitura
      Arq.openRead(nomeArquivo, "UTF8");
	  File file = new File(nomeArquivo);
      //Informacao sobre o arquivo html
      this.pagina = nomeArquivo;
      this.paginaTam = file.length();


      //Ignorar tagas iniciais
      for(boolean stop = false; stop == false; stop = Arq.readLine().contains("background-color:#B0C4DE"));
      for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("Presidente do Brasil"));

      //id
      linha = linha.substring(linha.indexOf(">")+1);
      linha = linha.substring(linha.indexOf(">")+1);
      this.id = Integer.parseInt(linha.substring(0, linha.indexOf("</a>")).replace("\u00BA","").replace("\u00AA",""));
      //Ignorar tags
	  String pe="Per";
	  pe+="\u00ED";
	  pe+="odo";
      for(boolean stop = false; stop == false; stop = Arq.readLine().contains(pe));
      for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
      linha = linha.substring(linha.indexOf(">")+1);
      linha = linha.substring(linha.indexOf(">")+1);
      //Inicio do governo
      dia = Integer.parseInt(linha.substring(0, (linha.charAt(1) == ' ' || linha.charAt(1) == '\u00BA') ? 1 : 2));
      linha = linha.substring(linha.indexOf(" de ")+4);
      mes = getMes(linha.substring(0, linha.indexOf("</a>")));
      linha = linha.substring(linha.indexOf("</a>")+4);
      linha = linha.substring(linha.indexOf(">")+1);
      ano = Integer.parseInt(linha.substring(0, linha.indexOf("</a>")));
      linha = linha.substring(linha.indexOf(">")+1);
      linha = linha.substring(linha.indexOf(">")+1);
      linha = linha.substring(linha.indexOf(">")+1);
      this.inicioMandato = LocalDate.of(ano, mes, dia);
      //Fim do governo
      dia = Integer.parseInt(linha.substring(0, (linha.charAt(1) == ' ' || linha.charAt(1) == '\u00BA') ? 1 : 2));
      linha = linha.substring(linha.indexOf(" de ")+4);
      mes = getMes(linha.substring(0, linha.indexOf("</a>")));
      linha = linha.substring(linha.indexOf("</a>")+4);
      linha = linha.substring(linha.indexOf(">")+1);
      ano = Integer.parseInt(linha.substring(0, linha.indexOf("</a>")));
      this.fimMandato = LocalDate.of(ano, mes, dia);
      //Vice-presidente
      for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
      if(linha.contains("Vice") == true){
         for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
         this.vice = removeTags(linha);
         for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
      } else {
         this.vice = "";
      }

      //Antecessor
      if(linha.contains("Antecessor") == true){
         for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
         this.antecessor = removeTags(linha);
         for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
      } else {
         this.antecessor = "";
      }

      //Sucessor
      if(linha.contains("Sucessor") == true){
         for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
         this.sucessor = removeTags(linha);
      } else {
         this.sucessor = "";
      }

      //Nome completo do presidente
      for(boolean stop = false; stop == false; stop = Arq.readLine().contains("Dados pessoais"));
      for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
      if(linha.contains("Nome") == true){
         for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
         nome = removeTags(linha);
         for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
      } else {
         this.nome = "";
      }

      //Data de nascimento
      for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
      linha = linha.substring(linha.indexOf(">")+1);
      linha = linha.substring(linha.indexOf(">")+1);
      dia = Integer.parseInt(linha.substring(0, (linha.charAt(1) == ' ' || linha.charAt(1) == '\u00BA') ? 1 : 2));
      linha = linha.substring(linha.indexOf(" de ")+4);
      mes = getMes(linha.substring(0, linha.indexOf("</a>")));
      linha = linha.substring(linha.indexOf("</a>")+4);
      linha = linha.substring(linha.indexOf(">")+1);
      ano = Integer.parseInt(linha.substring(0, linha.indexOf("</a>")));
      this.dataNascimento = LocalDate.of(ano, mes, dia);
      this.idade = 2019 - ano + ((mes == 1 && dia <= 3) ? 1 : 0);
      this.localNascimento = removeTags(linha.substring(linha.indexOf("</a>")+4));
      if(this.localNascimento.contains("anos") == true){
         this.localNascimento = this.localNascimento.substring(this.localNascimento.indexOf(")")+2);
         this.dataMorte = null;
         this.localMorte = null;
      } else {
         for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
         for(boolean stop = false; stop == false; linha = Arq.readLine(), stop = linha.contains("<td"));
         linha = linha.substring(linha.indexOf(">")+1);
         linha = linha.substring(linha.indexOf(">")+1);
         linha = linha.substring(linha.indexOf(">")+1);
         dia = Integer.parseInt(linha.substring(0, (linha.charAt(1) == ' ' || linha.charAt(1) == '\u00BA') ? 1 : 2));
         linha = linha.substring(linha.indexOf(" de ")+4);
         mes = getMes(linha.substring(0, linha.indexOf("</a>")));
         linha = linha.substring(linha.indexOf("</a>")+4);
         linha = linha.substring(linha.indexOf(">")+1);
         ano = Integer.parseInt(linha.substring(0, linha.indexOf("</a>")));
         this.dataMorte = LocalDate.of(ano, mes, dia);
         this.localMorte = removeTags(linha.substring(linha.indexOf("</a>")+4));
         this.localMorte = this.localMorte.substring(this.localMorte.indexOf(")")+2);
      }
	  LocalDate agr = LocalDate.of(2019,12,31);
	  LocalDate nascimento=getDataNascimento();
	  Period anos = nascimento.until(agr);
	  int anosidade = anos.getYears();
	  setIdade(anosidade);
	  
      //Fechar o arquivo para a leitura
   }
	public void printPresidente(Presidente teste){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		String nascimento= teste.getDataNascimento().format(formatter);
		String iniciomandato = teste.getInicioMandato().format(formatter);
		String fimmandato = teste.getFimMandato().format(formatter);
		String datamorte="";
		if(teste.getDataMorte()!=null)datamorte = teste.getDataMorte().format(formatter);
		if(teste.getDataMorte()==null)MyIO.println(teste.getId()+" ## "+teste.getNome()+" ## "+iniciomandato+" (I) ## "+fimmandato+" (F) ## "+nascimento+" em "+teste.getLocalNascimento()+" (N) ## "
		+teste.getIdade()+" ## "+teste.getPagina()+" ## "+(int)teste.getPaginaTam()+" ## "+teste.getAntecessor()+" ## "+teste.getSucessor()+" ## "+teste.getVice());//PRINTA VIVOS
		else MyIO.println(teste.getId()+" ## "+teste.getNome()+" ## "+iniciomandato+" (I) ## "+fimmandato+" (F) ## "+nascimento+" em "+teste.getLocalNascimento()+" (N) ## "+teste.getIdade()+" ## "+datamorte+
		" em "+teste.getLocalMorte()+" (M) ## "+teste.getPagina()+" ## "+(int)teste.getPaginaTam()+" ## "+teste.getAntecessor()+" ## "+teste.getSucessor()+" ## "+teste.getVice());//printa mortos
	}
}
