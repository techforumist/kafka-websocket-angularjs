package org.techforumist.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.techforumist.websocket.CounterHandler;

/**
 * @author Sarath Muraleedharan
 *
 */
public class Receiver {

	@Autowired
	CounterHandler counterHandler;
	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = "${kafka.topic.topic-name}")
	public void receive(String message) {
		System.out.println("received message=" + message);
		counterHandler.sendMessage(message);
		latch.countDown();
	}
}
