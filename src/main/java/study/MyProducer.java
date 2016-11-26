package study;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MyProducer extends Thread {

	private final KafkaProducer<String, String> producer;

	public MyProducer() {
		Properties props = new Properties();
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put("bootstrap.servers", "localhost:9092");
		this.producer = new KafkaProducer<String, String>(props);
	}

	@Override
	public void run() {
		int messageNo = 1;
		while (true) {
			String messageStr = "Message_" + messageNo;
			System.out.println("Send:" + messageStr);
			producer.send(new ProducerRecord<String, String>("my_test", messageStr));
			messageNo++;
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}