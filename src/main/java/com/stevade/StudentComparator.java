package com.stevade;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        if (firstStudent.getCgpa() == secondStudent.getCgpa())
            return firstStudent.getName().compareTo(secondStudent.getName());
        else if ((firstStudent.getCgpa() == secondStudent.getCgpa()) && (firstStudent.getName().equals(secondStudent.getName())))
            return Integer.compare(firstStudent.getId(), secondStudent.getId());
        else
            return Double.compare(secondStudent.getCgpa(), firstStudent.getCgpa());
    }
}
