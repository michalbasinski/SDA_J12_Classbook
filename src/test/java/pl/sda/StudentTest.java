package pl.sda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        student = new Student(1,"Jas", "Nowak", Sex.MALE);
    }

    @Test
    public void shouldAddNewGradeSuccessfully() {
        //given
        final Double grade = 4.0;
        final SchoolSubject subject = SchoolSubject.MATH;
        final List<Double> expectedGrades = Arrays.asList(4.0);

        //when
        student.addGrade(subject, grade);
        List<Double> grades = student.getGrades(subject);

        //then
        Assert.assertEquals(expectedGrades, grades);
    }

    @Test
    public void shouldComputeFinalGrade() {
        //given
        final SchoolSubject subject = SchoolSubject.MATH;
        final Double expectedAverage = 4.0;
        prepareGrades();

        //when
        Double average = student.getFinalGrade(subject);

        //then
        Assert.assertEquals(expectedAverage, average, 0.05);
    }

    @Test
    public void shouldComputeAverageFromManySubjects() {
        //given
        prepareGrades();
        final Double expectedAverage = 4.0;

        //when
        Double average = student.getAverage();

        //then
        Assert.assertEquals(expectedAverage, average);
    }

    private void prepareGrades() {
        student.addGrade(SchoolSubject.MATH, 4.0);
        student.addGrade(SchoolSubject.MATH, 4.5);
        student.addGrade(SchoolSubject.MATH, 3.0);

        student.addGrade(SchoolSubject.CHEMISTY, 3.0);
        student.addGrade(SchoolSubject.CHEMISTY, 3.5);
        student.addGrade(SchoolSubject.CHEMISTY, 4.0);
    }
}
