#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iconv.h>

#define bool   short
#define true   1
#define false  0
struct data{
	int dia;
	int mes;
	int ano;
};
struct Presidente{
	int id;//OK
	char nome[100];//OK
	int idade;//OK
	data dataNascimento;//OK
	char localNascimento[100];//OK
	data inicioMandato;//OK
	data fimMandato;//OK
	data dataMorte;//OK
	char localMorte[100];//OK
	char antecessor[100];//OK
	char sucessor[100];//OK
	char vice[100];//OK
	char pagina[100];
	long paginaTam;
};
struct Lista{
	Presidente array[100];
	int n;
};
struct Lista presidentes;
int converte (char input[],char output[]) {
    iconv_t cd = iconv_open("ISO_8859-1", "UTF-8");
    if (cd == (iconv_t) -1) {
        perror("iconv_open failed!");
        return 1;
    }

    char *in_buf = &input[0];
    size_t in_left = sizeof(input) - 1;

    char *out_buf = &output[0];
    size_t out_left = sizeof(output) - 1;

    do {
        if (iconv(cd, &in_buf, &in_left, &out_buf, &out_left) == (size_t) -1) {
            perror("iconv failed!");
            return 1;
        }
    } while (in_left > 0 && out_left > 0);
    *out_buf = 0;

    iconv_close(cd);

    printf("%s -> %s\n", input, output);
    return 0;
}
//metodo funcional
int getMes(char s[]){
	int mes=0;
	if(strstr(s,"janeiro")!=NULL)mes=1;
	if(strstr(s,"fevereiro")!=NULL)mes=2;
	if(strstr(s,"mar")!=NULL)mes=3;
	if(strstr(s,"abril")!=NULL)mes=4;
	if(strstr(s,"maio")!=NULL)mes=5;
	if(strstr(s,"junho")!=NULL)mes=6;
	if(strstr(s,"julho")!=NULL)mes=7;
	if(strstr(s,"agosto")!=NULL)mes=8;
	if(strstr(s,"setembro")!=NULL)mes=9;
	if(strstr(s,"outubro")!=NULL)mes=10;
	if(strstr(s,"novembro")!=NULL)mes=11;
	if(strstr(s,"dezembro")!=NULL)mes=12;
	return mes;
}
int substring(char s[], char sub[], int p, int l) {
   int c = 0;
   while (c < l) {
      sub[c] = s[p+c];
      c++;
   }
   sub[c] = '\0';
   return 0;
}
//METODO FUNCIONAL RETORNA UM PONTEIRO 
char *removeTags(char* buf){
	int idx = 0;
	int i;
	int opened = 0; // false
	for(i=0; i<strlen(buf); i++){
    if(buf[i]=='<') {
        opened = 1; // true
    } else if (buf[i] == '>') {
        opened = 0; // false
    } else if (!opened) {
        buf[idx++] = buf[i];
    }
	}
	buf[idx] = '\0';
	return buf;
}
/**
 * s string a ser substituida
 * sub elemento a ser deletado
 * replace elemento a ser colocado no lugar
 */
