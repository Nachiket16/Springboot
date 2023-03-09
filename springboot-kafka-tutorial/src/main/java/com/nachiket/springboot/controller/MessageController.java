package com.nachiket.springboot.controller;

import com.nachiket.springboot.kafka.KafkaProducer;
import org.apache.kafka.common.protocol.types.Field.Str;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

  private KafkaProducer kafkaProducer;

  //http://localhost:8080/api/v1/kafka/publish?message=hello
  public MessageController(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }


  @GetMapping("/publish")
  public ResponseEntity<String> publish(@RequestParam("message") String message) {
    kafkaProducer.sendMessage(message);
    return ResponseEntity.ok("Message sent to the topic");
  }
}
