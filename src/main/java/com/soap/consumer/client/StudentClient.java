package com.soap.consumer.client;

import com.soap.consuming.wsdl.AddStudentRequest;
import com.soap.consuming.wsdl.AddStudentResponse;
import com.soap.consuming.wsdl.GetStudentRequest;
import com.soap.consuming.wsdl.GetStudentResponse;
import com.soap.consuming.wsdl.StudentSoapDto;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class StudentClient extends WebServiceGatewaySupport {

    public GetStudentResponse getStudent(Long id) {
        GetStudentRequest request = new GetStudentRequest();
        request.setId(id);

        GetStudentResponse response = (GetStudentResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/students", request,
                        new SoapActionCallback(
                                "http://soap.producer/GetStudentRequest"));

        return response;
    }

    public AddStudentResponse addStudent(StudentSoapDto studentSoapDto) {
        AddStudentRequest request = new AddStudentRequest();
        request.setStudent(studentSoapDto);

        return (AddStudentResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/students", request,
                        new SoapActionCallback(
                                "http://soap.producer/AddStudentRequest"));
    }

}