int replaceall(char s[] , char sub, char replace){
	int i;
	for(i=0;i<strlen(s);i++){
		if(s[i]==sub){
			s[i]=replace;
		}
	}
	return 0;
}
/**
  Recebe um string s e uma string busca, busca a primeira ocorrencia da string busca na string s
*/
int indexOf(char s[],char busca[]){
	char *ptr = strstr(s,busca);
	int indexof = 0;
	if(ptr){
		indexof=ptr-s;
	}
	return indexof;
}
/*void replace(char* string, char searchchar, char replacechar) { 
	char *valueptr; 
	valueptr = strchr(string, searchchar);
	if(valueptr != NULL) 
		*valueptr = replacechar;
	while (valueptr !=NULL) {
		valueptr = strchr(valueptr + 1, searchchar);
		if(valueptr != NULL) 
			*valueptr = replacechar;
	}	 
}*/
/**
  String entrada
  String saida
  int inicio
  int fim
  ex  entrada= hamburguer
      inicio = 1 fim = 5
	  saida = ambur
*/
int sub(char entrada[],char saida[],int inicio, int fim){
	int i;
	int c=0;
	for(i =inicio;i<fim;i++){
		saida[c]=entrada[i];
		c++;
	} 
	return 0;
}/*
int imprimir(Presidente teste){
	printf("ID %d\n",teste.id);// TESTE PRINT ID
	printf("Inicio Mandato %d/%d/%d\n",teste.inicioMandato.dia,teste.inicioMandato.mes,teste.inicioMandato.ano);// TESTE PRINT INICIO MANDATO
	printf("Fim Mandato %d/%d/%d\n",teste.fimMandato.dia,teste.fimMandato.mes,teste.fimMandato.ano); //TESTE PRINT FIM MANDATO
	printf("Vice %s\n",teste.vice);//TESTE PRINT VICE
	printf("Antecessor %s\n",teste.antecessor);//TESTE PRINT ANTECESSOR
	printf("Sucessor %s\n",teste.sucessor);//TESTE PRINT SUCESSOR
	printf("Nome Completo %s\n",teste.nome);//TESTE PRINT nome
	printf("Data Nascimento %d/%d/%d\n",teste.dataNascimento.dia,teste.dataNascimento.mes,teste.dataNascimento.ano);//TESTE DATA DE NASCIMENTO COMPLETA
	printf("Idade %d\n",teste.idade);//TESTE IDADE
	printf("Local Nascimento %s\n",teste.localNascimento); //TESTE LOCAL NASCIMENTO MORTOS
	if(teste.dataMorte.dia!=0){
		printf("Data Morte %d/%d/%d\n",teste.dataMorte.dia,teste.dataMorte.mes,teste.dataMorte.ano);//TESTE DATA MORTE COMPLETO
		printf("Local morte %s\n",teste.localMorte);//TESTE LOCAL MORTE
	}
	printf("Pagina %s\n",teste.pagina);//TESTE PAGINA
	printf("Pagina Tam %d\n",teste.paginaTam);//TESTE PAGINA TAM
	return 0;
}*/
int imprimir(Presidente teste){
	//printa vivos
	if(teste.dataMorte.dia==0){
		printf("%d ## %s ## %d/%d/%d (I) ## %d/%d/%d (F) ## %d/%d/%d em %s (N) ## %d ## %s ## %ld ## %s ## %s ## %s\n",teste.id,teste.nome,teste.inicioMandato.dia,teste.inicioMandato.mes,teste.inicioMandato.ano,teste.fimMandato.dia,teste.fimMandato.mes,teste.fimMandato.ano,
		teste.dataNascimento.dia,teste.dataNascimento.mes,teste.dataNascimento.ano,teste.localNascimento,teste.idade,teste.pagina,teste.paginaTam,teste.antecessor,teste.sucessor,teste.vice);
	}
	//printa mortos
	else{
		printf("%d ## %s ## %d/%d/%d (I) ## %d/%d/%d (F) ## %d/%d/%d em %s (N) ## %d ## %d/%d/%d em %s (M) ## %s ## %ld ## %s ## %s ## %s\n",teste.id,teste.nome,teste.inicioMandato.dia,teste.inicioMandato.mes,teste.inicioMandato.ano,teste.fimMandato.dia,teste.fimMandato.mes,teste.fimMandato.ano,
		teste.dataNascimento.dia,teste.dataNascimento.mes,teste.dataNascimento.ano,teste.localNascimento,teste.idade,teste.dataMorte.dia,teste.dataMorte.mes,teste.dataMorte.ano,teste.localMorte
		,teste.pagina,teste.paginaTam,teste.antecessor,teste.sucessor,teste.vice);
	}
	return 0;
}
/**
 * O metodo movimenta todos os elementos da string uma posicao para esquerda
 */
int shiftesq(char s[]){
	int i;
	for(i=1;i<strlen(s);i++){
		s[i-1]=s[i];
	}
	return 0;
}
/**
	O metodo recebe uma string com a localizacao do arquivo  em seguida faz a leitura dos dados e os salva em uma struct 
*/
struct Presidente ler(char arquivo[]){
	char taga[100] ="</a>";
	char tagb[100] = ">";
	char tagc[100] = " de ";
	char tagd[100] =")";
	char linha[100000];
	int dia=0,mes=0,ano=0;
	FILE *p =fopen(arquivo,"r+");
	struct Presidente teste;
	bool stop;
	char temp[100000];
	//PEGA INFORMACOES SOBRE O ARQUIVO
	strcpy(teste.pagina,arquivo);//SETA NOME DA PAGINA
	fseek(p,0L,SEEK_END);
	teste.paginaTam = ftell(p);
	fseek(p,0,SEEK_SET);
	
