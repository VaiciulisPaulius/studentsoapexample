package lt.viko.eif.pvaiciulis.studentsoapexample.endpoint;

import lt.viko.eif.pv.springsoap.gen.GetStudentRequest;
import lt.viko.eif.pv.springsoap.gen.GetStudentResponse;
import lt.viko.eif.pvaiciulis.studentsoapexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {
    private static final String NAMESPACE_URI = "http://eif.viko.lt/pv/springsoap/gen";

    private StudentService studentService;

    @Autowired
    public StudentEndpoint(StudentService countryRepository) {
        this.studentService = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
    @ResponsePayload
    public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
        GetStudentResponse response = new GetStudentResponse();
        response.setStudent(studentService.findStudent(request.getName()));

        return response;
    }
}
