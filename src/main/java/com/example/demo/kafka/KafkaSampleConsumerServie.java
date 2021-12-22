package com.example.demo.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class KafkaSampleConsumerServie {
	@KafkaListener(topics="oingd",groupId="group-id-org")
	public void consume(String message) throws IOException{
		System.out.println("receive msg :" + message);
	}
}
