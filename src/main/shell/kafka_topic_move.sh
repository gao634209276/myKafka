#!/usr/bin/env bash

export KAFKA_HOME=/opt/modules/kafka

${KAFKA_HOME}/bin/kafka-reassign-partitions.sh \
--zookeeper hadoop:2181 \
--topics-to-move-json-file ../resources/topic_move.json \
--broker-list 0 --generate
