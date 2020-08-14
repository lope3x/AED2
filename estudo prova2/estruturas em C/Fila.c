#include <stdio.h>
#include <stdlib.h>

typedef struct Celula{
	int elemento;
	struct Celula* prox;
}Celula;

Celula* primeiro;
Celula* ultimo;

Celula* newCelula(int elemento){
	Celula* new = (Celula*) malloc(sizeof(Celula));
	new->elemento=elemento;
	new->prox=NULL;
	return new;
}
int start(){
	ultimo=primeiro = newCelula(0);
	return 0;
}
int inserir(int elemento){
	ultimo->prox = newCelula(elemento);
	ultimo = ultimo->prox;
	return 0;
}
int remover(){
	int resp=0;
	if(primeiro!=ultimo){
		resp = primeiro->prox->elemento;
		Celula* tmp = primeiro->prox;
		primeiro->prox = tmp->prox;
		tmp->prox = NULL;
		free(tmp);
		tmp=NULL;
	}
	else{
		printf("NAO TEM NADA PARA REMOVER BABACA\n");
	}
	return resp;
}
int mostrar(){
	Celula* i;
	for(i=primeiro->prox;i!=NULL;i=i->prox){
		printf("%d",i->elemento);
	}
	return 0;
}
int main(){
	start();
	inserir(1);
	inserir(2);
	inserir(3);
	inserir(4);
	inserir(5);
	inserir(6);
	mostrar();
	return 0;
}