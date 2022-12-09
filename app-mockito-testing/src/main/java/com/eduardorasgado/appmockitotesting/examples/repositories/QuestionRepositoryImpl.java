package com.eduardorasgado.appmockitotesting.examples.repositories;

import java.util.Arrays;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {

    @Override
    public List<String> findByExamId(Long id) {
        System.out.println("QuestionRepositoryImpl.findByExamId");
        return Arrays.asList(
                "Arithmetics",
                "Derivatives",
                "Linear Algebra",
                "Differential Equations"
        );
    }

    @Override
    public void saveAll(List<String> questions) {
        System.out.println("QuestionRepositoryImpl.saveAll");
    }
}
