package com.nachiket.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
  //To listen from the kafka library we will create this listener
  //This will subscribe the javaguides topic
  //There can be multiple subscriber for the single topic
  @KafkaListener(topics = "javaguides",groupId = "myGroup")
  public void consume(String message){
    LOGGER.info("Message received :--> {}",message);
  }

}
