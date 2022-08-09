package SpringBootJunit.springJunit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentTests {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Rollback(value = false)
    public void testCreateStudent() {
        Student student = new Student("Henry", 2, 3, 4);
        Student savedStudent = studentRepository.save(student);

        assertNotNull(savedStudent);
    }

    @Test
    @Rollback(value = false)
    public void findByKeyWordStudentSuccess() {
        String fullName = "Eric Dang";
        Student student = studentRepository.findByFullName(fullName);

        assertThat(student.getFullName()).isEqualTo(fullName);
    }

    @Test
    @Rollback(value = false)
    public void findByKeyWordStudentFails() {
        String fullName = "Eric";
        Student student = studentRepository.findByFullName(fullName);

        assertThat(student.getFullName()).isEqualTo(fullName);
    }

    @Test
    @Rollback(value = false)
    public void updateStudent() {
        String fullName = "Eric Dang";

        Student student = new Student(fullName, 2, 3, 4);
        student.setId(2);

        studentRepository.save(student);
        Student updateStudent = studentRepository.findByFullName(fullName);

        assertThat(updateStudent.getFullName()).isEqualTo(fullName);
    }

    @Test
    public void getAllStudents() {
        List<Student> students = (List<Student>) studentRepository.findAll();
        assertThat(students).size().isGreaterThan(0);
    }

    @Test
    public void deleteStudent() {
        Integer id = 2;

        boolean testBeforeDeleteStudent =  studentRepository.findById(id).isPresent();
        studentRepository.deleteById(id);
        boolean testAfterDeleteStudent = studentRepository.findById(id).isPresent();

        assertTrue(testBeforeDeleteStudent);
        assertFalse(testAfterDeleteStudent);
    }
}
