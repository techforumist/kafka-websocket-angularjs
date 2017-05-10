package org.techforumist;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.techforumist.kafka.producer.Sender;

/**
 * @author Sarath Muraleedharan
 *
 */
@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}
}

/**
 * @author Sarath Muraleedharan
 *
 */
@RestController
class HomeController {
	@Autowired
	Sender sender;

	@RequestMapping("/sendMessage")
	public Object home(@RequestParam String message) {
		Map<String, Object> result = new HashMap<>();
		sender.send("test_topic", message);
		return result;
	}
}