#!/usr/bin/env bash
export KAFKA_HOME=/opt/modules/kafka

${KAFKA_HOME}/bin/kafka-reassign-partitions.sh \
--zookeeper hadoop:2181 \
--reassignment-json-file  ../resources/expand_cluster_reassignment.json \
--execute
