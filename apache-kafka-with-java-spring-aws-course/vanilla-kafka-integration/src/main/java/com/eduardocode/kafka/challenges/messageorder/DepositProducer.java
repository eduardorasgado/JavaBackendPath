package com.eduardocode.kafka.challenges.messageorder;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class DepositProducer {

    public static void main(String[] args) {
        Properties props = new Properties();

        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getCanonicalName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getCanonicalName());

        props.setProperty(ProducerConfig.ACKS_CONFIG, "1");

        props.setProperty(ProducerConfig.LINGER_MS_CONFIG, "0");

        List<DepositEntry> data = new ArrayList<>();
        getDataList(data);


        try(Producer<String, String> producer = new KafkaProducer<>(props)) {
            for(DepositEntry row : data) {
                producer.send(
                        new ProducerRecord<String, String>("vanilla-topic", Integer.toString(row.getUser()), row.getJsonValue())
                );
            }
        }
    }

    public static void getDataList(List<DepositEntry> data) {
        data.add(new DepositEntry(1020, Action.DEPOSIT, 200, Timestamp.valueOf("2020-08-25 00:00:00.0")));
        data.add(new DepositEntry(1020, Action.DEPOSIT, 100, Timestamp.valueOf("2020-08-25 01:25:02.0")));
        data.add(new DepositEntry(1020, Action.DEPOSIT, 200, Timestamp.valueOf("2020-08-25 02:56:00.0")));
        data.add(new DepositEntry(1020, Action.WITHDRAWAL, -300, Timestamp.valueOf("2020-08-26 04:32:00.0")));

        data.add(new DepositEntry(1021, Action.DEPOSIT, 200, Timestamp.valueOf("2020-08-26 16:43:00.0")));
        data.add(new DepositEntry(1021, Action.DEPOSIT, 240, Timestamp.valueOf("2020-08-27 18:33:00.0")));
    }

    private static class DepositEntry {
        private int user;

        private final Map.Entry<String, Action> action;

        private final Map.Entry<String, Integer> amount;

        private final Map.Entry<String, Timestamp> timestamp;

        public DepositEntry(int user, Action action, int amount, Timestamp timestamp) {
            this.user = user;
            this.action = new AbstractMap.SimpleEntry<>("Action", action);
            this.amount = new AbstractMap.SimpleEntry<>("Amount", amount);
            this.timestamp = new AbstractMap.SimpleEntry<>("Timestamp", timestamp);
        }

        public int getUser() {
            return user;
        }

        private Map.Entry<String, Action> getAction() {
            return action;
        }

        private Map.Entry<String, Integer> getAmount() {
            return amount;
        }

        private Map.Entry<String, Timestamp> getTimestamp() {
            return timestamp;
        }

        public String getJsonValue() {
            return "{"
                    + getAction().getKey()
                    + ": "
                    + getAction().getValue().getName()
                    + ", "
                    + getAmount().getKey()
                    + ": "
                    + String.valueOf(getAmount().getValue())
                    + ", "
                    + getTimestamp().getKey()
                    + ": "
                    + getTimestamp().getValue().toString()
                    + "}";
        }
    }

    private static enum Action {
        DEPOSIT("Deposit"),
        WITHDRAWAL("Withdrawal");

        private final String name;

        Action(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}