jar:
	mvn clean && mvn package
	java -jar target/coffee-machine-0.0.1.jar

docker:
	mvn clean && mvn package
	docker build --tag coffee-machine .
	docker run --detach --name coffee-machine -p 8080:8080 coffee-machine:latest
	docker ps

test:
	mvn test

clean:
	docker stop coffee-machine
	docker system prune --force