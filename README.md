### Make sure to run kafka zookeeper
# Linux Commands
    ./bin/kafka-storage format \
    --config ./etc/kafka/kraft/server.properties \
    --cluster-id $(./bin/kafka-storage random-uuid)

    ./bin/kafka-server-start ./etc/kafka/kraft/server.properties

## To install kafka
    wget https://packages.confluent.io/archive/7.0/confluent-community-7.0.1.tar.gz

    tar -xf confluent-community-7.0.1.tar.gz