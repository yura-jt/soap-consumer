package com.soap.consumer;

import com.soap.consumer.client.StudentClient;
import com.soap.consuming.wsdl.GetStudentResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class, args);

    }

    @Bean
    CommandLineRunner lookup(StudentClient client) {
        return args -> {
            Long id = 1L;

            if (args.length > 0) {
                id = Long.parseLong(args[0]);
            }
            GetStudentResponse response = client.getStudent(id);
            System.err.println(response.getStudent().getFirstName());
        };
    }

}
