package com.homework.exceptions.university;

import com.homework.exceptions.Pair;
import com.homework.exceptions.university.exceptions.*;


import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<ArrayList<ArrayList<Student>>> facultiesAndGroupsTable = new ArrayList<>();

    public University(int amountOfFacultiesToEstablish) throws NoFacultiesAtUniversityException {
        if (amountOfFacultiesToEstablish < 1)
            throw new NoFacultiesAtUniversityException();

        for (int i = 0; i < amountOfFacultiesToEstablish; i++)
            facultiesAndGroupsTable.add(new ArrayList<>());
    }

    public void addGroupsToFaculty(int facultyId, int amountOfGroups) {
        for (int i = 0; i < amountOfGroups; i++)
            facultiesAndGroupsTable.get(facultyId).add(new ArrayList<>());
    }

    @SafeVarargs
    public final void addStudent
            (int facultyId, int groupId, Pair<Subject, Integer>... subjectsGrades)
            throws GradeOutOfBoundsException, StudentHasNoSubjectsException {
        if (subjectsGrades.length == 0)
            throw new StudentHasNoSubjectsException();

        for (Pair<Subject, Integer> pair: subjectsGrades) {
            if (pair.getSecond() < 0 || pair.getSecond() > 10)
                throw new GradeOutOfBoundsException();
        }

        facultiesAndGroupsTable.get(facultyId).get(groupId).add(new Student(subjectsGrades));
    }

    public double getAverageGradeOfSubjectInGroup
            (Subject subject, int facultyId, int groupId)
            throws NoGroupsAtFacultyException, NoStudentsInGroupException {

        if (facultiesAndGroupsTable.get(facultyId).isEmpty())
            throw new NoGroupsAtFacultyException();

        List<Student> chosenGroup =  facultiesAndGroupsTable.get(facultyId).get(groupId);

        if (chosenGroup.isEmpty())
            throw new NoStudentsInGroupException();

        int gradesOfSubjectInGroupSum = 0;
        for (Student student : chosenGroup)
            gradesOfSubjectInGroupSum += student.getGradeForSubjectIfExists(subject);

        return (double)gradesOfSubjectInGroupSum / chosenGroup.size();
    }

    public double getAverageGradeOfSubjectAtUniversity(Subject subject) {
        int amountOfTrackedStudents = 0;
        int sumOfSubjectsGrades = 0;

        for (ArrayList<ArrayList<Student>> faculty : facultiesAndGroupsTable)
            for (ArrayList<Student> group : faculty)
                for (Student student : group)
                    if(student.hasSubject(subject)) {
                        sumOfSubjectsGrades += student.getGradeForSubjectIfExists(subject);
                        amountOfTrackedStudents++;
                    }

        return (double) sumOfSubjectsGrades / amountOfTrackedStudents;
    }

    public double getStudentsAverageGrade(int facultyId, int groupId, int studentId) {
        return facultiesAndGroupsTable.get(facultyId).get(groupId).get(studentId).getAverageGrade();
    }

}
