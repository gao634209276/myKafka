#!/usr/bin/env bash

export KAFKA_HOME=/opt/modules/kafka
# 将test的topic迁移到名称为1,2的broker中,(这里副本有两个,所以至少要两个broker)
# 生成的Proposed partition reassignment configuration是以json格式数据为分区计划情况,
# 存放到resources/expand_cluster_reassignment.json中,
# 然后使用kafka_topic_move_exec.sh脚本执行迁移,
# 为了防止备份出错,最好将生成的目前分区信息Current partition replica assignment保持一个备份

${KAFKA_HOME}/bin/kafka-reassign-partitions.sh \
--zookeeper hadoop:2181/kafka \
--topics-to-move-json-file ../resources/topic_move.json \
--broker-list "1,2" --generate
