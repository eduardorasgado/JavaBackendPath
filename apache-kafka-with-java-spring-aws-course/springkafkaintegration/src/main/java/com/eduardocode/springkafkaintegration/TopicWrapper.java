package com.eduardocode.springkafkaintegration;

import org.springframework.beans.factory.annotation.Value;

public class TopicWrapper {
    protected final String topicPropPath = "${broker.topic}";

    protected final String TOPIC;

    public TopicWrapper(String TOPIC) {
        this.TOPIC = TOPIC;
    }
}
