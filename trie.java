class trie{
	public void inserir(String s){
		raiz.prox[hash(s.charAt(0))] = inserir(s,raiz.prox[hash(s.charAt(0))],0);
	}
	private No inserir(String s,No no,int i){
		if(no==null){
			no = new No(s.charAt(i),(i == s.length()-1 ? true:false);
		}
		if(!no.folha&&i!=s.length()-1){
			no.prox[hash(s.charAt(i+1))] = inserir(s,no.prox[hash(s.charAt(i+1))],i+1);
		}
		return no;
	}
	public boolean pesquisar(String s){
		return pesquisar(s,raiz.prox[hash(s.charAt(0))],0);
	}
	private boolean pesquisar(String s,No i,int x){
		boolean resp = false;
		if(i!=null){
			if(!i.folha&&x != s.length()-1){
				resp = pesquisar(s,i.prox[hash(s.charAt(i+1))],i+1);
			}
			else if(i.folha&& x==s.length()-1){
				resp = true;
			}
		}
		return resp;
	}
}