public class TP01Q12{
	public static void main(String[]args){
		entradaeSaidaRecursivo();
	}
	public static boolean isPalindromoRecursivo(String s){
		return isPalindromoRecursivo(s,0);
	}
	public static boolean isPalindromoRecursivo(String s,int i){
		boolean resp;
		int j=(s.length()-(1+i));
		if(i==s.length()/2){
			resp=true;
		}
		else{
			if(s.charAt(i)!=s.charAt(j)){
				resp=false;
			}
			else{
				resp=isPalindromoRecursivo(s,i+1);
			}
		}
		return resp;
	}
	public static boolean equalsRecursivo(String str1,String str2){
		boolean isEquals=false;
		if(mesmoTamanho(str1,str2)){
			isEquals=equalsRecursivo(str1,str2,0);
		}
		return isEquals;
	}
	public static boolean equalsRecursivo(String str1,String str2,int i){
		boolean isEquals;
		if(i==str1.length()){
			isEquals=true;
		}
		else{
			if(str1.charAt(i)!=str2.charAt(i)){
				isEquals=false;
			}
			else{
				isEquals=equalsRecursivo(str1,str2,i+1);
			}
		}
		return isEquals;
	}
	public static boolean mesmoTamanho(String str1,String str2){
		return (str1.length()==str2.length());
	}
	public static void entradaeSaidaRecursivo(){
		String input=MyIO.readLine();
		if(!equalsRecursivo(input,"FIM")){
			if(isPalindromoRecursivo(input)){
				MyIO.println("SIM");
			}
			else{
				MyIO.println("NAO");
			}
			entradaeSaidaRecursivo();
		}
	}
}