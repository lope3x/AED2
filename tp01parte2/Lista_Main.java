
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
import java.nio.charset.*;
/**
 * Classe principal da Lista de presidentes
 * @author Iago Augusto Coelho Morgado
 * @version 1 02/2019
 */
class Lista_Main{
	public static void main(String[]args){
		Lista lista=new Lista();
		Presidente taokei=new Presidente();
		String pagina,casos;
		int procedimentos,pos;
		try{
			//leitura das paginas html até que a flag (FIM) seja encontrada
			pagina=MyIO.readLine();
			while(!isEqualFlag(pagina,"FIM")){
				pagina=parseCharset(pagina);
				pagina=converteString(pagina);
				taokei.ler(pagina);
				lista.inserirFim(taokei);
				pagina=MyIO.readLine();
			}
			//realiza as demais operações indicadas pelo arquivo pub.in
			procedimentos=MyIO.readInt();
			for(int i=0;i<procedimentos;i++){
				casos=MyIO.readString();
				switch(casos){
					case"IF":
						pagina=MyIO.readString();
						pagina=parseCharset(pagina);
						pagina=converteString(pagina);
						taokei.ler(pagina);
						lista.inserirFim(taokei);
						break;
					case"II":
						pagina=MyIO.readString();
						pagina=parseCharset(pagina);
						pagina=converteString(pagina);
						taokei.ler(pagina);
                                                lista.inserirInicio(taokei);
						break;
					case"I*":
						pos=MyIO.readInt();
						pagina=MyIO.readString();
						pagina=parseCharset(pagina);
						pagina=converteString(pagina);
						taokei.ler(pagina);
						lista.inserir(taokei,pos);
						break;
					case"RF":
						taokei=lista.removerFim();
						MyIO.println("(R) "+taokei.getNome());
						break;
					case"RI":
						taokei=lista.removerInicio();
                                                MyIO.println("(R) "+taokei.getNome());
                                                break;
					case"R*":
						pos=MyIO.readInt();
						taokei=lista.remover(pos);
						MyIO.println("(R) "+taokei.getNome());
						break;
				}
			}
			lista.mostrar();
		}catch(Exception x){
			x.printStackTrace();
		}
	}
	public static String converteString(String in){
		in=in.replaceAll("\u00E3","a");
		in=in.replaceAll("\u00E1","a");
		in=in.replaceAll("\u00E3","a");
		in=in.replaceAll("\u00E2","a");
		in=in.replaceAll("\u00E9","e");
		in=in.replaceAll("\u00ED","i");
		in=in.replaceAll("\u00FA","u");
		in=in.replaceAll("\u00E7","c");
		return in;
	}
	/**
	 * Faz a conversão de uma linha escrita com o charset UTF-8 para o charset ISO-8859-1
	 * @param str String linha a ser convertida
	 */
	public static String parseCharset(String str)throws Exception{
                byte[] isoBytes=str.getBytes("ISO-8859-1");
		return new String(isoBytes,"UTF-8");
   	}
	/**
	 * Metodo semelhante a função eqquals que compara se duas Strings são iguais
	 * @param str String de comparação
	 * @param flag String de comparação
	 */
	public static boolean isEqualFlag(String str,String flag){/*verifica se uma determida string e igual a uma flag desejada*/
		boolean isequal=false;
		int count=0;
		try{
			for(int j=0;j<flag.length();j++){
				if(str.charAt(j)==flag.charAt(j))count++;
			}
			if(count==flag.length())isequal=true;
		}
		catch(StringIndexOutOfBoundsException x){
			isequal=false;
		}
		return isequal;
	}
}
/**
 * Classe Presidente que descreve dados básicos dos presidentes da república brasileira
 * @author Iago Augusto Coelho Morgado
 * @version 1 02/2019
 */
class Presidente{
	private int id;
	private String nome;
	private int idade;
	private LocalDate dataNascimento;
	private String localNascimento;
	private LocalDate inicioMandato;
	private LocalDate fimMandato;
	private LocalDate dataMorte;
	private String localMorte;
	private String antecessor;
	private String sucessor;
	private String vice;
	private String pagina;
	private long paginaTam;


