package com.eduardorasgado.appmockitotesting.examples.services;

import com.eduardorasgado.appmockitotesting.examples.models.Exam;
import com.eduardorasgado.appmockitotesting.examples.repositories.ExamRepositoryImpl;
import com.eduardorasgado.appmockitotesting.examples.repositories.QuestionRepositoryImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExamServiceImplSpyTest {

    // Spy requires an implemented class
    @Spy
    private ExamRepositoryImpl examRepository;

    @Spy
    private QuestionRepositoryImpl questionRepository;

    @InjectMocks
    private ExamServiceImpl examService;

    @DisplayName("Spies testing")
    @Test
    void testSpy(TestInfo testInfo, TestReporter testReporter) throws CloneNotSupportedException {
        testReporter.publishEntry("Evaluating " + testInfo.getTestMethod().get().getName());

        doReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS).when(questionRepository).findByExamId(anyLong());

        Exam expectedExam = ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.MATH_EXAM_INDEX).clone();
        expectedExam.setQuestions(List.copyOf(ExamServiceTestingData.MATH_EXAM_QUESTIONS));

        Exam exam = examService.findByNameWithQuestions(expectedExam.getName());

        assertAll(
                () -> assertEquals(expectedExam.getId(), exam.getId(), "actual id should be " + expectedExam.getId()),
                () -> assertEquals(expectedExam.getName(), exam.getName(), "actual name should be " + expectedExam.getName()),
                () -> assertEquals(expectedExam.getQuestions().size(), exam.getQuestions().size(),
                        "actual question size should be " + expectedExam.getQuestions().size()),
                () -> assertTrue(exam.getQuestions().contains("Derivatives"),
                        "actual exam questions should contains an element called Derivatives")
        );

        verify(examRepository).findAll();
        verify(questionRepository).findByExamId(anyLong());
    }
}
