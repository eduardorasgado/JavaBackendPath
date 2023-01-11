package com.eduardocode.springkafkaintegration.components.producers;

import com.eduardocode.springkafkaintegration.components.TopicPathWrapper;

public class TopicWrapper extends TopicPathWrapper {

    protected final String TOPIC;

    public TopicWrapper(String TOPIC) {
        this.TOPIC = TOPIC;
    }
}
