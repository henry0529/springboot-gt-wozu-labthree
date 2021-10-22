package edu.cpcc.labs.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cpcc.labs.model.Greeting;


@RestController
public class GreetingController {
	
	 
    private static final String template = "Greetings, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/api/greetings/greeting")
    // http://localhost:8080/api/greetings/greeting?name=henry
    // Example: /api/greetings/greeting?name=john
    // public constructor. The name to be passed in is optional and will default to "User" if not specified
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
    	Greeting greeting = null;
    	// the counter value odd(1, 3, 5)
    	long newCounter = 0; //initialize
    	
    	newCounter = counter.incrementAndGet();
    	
    	if (newCounter % 2 !=0) {
    		// an odd number greeting...display it... don't display even number readings...
    		String templateWithName = String.format(template, name);
    		greeting = new Greeting(newCounter, templateWithName);
    		System.out.println(greeting.toString());
    	}

        return greeting;
        
    }

}