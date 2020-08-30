package com.homework.exceptions;

import com.homework.exceptions.university.Subject;
import com.homework.exceptions.university.University;
import com.homework.exceptions.university.exceptions.*;


public class Runner {
    public static void main(String[] args) throws NoFacultiesAtUniversityException  {
        University university = new University(3);
        university.addGroupsToFaculty(0, 1);
        university.addGroupsToFaculty(2, 1);

        try {
            university.addStudent(0, 0, new Pair<>(Subject.AUTOMATION, 9),
                    new Pair<>(Subject.OOP, 8), new Pair<>(Subject.DATABASES, 9));
            university.addStudent(0, 0, new Pair<>(Subject.AUTOMATION, 6));

            university.addStudent(2, 0, new Pair<>(Subject.AUTOMATION, 8),
                    new Pair<>(Subject.OOP, 5), new Pair<>(Subject.DATABASES, 5));
            university.addStudent(2, 0, new Pair<>(Subject.AUTOMATION, 4),
                    new Pair<>(Subject.DATABASES, 8));
        } catch (GradeOutOfBoundsException | StudentHasNoSubjectsException e) {
            System.out.println("all your base are belong to us");
        }


        try {
            System.out.println("AVERAGE GRADE FOR AUTOMATION IN PARTICULAR GROUP: " +
                    Math.round(university.
                            getAverageGradeOfSubjectInGroup(Subject.AUTOMATION, 0, 0) * 100.0) / 100.0);
        } catch (NoGroupsAtFacultyException | NoStudentsInGroupException e) {
            e.printStackTrace();
        }

        System.out.println("AVERAGE GRADE FOR DATABASES: "
                + (Math.round(university.getAverageGradeOfSubjectAtUniversity(Subject.DATABASES) * 100.0)) / 100.0);

        System.out.println("AVERAGE GRADE OF A PARTICULAR STUDENT: "
                + (Math.round(university.getStudentsAverageGrade(0, 0, 0) * 100.0)) / 100.0);
    }
}
