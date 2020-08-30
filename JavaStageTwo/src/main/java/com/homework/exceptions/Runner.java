package com.homework.exceptions;

import com.homework.exceptions.university.Subjects;
import com.homework.exceptions.university.University;
import com.homework.exceptions.university.exceptions.GradeOutOfBoundsException;
import com.homework.exceptions.university.exceptions.NoFacultiesAtUniversityException;
import com.homework.exceptions.university.exceptions.NoGroupsAtFacultyException;



public class Runner {
    public static void main(String[] args) throws NoFacultiesAtUniversityException, GradeOutOfBoundsException {
        University university = new University(3);
        university.addGroupsToFaculty(0, 1);
        university.addGroupsToFaculty(2, 1);


        university.addStudent(0, 0, new Pair<>(Subjects.AUTOMATION, 9),
                new Pair<>(Subjects.OOP, 8));
        university.addStudent(0, 0, new Pair<>(Subjects.AUTOMATION, 6));

        university.addStudent(2, 0, new Pair<>(Subjects.AUTOMATION, 8),
                new Pair<>(Subjects.OOP, 5), new Pair<>(Subjects.DATABASES, 5));
        university.addStudent(2, 0, new Pair<>(Subjects.AUTOMATION, 4),
                new Pair<>(Subjects.DATABASES, 5));

        try {
            university.getAverageGradeOfSubjectInGroup(Subjects.AUTOMATION, 0, 1);
        } catch (NoGroupsAtFacultyException e) {
            e.printStackTrace();
        }
    }
}
