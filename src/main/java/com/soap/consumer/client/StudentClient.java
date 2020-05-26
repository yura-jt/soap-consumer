package com.soap.consumer.client;

import com.soap.consuming.wsdl.GetStudentRequest;
import com.soap.consuming.wsdl.GetStudentResponse;
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

}
