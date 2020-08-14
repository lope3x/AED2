import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.nio.charset.*;
import java.nio.*;
public class tp01p2q09{
	/*
	   @author Gabriel Lopes
	   Metodo main do programa 
	   */
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
		input=UTF8toISO(input);
		Lista presidentes = new Lista();
		Presidente tmp;
		do{
			tmp = new Presidente();
			tmp.lePresidente(input);
			tmp.setPagina(input);
			presidentes.inserirFim(tmp.getClone());
			input=MyIO.readLine();
			if(!input.contains("FIM"))input=UTF8toISO(input);
		}while(!input.contains("FIM"));
		input=MyIO.readLine();//nome
		input=UTF8toISO(input);//converte nome
		int comparacao=0;
		long comeco=System.currentTimeMillis();
		presidentes.ordenacaoSelecaoRec();
		comparacao=presidentes.getComparacao();
		int movimentacoes=presidentes.getMovimentacoes();
		long fim=System.currentTimeMillis();
		presidentes.mostrar();
		Arq.openWrite("619148_selecaoRecursiva.txt");
		long tempo=fim-comeco;
		Arq.print("619148\t"+comparacao+"\t"+movimentacoes+"\t"+tempo);
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
class Lista{
	private Presidente[] array;
	private int n;
	private int comparacao=0;
	private int movimentacoes;
	/*
	   Construtor da classe
	   */
	public Lista(){
		this(100);
	}/*
	Construtor da classe
	@param tam Tamanho da Lista
	*/
	public Lista(int tam){
		array = new Presidente[tam];
		n=0;
	}
	public int getComparacao(){
		return this.comparacao;	
	}
	public int getMovimentacoes(){
		return this.movimentacoes;
	}
	/**
	 * Insere um elemento na primeira posicao da lista e move os demais
	 * elementos para o fim da lista.
	 * @author Gabriel Lopes
	 * @param x Presidente elemento a ser inserido.
	 * @throws Exception Se a lista estiver cheia.
	 */
	public void inserirInicio(Presidente x) throws Exception {

		//validar insercao
		if(n >= array.length){
			throw new Exception("Erro ao inserir! Array Full");
		} 

		//levar elementos para o fim do array
		for(int i = n; i > 0; i--){
			array[i] = array[i-1];
		}

		array[0] = x;
		n++;
	}
	/**
	 * Insere um elemento na ultima posicao da lista.
	 * @param x Presidente elemento a ser inserido.
	 * @throws Exception Se a lista estiver cheia.
	 */
	public void inserirFim(Presidente x) throws Exception {

		//validar insercao
		if(n >= array.length){
			throw new Exception("Erro ao inserir! Array Full");
		}

		array[n] = x;
		n++;
	}
	/**
	 * Insere um elemento em uma posicao especifica e move os demais
	 * elementos para o fim da lista.
	 * @author Gabriel Lopes
	 * @param x Presidente elemento a ser inserido.
	 * @param pos Posicao de insercao.
	 * @throws Exception Se a lista estiver cheia ou a posicao invalida.
	 */
	public void inserir(Presidente x, int pos) throws Exception {

		//validar insercao
		if(n >= array.length || pos < 0 || pos > n){
			throw new Exception("Erro ao inserir! Posicao Invalida ou Array Full");
		}

		//levar elementos para o fim do array
		for(int i = n; i > pos; i--){
			array[i] = array[i-1];
		}

		array[pos] = x;
		n++;
	}
	/**
	 * Remove um elemento da primeira posicao da lista e movimenta 
	 * os demais elementos para o inicio da mesma.
	 * @author Gabriel Lopes
	 * @return resp Presidente elemento a ser removido.
	 * @throws Exception Se a lista estiver vazia.
	 */
	public Presidente removerInicio() throws Exception {

		//validar remocao
		if (n == 0) {
			throw new Exception("Erro ao remover! Array Vazio");
		}

		Presidente resp = array[0];
		n--;

		for(int i = 0; i < n; i++){
			array[i] = array[i+1];
		}

		return resp;
	}
	/**
	 * Remove um elemento da ultima posicao da lista.
	 * @author Gabriel Lopes
	 * @return resp Presidente elemento a ser removido.
	 * @throws Exception Se a lista estiver vazia.
	 */
	public Presidente removerFim() throws Exception {

		//validar remocao
		if (n == 0) {
			throw new Exception("Erro ao remover! Array Vazio");
		}

		return array[--n];
	}
	/**
	 * Remove um elemento de uma posicao especifica da lista e 
	 * movimenta os demais elementos para o inicio da mesma.
	 * @author Gabriel Lopes
	 * @param pos Posicao de remocao.
	 * @return resp Presidente elemento a ser removido.
	 * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
	 */
	public Presidente remover(int pos) throws Exception {

		//validar remocao
		if (n == 0 || pos < 0 || pos >= n) {
			throw new Exception("Erro ao remover! Array Vazio ou Posicao Invalida");
		}

		Presidente resp = array[pos];
		n--;

		for(int i = pos; i < n; i++){
			array[i] = array[i+1];
		}

		return resp;
	}
	/*
	 * @author Gabriel Lopes
	 * Imprime na tela os objetos contidos na lista
	 */
	public void mostrar (){
		Presidente imprime = new Presidente();
		for(int i = 0; i < n; i++){
			//MyIO.print("["+i+"] ");
			imprime.printPresidente(array[i]);
		}
	}
	public void mostrarRec (){
		mostrarRec(0);
	}

