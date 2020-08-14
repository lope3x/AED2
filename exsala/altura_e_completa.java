public class altura_e_completa{
	public int getAltura(){
		return getAltura(raiz);
	}
	private int getAltura(No i){
		int resp=0;
		if(i!=null){
			int a = getAltura(i.esq);
			int b = getAltura(i.dir);
			resp = (a>b) ? a+1 : b+1; 
		}
		return resp;
	}
	public boolean ehcompleta(){
		return ehcompleta(raiz);
	}
	private boolean ehcompleta(No i){
		boolean resp=true;
		if(i!=null){
			resp  = (getAltura(i.esq) != getAltura(i.dir)) ? false :true ;
			if(resp){
				resp = ehcompleta(i.esq);
				if(resp){
					resp =  ehcompleta(i.dir);
				}
			}
		}
		return resp;
	}
}