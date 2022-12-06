package com.eduardorasgado.appmockitotesting.examples.repositories;

import com.eduardorasgado.appmockitotesting.examples.models.Exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExamRepositoryImpl implements ExamRepository {

    @Override
    public List<Exam> findAll() {

        return Collections.emptyList();
    /*    return Arrays.asList(
                new Exam(5L, "Math"),
                new Exam(6L, "Spanish"),
                new Exam(7L, "History")
        );*/
    }
}
