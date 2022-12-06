package com.eduardorasgado.appmockitotesting.examples.repositories;

import com.eduardorasgado.appmockitotesting.examples.models.Exam;

import java.util.List;

public interface ExamRepository {
    List<Exam> findAll();
}
