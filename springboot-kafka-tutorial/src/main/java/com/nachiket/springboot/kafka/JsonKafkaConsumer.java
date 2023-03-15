package com.nachiket.springboot.kafka;

import com.nachiket.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

  @KafkaListener(topics = "javaguides_json", groupId = "myGroup")
  private void consume(User user){
    LOGGER.info("Json Message Received :--> {}",user.toString());
  }

}
