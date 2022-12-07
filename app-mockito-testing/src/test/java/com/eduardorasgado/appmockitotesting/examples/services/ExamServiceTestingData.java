package com.eduardorasgado.appmockitotesting.examples.services;

import com.eduardorasgado.appmockitotesting.examples.models.Exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExamServiceTestingData {
    public static int MATH_EXAM_INDEX = 1;
    public static int SPANISH_EXAM_INDEX = 0;
    public static List<Exam> EXAM_LIST = Arrays.asList(
            new Exam(5L, "Spanish"),
            new Exam(6L, "Math"),
            new Exam(7L, "History")
    );

    public static List<Exam> ID_NULL_EXAM_LIST = Arrays.asList(
            new Exam(null, "Spanish"),
            new Exam(null, "Math"),
            new Exam(null, "History")
    );

    public static final List<Exam> NEGATIVE_ID_EXAM_LIST = Arrays.asList(
            new Exam(-5L, "Spanish"),
            new Exam(-6L, "Math"),
            new Exam(-7L, "History")
    );
    public static List<Exam> EMPTY_EXAM_LIST = Collections.emptyList();

    public static List<String> MATH_EXAM_QUESTIONS = Arrays.asList(
            "Arithmetics",
            "Derivatives",
            "Linear Algebra",
            "Differential Equations"
    );

    public static final Exam PHYSICS_EXAM = new Exam(null, "Physics");

    public static List<String> PHYSICS_EXAM_QUESTIONS = Arrays.asList(
            "Kinematics",
            "Motion",
            "Energy",
            "Gravitation"
    );
}
