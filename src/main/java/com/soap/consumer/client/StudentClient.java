package com.soap.consumer.client;

import com.soap.consuming.wsdl.GetStudentRequest;
import com.soap.consuming.wsdl.GetStudentResponse;
import com.soap.consuming.wsdl.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class StudentClient extends WebServiceGatewaySupport {
    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    public GetStudentResponse getStudent(Long id){
        GetStudentRequest request = OBJECT_FACTORY.createGetStudentRequest();
        request.setId(id);

        return (GetStudentResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

}
