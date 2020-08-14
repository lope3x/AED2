public class radixsort{
	public static int qtosDig(int n){
		cont=0;
		while(num !=0) {
			num = num/10;
			cont++;
		} 
	}
	//RECEBE COMO PARAMETRO QUAL DIGITO QUER PEGAR DIG
	//int n eh o numero a ser verificado 45 102 qualquer 1
	public static void pegaDig(int dig,int n){
		int divisor=1;
		resp;
		for(int i=1;i<dig;divisor*=10);
		n=n/divisor;
		resp=n%10;
		
	}
}
