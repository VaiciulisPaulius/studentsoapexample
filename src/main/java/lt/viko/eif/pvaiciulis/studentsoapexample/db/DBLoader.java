package lt.viko.eif.pvaiciulis.studentsoapexample.db;

import lt.viko.eif.pvaiciulis.studentsoapexample.model.Account;
import lt.viko.eif.pvaiciulis.studentsoapexample.model.Student;
import lt.viko.eif.pvaiciulis.studentsoapexample.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBLoader {

    private StudentJpaRepository studentJpaRepository;

    @Autowired
    public void DataLoader(StudentJpaRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
        loadStudents();
    }
    public void loadStudents() {
        Student studentA = new Student("Paulius", "Vaiciulis", "s046598");

        Account studentAAccount = new Account("user1", "user321");
        studentA.setAccount(studentAAccount);

        Subject math = new Subject("Math", 6);
        Subject english = new Subject("English", 6);
        Subject psychology = new Subject("Psychology", 3);

        studentJpaRepository.save(studentA);
    }
}
