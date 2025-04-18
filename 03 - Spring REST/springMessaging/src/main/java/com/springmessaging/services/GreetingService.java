package com.springmessaging.services;

import com.springmessaging.entities.Greeting;
import com.springmessaging.repositories.IGreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    private final IGreetingRepository greetingRepository;

    public GreetingService(IGreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting getSimpleGreeting(){
        return Greeting.builder().message("Hello World!").build();
    }

    public List<Greeting> getGreeting() {
        return greetingRepository.findAll();
    }

    public Greeting addGreeting(String firstName, String lastName) {
        Greeting greeting = Greeting.builder().message(("Hello " + firstName + " " + lastName).trim()).build();
        greetingRepository.save(greeting);
        return greeting;
    }
}
