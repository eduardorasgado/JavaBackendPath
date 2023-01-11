package com.eduardocode.springkafkaintegration;

import org.springframework.beans.factory.annotation.Value;

public class TopicWrapper {
    protected static final String topicPropPath = "${broker.topic}";

    protected final String TOPIC;

    public TopicWrapper(String TOPIC) {
        this.TOPIC = TOPIC;
    }
}
