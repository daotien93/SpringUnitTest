package SpringBootJunit.springJunit;

import javax.persistence.*;

@Entity
@Table(name="test")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;

    private float pointNumberOne;
    private float pointNumberTwo;
    private float pointNumberThree;

    public Student() {
    }

    public Student(String fullName, float pointNumberOne, float pointNumberTwo, float pointNumberThree) {
        this.fullName = fullName;
        this.pointNumberOne = pointNumberOne;
        this.pointNumberTwo = pointNumberTwo;
        this.pointNumberThree = pointNumberThree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getPointNumberOne() {
        return pointNumberOne;
    }

    public void setPointNumberOne(float pointNumberOne) {
        this.pointNumberOne = pointNumberOne;
    }

    public float getPointNumberTwo() {
        return pointNumberTwo;
    }

    public void setPointNumberTwo(float pointNumberTwo) {
        this.pointNumberTwo = pointNumberTwo;
    }

    public float getPointNumberThree() {
        return pointNumberThree;
    }

    public void setPointNumberThree(float pointNumberThree) {
        this.pointNumberThree = pointNumberThree;
    }

}
