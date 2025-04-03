<h1 align="center">Arquivos MakeFile</h1>

## Descrição

Arquivos makefile são arquivos onde você pode criar comandos personalizados para serem utilizados em um determinado diretório, você pode utilizar eles pra tornar a experiência de criar pastas, compilar seus programas e até mesmo testar seus programas uma tarefa menos custosa no sentido de digitação uma vez que como vimos nos documentos anteriores são muuuuitos comandos.

## Como utilizar makefile?

1. Para utilizar o makefile você precisa ter inicialmente certeza que ele está instalado no seu sistema.

**Para verificar a instalação digite isso no seu terminal:**
```
make --version
```

2. Uma vez sabendo que o makefile está instalado, você deve criar um arquivo com o nome `makefile` no diretório onde você quer utilizar seus comandos.

3. Criado o arquivo makefile agora você deve criar os seus comandos!! Para isso você deve utilizar essa sintaxe:

```
nomeDoSeuComando: (Se seu comando precisar de dependencias coloque a frente do nome do comando)
    comandosQueSeuComandoIráExecutar;
```

4. Com o comando criado agora é só você salvar o arquivo e digitar `make nomeDoSeuComando` no terminal dentro do diretório que você quer ter esse comando.

## Exemplo

Vamos criar um makefile que compila e roda o seu código utilizando dois comandos diferentes chamados `compile` e `run`:

```
run: compile
    ./exec;

compile:
    gcc meuPrograma.c -o exec;
```

Como podemos ver, meu arquivo makefile tem dois comandos, um faz a compilação de algum programa meu .c e outro roda esse programa através do comando `./exec`

Porém se observarmos bem, eu posso muito bem dar o comando make run sem compilar o meu programa, uma vez que o meu comando `run`, tem como prérequisito chamar o comando `compile`.

