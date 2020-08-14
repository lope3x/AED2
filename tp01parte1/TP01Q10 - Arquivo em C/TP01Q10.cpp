#include <stdio.h>
#include <stdlib.h>

int main(){
	FILE *p =fopen("teste.txt","wb+");
	int repete;
	scanf("%d",&repete);
	int i=0;
	double d;
	long bytes;
	while(i<repete){
		scanf("%lf",&d);
		fwrite(&d,sizeof(double),1,p);
		i++;
	}
	i=0;
	bytes=ftell(p);
	bytes-=8;
	rewind(p);
	fseek(p,bytes,SEEK_SET);
	while(i<repete){
		fseek(p,bytes,SEEK_SET);
		fread(&d,sizeof(double),1,p);
		bytes-=8;
		printf("%g\n",d);
		i++;
	}
	fclose(p);
	return 0;
}