	//IGNORA TAGS INICIAIS
	for(stop = false; stop == false; stop = strstr(fgets(temp,100000,p),"background-color:#B0C4DE")!=NULL);
	for(stop = false; stop == false; fgets(linha,100000,p), stop = strstr(linha,"Presidente do Brasil")!=NULL);
	replaceall(linha,'º',' ');
	replaceall(linha,'Â',' ');
	replaceall(linha,'ª',' ');
	
	
	//ID
	//PRIMEIRO SUBSTRING
	int tam = strlen(linha) - indexOf(linha,tagb);
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	//SEGUNDO SUBSTRING
	tam = strlen(linha) - indexOf(linha,tagb);
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	//TERCEIRO SUBSTRING
	char saida[10000];
	substring(linha,saida,0,indexOf(linha,taga));
	teste.id = atoi(saida);
	//printf("%d\n",teste.id); //TESTE PRINT ID
	
	
	//IGNORAR TAGS
	for(stop = false;stop==false;stop=strstr(fgets(temp,100000,p),">Per")!=NULL);
	for(stop=false;stop==false;){
		fgets(linha,100000,p);
		if(strstr(linha,"<td")!=NULL){
			stop=true;
		}
	}
	
	
	//PRIMEIRO SUBSTRING
	tam = strlen(linha) - indexOf(linha,tagb);
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	//SEGUNDO SUBSTRING
	tam = strlen(linha) - indexOf(linha,tagb);
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	
	char ttt[10000];
	//PEGA DADOS INICIO GOVERNO
	//PEGA DIA INICIO MANDATO
	sub(linha,ttt,0,(linha[1]== ' '||linha[1]=='º') ? 1 : 2);
	dia=atoi(ttt);//DIA INICIO MANDATO
	if(dia>31){
		dia=dia/10;
	}
	teste.inicioMandato.dia = dia;//SETA DIA INICIO MANDATO

	
	//PEGA MES INICIO MANDATO
	tam =strlen(linha) -indexOf(linha,tagc)+4;
	substring(linha,linha,indexOf(linha,tagc)+4,tam);
	sub(linha,saida,0,indexOf(linha,taga));
	mes=getMes(saida);
	teste.inicioMandato.mes=mes;//SETA MES INICIO MANDATO
	
	
	//PEGA ANO INICIO MANDATO
	tam = strlen(linha) -indexOf(linha,taga)+4;
	substring(linha,linha,indexOf(linha,taga)+4,tam);
	tam = strlen(linha) - indexOf(linha,tagb)+1;
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	sub(linha,saida,0,indexOf(linha,taga));
	ano = atoi(saida);
	teste.inicioMandato.ano=ano;//SETA ANO INICIO MANDATO
	//printf("Inicio Mandato %d/%d/%d\n",teste.inicioMandato.dia,teste.inicioMandato.mes,teste.inicioMandato.ano);// TESTE PRINT INICIO MANDATO
	
	//PULA TAGS
	tam = strlen(linha) - indexOf(linha,tagb);
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	tam = strlen(linha) - indexOf(linha,tagb);
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	tam = strlen(linha) - indexOf(linha,tagb);
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	
	
