#include <stdio.h>
#include <stdlib.h>

typedef struct CelulaDupla{
	struct CelulaDupla* prox;
	struct CelulaDupla* ant;
	int elemento;
}CelulaDupla;

CelulaDupla* primeiro;
CelulaDupla* ultimo;

CelulaDupla* newCelulaDupla(int elemento){
	CelulaDupla* tmp = (CelulaDupla*)malloc(sizeof(CelulaDupla));
	tmp->ant=NULL;
	tmp->prox=NULL;
	tmp->elemento=elemento;
	return tmp;
}
int start(){
	primeiro=newCelulaDupla(-1);
	ultimo=primeiro;
}
int inserirInicio(int elemento){
	CelulaDupla* tmp = newCelulaDupla(elemento);
	tmp->prox = primeiro->prox;
	tmp->ant = primeiro;
	primeiro->prox = tmp;
	if(primeiro==ultimo){
		ultimo=tmp;
	}
	else{
		tmp->prox->ant = tmp;
	}
	return 0;
}
int inserirFim(int elemento){
	ultimo->prox = newCelulaDupla(elemento);
	ultimo->prox->ant = ultimo;
	ultimo=ultimo->prox;
	return 0;
}
int inserir(int elemento,int pos){
	if(pos==tamanho())inserirFim(elemento);
	else if(pos==0)inserirInicio(elemento);
	else{
		CelulaDupla* i;
		int j=0;
		for(i=primeiro;j<pos;i=i->prox,j++);
		CelulaDupla* tmp = newCelulaDupla(elemento);
		tmp->ant=i;
		tmp->prox = i->prox;
		i->prox=tmp;
		tmp->prox->ant=tmp;
		tmp=NULL;
		i=NULL;
	}
}
int removerInicio(){
	int resp = primeiro->prox->elemento;
	CelulaDupla* tmp = primeiro->prox;
	if(ultimo!=tmp)tmp->prox->ant=primeiro;
	primeiro->prox=tmp->prox;
	tmp->prox=tmp->ant=NULL;
	free(tmp);
	tmp=NULL;
	return resp;
}
int removerFim(){
	int resp = ultimo->elemento;
	ultimo = ultimo->ant;
	ultimo->prox->ant=NULL;
	free(ultimo->prox);
	ultimo->prox=NULL;
	return resp;
}
int remover(int pos){
	int resp;
	if(pos==tamanho()-1)resp=removerFim();
	else if(pos==0)resp=removerInicio();
	else{
		CelulaDupla* i;
		int j=0;
		for(i=primeiro;j<pos;j++,i=i->prox);
		CelulaDupla* tmp = i->prox;
		resp = i->prox->elemento;
		i->prox = tmp->prox;
		tmp->prox->ant=i;
		tmp->ant=NULL;
		tmp->prox=NULL;
		free(tmp);
	}
	return resp;
}
int tamanho(){
	int tam=0;
	CelulaDupla* i;
	for(i=primeiro;i!=ultimo;tam++,i=i->prox);
	return tam;
}
int mostrar(){
	CelulaDupla* i;
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
	printf("%d\n\n",remover(2));
	inserir(5,2);
	mostrar();
	return 0;
}