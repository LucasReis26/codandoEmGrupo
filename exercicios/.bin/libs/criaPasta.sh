criaPasta(){

	mkdir -p "./ex$1/pubs/"

	mkdir "./ex$1/c"
	touch "./ex$1/c/ex$1.c"

	mkdir "./ex$1/cpp"
	touch "./ex$1/cpp/ex$1.cpp"

	mkdir "./ex$1/java"
	touch "./ex$1/java/Ex$1.java"
	echo "package ex$1.java;" > "./ex$1/java/Ex$1.java"

	echo "Deseja incluir as pubs?"
	echo " 1 - Sim"
	echo " 2 - Não"
	read -p "Sua opção: " op

	if [ "$op" -eq 1 ]
	then

		nvim "./ex$1/pubs/pub.in"
		nvim "./ex$1/pubs/pub.out"

	fi

	echo $'\nPasta criada com sucesso!'

	read -p $'\nPressione ENTER para sair...' 

	clear
}
