package com.eduardocode.kafka.assignseek;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class CheetosAssignSeekConsumer {

    private static final String VANILLA_TOPIC = "vanilla-topic";

    private static final int TOPIC_PARTITION = 0; // where consumer previously allocated producers messages.

    private static final Logger logger = LoggerFactory.getLogger(CheetosAssignSeekConsumer.class);

    public static void main(String[] args) {
        Properties props = new Properties();

        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "vanilla-group");
        props.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.setProperty(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, Integer.toString(1000));
        props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getCanonicalName());
        props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getCanonicalName());

        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        try(Consumer<String, String> consumer = new KafkaConsumer<>(props)) {
            TopicPartition topicPartition = new TopicPartition(VANILLA_TOPIC, 0);

            // assign: to assign this consumer an specific partition to read from
            consumer.assign(List.of(topicPartition));
            // seek: to start reading on a certain partition at selected offset
            consumer.seek(topicPartition, 50);

            while (true) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, String> record : consumerRecords) {
                    logger.info("Offset = {}, Partition = {}, Key = {}, Value = {}",
                            record.offset(), record.partition(), record.key(), record.value());
                }
            }
        }
    }
}