	public void setId(int n){
		this.id=n;
	}
	public void setNome(String str){
		this.nome=str;
	}
	public void setIdade(int n){
		this.idade=n;
	}
	public void setDataNascimento(LocalDate data){
		this.dataNascimento=data;
	}
	public void setLocalNascimento(String str){
		this.localNascimento=str;
	}
	public void setInicioMandato(LocalDate data){
		this.inicioMandato=data;
	}
	public void setFimMandato(LocalDate data){
		this.fimMandato=data;
	}
	public void setDataMorte(LocalDate data){
		this.dataMorte=data;
	}
	public void setLocalMorte(String str){
		this.localMorte=str;
	}
	public void setAntecessor(String str){
		this.antecessor=str;
	}
	public void setSucessor(String str){
		this.sucessor=str;
	}
	public void setVice(String str){
		this.vice=str;
	}
	public void setPagina(String str){
		this.pagina=str;
	}
	public void setPaginaTam(long n){
		this.paginaTam=n;
	}


	public long getPaginaTam(){
		return this.paginaTam;
	}
	public String getPagina(){
		return this.pagina;
	}
	public String getVice(){
		return this.vice;
	}
	public String getSucessor(){
		return this.sucessor;
	}
	public String getAntecessor(){
		return this.antecessor;
	}
	public String getLocalMorte(){
		return this.localMorte;
	}
	public LocalDate getDataMorte(){
		return this.dataMorte;
	}
	public LocalDate getFimMandato(){
		return this.fimMandato;
	}
	public LocalDate getInicioMandato(){
		return this.inicioMandato;
	}
	public String getLocalNascimento(){
		return this.localNascimento;
	}
	public LocalDate getDataNascimento(){
		return this.dataNascimento;
	}
	public int getIdade(){
		return this.idade;
	}
	public String getNome(){
		return this.nome;
	}
	public int getId(){
		return this.id;
	}

