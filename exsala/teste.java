public class teste{
	public static void main(String[]args){
		int n=1024;
		int sub=0;
		for(int i=1;i<n;i*=2){
			for(int j=n;j>1;j/=2){
				sub++;
			}
		}
		MyIO.println(sub);
	}
}

n+1
lg(n)+1