package study;


public class KafkaConsumerProducerDemo {

    public static void main(String[] args) {
        new MyProducer().start();
        new MyConsumer().start();
    }

}