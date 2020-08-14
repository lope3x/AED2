import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.nio.charset.*;
import java.nio.*;
public class TP03Q04{
	/*
	   @author Gabriel Lopes
	   Metodo main do programa 
	   */
	public static void main(String[]args)throws Exception{
		entrada();
	}
	/*
	   @author Gabriel Lopes
	   @since 1.0
	   @version 1.0
	   O metodo le a entrada padrao e faz as operacoes de insercao de remocao 
	   */
	public static void entrada()throws Exception{
		String input=MyIO.readLine();
		input=UTF8toISO(input);
		Presidente tmp;
		Alvinegra presidentes = new Alvinegra();
		do{
			tmp = new Presidente();
			tmp.lePresidente(input);
			tmp.setPagina(input);
			presidentes.inserir(tmp.getClone());
			input=MyIO.readLine();
			if(!input.contains("FIM"))input=UTF8toISO(input);
		}while(!input.contains("FIM"));
		input=MyIO.readLine();
		//input=UTF8toISO(input);
		do{
			//(presidentes.pesquisar(input)) ? MyIO.println("SIM") : MyIO.println("NÃO"); 
			System.out.print(input);
			MyIO.println((presidentes.pesquisar(input)) ? "SIM" : "NÃO");
			input=MyIO.readLine();
			if(!input.contains("FIM"))input=UTF8toISO(input);
		}while(!input.contains("FIM"));
		long comeco=System.currentTimeMillis();
		long fim=System.currentTimeMillis();
		long tempo=fim-comeco;
		Arq.openWrite("matricula_avinegra.txt");
		Arq.print("619148\t"+tempo+"\t"+presidentes.cmp);
		Arq.close();
	}
	/*	
		@author Gabriel Lopes
		@version 1.0
		@since 1.0
		@param str String para conversao
		@return String ja convertida

		O metodo converte uma string de utf-8 para iso-8859-1

*/
	public static String UTF8toISO(String str){
		Charset utf8charset = Charset.forName("UTF-8");
		Charset iso88591charset = Charset.forName("ISO-8859-1");

		ByteBuffer inputBuffer = ByteBuffer.wrap(str.getBytes());

		// decode UTF-8
		CharBuffer data = utf8charset.decode(inputBuffer);

		// encode ISO-8559-1
		ByteBuffer outputBuffer = iso88591charset.encode(data);
		byte[] outputData = outputBuffer.array();

		return new String(outputData);
	}
}
/**
 * No da arvore binaria
 * @author Gabriel Lopes Ferreira
 */
class No{
  public boolean cor;
  public Presidente elemento;
  public No esq, dir;
  public No (Presidente elemento){
      this(elemento, false, null, null);
  }
  public No (Presidente elemento, boolean cor){
      this(elemento, cor, null, null);
  }
  public No (Presidente elemento, boolean cor, No esq, No dir){
    this.cor = cor;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}

/**
 * Arvore binaria de pesquisa
 * @author Gabriel Lopes Ferreira
 */
class Alvinegra {
	private No raiz; // Raiz da arvore.
	public int cmp;

	/**
	 * Construtor da classe.
	 */
	public Alvinegra() {
		raiz = null;
		cmp=0;
	}

	public boolean pesquisar(String nome){
		MyIO.print(" raiz ");
		return pesquisar(nome,raiz);
	}
	private boolean pesquisar(String nome,No i){
		boolean resp;
		cmp++;
		if(i==null){
			resp = false;
		}
		//vai pra direita lexicamente eh maior
		else if(nome.compareTo(i.elemento.getNome())>0){
			cmp++;
			MyIO.print("dir ");
			resp=pesquisar(nome, i.dir);
		}
		//vai pra esq lexicamente eh menor
		else if(nome.compareTo(i.elemento.getNome())<0){
			cmp++;
			MyIO.print("esq ");
			resp = pesquisar(nome,i.esq);
		}
		//encontrou
		else{
			resp=true;
		}
		return resp;
	}



