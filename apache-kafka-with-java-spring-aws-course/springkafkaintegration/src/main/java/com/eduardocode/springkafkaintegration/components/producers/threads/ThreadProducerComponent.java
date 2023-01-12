package com.eduardocode.springkafkaintegration.components.producers.threads;

import com.eduardocode.springkafkaintegration.components.producers.ProducerWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 This can not live with BatchListener, it creates a bug where batch listener does not wait for the secs it has to wait
 For this reason I created a project named scheduled-spring-kafka-producer to be able to run this component on a new spring project
 */

//@Component
public class ThreadProducerComponent extends ProducerWrapper implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(ThreadProducerComponent.class);

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(r -> {
        Thread thread = new Thread(r, "myThread");
        thread.setDaemon(true);

        return thread;
    });
    public static long count = 0;

    public ThreadProducerComponent(@Value(topicPropPath) String TOPIC) {
        super(TOPIC);
    }

    @Override
    public void run(String... args) {
        logger.info("[THREAD PRODUCER COMPONENT] is now running.");
        String BASE_KEY = "batch-key";

        executorService.scheduleAtFixedRate(() -> {
            kafkaTemplate.send(TOPIC, BASE_KEY, String.format("Sample message %d", count++));
        },0, 500, TimeUnit.MILLISECONDS);
    }
}
