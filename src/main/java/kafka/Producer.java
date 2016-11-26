package kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer extends Thread{

	private  KafkaProducer<String, String> producer;

	public Producer() {
		Properties props = new Properties();
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put("bootstrap.servers", "localhost:9092");
		this.producer = new KafkaProducer<String, String>(props);
	}

	public static void main(String[] args) {

		int messageNo = 1;
		while (true) {
			String messageStr = "Message_" + messageNo;
			System.out.println("Send:" + messageStr);
			new Producer().producer.send(new ProducerRecord<String, String>("my_test", messageStr));
			messageNo++;
		}
	}
}