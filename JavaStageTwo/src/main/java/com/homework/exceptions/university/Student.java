package com.homework.exceptions.university;


import com.homework.exceptions.Pair;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class Student {
    private final Map<Subject, Integer> subjectsGrades = new EnumMap<>(Subject.class);

    Student(Pair<Subject, Integer>[] subjectsGrades) {
        for (Pair<Subject, Integer> pair: subjectsGrades) {
            this.subjectsGrades.put(pair.getFirst(), pair.getSecond());
        }
    }

    public boolean hasSubject(Subject subject) {
        return subjectsGrades.get(subject) != null;
    }

    public int getGradeForSubjectIfExists(Subject subject) {
        if (subjectsGrades.get(subject) != null)
            return this.subjectsGrades.get(subject);

        return -1;
    }

    public double getAverageGrade() {
        int gradesSum = 0;
        for (Integer grade: this.subjectsGrades.values())
            gradesSum += grade;

        return (double) gradesSum / this.subjectsGrades.values().size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(subjectsGrades, student.subjectsGrades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectsGrades);
    }
}