	public void mostrarRec(int i){
		Presidente imprime = new Presidente();
		if(i < n){
			MyIO.print("["+i+"] ");
			imprime.printPresidente(array[i]);
			mostrarRec(i + 1);
		}
	}
	/**
	 *@author Gabriel Lopes
	 *@param nome Um nome para ser pesquisado no array
	 *@return resp Um booleano indicando se o nome esta ou n no array
	 */
	public boolean pesquisaSequencial(String nome){
		boolean resp=false;
		for(int i=0;i<n;i++){
			comparacao++;
			if(array[i].getNome().equals(nome)){
				resp=true;
				i=n;
			}
		}
		return resp;
	}

	/**
	 * Troca o conteudo de duas posicoes do array
	 * @param i int primeira posicao
	 * @param j int segunda posicao
	 */
	public void swap(int i, int j) {
		Presidente temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		movimentacoes+=2;
	}
	/**
	 * Verifica se o array esta ordenado 
	 * @return resp boolean indicando se o array esta ordenado
	 */
	public boolean isOrdenado(){
		boolean resp=true;
		for(int i=0;i<n;i++){
			if(array[i].getId()<array[i-1].getId()){
				i=n;
				resp=false;
			}
		}
		return resp;
	}
	/**
	 * Ordena o array com o algoritmo de selecao
	 */
	public void ordenacaoSelecao(){
		int menor;
		for(int i=0;i<(n-1);i++){
			menor=i;
			for(int j=(i+1);j<n;j++){
				comparacao++;
				if(array[menor].getId()>array[j].getId()){
					menor=j;
				}
			}
			swap(menor,i);
		}
	}
	/**
	 * Ordena o array com o algoritmo de selecao de forma recursiva
	 */
	public void ordenacaoSelecaoRec(){
		ordenacaoSelecaoRec(0);
	}
	public void ordenacaoSelecaoRec(int i){
		int menor=i;
		if(i<(n-1)){
			menor=loopJ(i);
			swap(menor,i);
			i++;
			ordenacaoSelecaoRec(i);
		}
	}
	/**
	 * O metodo realiza o loop interno do algoritmo
	 */
	public int loopJ(int i){
		return	loopJ(i,i+1);
	}
	public int loopJ(int menor,int j){
		comparacao++;
		if(j<n){
			if(array[menor].getId()>array[j].getId()){
				menor=j;
			}
			j++;
			menor=loopJ(menor,j);
		}
		return menor;

	}
}//Fim Classe Lista

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
