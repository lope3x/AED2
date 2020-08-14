#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int isPalindromoRecursivo(char* s,int i){
	int resp;
	int tam = strlen(s);
	int j= tam-(1+i);
	if(i<strlen(s)){
		if(s[i]!=s[j]){
			resp=0;
		}
		else{
			resp=isPalindromoRecursivo(s,i+1);
		}
	}
	return resp;
}
int isPalindromoRecursivoo(char* s){
	return isPalindromoRecursivo(s,0);
}
/*int equalsRecursivoo(char* s1,char* s2){
	int resp;
	if(strlen(s1)!=strlen(s2)){
		resp=0;
	}
	else{
		resp=equalsRecursivo(s1,s2,0);
	}
	return resp;
}
int equalsRecursivo(char* s1,char* s2,int i){
	int resp;
	if(i<strlen(s1)){
		if(s1[i]!=s2[i]){
			resp=0;
		}
		else{
			resp=equalsRecursivo(s1,s2,i+1);
		}
	}
	return resp;
}*/
int equals(char s1[],char s2[]){
	int resp=1;
	if(strlen(s1)!=strlen(s2)) resp=0;
	int tam = strlen (s1);
	int i;
	for(i=0;i<tam;i++){
		if(s1[i]!=s2[i])resp=0;
	}
	return resp;
}
int main(){
	char input[1000];
	int i;
	fgets(input,1000,stdin);
	size_t ln = strlen(input) - 1;
	if (input[ln] == '\n')
		input[ln] = '\0';
	do{
		if(isPalindromoRecursivoo(input)){
			printf("SIM\n");
		}
		else{
			printf("NAO\n");
		}
		fgets(input,1000,stdin);
		ln=strlen(input)-1;
		if (input[ln] == '\n')
			input[ln] = '\0';
	}while(!equals(input,"FIM"));
	return 0;
}