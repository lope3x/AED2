#include <stdio.h>
#include <stdlib.h>

typedef struct Celula{
	int elemento;
	struct Celula * prox;
}Celula;

Celula* primeiro;
Celula* ultimo;

Celula* newCelula(int elemento){
	Celula* new  = (Celula*)malloc(sizeof(Celula));
	new->elemento=elemento;
	new->prox = NULL;
	return new;
}
int start(){
	ultimo = primeiro= newCelula(0);
	return 0;
}
int inserirInicio(int elemento){
	Celula* tmp = newCelula(elemento);
	tmp->prox = primeiro->prox;
	primeiro->prox = tmp;
	if(primeiro==ultimo){
		ultimo=tmp;
	}
	tmp = NULL;
	return 0;
}
int inserirFim(int elemento){
	ultimo->prox = newCelula(elemento);
	ultimo = ultimo->prox;
	return 0;
}
int inserir(int elemento,int pos){
	if(pos==tamanho())inserirFim(elemento);
	else if(pos==0)inserirInicio(elemento);
	else{
		int c=0;
		Celula* i;
		for(i=primeiro;c<pos;c++,i=i->prox);
		Celula* tmp = newCelula(elemento);
		tmp->prox = i->prox;
		i->prox = tmp;
		i=tmp=NULL;
	}
	return 0;
}
int removerInicio(){
	int resp = primeiro->prox->elemento;
	Celula* tmp = primeiro->prox;
	primeiro->prox = tmp->prox;
	tmp->prox = NULL;
	free(tmp);
	tmp=NULL;
	return resp;
}
int removerFim(){
	Celula* i;
	for(i=primeiro->prox;i->prox!=ultimo;i=i->prox);
	int resp=ultimo->elemento;
	free(ultimo);
	ultimo =i;
	ultimo->prox=NULL;
	i=NULL;
	return resp;
}
int remover(int pos){
	int resp;
	if(pos==tamanho()-1)resp=removerFim();
	else if(pos==0)resp=removerInicio();
	else{
		int c=0;
		Celula* i;
		//SEMPRE PARA NO ANTERIOR AO Q VAI SER REMOVIDO
		for(i=primeiro;c<pos;c++,i=i->prox);
		resp = i->prox->elemento;
		Celula* tmp = i->prox;//celula a ser removida
		i->prox = tmp->prox;
		i=tmp->prox = NULL;
		free(tmp);
		tmp=NULL;
	}
	return resp;
}
int tamanho(){
	int resp=0;
	Celula* i;
	for(i = primeiro->prox;i!=NULL;i=i->prox,resp++);
	return resp;
}
int mostrar(){
	Celula* i;
	for(i=primeiro->prox;i!=NULL;i=i->prox){
		printf("%d",i->elemento);
	}
}
int main(){
	start();
	inserirInicio(5);
	inserirInicio(4);
	inserirInicio(3);
	inserirInicio(2);
	inserirInicio(1);
	inserirFim(6);
	inserirFim(7);
	inserirFim(8);
	inserirFim(9);
	inserirFim(10);
	removerInicio();
	removerInicio();
	removerFim();
	removerFim();
	inserir(remover(2),2);
	mostrar();
	return 0;
}