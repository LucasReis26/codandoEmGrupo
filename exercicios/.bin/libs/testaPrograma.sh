testaPrograma(){

	if [ "$2" -eq 1 ]
	then
		gcc "ex$1/c/ex$1.c" -o "ex$1/c/exec"
		"./ex$1/c/exec" < "ex$1/pubs/pub.in" > "ex$1/program.out"
		nvim -d "ex$1/program.out" "ex$1/pubs/pub.out"

	elif [ "$2" -eq 2 ]
	then
		g++ "ex$1/cpp/ex$1.cpp" -o "ex$1/cpp/exec"
		"./ex$1/cpp/exec" < "ex$1/pubs/pub.in" > "ex$1/program.out"
		nvim -d "ex$1/program.out" "ex$1/pubs/pub.out"

	elif [ "$2" -eq 3 ]
	then
		javac "ex$1/java/Ex$1.java" 
		java "ex$1.java.Ex$1" < "ex$1/pubs/pub.in" > "ex$1/program.out"
		nvim -d "ex$1/program.out" "ex$1/pubs/pub.out"

	else
		echo $'\nERROR: Linguagem não encontrada'
	fi
}
