package com.eduardorasgado.appmockitotesting.examples.repositories;

import java.util.List;

public interface QuestionRepository {
    List<String> findByExamId(Long id);
}
