package com.homework.exceptions.university;

import com.homework.exceptions.Pair;
import com.homework.exceptions.university.exceptions.GradeOutOfBoundsException;
import com.homework.exceptions.university.exceptions.NoFacultiesAtUniversityException;
import com.homework.exceptions.university.exceptions.NoGroupsAtFacultyException;


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
    public final void addStudent(int facultyId, int groupId,
                                 Pair<Subjects, Integer>... subjectsGrades) throws GradeOutOfBoundsException {
        for (Pair<Subjects, Integer> pair: subjectsGrades) {
            if (pair.getSecond() < 0 || pair.getSecond() > 10)
                throw new GradeOutOfBoundsException();
        }

        facultiesAndGroupsTable.get(facultyId).get(groupId).add(new Student(subjectsGrades));
    }

    public Student getStudent(int facultyId, int groupId, int studentId) {
        return facultiesAndGroupsTable.get(facultyId).get(groupId).get(studentId);
    }

    public double getAverageGradeOfSubjectInGroup(Subjects subject,
                                                  int facultyId, int groupId) throws NoGroupsAtFacultyException {
        if (facultiesAndGroupsTable.get(facultyId).size() == 0)
            throw new NoGroupsAtFacultyException();

        for (ArrayList<ArrayList<Student>> faculty : facultiesAndGroupsTable)
            for (ArrayList<Student> group : faculty)
                for (Student student : group)
                    System.out.println(student.getGradeForSubject(subject));


        return 1.0;
    }
}
