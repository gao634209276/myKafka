package send;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SendMessage {

	public static void main(String[] args) {
		// producer的配置
		Properties props = new Properties();
		props.setProperty("zookeeper.connect",
				"hadoop:2181,hadoop1:2181,hadoop2:2181/kafka");
		props.setProperty("serializer.class", "kafka.serializer.StringEncoder");
		props.setProperty("producer.type", "async");
		props.setProperty("compression.codec", "1");
		props.setProperty("metadata.broker.list", "hadoop:9092");

		props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("bootstrap.servers", "hadoop:9092");

		KafkaProducer<String, String> producer = new KafkaProducer<>(props);

		// 构造数据
		Random r = new Random();
		// List messageList = new ArrayList<KeyedMessage<String, String>>();
		for (int i = 0; i < 10; i++) {
			int id = r.nextInt(10000000);
			int memberid = r.nextInt(100000);
			int totalprice = r.nextInt(1000) + 100;
			int youhui = r.nextInt(100);
			int sendpay = r.nextInt(3);

			StringBuffer data = new StringBuffer();
			data.append(String.valueOf(id)).append("\t")
					.append(String.valueOf(memberid)).append("\t")
					.append(String.valueOf(totalprice)).append("\t")
					.append(String.valueOf(youhui)).append("\t")
					.append(String.valueOf(sendpay)).append("\t")
					.append("2016-06-02");
			System.out.println(data.toString());
			// messageList.add(new KeyedMessage<String,String> ("order",data.toString()));
			producer.send(new ProducerRecord<String, String>("order", data.toString()));
		}
		producer.close();
		System.out.println("send over ------------------");
	}

}