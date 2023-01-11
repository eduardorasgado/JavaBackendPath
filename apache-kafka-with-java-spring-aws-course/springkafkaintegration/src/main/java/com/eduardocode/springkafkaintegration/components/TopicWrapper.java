package com.eduardocode.springkafkaintegration.components;

public class TopicWrapper extends TopicPathWrapper{

    protected final String TOPIC;

    public TopicWrapper(String TOPIC) {
        this.TOPIC = TOPIC;
    }
}
