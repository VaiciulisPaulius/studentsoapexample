package lt.viko.eif.pvaiciulis.studentsoapexample.service;

import lt.viko.eif.pvaiciulis.studentsoapexample.db.StudentJpaRepository;
import lt.viko.eif.pvaiciulis.studentsoapexample.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentJpaRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Student> list() {
        return studentRepository.findAll();
    }
    private lt.viko.eif.pv.springsoap.gen.Student convertToDto(Student student) {
        lt.viko.eif.pv.springsoap.gen.Student studentDto = modelMapper.map(student, lt.viko.eif.pv.springsoap.gen.Student.class);
        return studentDto;
    }
    public lt.viko.eif.pv.springsoap.gen.Student findStudent(String name) {
        Student student = this.list().stream()
                .filter(st -> st.getFirstName().equals(name)).findFirst().get();
        return convertToDto(student);
    }
}

