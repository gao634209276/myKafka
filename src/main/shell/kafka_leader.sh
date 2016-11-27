#!/usr/bin/env bash

export KAFKA_HOME=/opt/modules/kafka
${KAFKA_HOME}/bin/kafka-preferred-replica-election.sh \
 --zookeeper hadoop:2181/kafka auto.leader.rebalance.enable=true
