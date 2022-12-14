package com.eduardocode.kafka.manualcommit;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class CheetosManualCommitConsumer {

    private static final String VANILLA_TOPIC = "vanilla-topic";

    private static final Logger logger = LoggerFactory.getLogger(CheetosManualCommitConsumer.class);

    public static void main(String[] args) {
        Properties props = new Properties();

        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "vanilla-group");
        props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getCanonicalName());
        props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getCanonicalName());

        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        //props.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        //props.setProperty(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, Integer.toString(1000));
        props.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

        try(Consumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(VANILLA_TOPIC));

            while (true) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, String> record : consumerRecords) {
                    logger.info("Offset = {}, Partition = {}, Key = {}, Value = {}",
                            record.offset(), record.partition(), record.key(), record.value());

                    consumer.commitSync();
                }
                // we can either commit where our logic requires to do it, probably we want to commit on every record read
                // or at the end of the total reading
                //consumer.commitSync();
            }
        }
    }
}
