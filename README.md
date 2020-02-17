# POC Spring Boot + DynamoDB +  Kafka :money_with_wings:

## About project

The principal objective of this project is study a little about <a href="https://kafka.apache.org/" target="_blank" >Kafka</a>, <a href="https://aws.amazon.com/pt/dynamodb/" target="_blank" >Dynamo DB</a> and <a href="https://razorsql.com/" target="_blank" >RazorSQL</a>.

### Configure project

Is required <a href="https://docs.docker.com/docker-for-windows/install/" target="_blank" >Docker</a>, <a href="https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html" target="_blank" >JDK</a> and <a href="https://maven.apache.org/" target="_blank" >Maven</a>

After clone this project, enter in the folder of the project and execute the followings commands.

```
cd /path/project/poc-service-kafka-topic

docker-compose up -d

docker-compose exec kafka  \
kafka-topics --create --topic qrcode-save --partitions 1 --replication-factor 1 --if-not-exists --zookeeper localhost:32181

mvn clean spring-boot:run

```
