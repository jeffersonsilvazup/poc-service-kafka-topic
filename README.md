# POC Spring Boot + DynamoDB +  Kafka :money_with_wings:

## About project

The principal objective of this project is study a little about <a href="https://kafka.apache.org/" target="_blank" >Kafka</a> and <a href="https://aws.amazon.com/pt/dynamodb/" target="_blank" >Dynamo DB</a>.

### Configure project

Is required <a href="https://docs.docker.com/docker-for-windows/install/" target="_blank" >Docker</a>, <a href="https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html" target="_blank" >JDK</a>, <a href="https://maven.apache.org/" target="_blank" >Maven</a> and <a href="https://razorsql.com/" target="_blank" >RazorSQL</a>.


After clone this project, enter in the folder of the project and execute the followings commands.

```
cd /path/project/poc-service-kafka-topic

mvn install -DskipTests

docker-compose up -d

```

After executing the above commands, create a table in DynamoDB with the name 'QrCode' and a 'id' attribute of Scalar type String and HASH partition key.

### Routes

#### GET: http://localhost:8080/qrcode

```json
[
  {
    "id": "xxxxxx-xxxxx-xxxxx-xxxx-xxxxxxx",
    "valor": 100,
    "tipo": "ESTATICO",
    "alias": "matesu.zup@itau",
    "banco": null,
    "tipoConta": null,
    "agencia": null,
    "conta": null,
    "url": null,
    "juros": null,
    "multa": null,
    "desconto": null,
    "abatimento": null,
    "vencimento": null
  },
  {
    "id": "xxxxxxx-xxxx-xxxx-xxxx-xxxxxxxx",
    "valor": 200,
    "tipo": "DINAMICO",
    "alias": null,
    "banco": 260,
    "tipoConta": "POUPANCA",
    "agencia": 4234,
    "conta": 5555555,
    "url": "http://localhost:8080/qrcode/estatico/x",
    "juros": 2,
    "multa": 10,
    "desconto": 0,
    "abatimento": 0,
    "vencimento": "2020-02-19"
  }
]
```

#### GET: http://localhost:8080/qrcode/dinamico/{id}

```json
  {
    "id": "xxxxxxx-xxxx-xxxx-xxxx-xxxxxxxx",
    "valor": 200,
    "tipo": "DINAMICO",
    "alias": null,
    "banco": 260,
    "tipoConta": "POUPANCA",
    "agencia": 4234,
    "conta": 5555555,
    "url": "http://localhost:8080/qrcode/estatico/x",
    "juros": 2,
    "multa": 10,
    "desconto": 0,
    "abatimento": 0,
    "vencimento": "2020-02-19",
    "hash":"002101021226740014br.gov.bcb.spi21082602204POUPANCA230842342420555555552040530398654064005802BR5913FULANO DE TAL6008BRASILIA62190515RP12345678-201980720014br.gov.bcb.spi2550http://localhost:8080/qrcode/dinamico/calculo/f23f471b-effd-4291-8dfb-0a9a56c22589630434D1"
  }
```

#### POST: http://localhost:8080/qrcode/estatico

```json
{
	"alias":"matesu.zup@itau",
	"valor":100
}
```

#### POST: http://localhost:8080/qrcode/dinamico

```json
{
    "valor":200,
    "banco":260,
    "conta":5555555,
	  "agencia":4234,
    "url":"http://localhost:8080/qrcode/estatico/x",
    "indentificador":"xxxxxxxx-yyyyyy",
    "juros":2,
    "multa":10,
    "desconto":0,
    "abatimento":0,
    "vencimento":"2020-02-19",
    "tipoConta":1
}
```

The API it is ready to use.

Thank you :smile:
