.DEFAULT_GOAL := run

clear:
	rm -rf ./out

compile: clear
	javac -d ./out -cp ./src ./src/Program.java

run: compile
	java -cp ./out Program
