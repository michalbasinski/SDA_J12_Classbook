package pl.sda;

import java.util.List;
import java.util.Map;

public class Student {
    private int studentId;
    private String name;
    private String lastName;
    private Sex sex;
    private Map<SchoolSubject, List<Double>> grades;
}
