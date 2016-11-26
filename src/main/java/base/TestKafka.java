package base;

public class TestKafka {

    public static void main(String[] args) {
        new MyProducer().start();
        new MyConsumer().start();
    }

}