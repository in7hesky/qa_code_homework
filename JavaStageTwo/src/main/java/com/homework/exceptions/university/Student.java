package com.homework.exceptions.university;


import com.homework.exceptions.Pair;

import java.util.EnumMap;
import java.util.Map;

public class Student {
    private final Map<Subjects, Integer> subjectsGrades = new EnumMap<>(Subjects.class);

    Student(Pair<Subjects, Integer>[] subjectsGrades) {
        for (Pair<Subjects, Integer> pair: subjectsGrades) {
            this.subjectsGrades.put(pair.getFirst(), pair.getSecond());
        }
    }

    public int getGradeForSubject(Subjects subject) {
        return this.subjectsGrades.get(subject);
    }

    public double getAverageGrade() {
        int gradesSum = 0;
        for (Integer grade: this.subjectsGrades.values())
            gradesSum += grade;

        return (double) gradesSum / this.subjectsGrades.values().size();
    }
}
