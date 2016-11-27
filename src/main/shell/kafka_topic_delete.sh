#!/usr/bin/env bash
export KAFKA_HOME=/opt/modules/kafka
export ZOOKEEPER_HOME=/opt/modules/zookeeper-3.4.8
${KAFKA_HOME}/bin/kafka-topics.sh \
--delete --zookeeper hadoop:2181 \
--topic HelloKafka


${ZOOKEEPER_HOME}/bin/zkCli.sh  <<EOF
rmr /brokers/topics/HelloKafka
EOF