	/**
	 * Metodo publico iterativo para inserir elemento.
	 * @param elemento Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(Presidente elemento) throws Exception {
   
      //Se a arvore estiver vazia
      if(raiz == null){
         raiz = new No(elemento, false);

      //Senao, se a arvore tiver um elemento 
      } else if (raiz.esq == null && raiz.dir == null){
         if (raiz.elemento.getNome().compareTo(elemento.getNome()) > 0){
            raiz.esq = new No(elemento, true);
         } else {
            raiz.dir = new No(elemento, true);
         }

      //Senao, se a arvore tiver dois elementos (raiz e dir)
      } else if (raiz.esq == null){

         if(raiz.elemento.getNome().compareTo(elemento.getNome()) > 0){
            raiz.esq = new No(elemento);

         } else if (raiz.dir.elemento.getNome().compareTo(elemento.getNome())>0){
            raiz.esq = new No(raiz.elemento);
            raiz.elemento = elemento;


         } else {
            raiz.esq = new No(raiz.elemento);
            raiz.elemento = raiz.dir.elemento;
            raiz.dir.elemento = elemento;

         }

         raiz.esq.cor = raiz.dir.cor = false;
         
      //Senao, se a arvore tiver dois elementos (raiz e esq)
      } else if (raiz.dir == null){
         
         if(raiz.elemento.getNome().compareTo(elemento.getNome())<0){
            raiz.dir = new No(elemento);

         } else if (raiz.esq.elemento.getNome().compareTo(elemento.getNome())<0){
            raiz.dir = new No(raiz.elemento);
            raiz.elemento = elemento;

         } else {
            raiz.dir = new No(raiz.elemento);
            raiz.elemento = raiz.esq.elemento;
            raiz.esq.elemento = elemento;

         }

         raiz.esq.cor = raiz.dir.cor = false;

      //Senao, a arvore tem tres ou mais elementos
      } else {
		   inserir(elemento, null, null, null, raiz);
      }

      raiz.cor = false;
   }

   private void balancear(No bisavo, No avo, No pai, No i){

      //Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
      if(pai.cor == true){

         //4 tipos de reequilibrios e acoplamento
         if(pai.elemento.getNome().compareTo(avo.elemento.getNome())>0){ // rotacao a esquerda ou direita-esquerda
            if(i.elemento.getNome().compareTo(pai.elemento.getNome())>0){
               avo = rotacaoEsq(avo);
            } else {
               avo = rotacaoDirEsq(avo);
            }

         } else { // rotacao a direita ou esquerda-direita
            if(i.elemento.getNome().compareTo(pai.elemento.getNome())<0){
               avo = rotacaoDir(avo);
            } else {
               avo = rotacaoEsqDir(avo);
            }
         }

         if (bisavo == null){
            raiz = avo;
         } else {
            if(avo.elemento.getNome().compareTo(bisavo.elemento.getNome())<0){
               bisavo.esq = avo;
            } else {
               bisavo.dir = avo;
            }
         }

         //reestabelecer as cores apos a rotacao
         avo.cor = false;
         avo.esq.cor = avo.dir.cor = true;

      } //if(pai.cor == true)
   }

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * @param elemento Elemento a ser inserido.
	 * @param avo No em analise.
	 * @param pai No em analise.
	 * @param i No em analise.
	 * @throws Exception Se o elemento existir.
	 */
	private void inserir(Presidente elemento, No bisavo, No avo, No pai, No i){
		if (i == null) {
         if(elemento.getNome().compareTo(pai.elemento.getNome())<0){
            i = pai.esq = new No(elemento, true);
         } else {
            i = pai.dir = new No(elemento, true);
         }
         if(pai.cor == true){
            balancear(bisavo, avo, pai, i);
         }
      } else {
        //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
         if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
            i.cor = true;
            i.esq.cor = i.dir.cor = false;
            if(i == raiz){
               i.cor = false;
            }else if(pai.cor == true){
               balancear(bisavo, avo, pai, i);
            }
         }
         if (elemento.getNome().compareTo(i.elemento.getNome())<0) {
            inserir(elemento, avo, pai, i, i.esq);
         } else if (elemento.getNome().compareTo(i.elemento.getNome())>0) {
            inserir(elemento, avo, pai, i, i.dir);
         }
      }
	}

   private No rotacaoDir(No no) {
      No noEsq = no.esq;
      No noEsqDir = noEsq.dir;

      noEsq.dir = no;
      no.esq = noEsqDir;

      return noEsq;
   }

   private No rotacaoEsq(No no) {
      No noDir = no.dir;
      No noDirEsq = noDir.esq;

      noDir.esq = no;
      no.dir = noDirEsq;
      return noDir;
   }

   private No rotacaoDirEsq(No no) {
      no.dir = rotacaoDir(no.dir);
      return rotacaoEsq(no);
   }

   private No rotacaoEsqDir(No no) {
      no.esq = rotacaoEsq(no.esq);
      return rotacaoDir(no);
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
