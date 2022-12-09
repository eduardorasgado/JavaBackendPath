package com.eduardorasgado.appmockitotesting.examples.repositories;

import com.eduardorasgado.appmockitotesting.examples.models.Exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExamRepositoryImpl implements ExamRepository {

    @Override
    public List<Exam> findAll() {
        System.out.println("ExamRepositoryImpl.findAll");
        //return Collections.emptyList();
        return Arrays.asList(
                new Exam(5L, "Spanish"),
                new Exam(6L, "Math"),
                new Exam(7L, "History")
        );
    }

    @Override
    public Exam save(Exam exam) throws CloneNotSupportedException {
        System.out.println("ExamRepositoryImpl.save");
        return exam.clone();
    }
}
