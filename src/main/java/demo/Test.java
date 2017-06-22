package demo;

import kafka.consumer.*;
import kafka.javaapi.consumer.ConsumerConnector;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Test
 * Created by noah on 17-4-24.
 */
public class Test {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("zookeeper.connect", "xxxx:2181");
		props.put("zookeeper.connectiontimeout.ms", "1000000");
		props.put("group.id", "test_group");
		props.put("zookeeper.session.timeout.ms", "40000");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");

		ConsumerConfig consumerConfig = new ConsumerConfig(props);
		ConsumerConnector consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);


		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put("test", new Integer(1));
		//key--topic
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector.createMessageStreams(topicCountMap);
		KafkaStream<byte[], byte[]> stream = consumerMap.get("test").get(0);
		ConsumerIterator<byte[], byte[]> it = stream.iterator();
		StringBuffer sb = new StringBuffer();
		while (it.hasNext()) {
			try {
				String msg = new String(it.next().message(), "utf-8").trim();
				System.out.println("receive:" + msg);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
}
