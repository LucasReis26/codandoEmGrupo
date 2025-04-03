<h1 align="center">Comandos GitHub</h1>

## Descrição

Para utilizar esse repositório é bom saber utilizar pelo menos o básico do GitHub, então pra ajudar deixarei aqui alguns comandos que podem ajudar.

## Principais Comandos

### 1. Clone
---

O comando clone é responsável por clonar um repositório remoto dentro da nossa máquina, podemos clonar nosso repositório de 3 formas diferentes, https, ssh e GitHub CLI.

_No exemplo desse repositório estaremos considerando que todos estão utilizando o GitHub por SSH_

**Como utilizar:**

`git clone linkDoSeuRepositorio`

### 2. Status
---

O comando `git status` é responsável por dizer qual o status atual do nosso repositório dentro da nossa máquina, ao digitar ele no terminal ele vai falar se temos mudanças para serem adicionadas ao próximo commit, se já temos mudanças adicionadas ao próximo commit ou até mesmo se não temos nada para adicionar ao próximo commit.

### 3. Add
---

O comando `git add` é responsável por adicionar mudanças ao próximo commit, antes de darmos um commit nós precisamos falar pro nosso repositório o que será commitado, o git add é responsável por essa parte

**Exemplo:**

`git add .` => Adiciona todas as mudanças da pasta atual e pastas filhas para o próximo commit.

`git add someFile.txt` => Adiciona algum arquivo de texto para o próximo commit.

### 4. Commit
---

Agora que temos mudanças adicionadas chegou a tão esperada hora de Commitar!! O commit nada mais é do que salvar nossas mudanças no nosso repositório **local** dando um título descritivo a ele, dessa forma podemos ter toda uma documentação do que está sendo feito no nosso código.

**Como utilizar:**

`git commit -m "mensagem do seu commit"`

_É uma boa prática commitar sempre que fizermos algo significativo no nosso código, por exempo: implementei um um algoritmo de ordenação, Bug de entrada de dados consertado, Código concluido e funcionando, etc..._

### 5. Push
---

Okay! Escrevi todo o meu código, adicionei mudanças para serem commitadas, commitei diversas vezes e meu projeto ta pronto, COMO EU MANDO PRO GITHUB AGORA???

Para isso utilizamos o git push!!

O git push é responsável por pegar todos os commits que estão na sua máquina e que ainda não estão no github e mandalos para lá, simples né? Vamos ver como utilizamos então:

**Como utilizar:**

`git push origin nomeDaBranchDesejada`

_**origin** => representa o repositório de origem no GitHub_

_É uma boa prática sempre que terminarmos um código ou sempre que nosso horário de trabalho terminar, nós darmos um git push para manter o nosso repositório atualizado_

### 6. Pull
---

E se o meu GitHub tiver commits que minha máquina ainda não tem? Nesse caso utilizamos o pull, esse comando serve justamente para pegaros as mudanças a frente no nosso repositório remoto, nesse caso o nosso GitHub e trazer pra nossa máquina

**Como utilizar:**

`git pull origin nomeDaBranchDesejada`

### 7. Branch
---

Você deve ter reparado que nos exemplos de push e pull foi escrito "nomeDaBranchDesejada" mas o que diabos são branchs?? Branchs são basicamente ramificações do nosso código, muito úteis pra quando queremos trabalhar em funcionalidades diferentes, dessa forma estaremos trabalhando em um mesmo repositório, porém em ambientes completamente isolados e seguros.

`git branch` => é responsável por listar todas as branches do seu repositório

_É uma boa prática utilizarmos uma branch diferente para cada funcionalidade nova que iremos desenvolver em nosso código, principalmente se estivermos trabalhando em equipe!_

### 8. Checkout
---

Okay! Aprendemos agora o que são branches, mas como eu posso criar uma branch nova? Ou como eu posso trocar de branch sempre que me for conveniente???

Para isso utilizaremos o comando checkout!!

**Como utilizar:**

`git checkout -b nomeDaNovaBranch` => comando responsável por mudar para uma nova branch ao mesmo tempo em que se cria uma nova branch.

`git checkout nomeDaBranch` => Quando não utilizamos o "-b" nós não criamos uma branch nova, porém ao usar o git checkout com o nome de uma branch que já existe, nós automáticamente mudamos pra ela!!

_Todas essas mudanças são visíveis utilizando o `git status` ou `git branch`_