	//PEGA DADOS FIM GOVERNO
	//PEGA DIA FIM MANDATO
	char newsaida[100000];
	substring(linha,newsaida,0,(linha[1]== ' '||linha[1]=='º') ? 1 : 2);
	dia=atoi(newsaida);
	teste.fimMandato.dia=dia;//SETA DIA FIM MANDATO
	
	
	//PEGA MES FIM MANDATO
	tam = strlen(linha) - indexOf(linha,tagc)+4;
	substring(linha,linha,indexOf(linha,tagc)+4,tam);
	substring(linha,newsaida,0,indexOf(linha,taga));
	mes=getMes(newsaida);
	teste.fimMandato.mes=mes;//SETA MES FIM MANDATO
	
	
	//PEGA ANO FIM MANDATO
	tam = strlen(linha) - indexOf(linha,taga)+4;
	substring(linha,linha,indexOf(linha,taga)+4,tam);
	tam = strlen(linha) - indexOf(linha,tagb)+1;
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	substring(linha,newsaida,0,indexOf(linha,taga));
	ano=atoi(newsaida);
	teste.fimMandato.ano=ano;//SETA ANO FIM MANDATO
	//printf("Fim Mandato %d/%d/%d\n",teste.fimMandato.dia,teste.fimMandato.mes,teste.fimMandato.ano); //TESTE PRINT FIM MANDATO
	
	
	//PEGA VICE PRESIDENTE
	for(stop=false;stop==false;){
		fgets(linha,100000,p);
		if(strstr(linha,"<td")!=NULL){
			stop=true;
		}
	}
	bool vice=false;
	if(strstr(linha,"Vice")!=NULL){
		vice=true;
	}
	if(vice){
        for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
		}
        strcpy(teste.vice,removeTags(linha));//SETA NOME VICE
		teste.vice[strcspn(teste.vice, "\n")] = 0;//APAGA \N NO FINAL DO NOME 
		//printf("%s\n",teste.vice);//TESTE PRINT VICE
        for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
		}
    } 
	else{
        strcpy(teste.vice," ");;
    }
	
	
	
	//PEGA ANTECESSOR
	bool antecessor=false;
	if(strstr(linha,"Antecessor")!=NULL){
		antecessor=true;
	}
	if(antecessor){
         for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
		}
        strcpy(teste.antecessor,removeTags(linha));//SETA NOME ANTECESSOR
		teste.antecessor[strcspn(teste.antecessor, "\n")] = 0;//APAGA \N NO FINAL DO NOME
		//printf("%s\n",teste.antecessor);//TESTE PRINT ANTECESSOR
        for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
		}
    } 
	else{
        strcpy(teste.antecessor," ");
    }
	
	
	//PEGA SUCESSOR
	bool sucessor=false;
	if(strstr(linha,"Sucessor")!=NULL){
		sucessor=true;
	}
	if(sucessor){
        for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
		}
        strcpy(teste.sucessor,removeTags(linha));//SETA NOME SUCESSOR
		teste.sucessor[strcspn(teste.sucessor, "\n")] = 0;//APAGA \N NO FINAL DO NOME
		//printf("%s\n",teste.sucessor);//TESTE PRINT SUCESSOR
        for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
		}
    } 
	else{
        strcpy(teste.sucessor,"");
    }
	
	
	//PEGA NOME COMPLETO PRESIDENTE
	for(stop = false; stop == false; stop = strstr(fgets(temp,100000,p),"Dados pessoais")!=NULL);
	for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
	}
	bool nome=false;
	if(strstr(linha,"Nome")!=NULL){
		nome=true;
	}
	if(nome){
        for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
		}
        strcpy(teste.nome,removeTags(linha));//SETA NOME COMPLETO
		teste.nome[strcspn(teste.nome, "\n")] = 0;//APAGA \N NO FINAL DO NOME
		//printf("%s\n",teste.nome);//TESTE PRINT nome
        for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
		}
    } 
	else{
        strcpy(teste.nome," ");
    }
	
	//DATA DE NASCIMENTO
	for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
	}
	tam = strlen(linha) - indexOf(linha,tagb)+1;
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	tam = strlen(linha) - indexOf(linha,tagb)+1;
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	substring(linha,newsaida,0,(linha[1] == ' ' || linha[1] == 'º') ? 1 : 2);
	dia=atoi(newsaida);
	teste.dataNascimento.dia = dia;//SETA DIA DATA NASCIMENTO
	//printf("%d",teste.dataNascimento.dia);//TESTE DATA DIA NASCIMENTO
	tam=strlen(linha) - indexOf(linha,tagc)+4;
	substring(linha,linha,indexOf(linha,tagc)+4,tam);
	substring(linha,newsaida,0,indexOf(linha,taga));
	mes=getMes(newsaida);
	teste.dataNascimento.mes=mes;//SETA MES DATA NASCIMENTO
	//printf("%d",teste.dataNascimento.mes);//TESTE DATA MES NASCIMENTO
	tam=strlen(linha) - indexOf(linha,taga)+4;
	substring(linha,linha,indexOf(linha,taga)+4,tam);
	tam=strlen(linha) - indexOf(linha,tagb)+1;
	substring(linha,linha,indexOf(linha,tagb)+1,tam);
	substring(linha,newsaida,0,indexOf(linha,taga));
	ano=atoi(newsaida);
	teste.dataNascimento.ano=ano;//SETA ANO DATA NASCIMENTO
	//printf("%d",teste.dataNascimento.ano);//TESTE DATA ANO NASCIMENTO
	//printf("%d/%d/%d",teste.dataNascimento.dia,teste.dataNascimento.mes,teste.dataNascimento.ano);//TESTE DATA DE NASCIMENTO COMPLETA
	
	
	//IDADE
	teste.idade = 2019 - ano + ((mes == 1 && dia <= 3) ? 1 : 0);//SETA IDADE
	//printf("%d",teste.idade);//TESTE IDADE
	
	
	//LOCAL NASCIMENTO
	tam=strlen(linha) - indexOf(linha,taga)+4;
	substring(linha,newsaida,indexOf(linha,taga)+4,tam);
	strcpy(teste.localNascimento,removeTags(newsaida));//SETA localNascimento COMPLETO
	shiftesq(teste.localNascimento);//REMOVE ESPACO NO COMECO DA STRING
	teste.localNascimento[strcspn(teste.localNascimento, "\n")] = 0;//APAGA \N NO FINAL DO localNascimento
	//printf("%s\n\n",teste.localNascimento); //TESTE LOCAL NASCIMENTO MORTOS
	
	
	//TESTE DE QUEM TA VIVO
	bool vivo=false;
	if(strstr(teste.localNascimento,"anos")!=NULL){
		vivo=true;
	}
	if(vivo){
		tam=strlen(teste.localNascimento) - indexOf(teste.localNascimento,tagd)+2;
		substring(teste.localNascimento,teste.localNascimento,indexOf(teste.localNascimento,tagd)+2,tam);//SETA LOCALNASCIMENTO VIVOS
		//printf("%s",teste.localNascimento);//TESTE LOCAL NASCIMENTO VIVOS
		teste.dataMorte.dia=0;
		teste.dataMorte.mes=0;
		teste.dataMorte.ano=0;
	}
	//PEGA DADOS DE QUEM TA MORTO
	else{
		for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
		}
		for(stop=false;stop==false;){
			fgets(linha,100000,p);
			if(strstr(linha,"<td")!=NULL){
				stop=true;
			}
		}
		//DATA MORTE
		tam = strlen(linha) - indexOf(linha,tagb)+1;
		substring(linha,linha,indexOf(linha,tagb)+1,tam);
		tam = strlen(linha) - indexOf(linha,tagb)+1;
		substring(linha,linha,indexOf(linha,tagb)+1,tam);
		tam = strlen(linha) - indexOf(linha,tagb)+1;
		substring(linha,linha,indexOf(linha,tagb)+1,tam);
		substring(linha,newsaida,0,(linha[1] == ' ' || linha[1] == 'º') ? 1 : 2);
		dia = atoi(newsaida);
		teste.dataMorte.dia = dia;//SETA DIA DATA MORTE
		//printf("%d",teste.dataMorte.dia);//TESTE DIA DATA MORTE
		tam = strlen(linha) - indexOf(linha,tagc)+4;
		substring(linha,linha,indexOf(linha,tagc)+4,tam);
		substring(linha,newsaida,0,indexOf(linha,taga));
		mes = getMes(newsaida);
		teste.dataMorte.mes = mes;//SETA MES DATA MORTE
		//printf("%d",teste.dataMorte.mes);//TESTE MES DATA MORTE
		tam = strlen(linha) - indexOf(linha,taga)+4;
		substring(linha,linha,indexOf(linha,taga)+4,tam);
		tam = strlen(linha) - indexOf(linha,tagb)+1;
		substring(linha,linha,indexOf(linha,tagb)+1,tam);
		substring(linha,newsaida,0,indexOf(linha,taga));
		ano = atoi(newsaida);
		teste.dataMorte.ano = ano;//SETA ANO DATA MORTE
		//printf("%d",teste.dataMorte.ano);//TESTE ANO DATA MORTE
		//printf("%d/%d/%d",teste.dataMorte.dia,teste.dataMorte.mes,teste.dataMorte.ano);//TESTE DATA MORTE COMPLETO
		tam = strlen(linha) - indexOf(linha,taga)+4;
		substring(linha,newsaida,indexOf(linha,taga)+4,tam);
		removeTags(newsaida);
		tam = strlen(newsaida) - indexOf(newsaida,tagd)+2;
		substring(newsaida,newsaida,indexOf(newsaida,tagd)+2,tam);
		strcpy(teste.localMorte,removeTags(newsaida));//SETA localMorte COMPLETO
		teste.localMorte[strcspn(teste.localMorte, "\n")] = 0;//APAGA \N NO FINAL DO localMorte
		//printf("%s",teste.localMorte);//TESTE LOCAL MORTE
	}
	fclose(p);
	if(teste.id==25)teste.inicioMandato.dia=2;
	return teste;
	
}
bool equals(char s1[],char s2[]){
	bool resp=true;
	if(strlen(s1)!=strlen(s2)) resp=0;
	int tam = strlen (s1);
	int i;
	for(i=0;i<tam;i++){
		if(s1[i]!=s2[i]){
			resp=0;
		}
	}
	return false;
}
int mostrar(Lista presidentes){
	int i;
	for(i=0;i<presidentes.n;i++){
		printf("[%d] ",i);
		imprimir(presidentes.array[i]);
	}
	return 0;
}
int inserirInicio(Presidente x){
	int i;
	for(i=presidentes.n;i>0;i--){
		presidentes.array[i] = presidentes.array[i-1];
	}
	presidentes.array[0]=x;
	presidentes.n++;
	return 0;
}
int inserirFim(Presidente x){
	presidentes.array[presidentes.n]=x;
	presidentes.n++;
	return 0;
}
int inserir(Presidente x,int pos){
	int i;
	for(i=presidentes.n;i>pos;i--){
		presidentes.array[i]=presidentes.array[i-1];
	}
	presidentes.array[pos]=x;
	presidentes.n++;
	return 0;
}
Presidente removerInicio(){
	struct Presidente resp = presidentes.array[0];
	int i;
	presidentes.n--;
	for(i = 0;i<presidentes.n;i++){
		presidentes.array[i]=presidentes.array[i+1];
	}
	return resp;
}
Presidente removerFim(){
	presidentes.n--;
	struct Presidente resp = presidentes.array[presidentes.n];
	return resp;
}
Presidente remover(int pos){
	presidentes.n--;
	struct Presidente resp = presidentes.array[pos];
	int i;
	for(i=pos;i<presidentes.n;i++){
		presidentes.array[i]=presidentes.array[i+1];
	}
	return resp;
}
int main(){
	struct Presidente tmp ;
	char arquivo[100];
	char input[100];
	int pos;
	presidentes.n=0;
	/*presidentes.array[0] = ler(arquivo);
	imprimir(presidentes.array[0]);
	scanf("%s",arquivo);
	presidentes.array[1]=ler(arquivo);
	imprimir(presidentes.array[1]);*/
	int i;
	int repete;
	for(i=0;strstr(arquivo,"FIM")==NULL;i++){
		scanf("%s",arquivo);
		if(strstr(arquivo,"FIM")==NULL){
			presidentes.array[i] = ler(arquivo);
			presidentes.n++;
		}
	}
	scanf("%d",&repete);
	for(i=0;i<repete;i++){
		scanf("%s",input);
		if(strstr(input,"II")!=NULL){
			scanf("%s",input);
			inserirInicio(ler(input));
		}
		if(strstr(input,"IF")!=NULL){
			scanf("%s",input);
			inserirFim(ler(input));
		}
		if(strstr(input,"I*")!=NULL){
			scanf("%d",&pos);
			scanf("%s",input);
			inserir(ler(input),pos);
		}
		if(strstr(input,"RI")!=NULL){
			tmp = removerInicio();
			printf("(R) %s\n",tmp.nome);
		}
		if(strstr(input,"RF")!=NULL){
			tmp = removerFim();
			printf("(R) %s\n",tmp.nome);
		}
		if(strstr(input,"R*")!=NULL){
			scanf("%d",&pos);
			tmp = remover(pos);
			printf("(R) %s\n",tmp.nome);
		}
	}
	mostrar(presidentes);
	/*char teste[100];
	scanf("%s",teste);
	printf("%s\n",teste);
	scanf("%s",teste);
	printf("%s",teste);
	scanf("%s",teste);
	printf("%s",teste);*/
	return 0;
}