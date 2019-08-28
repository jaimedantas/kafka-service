package com.jaimedantas.kafkaservice.kafka;

import com.jaimedantas.Payment;
import com.jaimedantas.Register;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DummyProducer {

    private static final Logger LOG = LoggerFactory.getLogger(DummyProducer.class);

    @Autowired
    private KafkaTemplate<String, Register> kafkaTemplate;

    private String topic = "topic-jaime4";

    public void send(Register message){
        LOG.info("sending message='{}' to topic='{}'", message.toString(), topic);
        kafkaTemplate.send(topic, message);
    }
}