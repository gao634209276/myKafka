package kafka;

public class KafkaConsumerProducerDemo {

    public static void main(String[] args) {
        new Producer().start();
        new Consumer().start();
    }

}