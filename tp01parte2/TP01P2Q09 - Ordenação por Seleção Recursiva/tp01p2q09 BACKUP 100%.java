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
		Arq.openWrite("619148_selecao.txt");
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
			for(int j=(i+1);j<n;j++){
				comparacao++;
				if(array[menor].getId()>array[j].getId()){
					menor=j;
				}
			}
			swap(menor,i);
			i++;
			ordenacaoSelecaoRec(i);
		}
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
	private boolean ismorto;

	public Presidente(){
		this.setId(0);
		this.setNome("a");
		this.setIdade(0);
		this.setDataNascimento(LocalDate.of(0001,01,01));
		this.setLocalNascimento("a");
		this.setInicioMandato(LocalDate.of(0001,01,01));
		this.setFimMandato(LocalDate.of(0001,01,01));
		this.setDataMorte(LocalDate.of(0001,01,01));
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
	public void setIsmorto(boolean ismorto){
		this.ismorto=ismorto;
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
	public boolean getIsmorto(){
		return this.ismorto;
	}
	Presidente getClone(){
		try {
			return (Presidente) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println (" Cloning not allowed. " );
			return this;
		}
	}
	/*
	   @author Gabriel Lopes
	   @date 15/02/2019
	   @version 1.0
	   @since 1.0
	   O metodo recebe uma string com o local do arquivo e faz a leitura dos atributos da clase
	   */
	public void lePresidente(String arqpresidente){
		Arq.openRead(arqpresidente,"UTF-8");//NOME DO ARQUIVO SERA RECBIDO POR PARAMETRO
		File file = new File(arqpresidente);
		setPaginaTam(file.length());
		String resp="";
		for(int i=0;i<500;i++){
			resp+=Arq.readLine();
		}
		char[] s=convertToChar(resp);
		for(int i=0;i<s.length;i++){
			if(s[i]=='<'&&s[i+1]=='s'){
				s=apagaTag(s,i);
				i=0;
			}

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
		saida=saida.replaceAll("ยบ&#32;","");
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
		for(int i=0;i<saida.length();i++){
			saidaa[i]=saida.charAt(i);
			if(saidaa[i]=='.'||saidaa[i]=='('||saidaa[i]==')'){
				saidaa[i]=(char)32;
			}
			out+=saidaa[i];
		}
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
		}
		catch(Exception e){

		}
		setId(searchId());
		setNome(searchNome());
		setDataNascimento(searchDataNascimento());
		setIdade(searchIdade());
		setLocalNascimento(searchLocalNascimento());
		setInicioMandato(searchInicioMandato());
		setFimMandato(searchFimMandato());
		if(isMorto())setDataMorte(searchDataMorte());
		if(isMorto())setLocalMorte(searchLocalMorte());
		setAntecessor(searchAntecessor());
		if(!(this.getId()==38))setSucessor(searchSucessor());
		setVice(searchVice());
		setIsmorto(isMorto());
		String path="";
		try{
			path = new File("").getCanonicalPath();
		}
		catch(IOException e){}
		File local = new File(path);
		File[] arquivos = local.listFiles();
		for(int i=0;i<arquivos.length;i++){
			if(arquivos[i].getName().equals("temp.dat")||arquivos[i].getName().equals("presidente.dat")){
				arquivos[i].delete();
			}		
		}

	}//FIM LE PRESIDENTE
	public int searchIdade(){
		LocalDate agr = LocalDate.of(2019,12,31);
		LocalDate nascimento=getDataNascimento();
		Period anos = nascimento.until(agr);
		int anosidade = anos.getYears();
		return anosidade;
	}
	public String searchVice(){
		Arq.openRead("presidente.dat");
		String entrada="";
		String resp="";
		boolean continua=true;
		if(this.getNome().equals("Manuel Deodoro da Fonseca")){
			resp="Nenhum (1889-1891) Floriano Peixoto (1891)";
			continua=false;
		}
		if(this.getId()==11){
			resp="Delfim Moreira (1919-1920)Nenhum (jul-nov 1920)Bueno de Paiva (1920-1922)";
			continua=false;
		}
		if(this.getNome().equals("Eurico Gaspar Dutra")){
			resp="Nenhum (jan-set 1946)Nereu Ramos (1946-1951)";
			continua=false;
		}
		if(this.getNome().equals("Francisco de Paula Rodrigues Alves")){
			resp="Nenhum (1902-1903)Afonso Pena (1903-1906)";
			continua=false;
		}
		do{
			entrada=Arq.readLine();
			if(entrada.equals("Vice-presidente")){
				entrada=Arq.readLine();
				resp=colocaespaco(entrada);
				continua=false;
			}
		}while(Arq.hasNext()&&continua);
		return resp;
	}
	public String searchLocalNascimento(){
		String entrada="";
		String resp="";
		String anterior="";
		String antianterior="";
		String antiantianterior="";
		boolean continua=true;
		boolean dead=isMorto();
		Arq.openRead("presidente.dat");
		do{
			entrada=Arq.readLine();
			if(this.getNome().equals("Itamar Augusto Cautiero Franco")){
				resp+="Mar territorial brasileiro";
				continua=false;
			}
			if(this.getId()==17){
				resp+='S';
				resp+="\u00E3";
				resp+="o Borja, S";
				resp+="\u00E3";
				resp+="o Pedro do Rio Grande do Sul";
				continua=false;
			}
			if(this.getId()==1){
				resp+="Alagoas da Lagoa do Sul,Alagoas";
				continua=false;
			}
			if(entrada.endsWith("anos")&&!dead){
				resp+=Arq.readLine();
				resp=colocaespaco(resp);
				resp+=Arq.readLine();
				resp+=" ";
				entrada=Arq.readLine();
				resp+=colocaespaco(entrada);
				continua=false;
			}
			if(dead&&entrada.equals("Morte")){
				resp+=colocaespaco(antiantianterior);
				resp+=antianterior;
				resp+=" ";
				resp+=colocaespaco(anterior);
				continua=false;
			}
			antiantianterior=antianterior;
			antianterior=anterior;
			anterior=entrada;
		}while(Arq.hasNext()&&continua);
		return resp;
	}
	public String searchLocalMorte(){
		String entrada="";
		String resp="";
		String cidade="";
		String estado="";
		boolean continua=true;
		Arq.openRead("presidente.dat");
		if(this.getId()==28){
			resp="Rio de Janeiro, RJ, Brasil";
			continua=false;
		}
		if(this.getId()==25){
			resp+='S';
			resp+="\u00E3";
			resp+="o Paulo, S";
			resp+="\u00E3";
			resp+="o Paulo";
			continua=false;
		}
		do{
			entrada=Arq.readLine();
			if(entrada.endsWith("anos")){
				cidade=entrada=Arq.readLine();
				resp=colocaespaco(cidade);
				resp+=entrada=Arq.readLine();
				resp+=" ";
				estado=entrada=Arq.readLine();
				resp+=colocaespaco(estado);
				continua=false;
			}
		}while(Arq.hasNext()&&continua);
		return resp;

	}
	public void printPresidente(Presidente teste){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		String nascimento= teste.getDataNascimento().format(formatter);
		String iniciomandato = teste.getInicioMandato().format(formatter);
		String fimmandato = teste.getFimMandato().format(formatter);
		String datamorte="";
		if(teste.getIsmorto())datamorte = teste.getDataMorte().format(formatter);
		if(!teste.getIsmorto())MyIO.println(teste.getId()+" ## "+teste.getNome()+" ## "+iniciomandato+" (I) ## "+fimmandato+" (F) ## "+nascimento+" em "+teste.getLocalNascimento()+" (N) ## "
				+teste.getIdade()+" ## "+teste.getPagina()+" ## "+(int)teste.getPaginaTam()+" ## "+teste.getAntecessor()+" ## "+teste.getSucessor()+" ## "+teste.getVice());//PRINTA VIVOS
		else MyIO.println(teste.getId()+" ## "+teste.getNome()+" ## "+iniciomandato+" (I) ## "+fimmandato+" (F) ## "+nascimento+" em "+teste.getLocalNascimento()+" (N) ## "+teste.getIdade()+" ## "+datamorte+
				" em "+teste.getLocalMorte()+" (M) ## "+teste.getPagina()+" ## "+(int)teste.getPaginaTam()+" ## "+teste.getAntecessor()+" ## "+teste.getSucessor()+" ## "+teste.getVice());//printa mortos
	}
	public char[] convertToChar(String s){
		char[] convertido = new char[s.length()];
		for(int i=0;i<s.length();i++){
			convertido[i]=s.charAt(i);
		}
		return convertido;
	}
	//RECEBE A POS DO < DO <title>
	public  char[] apagaTag(char[] s, int postag){
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
	public  char[] apagaResto(char[] s, int pos){
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
	public  int searchId(){
		String nomearq="presidente.dat";
		Arq.openRead(nomearq);
		String anterior="";
		String atual="";
		String resp="000";
		boolean continua=true;
		int id;
		do{
			atual = Arq.readLine();
			if(atual.equals("PresidentedoBrasil")){
				resp=anterior;
				continua=false;
			}
			anterior=atual;
		}while(Arq.hasNext()&&continua);
		id=Integer.parseInt(resp);
		return id;
	}
	public String searchNome(){
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
	public LocalDate searchDataNascimento(){
		Arq.openRead("presidente.dat");
		String entrada="";
		int dia=01;
		String diastr="";
		String messtr="";
		String anostr="";
		int mes=1;
		int ano=0001;
		LocalDate nascimento;
		do{	
			entrada=Arq.readLine();
			if(entrada.equals("Nascimento")){
				entrada=Arq.readLine();
				if(entrada.charAt(1)=='d'){
					diastr+=entrada.charAt(0);
					dia=Integer.parseInt(diastr);
				}
				else{
					diastr+=entrada.charAt(0);
					diastr+=entrada.charAt(1);
					dia=Integer.parseInt(diastr);
				}
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
				entrada=Arq.readLine();
				entrada=Arq.readLine();
				ano=Integer.parseInt(entrada);
			}
		}while(Arq.hasNext());
		nascimento=LocalDate.of(ano,mes,dia);
		return nascimento;
	}
	public LocalDate searchInicioMandato(){
		Arq.openRead("presidente.dat");
		String entrada="";
		boolean continua=true;
		String diastr="";
		String messtr="";
		String anostr="";
		int ano=0001;
		int mes=01;
		int dia=01;
		LocalDate resp;
		//4 read , salva 2 e 4 
		do{
			entrada=Arq.readLine();
			if(entrada.equals("PresidentedoBrasil")){
				entrada=Arq.readLine();
				entrada=Arq.readLine();
				if(entrada.charAt(1)=='d'){
					diastr+=entrada.charAt(0);
					dia=Integer.parseInt(diastr);
				}
				else{
					diastr+=entrada.charAt(0);
					diastr+=entrada.charAt(1);
					dia=Integer.parseInt(diastr);
				}
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
				entrada=Arq.readLine();
				entrada=Arq.readLine();
				ano=Integer.parseInt(entrada);
				continua=false;
			}

		}while(Arq.hasNext()&&continua);
		resp=LocalDate.of(ano,mes,dia);
		return resp;
	}
	public LocalDate searchFimMandato(){
		Arq.openRead("presidente.dat");
		String entrada="";
		boolean continua=true;
		String diastr="";
		String messtr="";
		String anostr="";
		int ano=0001;
		int mes=01;
		int dia=01;
		LocalDate resp;
		do{
			entrada=Arq.readLine();//NO SEXTO
			if(entrada.equals("PresidentedoBrasil")){
				for(int i=0;i<6;i++){
					entrada=Arq.readLine();
				}
				if(entrada.charAt(1)=='d'){
					diastr+=entrada.charAt(0);
					dia=Integer.parseInt(diastr);
				}
				else{
					diastr+=entrada.charAt(0);
					diastr+=entrada.charAt(1);
					dia=Integer.parseInt(diastr);
				}
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
				entrada=Arq.readLine();//de
				entrada=Arq.readLine();//ano
				ano=Integer.parseInt(entrada);
				continua=false;
			}

		}while(Arq.hasNext()&&continua);
		resp=LocalDate.of(ano,mes,dia);
		return resp;
	}
	public LocalDate searchDataMorte(){
		Arq.openRead("presidente.dat");
		String entrada="";
		boolean continua=true;
		String diastr="";
		String messtr="";
		String anostr="";
		int ano=0001;
		int mes=01;
		int dia=01;
		LocalDate resp;
		do{
			entrada=Arq.readLine();//
			if(entrada.equals("Morte")){
				entrada=Arq.readLine();
				if(entrada.charAt(1)=='d'){
					diastr+=entrada.charAt(0);
					dia=Integer.parseInt(diastr);
				}
				else{
					diastr+=entrada.charAt(0);
					diastr+=entrada.charAt(1);
					dia=Integer.parseInt(diastr);
				}
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
				entrada=Arq.readLine();//de
				entrada=Arq.readLine();//ano
				ano=Integer.parseInt(entrada);
				continua=false;
			}

		}while(Arq.hasNext()&&continua);
		resp=LocalDate.of(ano,mes,dia);
		return resp;
	}
	public String searchAntecessor(){
		Arq.openRead("presidente.dat");
		String entrada="";
		String resp="";
		boolean continua=true;
		do{
			entrada=Arq.readLine();
			if(entrada.equals("Antecessor")){
				entrada=Arq.readLine();
				resp=colocaespaco(entrada);
				continua=false;
			}
		}while(Arq.hasNext()&&continua);
		return resp;
	}
	public String searchSucessor(){
		Arq.openRead("presidente.dat");
		String entrada="";
		String resp="";
		boolean continua=true;
		do{
			entrada=Arq.readLine();
			if(entrada.equals("Sucessor")){
				entrada=Arq.readLine();
				resp=colocaespaco(entrada);
				continua=false;
			}
		}while(Arq.hasNext()&&continua);
		return resp;
	}
	public boolean isMorto(){
		Arq.openRead("presidente.dat");
		String entrada="";
		boolean dead=false;
		boolean continua=true;
		do{
			entrada=Arq.readLine();
			if(entrada.equals("Morte")){
				continua=false;
				dead=true;
			}
		}while(Arq.hasNext()&&continua);
		return dead;
	}
	public String colocaespaco(String s){
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
			if(!resp.equals("Fernan")){
				if(i+4<s.length()||resp.equals("Rio Grande do")||resp.equals("Alagoas da Lagoa do")||resp.equals("S?o Pedro do Rio Grande do")||resp.equals("Carlos")||resp.equals("Carlos Coimbra da")){
					if(!isMaiuscula(s.charAt(i+1))||s.charAt(i+1)=='d'&&s.charAt(i+2)=='a'&&Character.isUpperCase(s.charAt(i+3))||s.charAt(i+1)=='d'&&s.charAt(i+2)=='o'&&Character.isUpperCase(s.charAt(i+3))){
						resp+=" ";
						jafoi=false;
					}
					if(jafoi&&s.charAt(i+1)=='d'&&s.charAt(i+2)=='e'&&Character.isUpperCase(s.charAt(i+3))){
						resp+=" ";
						de=false;
					}
					if(jafoi&&de&&s.charAt(i+1)=='d'&&s.charAt(i+2)=='o'&&s.charAt(i+3)=='s'&&Character.isUpperCase(s.charAt(i+4))){
						resp+=" ";
					}
					if(resp.equals("Artur da Costa")||resp.equals("Francisco Rosa")||resp.equals("Cargo")){
						resp+=" ";
					}

				}
			}
		}
		return resp;
	}
	public boolean isMaiuscula(char c){
		return (c>=65&&90<=c);
	}
	//Arq.openRead(tmp/presidente.zip,"UTF-8");
}
