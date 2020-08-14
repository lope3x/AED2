class Patricia{
	int n=0;
	inserir(String s){
		S[n]=s;
		int i = n;
		int j = 0;
		int k = s.length()-1;
		n++;
		raiz.hash[s.charAt(0)]=inserir(raiz.hash[s.charAt(0)],raiz,i,j,k);
	}
	No inserir(No no,No pai,int i,int j,int k){
		if(no==null){
			no = new No(i,j,k);
		}
		else if(!no.folha){
			if(no.j==0&&no.k==0){
				// no com somente uma letra
				char letra = s[i].charAt(j+1);
				no.hash[letra] = inserir(no.hash[letra],
			}
			else{
				//aux aqui
			}
		}	
	}
}
