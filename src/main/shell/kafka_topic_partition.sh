#!/usr/bin/env bash
# partition 只能增加,不能减少
export KAFKA_HOME=/opt/modules/kafka
${KAFKA_HOME}/bin/kafka-topics.sh  \
--zookeeper hadoop:2181/kafka \
--alter -topic test --partitions 4
