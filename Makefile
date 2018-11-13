.DEFAULT_GOAL := run

clear:
#	del -rf .\target
	rm -rf ./target

compile: clear
#	mkdir .\target\classes
	mkdir -p ./target/classes
	javac -d ./target/classes -cp ./src ./src/pkg/Program.java

build: compile
#	jar cf ./target/Java-for-testers-1.0-SNAPSHOT.jar -C ./target/classes .
	jar cfe ./target/Java-for-testers-1.0-SNAPSHOT.jar pkg.Program -C ./target/classes .

run: build
#	java -cp ./target/classes Program
#	java -cp ./target/Java-for-testers-1.0-SNAPSHOT.jar Program
	java -jar ./target/Java-for-testers-1.0-SNAPSHOT.jar
