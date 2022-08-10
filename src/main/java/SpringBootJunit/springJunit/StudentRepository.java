package SpringBootJunit.springJunit;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    public Student findByFullName(String fullName);

    public Student findStudentsById(Integer id);
}
