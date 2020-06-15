package com.soap.consumer;

import com.soap.consumer.client.StudentClient;
import com.soap.consuming.wsdl.AddStudentResponse;
import com.soap.consuming.wsdl.GetStudentResponse;
import com.soap.consuming.wsdl.StudentSoapDto;
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

    @Bean
    CommandLineRunner save(StudentClient client) {
        return args -> {
            StudentSoapDto newStudent = new StudentSoapDto();
            newStudent.setFirstName("John");
            newStudent.setLastName("Snow");
            newStudent.setEmail("john.snow@gma1l.com");
            newStudent.setAge(22);
            newStudent.setGroupNumber(5);

            AddStudentResponse response = client.addStudent(newStudent);
            System.err.println(response.getStudent().getFirstName());
        };
    }

}
