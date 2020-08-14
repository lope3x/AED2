class getaltura_ehcompleta{
	public int getAltura(No raiz){
		return getAltura(raiz);
	}
	private int getAltura(No i){
		int resp = 0;
		if(i!=null){
			int a = getAltura(i.esq);
			int b = getAltura(i.dir);
			resp = (a>b) ? a+1 : b+1;
		}
		return resp;
	}
	public boolean ehCompleta(No raiz){
		return ehCompleta(raiz);
	}
	private boolean ehCompleta(No i){
		boolean resp =true;
		if(i!=null){
			if(getAltura(i.esq)!=getAltura(i.dir)){
				resp =false;
				// n eh completa
			}
			else{
				resp = ehCompleta(i.esq);
				if(resp){
					resp = ehCompleta(i.dir);
				}
			}
		}
	}
}
