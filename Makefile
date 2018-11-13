.DEFAULT_GOAL := run

clear:
	rm -rf ./target

compile: clear
	mkdir -p ./target/classes
	javac -d ./target/classes -cp ./src ./src/Program.java

run: compile
	java -cp ./target/classes Program
