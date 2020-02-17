# POC Spring Boot + DynamoDB +  Kafka :money_with_wings:

## About project

The principal objective of this project is study a little about <a href="https://kafka.apache.org/" target="_blank" >Kafka</a> and <a href="https://aws.amazon.com/pt/dynamodb/" target="_blank" >Dynamo DB</a>.

### Configure project

Is required <a href="https://docs.docker.com/docker-for-windows/install/" target="_blank" >Docker</a>, <a href="https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html" target="_blank" >JDK</a>, <a href="https://maven.apache.org/" target="_blank" >Maven</a> and <a href="https://razorsql.com/" target="_blank" >RazorSQL</a>.


After clone this project, enter in the folder of the project and execute the followings commands.

```
cd /path/project/poc-service-kafka-topic

docker-compose up -d

docker-compose exec kafka  \
kafka-topics --create --topic qrcode-save --partitions 1 --replication-factor 1 --if-not-exists --zookeeper localhost:32181

mvn clean spring-boot:run

```

After executing the above commands, create a table in DynamoDB with the name 'QrCode' and an 'id' attribute of Scalar type String and HASH partition key.

### Routes

#### GET: http://loccalhost:8080/qrcode

```json
{
    [
        "id":"xxxx-xxxx-xxxx-xxxx",
        "url":"http://localhost:8080/url",
        "valor":100,
        "alias":"mateus.zup@itau"
    ]
}
```

#### POST: http://loccalhost:8080/qrcode

```json
{
    "url":"http://localhost:8080/url",
    "valor":100,
    "alias":"mateus.zup@itau"
}
```

The API it is ready to use.

Thank you :smile:
