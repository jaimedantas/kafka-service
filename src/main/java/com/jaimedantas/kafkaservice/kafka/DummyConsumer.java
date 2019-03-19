package com.jaimedantas.kafkaservice.kafka;

import com.jaimedantas.Payment;
import com.jaimedantas.Register;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DummyConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(DummyConsumer.class);

    @Autowired
    DummyProducer producer;

    @KafkaListener(topics = "brazil")
    public void listen(@Payload Payment message) {
        LOG.info("received message='{}'", message.toString());
        Register register = new Register();
        register.setId(message.getId());
        register.setStatus("ok");
        producer.send(register);
    }

}