#List for all topic
kafka-topics --list --bootstrap-server localhost:9092

#Create new topic
kafka-topics --create --topic saurabh-topic --bootstrap-server localhost:9092 --partitions 2 --replication-factor 2

#describe topic
kafka-topics --describe --bootstrap-server localhost:9092 --topic saurabh-topic



#Produce Messages
kafka-console-producer --broker-list localhost:9092 --topic saurabh-topic


#Consumer
kafka-console-consumer --bootstrap-server localhost:9092 --topic saurabh-topic  --from-beginning

#with consumer Group
kafka-console-consumer --bootstrap-server localhost:9092 --topic saurabh-topic --group g-1 --from-beginning
kafka-console-consumer --bootstrap-server localhost:9092 --topic saurabh-topic --group g-2 --from-beginning

kafka-console-producer --bootstrap-server localhost:9092 --topic saurabh-topic --partition 1

kafka-console-producer --bootstrap-server localhost:9092 --topic saurabh-topic \
                          --property "key.serializer=org.apache.kafka.common.serialization.StringSerializer" \
                          --property "value.serializer=org.apache.kafka.common.serialization.StringSerializer"
