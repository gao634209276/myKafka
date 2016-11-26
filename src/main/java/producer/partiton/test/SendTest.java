package producer.partiton.test;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * producer.partiton.test.JasonPartitioner
 */
public class SendTest {

	private Properties props = new Properties();


	public void sendMessage() throws InterruptedException {

		props.put("metadata.broker.list", "10.206.216.13:19092,10.206.212.14:19092,10.206.209.25:19092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("partitioner.class", "producer.partiton.test.JasonPartitioner");
		props.put("request.required.acks", "1");
		//0;  绝不等确认  1:   leader的一个副本收到这条消息，并发回确认 -1：   leader的所有副本都收到这条消息，并发回确认
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);
		for (int i = 1; i <= 5; i++) {
			List messageList = new ArrayList<KeyedMessage<String, String>>();
			for (int j = 0; j < 4; j++) {
				messageList.add(new KeyedMessage<String, String>("topic2", j + "", "The " + i + " message for key " + j));
			}
			producer.send(messageList);
		}
		producer.close();
	}
}
