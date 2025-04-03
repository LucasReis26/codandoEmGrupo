<h1 align="center">Comandos Linux</h1>

## Descrição

Arquivo contendo os comandos linux mais importantes de se conhecer.

## Variáveis de Localização

`.` => Referencia o diretório atual;

`..` => Referencia o diretório pai do atual (ou o diretório anterior);

`~` => Referencia a pasta home do seu usuário;

_**Obs.:** A pasta home é onde fica as principais pastas do seu usuário como Documents, Downloads, Vídeos, Pictures, etc..._

## Princiais Comandos

### 1. Listagem de Arquivos
---
 `ls $variavelDeLocalizacao` => LiSt, comando responsável por listar itens não ocultos no diretório listado;

 Exemplos:
 1. `ls .` => Lista todos os itens do diretório atual;
 1. `ls ~` => Lista todos os itens do diretório home;
 1. `ls ~/Downloads` => Lista todos os itens do diretório Downloads que está dentro do diretório home;

### 2. Mudança de Diretório
---
 `cd $variavelDeLocalizacao` => Change Directory, comando responsável por trocar a localização no terminal

 Exemplos: 
 1. `cd ~` => Vai pra pasta home
 1. `cd ~/Downloads/` => Vai pra pasta Downloads
 1. `cd ..` => Volta pra pasta Home (Considere que acabamos de ir pra pasta Downloads)

### 3. Criando novos Diretórios
---
 `mkdir $variavelDeLocalizacao/$nomePasta` => MaKe DIRectory, comando responsável por criar novos diretórios no seu sistema.

 Exemplos: 
 1. `mkdir ~/pastaTeste` => Cria um diretório chamado pastaTeste no diretório home
 1. `mkdir ~/pastaTeste/outraPasta` => Cria um diretório chamado outraPasta dentro do diretório pastaTeste que está na sua pasta home;

 _**Obs.:** também seria possível criar o diretório "outraPasta" dentro de "pastaTeste" da seguinte forma:_ 
 ```
 cd pastaTeste;
 mkdir outraPasta;
 cd ~;
 ```

### 4. Removendo Diretórios
---
 `rmdir $variavelDeLocalizacao/$nomePasta` => ReMove DIRectory, comando responsável por remover diretórios no seu sistema.

 **_IMPORTANTE: Somente diretórios vazios serão removidos_**

 Exemplos: 
 1. `rmdir ~/pastaTeste/outraPasta` => Remove um diretório chamado outraPasta dentro do diretório pastaTeste que está na sua pasta home;

 _**Obs.:** também seria possível remover o diretório "outraPasta" dentro de "pastaTeste" da seguinte forma:_
 ```
 cd pastaTeste;
 rmdir outraPasta;
 cd ~;
 ```

 2. `rmdir ~/pastaTeste` => Remove um diretório chamado "pastaTeste" no diretório home

### 5. Criando Arquivos
---
 `touch $variavelDeLocalizacao/$nomeArquivo.$extensao` => Touch é um comando responsável por criar qualquer tipo de arquivo.

 Exemplos: 
 1. `touch ~/arquivoTeste.txt` => Cria um arquivo de texto chamado "arquivoTeste" dentro da pasta home.

 2. `touch ~/Documents/outroArquivo.txt` => Cria um arquivo de texto chamado "outroArquivo" dentro do diretório Documents.

 _**Obs.:** também seria possível criar o arquivo "outraArquivo" dentro de "Documents" da seguinte forma:_
 ```
 cd Documents;
 touch outroArquivo.txt;
 cd ~;
 ```

### 6. Removendo Arquivos
---
 `rm $variavelDeLocalizacao/$nomeArquivo.$extensao` => ReMove, é um comando responsável por remover qualquer tipo de arquivo.

 Exemplos: 
 1. `rm ~/Documents/outroArquivo.txt` => Remove um arquivo de texto chamado "outroArquivo" dentro do diretório Documents.

 _**Obs.:** também seria possível criar o arquivo "outraArquivo" dentro de "Documents" da seguinte forma:_
 ```
 cd Documents;
rm outroArquivo.txt;
 cd ~;
 ```
 2. `rm ~/arquivoTeste.txt` => Remove um arquivo de texto chamado "arquivoTeste" dentro da pasta home.

## Comandos de Compilação

Para compilar nossos programas em C, C++ e Java utilizando o terminal nós podemos utilizar os seguintes comandos:

- **C** => `gcc $nomeDoSeuArquivo.c -o $nomeDoExecutavel`
- **C++** => `g++ $nomeDoSeuArquivo.cpp -o $nomeDoExecutavel`
- **Java** => `javac $nomeDoSeuArquivo.java`

_**Extra:** Se você estiver utilizando a biblioteca math.h em c, você deve adicionar -lm no final do comando._

Agora para rodar nossos programas nós devemos utilizar os seguintes comandos:

- **C && C++** => `./$nomeDoExecutavel`
- **Java** => `java $nomeDaClasse`

_**Obs.:** Em `$nomeDoExecutavel` não existe um nome específico que você deve usar, você pode usar o que vc quiser, eu uso "exec" por exemplo._
