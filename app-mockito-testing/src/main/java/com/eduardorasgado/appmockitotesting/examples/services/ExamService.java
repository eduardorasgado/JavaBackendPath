package com.eduardorasgado.appmockitotesting.examples.services;

import com.eduardorasgado.appmockitotesting.examples.models.Exam;

import java.util.Optional;

public interface ExamService {
    Optional<Exam> findByName(String name);

    Exam findByNameWithQuestions(String name);

    Exam save(Exam exam);
}
