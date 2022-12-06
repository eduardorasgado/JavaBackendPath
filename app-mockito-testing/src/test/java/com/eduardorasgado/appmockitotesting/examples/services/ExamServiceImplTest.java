package com.eduardorasgado.appmockitotesting.examples.services;

import com.eduardorasgado.appmockitotesting.examples.models.Exam;
import com.eduardorasgado.appmockitotesting.examples.repositories.ExamRepository;
import com.eduardorasgado.appmockitotesting.examples.repositories.ExamRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExamServiceImplTest {

    @DisplayName("Find exam by name")
    @Test
    void findExamByName() {
        //ExamRepository repository = new ExamRepositoryImpl();
        ExamRepository repository = mock(ExamRepository.class);
        ExamService service = new ExamServiceImpl(repository);

        List<Exam> exams = Arrays.asList(
                new Exam(5L, "Math"),
                new Exam(6L, "Spanish"),
                new Exam(7L, "History")
        );

        when(repository.findAll()).thenReturn(exams);

        Optional<Exam> exam = service.findByName("Math");

        assertTrue(exam.isPresent(), () -> "Exam should be present");
        assertEquals(5L, exam.orElseThrow().getId(), () -> "Exam should not be equals to 5");
        assertEquals("Math", exam.orElseThrow().getName(), () -> "Exam name should be equals to 'Math'");
    }

    @DisplayName("Find exam by name when empty list is retrieved")
    @Test
    void findExamByNameWhenEmptyListIsReturned() {
        //ExamRepository repository = new ExamRepositoryImpl();
        ExamRepository repository = mock(ExamRepository.class);
        ExamService service = new ExamServiceImpl(repository);

        List<Exam> exams = Collections.emptyList();

        when(repository.findAll()).thenReturn(exams);

        Optional<Exam> exam = service.findByName("Math");

        assertTrue(exam.isEmpty(), () -> "Exam should not be present");
    }
}