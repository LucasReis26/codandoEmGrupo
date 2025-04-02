<h1 align="center">Redirecionamento de Entrada e Saída</h1>

## Aviso!!

O guia a seguir só funciona em sistemas linux! Até é possível fazer o redirecionamento de entrada e saída no windows, mas os comandos são diferentes.

_Obviamente o WSL conta como sistema linux_

## Descrição

Redirecionamento de entrada e saída é a habilidade de mudar a entrada e a saída padrão para arquivos, sem ter que implementar isso em código, essa habilidade permite que a gente consiga testar nossos códigos com mais velocidade e sem depender de servidores de terceiros!!

_Uma excelente opção quando o verde estiver fora do ar por exemplo_

## Principais Comandos:

### 1. Redirecionamento de Entrada
---

Para redirecionar a entrada do nosso programa, nós utilizamos `<`, esse simples caractere é capaz de fazer com que o nosso programa pare de interpretar o nosso teclado como entrada padrão e passe a encarar o nosso arquivo.

**Exemplo:**

_Considere o seguinte programa exemplo:_

```
#include <stdio.h>
#include <stdlib.h>

int main(){
    int number;

    scanf("%d",&number);

    printf("%d\n",number);

    return 0;
}
```

Esse programa le um número e printa esse mesmo número na tela, então se eu digitar 5 no terminal ele vai printar 5 na tela, mas e se eu quiser mudar minha entrada padrão?

Para fazer isso primeiramente eu vou precisar de um arquivo, então vamos considerar que temos um arquivo _"teste.txt"_ que contem o número 5 dentro dele.

Se eu executar o programa dessa forma:

```
./exec < teste.txt;
```

Não será necessário digitar o 5 e ele printará o 5 na tela.

### 2. Redirecionamento de Saída
---

Para redirecionar a saída do nosso programa, nós utilizamos `>`, esse simples caractere é capaz de fazer com que o nosso programa não reconheça o terminal como saída padrão, redireconando a saída para um arquivo.

**Exemplo:**

_Considere o seguinte programa exemplo:_

```
#include <stdio.h>
#include <stdlib.h>

int main(){
    int number;

    scanf("%d",&number);

    printf("%d\n",number);

    return 0;
}
```

Esse programa le um número e printa esse mesmo número na tela, então se eu digitar 5 no terminal ele vai printar 5 na tela, mas e se eu quiser mudar minha saída padrão?

Para fazer isso primeiramente eu vou precisar de um arquivo, então vamos considerar que temos um arquivo _"saida.txt"_ que está inicialmente vazio.

Se eu executar o programa dessa forma:

```
./exec > saida.txt;
```

O programa vai pedir uma entrada, mas ao digitarmos o número 5 nada aparecerá na tela, mas se entrarmos no arquivo saida.txt o número 5 estará lá.


### 3. Como juntar os 2?
---

Agora que sabemos como redirecionar a entrada e como redirecionamos a saída, você sabia que é possível redirecionar tanto a entrada quanto a saída ao mesmo tempo?

**Como utilizar:**

`./exec < teste.txt > saida.txt`

Como podemos ver no código acima estamos utilizando os dois caracteres de redirecionamento, primeiro redirecionando a entrada e depois redirecionando a saída, e isso funciona!! podemos fazer isso para ter arquivos documentando a entrada e a saída do nosso programa.

## Como testar?

Para utilizar o redirecionamento de entrada e saída para testar os nossos programas precisamos nos atentar em algumas coisas:

1. Precisamos ter uma entrada esperada para o nosso programa que esteja correta.

1. Precisamos ter uma saída esperada para o nosso programa que esteja correta.

_**Obs.:** nós devemos redirecionar nossa entrada para a entrada esperada **PORÉM** em hipótese alguma redirecione a saída para a saída esperada, a saída esperada deve ficar inalterada para fazermos a comparação depois, crie um arquivo novo para a saída do seu programa._

3. Após redirecionar a entrada e jogar em uma saída NOVA, devemos comparar a saída esperada com a saída do nosso programa.

**Como comparar as saídas?**

Existem algumas maneiras de fazer isso, podemos comparar as saídas com o comando: 

```
diff saidaDoSeuPrograma saidaEsperada
```

Para saber se os arquivos estão iguais no comando acima, o exercício não deve retornar **NADA**

Além do `diff` nós também podemos utilizar opções de comparação do vim e do neovim que proporcionam pra gente uma interface gráfica que torna a comparação bem mais prática:

```
vimdiff saidaDoSeuPrograma saidaEsperada

// ou

nvim -d saidaDoSeuPrograma saidaEsperada
```

Ao fazer a comparação com esses comandos você deve conseguir visualizar as diferenças do seu código.

_**Obs.:** para sair das telas do vim e do neovim você deve digitar `:wqa`_
