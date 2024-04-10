package lt.viko.eif.pvaiciulis.studentsoapexample.db;

import lt.viko.eif.pvaiciulis.studentsoapexample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Long> {

}