	/**
	 * Construtor da classe
	 */
	public Presidente(){
		LocalDate now=LocalDate.now();
		setId(0);
		setNome("");
		setIdade(0);
		setDataNascimento(now);
		setLocalNascimento("");
		setInicioMandato(now);
		setFimMandato(now);
		setDataMorte(now);
		setLocalMorte("");
		setAntecessor("");
		setSucessor("");
		setVice("");
		setPagina("");
		setPaginaTam(0);
	}
	/**
	 * Construtor da classe
	 * @param ID id atributo id da classe
	 * @param NOME String atributo nome da classe
	 * @param IDADE int atributo idade da classe
	 * @param DATANASCIMENTO LocalDate atributo dataNascimento da classe
	 * @param LOCALNASCIMENTO String atributo localNascimento da classe
	 * @param INICIOMANDATO LocalDate atributo inicioMandato da classe
	 * @param FIMMANDATO LocalDate atributo fimMandato da classe
	 * @param DATAMORTE LocalDate atributo dataMorte da classe
	 * @param LOCALMORTE String atributo localMorte da classe
	 * @param ANTECESSOR String atributo antecessor da classe
	 * @param SUCESSOR String atributo sucessor da classe
	 * @param VICE String atributo vice da classe
	 * @param PAGINA String atributo pagina da classe
	 * @param PAGINATAM long atributo paginaTam da classe
	 */
	public Presidente(int ID,String NOME,int IDADE,LocalDate DATANASCIMENTO,String LOCALNASCIMENTO,LocalDate INICIOMANDATO,
			  LocalDate FIMMANDATO,LocalDate DATAMORTE,String LOCALMORTE,String ANTECESSOR,String SUCESSOR,String VICE,
			  String PAGINA,long PAGINATAM){
		setId(ID);
                setNome(NOME);
                setIdade(IDADE);
                setDataNascimento(DATANASCIMENTO);
                setLocalNascimento(LOCALNASCIMENTO);
                setInicioMandato(INICIOMANDATO);
                setFimMandato(FIMMANDATO);
                setDataMorte(DATAMORTE);
                setLocalMorte(LOCALMORTE);
                setAntecessor(ANTECESSOR);
                setSucessor(SUCESSOR);
                setVice(VICE);
                setPagina(PAGINA);
                setPaginaTam(PAGINATAM);
	}
	/**
	 * Cria e retorna um clone do objeto corrente da classe
	 * @return clone Presidente clone do objeto corrente
	 */
	public Presidente clone(){
		Presidente clone=new Presidente(this.getId(),this.getNome(),this.getIdade(),this.getDataNascimento(),
				                this.getLocalNascimento(),this.getInicioMandato(),this.getFimMandato(),
						this.getDataMorte(),this.getLocalMorte(),this.getAntecessor(),this.getSucessor(),
						this.getVice(),this.getPagina(),this.getPaginaTam());
		return clone;
	}
	/**
	 * Faz a leitura dos atributos da classe
	 * @param pagina String endereço da pagina html a ser lida
	 */
	public void ler(String pagina){
		setId(lerId(pagina));
		setNome(lerNomeCompleto(pagina));
		setDataNascimento(lerDataNascimento(pagina));
		setLocalNascimento(lerLocalNascimento(pagina));
		setInicioMandato(lerInicioMandato(pagina));
		setFimMandato(lerFimMandato(pagina));
		if(isDead(pagina)){
			setDataMorte(lerDataMorte(pagina));
			setLocalMorte(lerLocalMorte(pagina));
		}
		setAntecessor(lerAntecessor(pagina));
		if(haveSucessor(pagina)){
			setSucessor(lerSucessor(pagina));
		}
		if(haveVice(pagina)){
			setVice(lerVice(pagina));
		}
		setPagina(pagina);
		setPaginaTam(lerPaginaTam(pagina));
		setIdade(lerIdade(pagina));
	}
	/**
	 * Faz a leitura do atributo paginaTam
	 * @param pagina String endereço da pagina html a ser lida
	 */
	public long lerPaginaTam(String pagina){
		Arq.openRead(pagina);
		long i=Arq.length();
		Arq.close();
		return i;
	}
	 /**
         * Faz a leitura do atributo nome
         * @param pagina String endereço da pagina html a ser lida
         */
	public String lerNomeCompleto(String pagina){
		String key="";
		String resp="";
		Arq.openRead(pagina,"UTF-8");//inicializa a leitura do arquivo html desejado
		while(!key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Nome completo")){
			key=Arq.readLine();
		}
		resp+=Arq.readLine();
		resp+=Arq.readLine();
		resp=resp.replaceAll("</td><td style=\"vertical-align: top; text-align: left;\">","");
		Arq.close();
		return resp;
	}
	 /**
         * Faz a leitura do atributo id
         * @param pagina String endereço da pagina html a ser lida
         */
	public int lerId(String pagina){
		String key="";
		String resp="";
		int respp;
		Arq.openRead(pagina,"UTF-8");//inicializa a leitura do arquivo html desejado
		while(!key.equals("</td></tr>")){
			key=Arq.readLine();
		}
		while(!key.equals("</th></tr>")){
			key=Arq.readLine();
			resp+=key;
		}
		resp=apagaTag(resp);
		resp=resp.replace("\u00aa","");
		resp=resp.replace("\u00ba","");
		resp=resp.replace(".&#32;","");
		resp=resp.replace("Presidente do Brasil","");
		resp=resp.replaceAll(" ","");
		respp=Integer.parseInt(resp);
		Arq.close();
		return respp;
	}
	 /**
         * Faz a leitura do atributo dataNascimento
         * @param pagina String endereço da pagina html a ser lida
         */
	public LocalDate lerDataNascimento(String pagina){
		String key="";
		String resp="";
		String aux[];
		LocalDate respp=LocalDate.now();
		Arq.openRead(pagina,"UTF-8");//inicializa a leitura do arquivo html desejado
		while(!key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Nascimento")){
			key=Arq.readLine();
		}
		while(!key.equals("</td></tr>")){
			key=Arq.readLine();
			resp+=key;
		}
		resp=apagaTag(resp);
		resp=resp.replaceAll("&#160;","");
		resp=resp.replace("anos","");
		aux=resp.split(" ");
		aux[4]=removeParenteses(aux[4]);
		if(aux[2].equals("janeiro")){
			respp=LocalDate.of(Integer.parseInt(aux[4]),1,Integer.parseInt(aux[0]));
		}else{
			if(aux[2].equals("fevereiro")){
				respp=LocalDate.of(Integer.parseInt(aux[4]),2,Integer.parseInt(aux[0]));
			}else{
				if(aux[2].equals("março")){
					respp=LocalDate.of(Integer.parseInt(aux[4]),3,Integer.parseInt(aux[0]));
				}else{
					if(aux[2].equals("abril")){
						respp=LocalDate.of(Integer.parseInt(aux[4]),4,Integer.parseInt(aux[0]));
					}else{
						if(aux[2].equals("maio")){
							respp=LocalDate.of(Integer.parseInt(aux[4]),5,Integer.parseInt(aux[0]));
						}else{
							if(aux[2].equals("junho")){
								respp=LocalDate.of(Integer.parseInt(aux[4]),6,Integer.parseInt(aux[0]));
							}else{
								if(aux[2].equals("julho")){
									respp=LocalDate.of(Integer.parseInt(aux[4]),7,Integer.parseInt(aux[0]));
								}else{
									if(aux[2].equals("agosto")){
										respp=LocalDate.of(Integer.parseInt(aux[4]),8,Integer.parseInt(aux[0]));
									}else{
										if(aux[2].equals("setembro")){
											respp=LocalDate.of(Integer.parseInt(aux[4]),9,Integer.parseInt(aux[0]));
										}else{
											if(aux[2].equals("outubro")){
												respp=LocalDate.of(Integer.parseInt(aux[4]),10,Integer.parseInt(aux[0]));
											}else{
												if(aux[2].equals("novembro")){
													respp=LocalDate.of(Integer.parseInt(aux[4]),11,Integer.parseInt(aux[0]));
												}else{
													if(aux[2].equals("dezembro")){
														respp=LocalDate.of(Integer.parseInt(aux[4]),12,Integer.parseInt(aux[0]));
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Arq.close();
		return respp;
	}
	 /**
         * Faz a leitura do atributo localNascimento
         * @param pagina String endereço da pagina html a ser lida
         */
	public String lerLocalNascimento(String pagina){
		String key="";
                String resp="";
                String aux[];
		int i;
		Arq.openRead(pagina,"UTF-8");//inicializa a leitura do arquivo html desejado
                while(!key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Nascimento")){
                        key=Arq.readLine();
                }
                while(!key.equals("</td></tr>")){
                        key=Arq.readLine();
                        resp+=key;
                }
                resp=apagaTag(resp);
                resp=resp.replaceAll("&#160;","");
                resp=resp.replace("anos","");
                aux=resp.split(" ");
		resp="";
		i=aux.length-1;
		for(int j=5;j<=i;j++){
			resp+=aux[j];
			resp+=" ";
		}
		Arq.close();
		return resp;
	}
	 /**
         * Faz a leitura do atributo inicioMandato
         * @param pagina String endereço da pagina html a ser lida
         */
	public LocalDate lerInicioMandato(String pagina){
		String key="";
		String resp="";
		String aux[];
		LocalDate respp=LocalDate.now();
		Arq.openRead(pagina,"UTF-8");//inicializa a leitura do arquivo html desejado
		while(!key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Período")){
			key=Arq.readLine();
		}
		while(!key.equals("</td></tr>")){
			key=Arq.readLine();
			resp+=key;
		}
		resp=apagaTag(resp);
		resp=resp.replaceAll("&#32;"," ");
		resp=resp.replaceAll("\u00ba","");
		aux=resp.split(" ");
		aux[4]=aux[4].replace("até","");
		aux[4]=aux[4].replace("a","");
		if(aux[2].equals("janeiro")){
			respp=LocalDate.of(Integer.parseInt(aux[4]),1,Integer.parseInt(aux[0]));
		}else{
			if(aux[2].equals("fevereiro")){
				respp=LocalDate.of(Integer.parseInt(aux[4]),2,Integer.parseInt(aux[0]));
			}else{
				if(aux[2].equals("março")){
					respp=LocalDate.of(Integer.parseInt(aux[4]),3,Integer.parseInt(aux[0]));
				}else{
					if(aux[2].equals("abril")){
						respp=LocalDate.of(Integer.parseInt(aux[4]),4,Integer.parseInt(aux[0]));
					}else{
						if(aux[2].equals("maio")){
							respp=LocalDate.of(Integer.parseInt(aux[4]),5,Integer.parseInt(aux[0]));
						}else{
							if(aux[2].equals("junho")){
								respp=LocalDate.of(Integer.parseInt(aux[4]),6,Integer.parseInt(aux[0]));
							}else{
								if(aux[2].equals("julho")){
									respp=LocalDate.of(Integer.parseInt(aux[4]),7,Integer.parseInt(aux[0]));
								}else{
									if(aux[2].equals("agosto")){
										respp=LocalDate.of(Integer.parseInt(aux[4]),8,Integer.parseInt(aux[0]));
									}else{
										if(aux[2].equals("setembro")){
											respp=LocalDate.of(Integer.parseInt(aux[4]),9,Integer.parseInt(aux[0]));
										}else{
											if(aux[2].equals("outubro")){
												respp=LocalDate.of(Integer.parseInt(aux[4]),10,Integer.parseInt(aux[0]));
											}else{
												if(aux[2].equals("novembro")){
													respp=LocalDate.of(Integer.parseInt(aux[4]),11,Integer.parseInt(aux[0]));
												}else{
													if(aux[2].equals("dezembro")){
														respp=LocalDate.of(Integer.parseInt(aux[4]),12,Integer.parseInt(aux[0]));
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Arq.close();
		return respp;
	}
	 /**
         * Faz a leitura do atributo fimMandato
         * @param pagina String endereço da pagina html a ser lida
         */
	public LocalDate lerFimMandato(String pagina){
		String key="";
		String resp="";
		String aux[];
		LocalDate respp=LocalDate.now();
		Arq.openRead(pagina,"UTF-8");//inicializa a leitura do arquivo html desejado
		while(!key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Período")){
			key=Arq.readLine();
		}
		while(!key.equals("</td></tr>")){
			key=Arq.readLine();
			resp+=key;
		}
		resp=apagaTag(resp);
		resp=resp.replaceAll("&#32;"," ");
		resp=resp.replaceAll("\u00ba","");
		resp=resp.replace("[nota 1]","");
		aux=resp.split(" ");
		if(aux[aux.length-3].equals("janeiro")){
			respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),1,Integer.parseInt(aux[aux.length-5]));
		}else{
			if(aux[aux.length-3].equals("fevereiro")){
				respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),2,Integer.parseInt(aux[aux.length-5]));
			}else{
				if(aux[aux.length-3].equals("março")){
					respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),3,Integer.parseInt(aux[aux.length-5]));
				}else{
					if(aux[aux.length-3].equals("abril")){
						respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),4,Integer.parseInt(aux[aux.length-5]));
					}else{
						if(aux[aux.length-3].equals("maio")){
							respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),5,Integer.parseInt(aux[aux.length-5]));
						}else{
							if(aux[aux.length-3].equals("junho")){
								respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),6,Integer.parseInt(aux[aux.length-5]));
							}else{
								if(aux[aux.length-3].equals("julho")){
									respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),7,Integer.parseInt(aux[aux.length-5]));
								}else{
									if(aux[aux.length-3].equals("agosto")){
										respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),8,Integer.parseInt(aux[aux.length-5]));
									}else{
										if(aux[aux.length-3].equals("setembro")){
											respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),9,Integer.parseInt(aux[aux.length-5]));
										}else{
											if(aux[aux.length-3].equals("outubro")){
												respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),10,Integer.parseInt(aux[aux.length-5]));
											}else{
												if(aux[aux.length-3].equals("novembro")){
													respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),11,Integer.parseInt(aux[aux.length-5]));
												}else{
													if(aux[aux.length-3].equals("dezembro")){
														respp=LocalDate.of(Integer.parseInt(aux[aux.length-1]),12,Integer.parseInt(aux[aux.length-5]));
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Arq.close();
		return respp;
	}
	 /**
         * Faz a leitura do atributo dataMorte
         * @param pagina String endereço da pagina html a ser lida
         */
	public LocalDate lerDataMorte(String pagina){
		String key="";
		String resp="";
		String aux[];
		LocalDate respp=LocalDate.now();
		Arq.openRead(pagina,"UTF-8");//inicializa a leitura do arquivo html desejado
		while(!key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Morte")){
			key=Arq.readLine();
		}
		while(!key.equals("</td></tr>")){
			key=Arq.readLine();
			resp+=key;
		}
		resp=apagaTag(resp);
		resp=resp.replaceAll("&#160;","");
                resp=resp.replace("anos","");
		aux=resp.split(" ");
		aux[4]=removeParenteses(aux[4]);
		if(aux[2].equals("janeiro")){
                        respp=LocalDate.of(Integer.parseInt(aux[4]),1,Integer.parseInt(aux[0]));
                }else{
                        if(aux[2].equals("fevereiro")){
                                respp=LocalDate.of(Integer.parseInt(aux[4]),2,Integer.parseInt(aux[0]));
                        }else{
                                if(aux[2].equals("março")){
                                        respp=LocalDate.of(Integer.parseInt(aux[4]),3,Integer.parseInt(aux[0]));
                                }else{
                                        if(aux[2].equals("abril")){
                                                respp=LocalDate.of(Integer.parseInt(aux[4]),4,Integer.parseInt(aux[0]));
                                        }else{
                                                if(aux[2].equals("maio")){
                                                        respp=LocalDate.of(Integer.parseInt(aux[4]),5,Integer.parseInt(aux[0]));
                                                }else{
                                                        if(aux[2].equals("junho")){
                                                                respp=LocalDate.of(Integer.parseInt(aux[4]),6,Integer.parseInt(aux[0]));
                                                        }else{
                                                                if(aux[2].equals("julho")){
                                                                        respp=LocalDate.of(Integer.parseInt(aux[4]),7,Integer.parseInt(aux[0]));
                                                                }else{
                                                                        if(aux[2].equals("agosto")){
                                                                                respp=LocalDate.of(Integer.parseInt(aux[4]),8,Integer.parseInt(aux[0]));
                                                                        }else{
                                                                                if(aux[2].equals("setembro")){
                                                                                        respp=LocalDate.of(Integer.parseInt(aux[4]),9,Integer.parseInt(aux[0]));
                                                                                }else{
                                                                                        if(aux[2].equals("outubro")){
                                                                                                respp=LocalDate.of(Integer.parseInt(aux[4]),10,Integer.parseInt(aux[0]));
                                                                                        }else{
                                                                                                if(aux[2].equals("novembro")){
                                                                                                        respp=LocalDate.of(Integer.parseInt(aux[4]),11,Integer.parseInt(aux[0]));
                                                                                                }else{
                                                                                                        if(aux[2].equals("dezembro")){
                                                                                                                respp=LocalDate.of(Integer.parseInt(aux[4]),12,Integer.parseInt(aux[0]));
                                                                                                        }
                                                                                                }
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
		Arq.close();
		return respp;
	}
	 /**
         * Faz a leitura do atributo localMorte
         * @param pagina String endereço da pagina html a ser lida
         */
	public String lerLocalMorte(String pagina){
		String key="";
                String resp="";
                String aux[];
		int i;
                Arq.openRead(pagina,"UTF-8");//inicializa a leitura do arquivo html desejado
                while(!key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Morte")){
                        key=Arq.readLine();
                }
                while(!key.equals("</td></tr>")){
                        key=Arq.readLine();
                        resp+=key;
                }
                resp=apagaTag(resp);
                resp=resp.replaceAll("&#160;","");
                resp=resp.replace("anos","");
                aux=resp.split(" ");
		resp="";
                i=aux.length-1;
                for(int j=5;j<=i;j++){
                        resp+=aux[j];
                        resp+=" ";
                }
		Arq.close();
		return resp;
	}
	 /**
         * Faz a leitura do atributo antecessor
         * @param pagina String endereço da pagina html a ser lida
         */
	public String lerAntecessor(String pagina){
		String key="";
		String resp="";
		Arq.openRead(pagina,"UTF-8");
		while(!key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Antecessor")){
			key=Arq.readLine();
		}
		resp+=Arq.readLine();
		resp+=Arq.readLine();
		resp=apagaTag(resp);
		Arq.close();
		return resp;
	}
	 /**
         * Faz a leitura do atributo sucessor
         * @param pagina String endereço da pagina html a ser lida
         */
	public String lerSucessor(String pagina){
		String key="";
		String resp="";
		Arq.openRead(pagina,"UTF-8");
		while(!key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Sucessor")){
			key=Arq.readLine();
		}
		resp+=Arq.readLine();
		resp+=Arq.readLine();
		resp=apagaTag(resp);
		Arq.close();
		return resp;
	}
	 /**
         * Faz a leitura do atributo vice
         * @param pagina String endereço da pagina html a ser lida
         */
	public String lerVice(String pagina){
		String key="";
		String resp="";
		Arq.openRead(pagina,"UTF-8");
		while(!key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Vice-presidente")){
			key=Arq.readLine();
		}
		resp+=Arq.readLine();
		resp+=Arq.readLine();
		resp=apagaTag(resp);
		Arq.close();
		return resp;
	}
	 /**
         * Faz a leitura do atributo idade
         * @param pagina String endereço da pagina html a ser lida
         */
	public int lerIdade(String pagina){
		LocalDate aux=lerDataNascimento(pagina);
		int idade=2019-aux.getYear();
		return idade;
	}
	 /**
         * Verifica se o presidente tem sucessor
         * @param pagina String endereço da pagina html a ser lida
         */
	private boolean haveSucessor(String pagina){
		boolean resp=false;
                String key="";
                BufferedReader br;
                File f=new File(pagina);
                try{
                        br=new BufferedReader(new FileReader(pagina));//inicializa a leitura do arquivo html desejado;
                        for(int i=0;i<f.length();i++){
                                key=br.readLine();
                                if(key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Sucessor")){
                                        resp=true;
                                }
                        }
			br.close();
                }catch(Exception x){}
                return resp;
	}
	 /**
         * Verifica se o presidente tem vice
         * @param pagina String endereço da pagina html a ser lida
         */
	private boolean haveVice(String pagina){
		boolean resp=false;
		String key="";
		BufferedReader br;
		File f=new File(pagina);
		try{
			br=new BufferedReader(new FileReader(pagina));//inicializa a leitura do arquivo html desejado;
			for(int i=0;i<f.length();i++){
				key=br.readLine();
				if(key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Vice-presidente")){
					resp=true;
				}
			}
			br.close();
		}catch(Exception x){}
		return resp;
	}
	 /**
         * Verifica se o presidente esta morto
         * @param pagina String endereço da pagina html a ser lida
         */
	private boolean isDead(String pagina){
		boolean resp=false;
		String key="";
		BufferedReader br;
		File f=new File(pagina);
		try{
			br=new BufferedReader(new FileReader(pagina));//inicializa a leitura do arquivo html desejado;
			for(int i=0;i<f.length();i++){
				key=br.readLine();
				if(key.equals("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Morte")){
					resp=true;
				}
			}
			br.close();
		}catch(Exception x){}
		return resp;
	}
	 /**
         * Remove quaisquer caracteres entre parenteses da string enviada e seus parenteses
         * @param str String String contendo carecteres entre parenteses apos o quarto caractér
         */
	private String removeParenteses(String str){
		String aux="";
		try{
			if(str.charAt(4)=='('){
				int i=4;
				while(str.charAt(i)!=')'){
					aux+=str.charAt(i);
					i++;
				}
			}
			aux+=')';
			str=str.replace(aux,"");
		}catch(Exception x){};
		return str;
	}
	 /**
         * Remove as tags html de uma String
         * @param str String string contendo tags html a serem removidas
         */
	private String apagaTag(String str){
		String tag="";
		int j;
		char currentChar;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='<'){
				j=i;
				while(str.charAt(j)!='>'){
					currentChar=str.charAt(j);
					tag+=currentChar;
					j++;
				}
				str=str.replace(tag,"");
				tag="";
			}
		}
		str=str.replaceAll(">","");
		return str;
	}
	/**
	 * Imprime na saida padrão os atributos do objeto recorrente
	 * @param pagina String endereço da pagina html a ser lida
	 */
	public void imprimir(String pagina){
		MyIO.print(+this.id+" ## ");
                MyIO.print(this.nome+" ## ");
                MyIO.print(this.inicioMandato.getDayOfMonth()+"/"+this.inicioMandato.getMonthValue()+"/"+this.inicioMandato.getYear()+" (I) ## ");
                MyIO.print(this.fimMandato.getDayOfMonth()+"/"+this.fimMandato.getMonthValue()+"/"+this.fimMandato.getYear()+" (F) ## ");
                MyIO.print(this.dataNascimento.getDayOfMonth()+"/"+this.dataNascimento.getMonthValue()+"/"+this.dataNascimento.getYear()+" em ");
                MyIO.print(this.localNascimento+"(N) ## ");
                MyIO.print(this.idade+" ## ");
		if(isDead(pagina)){
                	MyIO.print(this.dataMorte.getDayOfMonth()+"/"+this.dataMorte.getMonthValue()+"/"+dataMorte.getYear()+" em ");
                	MyIO.print(this.localMorte+"(M) ## ");
		}
                MyIO.print(this.pagina+" ## ");
                MyIO.print(this.paginaTam+" ## ");
                MyIO.print(this.antecessor+" ## ");
		if(haveSucessor(pagina)){
                	MyIO.print(this.sucessor+" ## ");
		}else{
			MyIO.print(" ## ");
		}
		if(haveVice(pagina)){
                	MyIO.print(this.vice);
		}
		MyIO.print("\n");
	}
}
/**
 * Lista estatica de atributos da classe Presidente
 * @author Iago Augusto Coelho Morgado
 * @version 1 02/2019
 */
class Lista{
	private Presidente[] lista;
	private int n;
	/**
	 * Construtor da classe.
	 */
	public Lista(){
		this(100);
	}
	/**
	 * Construtor da classe.
	 * @param tam tamanho da Lista.
	 */
	public Lista(int tam){
		lista=new Presidente[tam];
		n=0;
	}
	/**
	 * Insere o elemento no inicio da lista e move os elementos já inseridos para o fim da lista.
	 * @param x Presidente elemento a ser inserido.
	 * @throws Exception se a lista ja estiver cheia.
	 */
	public void inserirInicio(Presidente x)throws Exception{
		//teste de conferencia se o atributo "lista" ainda contém espaço restante para a inserção
		if(n>=lista.length){
			throw new Exception("Erro de inserção");
		}
		//move os elementos para o fim da Lista
		for(int i=n;i>0;i--){
			lista[i]=lista[i-1];
		}
		//insere o elemento no inicio da lista
		lista[0]=x.clone();
		n++;
	}
	/**
	 * Insere o elemento no fim da lista.
	 * @param x Presidente elemento a ser inserido.
	 * @throws Exception se a lista estiver cheia.
	 */
	public void inserirFim(Presidente x)throws Exception{
		//teste de conferencia se o atributo "lista" ainda contém espaço restante para a inserção
                if(n>=lista.length){
                        throw new Exception("Erro de inserção");
                }
		//insere o elemento no fim da lista
		lista[n]=x.clone();
		n++;
	}
	/**
	 * Insere o elemento na posição desejada e move os elementos que necessitam para o fim da lista.
	 * @param x Presidente elemento a ser inserido
	 * @param pos int posição onde o elemento será inserido
	 * @throws Exception se a lista estiver cheia ou se a posição for inválida
	 */
	public void inserir(Presidente x,int pos)throws Exception{
		/*teste de conferencia se o atributo "lista" ainda contém espaço restante para a inserção
		 * e se a posição enviada é válida
		 */
                if(n>=lista.length||pos<0||pos>n){
                        throw new Exception("Erro de inserção");
                }
		//move os elementos das posições maiores ou iguais a "pos" para o fim da lista
		for(int i=n;i>pos;i--){
			lista[i]=lista[i-1];
		}
		//insere o elemento na posição desejada
		lista[pos]=x.clone();
		n++;
	}
	/**
	 * Remove o elemento no inicio da lista e reorganiza os demais elementos.
	 * @return resp Presidente elemento a ser removido.
	 * @throws Exception se a lista estiver vazia.
	 */
	public Presidente removerInicio()throws Exception{
		//verifica se a lista não está vazia
		if(n==0){
			throw new Exception("Erro de remoção");
		}
		//remove o primeiro elemento da lista
		Presidente resp=lista[0];
		n--;
		//desloca os elementos restantes para o inicio da lista
		for(int i=0;i<n;i++){
			lista[i]=lista[i+1];
		}
		return resp;
	}
	/**
	 * Remove o elemento no fim da lista
	 * @return elemento a ser removido
	 * @throws Exception se a listaestiver vazia
	 */
	public Presidente removerFim()throws Exception{
		//verifica se a lista não está vazia
                if(n==0){
                        throw new Exception("Erro de remoção");
                }
		return lista[--n];
	}
	/**
	 * Remove o elemento de uma posição desejada da lista e a reorganiza
	 * @param pos Posição de remoção
	 * @return resp Presidente elemento a ser removido
	 * @throws Exception se a lista estiver vazia ou se a posição for inválida
	 */
	public Presidente remover(int pos)throws Exception{
		//verifica se lista não está vazia e se a posição enviada é válida
		if(n==0||pos<0||pos>=n){
                        throw new Exception("Erro de remoção");
                }
		//remove o elemento na posiçao desejada
		Presidente resp=lista[pos];
		n--;
		//reorganiza a lista
		for(int i=pos;i<n;i++){
			lista[i]=lista[i+1];
		}
		return resp;
	}
	/**
	 * Mostra os elementos da lista
	 */
	public void mostrar(){
		for(int i=0;i<n;i++){
			MyIO.print("["+i+"] ");
			lista[i].imprimir(lista[i].getPagina());
		}
	}
	/**
	 * Procura um elemento e retorna se ele existe
	 * @param x Presidente elemento a ser pesquisado
	 * @return <code>true</code> se o elemento existir.
	 * <code>false</code> em caso contrário.
	 */
	public boolean pesquisar(Presidente x){
		boolean resp=false;
		for(int i=0;i<n&&resp==false;i++){
			resp=(lista[i]==x);
		}
		return resp;
	}
}
