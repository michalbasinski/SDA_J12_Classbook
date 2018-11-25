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
        final Double grade1 = 4.0;
        final Double grade2 = 4.5;
        final Double grade3 = 3.0;
        final Double expectedAverage = 3.8;

        //when
        student.addGrade(subject, grade1);
        student.addGrade(subject, grade2);
        student.addGrade(subject, grade3);
        Double average = student.getFinalGrade(subject);

        //then
        Assert.assertEquals(expectedAverage, average, 0.05);
    }
}
