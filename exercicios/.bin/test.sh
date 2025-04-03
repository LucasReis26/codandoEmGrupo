#! /bin/bash

clear

source .bin/libs/testaPrograma.sh

isTrue=false

read -p "Digite o número do exercício que você quer testar: " ex

if [ -e "ex$ex/" ]
then
	isTrue=true
fi

if [ "$isTrue" = true ]
then

	echo $'\nSelecione a linguagem que você deseja testar'
	echo " 1 - C"
	echo " 2 - C++"
	echo " 3 - Java"
	read -p "Sua opção: " op

	testaPrograma "$ex" "$op"

else

	echo $'\nERROR: Exercício não encontrado'

fi
