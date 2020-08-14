public class expag295{
	public static void main(String[]args){
		ArvoreArvore aa = new ArvoreArvore();
		aa.inserir("gabriel");//
		aa.inserir("artur");//
		aa.inserir("ab");//
		aa.inserir("az");
		aa.inserir("aaaaa");
		aa.inserir("jose");//
		aa.inserir("julia");//
		aa.inserir("alberto");//
		aa.inserir("antonio");//
		aa.inserir("pedro");//
		aa.inserir("jesus");//
		aa.inserir("joao");//
		aa.inserir("thanos");
		aa.inserir("roger");//
		aa.inserir("luiz");//
		aa.inserir("kleber");//
		aa.inserir("coutinho");//
		aa.inserir("rodrigo");//
		aa.inserir("otavio");//
		aa.inserir("mamut");//
		//aa.mostrar();
		aa.remover("artur");
		//aa.mostrar();
		System.out.println(aa.qtsTam7());
		System.out.println(aa.hasTam7());
		
	}
}
class No1{
	No1 esq;
	No1 dir;
	No2 raiz;
	char letra;
	public No1(char letra){
		this.letra=letra;
		this.dir=this.esq=null;
		this.raiz=null;
	}
	
}
class No2{
	No2 esq;
	No2 dir;
	String s;
	public No2(String s){
		this.s=s;
		this.dir=this.esq=null;
	}
}
class ArvoreArvore{
	No1 raiz;
	public ArvoreArvore(){
		inicializa('m');
        inicializa('n');
        inicializa('b');
        inicializa('v');
        inicializa('c');
        inicializa('x');
        inicializa('z');
        inicializa('l');
        inicializa('k');
        inicializa('j');
        inicializa('h');
        inicializa('g');
        inicializa('f');
        inicializa('d');
        inicializa('s');
        inicializa('a');
        inicializa('p');
        inicializa('o');
        inicializa('i');
        inicializa('u');
        inicializa('y');
        inicializa('t');
        inicializa('r');
        inicializa('e');
        inicializa('w');
        inicializa('q');
	}
	//lg n
	private void inicializa(char letra){
		raiz = inicializa(raiz,letra);
	}
	//lg(n)
	private No1 inicializa(No1 i,char letra){
		if(i==null){
			i=new No1(letra);
		}
		else if(letra<i.letra){
			i.esq=inicializa(i.esq,letra);
		}
		else if(letra>i.letra){
			i.dir=inicializa(i.dir,letra);
		}
		return i;
	}
	//lg(n)*lg(n)
	//(lg(n))^2
	public void inserir(String s){
		inserir(raiz,s);
	}
	//lg(n)
	private void inserir(No1 i,String s){
		if(i.letra==s.charAt(0)){
			i.raiz=inserir(i.raiz,s);
		}
		else if(s.charAt(0)<i.letra){
			inserir(i.esq,s);
		}
		else if(s.charAt(0)>i.letra){
			inserir(i.dir,s);
		}
	}
	//lg(n)
	private No2 inserir(No2 i,String s){
		if(i==null){
			i=new No2(s);
		}
		else if(s.compareTo(i.s)<0){
			i.esq=inserir(i.esq,s);
		}
		else if(s.compareTo(i.s)>0){
			i.dir=inserir(i.dir,s);
		}
		return i;
	}
	//n * n
	//n^2
	public void mostrar(){
		//System.out.print("raiz ");
		mostrar(raiz);
	}
	//n
	private void mostrar(No1 i){
		if(i!=null){
			//System.out.print("ESQ ");
			mostrar(i.esq);
			mostrar(i.raiz);
			//System.out.print("DIR ");
			mostrar(i.dir);
		}
	}
	//n
	private void mostrar(No2 i){
		if(i!=null){
			//System.out.print("esq ");
			mostrar(i.esq);
			System.out.println(i.s);
			//System.out.print("dir ");
			mostrar(i.dir);
		}
	}
	//lg(n)*lg(n)
	public boolean pesquisar(String s){
		return pesquisar(raiz,s);
	}
	private boolean pesquisar(No1 i ,String s){
		boolean resp=false;
		if(i!=null){
			if(i.letra==s.charAt(0)){
				resp = pesquisar(i.raiz,s);
			}
			else if(s.charAt(0)<i.letra){
				resp = pesquisar(i.esq,s);
			}
			else if(s.charAt(0)>i.letra){
				resp = pesquisar(i.dir,s);
			}
		}
		return resp;
	}
	private boolean pesquisar(No2 i,String s){
		boolean resp=false;
		if(i!=null){
			if(i.s.equals(s)){
				resp =true;
			}
			else if(s.compareTo(i.s)<0){
				resp = pesquisar(i.esq,s);
			}
			else if(s.compareTo(i.s)>0){
				resp = pesquisar(i.dir,s);
			}
		}
		return resp;
	}/*
	//RETORNA UMA STRING VAZIA CASO O ELEMENTO N ESTEJA NA ESTRUTURA 
	public String remover(String s){
		return remover(raiz,s);
	}
	private String remover(No1 i,String s){
		String resp="";
		if(i!=null){
			if(i.letra==s.charAt(0)){
				resp = remover(i.raiz,s);
			}
			else if(s.charAt(0)<i.letra){
				resp = remover(i.esq,s);
			}
			else if(s.charAt(0)>i.letra){
				resp = remover(i.dir,s);
			}
		}
		return resp;
	}
	private String remover(No2 i ,String s){
		String resp = "";
		if(i!=null){
			if(s.compareTo(i.s)<0){
				resp = remover(i.esq,s);
			}
			else if(s.compareTo(i.s)>0){
				resp = remover(i.dir,s); 
			}
			//NAO TEM filho a DIREITA e TALVEZ tenha filho a esquerda
			else if(i.dir==null){
				resp = i.s;
				
			}
			//TEM filho a DIREITA e NAO TEM filho a ESQUERDA
			else if(i.esq==null){
				resp = i.s;
			}
			else{
				resp = i.s;
			}
		}
		return resp;
	}*/
	public void remover(String s){
		remover(raiz,s);
	}
	private void remover(No1 i,String s){
		if(i!=null){
			if(s.charAt(0)==i.letra){
				i.raiz = remover(i.raiz,s);
			}
			else if(s.charAt(0)<i.letra){
				remover(i.esq,s);
			}
			else if(s.charAt(0)>i.letra){
				remover(i.dir,s);
			}
		}
	}
	private No2 remover(No2 i ,String s){
		if(i!=null){
			if(s.compareTo(i.s)<0){
				i.esq = remover(i.esq,s);
			}
			else if(s.compareTo(i.s)>0){
				i.dir = remover(i.dir,s);
			}
			//NAO TEM A DIR TALVEZ ESQ
			else if(i.dir==null){
				i = i.esq;
			}
			//NAO TEM ESQ E >TEM< A DIR
			else if(i.esq==null){
				i = i.dir;
			}
			//TEM FILHO DOS DOIS LADOS
			else{
				i.esq = anterior(i,i.esq);
			}
		}
		return i;
	}
	private No2 anterior(No2 i , No2 j){
		if(j.dir!=null){
			j.dir = anterior(i,j.dir);
		}
		else{
			i.s = j.s;
			j = j.esq;
		}
		return j;
	}
	public int qtsTam7(){
		return qtsTam7(raiz);
	}
	private int qtsTam7(No1 i){
		int resp=0;
		if(i!=null){
			resp+=qtsTam7(i.raiz);
			resp+=qtsTam7(i.esq);
			resp+=qtsTam7(i.dir);
		}
		return resp;
	}
	private int qtsTam7(No2 i){
		int resp=0;
		if(i!=null){
			if(i.s.length()==7)resp++;
			resp+=qtsTam7(i.esq);
			resp+=qtsTam7(i.dir);
		}
		return resp;
	}
	public boolean hasTam7(){
		return hasTam7(raiz);
	}
	private boolean hasTam7(No1 i){
		boolean resp=false;
		if(i!=null){
			resp=hasTam7(i.raiz);
			if(!resp){
				resp=hasTam7(i.esq);
				if(!resp){
					resp=hasTam7(i.dir);
				}	
			}
		}
		return resp;
	}
	private boolean hasTam7(No2 i){
		boolean resp =false;
		if(i!=null){
			resp = (i.s.length()==7) ? true : false;
			if(!resp){
				resp=hasTam7(i.esq);
				if(!resp){
					resp=hasTam7(i.dir);
				}	
			}
		}
		return resp;
	}
	public boolean pesquisarLetraTam(char letra,int tam){
		return pesquisarLetraTam(raiz,letra,tam);
	}
	private boolean pesquisarLetraTam(No1 i, char letra, int tam){
		boolean resp=false;
		if(i!=null){
			if(letra==i.letra){
				resp = pesquisarLetraTam(i.raiz,tam);
			}
			else if(letra<i.letra){
				resp = pesquisarLetraTam(i.esq,letra,tam);
			}
			else if(letra>i.letra){
				resp = pesquisarLetraTam(i.dir,letra,tam);
			}
		}
		return resp;
	}
	private boolean pesquisarLetraTam(No2 i,int tam){
		boolean resp=false;
		if(i!=null){
			resp = (i.s.length()==tam) ? true : false;
			if(!resp){
				resp=pesquisarLetraTam(i.esq,tam);
				if(!resp){
					resp=pesquisarLetraTam(i.dir,tam);
				}
			}
		}
		return resp;
	}
}