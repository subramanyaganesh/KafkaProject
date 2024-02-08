Procedure to Create a zookeeper and kafka services
1. docker run -d --name zookeeper -p 2181:2181 -e ALLOW_ANONYMOUS_LOGIN=yes zookeeper:3.6
or to remove once its used
docker run --rm --name zookeeper -p 2181:2181 -e ALLOW_ANONYMOUS_LOGIN=yes zookeeper 


2. docker run --rm --name kafka -p 9092:9092 --link zookeeper 
--env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 
--env KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092
confluentinc/cp-kafka

or
docker run --rm --name kafka -p 9092:9092
--link zookeeper
-e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092
-e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1
confluentinc/cp-kafka


Now after the producer has put a topic and a record inside kafka in order to check this
we have to do the following

go into the kafka container in a new shell:-docker exec -it kafka /bin/bash
list all the topics:-
    kafka-topics --list --bootstrap-server localhost:9092
read all messages from the topic
kafka-console-consumer --bootstrap-server localhost:9092 --topic <myFirstTopic> --from-beginning



Procedure to create this application 
1. import the basic template from https://start.spring.io/
2. import the following dependencies:-kafka-streams,spring-cloud-stream
