.DEFAULT_GOAL := run

clear:
#	del -rf .\target
#	rm -rf ./target
#	./mvnw clean
	./gradlew clean

#compile: clear
#	mkdir .\target\classes
#	mkdir -p ./target/classes
#	javac -d ./target/classes -cp ./src ./src/pkg/Program.java
#	./mvnw compile

build: clear #compile
#	jar cf ./target/Java-for-testers-1.0-SNAPSHOT.jar -C ./target/classes .
#	jar cfe ./target/Java-for-testers-1.0-SNAPSHOT.jar pkg.Program -C ./target/classes .
#	./mvnw package
	./gradle build

run: build
#	java -cp ./target/classes Program
#	java -cp ./target/Java-for-testers-1.0-SNAPSHOT.jar Program
#	java -jar ./target/Java-for-testers-1.0-SNAPSHOT-jar-with-dependencies.jar 1000
	java -jar ./build/Java-for-testers-1.0-SNAPSHOT.jar 1000

#update:
#	./mvnw versions:update-properties versions:display-plugin-updates
