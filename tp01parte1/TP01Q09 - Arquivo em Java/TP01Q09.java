import java.io.*;
public class TP01Q09{
	public static void main(String[]args)throws Exception{
		File file = new File("teste.txt");
		RandomAccessFile raf = new RandomAccessFile(file,"rw"); 
		int repete=MyIO.readInt();
		int i=0;
		double leitura;
		double d;
		int numnoarquvo=repete+1;
		long bytes=4;
		int j;
		while(i<repete){
			d=MyIO.readDouble();
			raf.writeDouble(d);
			i++;
		}
		bytes=raf.getFilePointer();
		bytes-=8;
		i=0;
		try{
			do{
				raf.seek(bytes);
				d=raf.readDouble();
				raf.seek(bytes);
				if(isInteiro(d)){
					bytes-=8;
					MyIO.println((int)d);
				}
				else{
					bytes-=8;
					MyIO.println(d);
				}
				i++;
			}while(i<repete);
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		catch(IOException e){
			System.out.println(e);
		}
		raf.close();
	}
	/*
		@author Gabriel Lopes Ferreira
		@date 04/02/2019
		@version 1.0
		@since 1.0
		@param str1 , str 2
		@return isEquals
		O metodo recebe duas Strings e verifica se as duas são iguais
	*/
	public static boolean isInteiro(double d){
		boolean resp=false;
		if((int)d==d){
			resp=true;
		}
		return resp;
	}
}
