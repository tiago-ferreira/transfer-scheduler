# transfer-scheduler


## Arquitetura
O sistema foi dividido em algumas camadas, aqui as camadas estao divididas apenas em nomeclatura de pacotes.

## Model
Onde ficam as classes de modelo

## Dao
E a camada responsavel porarmazenar em uma lista em memoria os dados

## Service
E a camada responsavel pelas regras de negocio

## Business
Foi usado para fazer a estrategia de calculo da taxa

## Schedulers
Usado para fazer as transferências do dia.

## Controllers
E a camada responsavel por disponibilizar as servicos Rest.

## Premissas

- O valor da transferência foi considerado com a mesma moeda de calculo da taxa.
- A data de uma transferência não pode ser inferior a data de hoje.
- A conta de destino não pode ser a mesma de origem.
- O calculo de taxa foi feito usando o padrão strategy.
- Ao invés de getter e setter, usei flunt interface para acesso aos atributos do modelo.
- O ato de realmente ser feita a transacao é um scheduler que executa de 10 em 10 minutos e verifica se tem alguma transferência com a data de transferência para hoje, logo após fazer o filtro ele remove essas transferências da lista de mémoria.

## Baixar os fontes

- git clone git@github.com:tiago-ferreira/transfer-scheduler.git

## Executar aplicação

Entrar no diretório do projeto:

- mvn clean install package
- java -jar target/transfer-scheduler-0.0.1-SNAPSHOT.jar

ou

- mvn spring-boot:run

A aplicação irá iniciar em http://localhost:8080

ou

- mvn clean install package docker:build
- docker run -p 8080:8080 -t transfer-scheduler

## Servicos para explorar

GET /transfer

POST /transfer



Exemplo de json para fazer um POST

{
	"origin":{
		"number" : "123456"
	},
	"destiny": {
		"number" : "654321"
	},
	"transferValue": 200,
	"transferDate":"2018-03-19"
}

