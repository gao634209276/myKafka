数据生产实现


1.配置数据生产模块
	项目工程的文件配置,集群链接信息配置
	start-all.sh
	zkServer.sh start

2.实现flume到kafka模块
	flume集群信息配置:flume-kafka-source.properties
	数据收集
	启动kafka,启动flume,启动kafka监控(8089)
