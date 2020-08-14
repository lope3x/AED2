#include <stdio.h>
#include <stdlib.h>

typedef struct Celula{
	int elemento;
	struct Celula* prox;
}Celula;
Celula* newCelula(int elemento){
	Celula* tmp = (Celula*)malloc(sizeof(Celula));
	tmp->elemento =elemento;
	tmp->prox=NULL;
	return tmp;
}
Celula* topo;
int empilhar(int elemento){
	Celula* tmp = newCelula(elemento);
	tmp->prox = topo;
	topo = tmp;
	tmp = NULL;
	return 0;
}
int desempilhar(){
	int resp=0;
	if(topo!=NULL){
		resp = topo->elemento;
		Celula* tmp = topo;
		topo=topo->prox;
		tmp->prox = NULL;
		free(tmp);
		tmp=NULL;
	}
	else{
		printf("N TEM NADA PRA REMOVER BABACA");
	}
	return resp;
}
int mostrarOrdemRemocao(Celula* i){
	if(i!=NULL){
		printf("%d\n",i->elemento);
		mostrarOrdemRemocao(i->prox);
	}
	return 0;
}
int mostrarOrdemRemocao1(){
	printf("ORDEM DE REMOCAO\n");
	mostrarOrdemRemocao(topo);
	return 0;
}
int mostrarOrdemInsercao(Celula* i){
	if(i!=NULL){
		mostrarOrdemInsercao(i->prox);
		printf("%d\n",i->elemento);
	}
	return 0;
}
int mostrarOrdemInsercao1(){
	printf("ORDEM DE INSERCAO\n");
	mostrarOrdemInsercao(topo);
	return 0;
}
int start(){
	topo=NULL;
	return 0;
}
int main(){
	start();
	empilhar(5);
	empilhar(4);
	empilhar(3);
	empilhar(2);
	empilhar(1);
	empilhar(0);
	mostrarOrdemRemocao1();
	return 0;
}