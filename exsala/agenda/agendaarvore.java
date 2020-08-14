public class agendaarvore{
    public static void main(String[] args) {
        Agenda a = new Agenda();
        
        a.inserir(new Contato(1000, "jose", 111111, "jose@gmail.com"));
        a.inserir(new Contato(1000, "pedro", 111111, "jose@gmail.com"));
        a.inserir(new Contato(1000, "antonio", 111111, "jose@gmail.com"));
        a.inserir(new Contato(1000, "marco", 111111, "jose@gmail.com"));
        a.inserir(new Contato(1000, "gabriel", 111111, "jose@gmail.com"));
        a.inserir(new Contato(1000, "nata", 111111, "jose@gmail.com"));
        a.inserir(new Contato(1000, "zeu", 111111, "jose@gmail.com"));
        a.inserir(new Contato(1000, "carol", 111111, "jose@gmail.com"));
        a.inserir(new Contato(1000, "julia", 111111, "jose@gmail.com"));
        System.out.print("raiz ");
        a.mostrarCentral(a.raiz);

    }
}
class Contato{
    int cpf;
    String nome;
    int telefone;
    String email;

    Contato(int cpf,String nome,int telefone,String email){
        this.cpf=cpf;
        this.nome=nome;
        this.telefone=telefone;
        this.email=email;
    }
    Contato(){
        this(0,"a",0,"a");
    }
}
class Agenda{
    No raiz;
    Agenda(){
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
    private void inicializa(char letra){
        raiz = inicializa(raiz,letra);
    }
    private No inicializa(No i,char letra){
        if(i==null){
            i = new No(letra);
            i.primeiro = new Celula();//inicializa no cabeca

        }
        else if(i.letra>letra){
            i.esq = inicializa(i.esq,letra);
        }
        else if(i.letra<letra){
            i.dir = inicializa(i.dir,letra);
        }
        return i;
    }
    public void inserir(Contato contato){
       inserir(raiz,contato);
    }
    private void inserir(No i,Contato contato){
        if(i!=null){
            if(i.letra==contato.nome.charAt(0)){
               inserirLista(i.primeiro,i.ultimo,contato);//chama insercao na lista enviando o no cabeca
	       
            }
            //vai pra esq
            else if(i.letra>contato.nome.charAt(0)){
                inserir(i.esq,contato);
            }
            //vai pra dir
            else if(i.letra<contato.nome.charAt(0)){
                inserir(i.dir,contato);
            }
        }
    }
    public Celula inserirLista(Celula primeiro,Celula ultimo,Contato contato){
       Celula tmp = primeiro.prox;
        primeiro.prox = new Celula(contato);
        primeiro.prox.prox = tmp;
        if(primeiro==ultimo){
            ultimo = tmp;
        }
	return primeiro;
        
    }
    public void mostrarCentral(No i){
        if(i!=null){
            System.out.print("esq ");
            mostrarCentral(i.esq);
            System.out.print("dir ");
            mostrarCentral(i.dir);
            mostrarLista(i.primeiro);
        }
    }
    private void mostrarLista(Celula x){
        for(Celula i =x.prox;i!=null;i=i.prox){
            System.out.print("prox ");
            System.out.println(i.contato.nome);
        }
    }
    public boolean pesquisarCPF(){
    	return pesquisarCPF(raiz);
    }
    public boolean pesquisarCPF(No i){
    	if(i!=null){
		System.out.print 
	}
    }
    
    /*
    public boolean pesquisar(String nome){
    	return pesquisar(raiz,nome);
    }/*
    private boolean pesquisar(No i,String nome){7
    	if(nome.charAt(0)==i.letra){
		//pesquisa lista	
	}
	else if(nome.charAt(0)<i.letra){
		//esq
	}
	else if(nome.charAt
    }*/
}
class No{
    No esq;
    No dir;
    Celula primeiro;
    Celula ultimo;
    char letra;
    No(char letra){
        this.letra=letra;
        primeiro=ultimo=new Celula();
        this.esq=null;
        this.dir=null;
    }
}
class Celula{
    Celula prox;
    Contato contato;
    Celula(){
        this(null,null);
    }
    Celula(Contato contato,Celula prox){
        this.contato = contato;
        this.prox = prox;

    }
    Celula(Contato contato){
        this.contato = contato;
	prox = null;
    }
}
