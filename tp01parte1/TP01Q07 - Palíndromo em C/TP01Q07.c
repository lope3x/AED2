#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(){
	char input[1000];
	int i;
	int tamanho = strlen(input);
	fgets(input,1000,stdin);
	do{
		if(isPalindromo(input)){
			printf("SIM\n");
		}
		else{
			printf("NAO\n");
		}
		fgets(input,1000,stdin);
	}while(!equals(input,"FIM\n"));
	return 0;
}
int isPalindromo(char s[]){
	int resp=1;
	int i;
	int tam = strlen(s);
	int j=tam-2;
	for(i=0;i<tam/2;i++){
		if(s[i]!=s[j]){
			resp=0;
		}
		j--;
	}
	return resp;
}
int equals(char s1[],char s2[]){
	int resp=1;
	if(strlen(s1)!=strlen(s2)) resp=0;
	int tam = strlen (s1);
	int i;
	for(i=0;i<tam;i++){
		if(s1[i]!=s2[i]){
			resp=0;
		}
	}
	return resp;
}
