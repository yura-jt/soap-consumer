package com.soap.consumer;

import com.soap.consumer.client.StudentClient;
import com.soap.consumer.config.SoapClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class, args);

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(SoapClientConfiguration.class);
        StudentClient studentClient = annotationConfigApplicationContext.getBean(StudentClient.class);
        System.out.println(studentClient.getStudent(1L).getStudent().getFirstName());
    }

}
