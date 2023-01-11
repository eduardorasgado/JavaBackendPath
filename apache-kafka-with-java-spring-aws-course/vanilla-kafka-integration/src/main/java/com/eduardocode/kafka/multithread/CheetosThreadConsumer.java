package com.eduardocode.kafka.multithread;

import com.eduardocode.kafka.consumers.CheetosConsumer;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CheetosThreadConsumer extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(CheetosThreadConsumer.class);

    // To enable thread safe feature
    private final AtomicBoolean closed = new AtomicBoolean(false);

    private final Consumer<String, String> consumer;
    private final String TOPIC;
    private final int POLLING_TIME_FRAME;

    public CheetosThreadConsumer(Consumer<String, String> consumer, String topic, int timeFrame) {
        this.consumer = consumer;
        TOPIC = topic;
        POLLING_TIME_FRAME = timeFrame;
    }

    @Override
    public void run() {
        consumer.subscribe(List.of(TOPIC));

        try {
            while(!closed.get()) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(POLLING_TIME_FRAME));

                for (ConsumerRecord<String, String> record : consumerRecords) {
                    logger.debug("Offset = {}, Partition = {}, Key = {}, Value = {}",
                            record.offset(), record.partition(), record.key(), record.value());

                    // print every n messages
                    if(Integer.parseInt(record.value()) % 10000 == 0) {
                        logger.info("Offset = {}, Partition = {}, Key = {}, Value = {}",
                                record.offset(), record.partition(), record.key(), record.value());
                    }
                }
            }
        } catch (WakeupException ex) {
            logger.error("An exception occurred while shutting down the consumer", ex);

            // if this execption ocurs and thi thread should be on, propagate the exception
            if(!closed.get()) {
                throw ex;
            }
        } finally {
            consumer.close();
        }
    }

    // this method is used by the ThreadPool, to make it stop it on receiving new tasks and await for threads to answer
    public void shutdown() {
        closed.set(true);
        // It is thread-safe and is useful in particular to abort a long poll
        consumer.wakeup();
    }
}
