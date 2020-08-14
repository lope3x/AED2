#include <stdio.h>
#include <stdlib.h>
typedef struct No No;
struct No
{
    int elemento;
    No* esq;
    No* dir;
};

No* newNo(int x)
{
    No* novo  = (No*) malloc(sizeof(No));
    novo->elemento = x;
    novo->esq = NULL;
    novo->dir = NULL;
    return novo;
}
No* raiz=NULL;
No* inserirA(int x,No* i)
{
    if(i==NULL)
    {
        i = newNo(x);
    }
    else if(x<i->elemento)
    {
        i->esq=inserirA(x,i->esq);
    }
    else if(x>i->elemento)
    {
        i->dir=inserirA(x,i->dir);
    }
    return i;
}
int inserir(int x)
{
    raiz = inserirA(x,raiz);
    return 0;
}
int mostrarCentralA(No* i)
{
    if(i!=NULL)
    {
        printf("esq ");
        mostrarCentralA(i->esq);
        printf("%d ",i->elemento);
        printf("dir ");
        mostrarCentralA(i->dir);
    }
    else{
        //printf("oops ");
    }
    return 0;
}
int mostrarCentral()
{
    printf("raiz ");
    mostrarCentralA(raiz);
}
//I EH FIXO E J ANDA 
No* anterior(No* i ,No* j)
{
    if(j->esq!=NULL)
    {
        j->esq =  anterior(i,j->esq);
    }
    else
    {
        i->elemento = j->elemento;
        free(j);
        j=j->esq;
    }
    return j;
}
No* removerA(int x,No* i)
{
    if(x<i->elemento)
    {
        i->esq=removerA(x,i->esq);
    }
    else if(x>i->elemento)
    {
        i->dir=removerA(x,i->dir);
    }
    //Nao tem filho a direita ,e talvez tenha a esquerda
    else if(i->dir==NULL)
    {
        No* tmp = i;
        i = i->esq;
        free(tmp);
        tmp=NULL;
    }
    //TEM filho a direita e NAO tem filho a esquerda
    else if(i->esq==NULL)
    {
        No* tmp = i;
        i = i->dir;
        free(tmp);
        tmp=NULL;
    }
    //TEM FILHO A DIREITA E TEM FILHO A ESQUERDA
    else
    {
        i->dir = anterior(i,i->dir);
    }
    return i;

}
int remover(int x)
{
    raiz =  removerA(x,raiz);
}
int main(int argc, char const *argv[])
{
    inserir(5);
    inserir(3);
    inserir(4);
    inserir(7);
    inserir(6);
    inserir(1);
    inserir(2);
    inserir(8);
    inserir(9);
    inserir(0);
    mostrarCentral();
    printf("\n");
    remover(0);
    remover(1);
    remover(2);
    remover(3);
    remover(4);
    mostrarCentral();
    return 0;
}
