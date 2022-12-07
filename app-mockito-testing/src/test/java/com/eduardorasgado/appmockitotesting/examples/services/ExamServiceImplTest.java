package com.eduardorasgado.appmockitotesting.examples.services;

import com.eduardorasgado.appmockitotesting.examples.models.Exam;
import com.eduardorasgado.appmockitotesting.examples.repositories.ExamRepository;
import com.eduardorasgado.appmockitotesting.examples.repositories.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// to enable mockito annotations in order to be able to inject dependencies
@ExtendWith(MockitoExtension.class)
class ExamServiceImplTest {

    @Mock
    private ExamRepository examRepository;

    @Mock
    private QuestionRepository questionRepository;

    // without injecting it using mockito annotations, we are able to use the interface as dependency inversion principle states
    //private ExamService examService;

    // by using inject mocks annotation, now we have to use an implementation to inject mocks
    @InjectMocks
    private ExamServiceImpl examService;


    /*
    @BeforeEach
    void setUp() {
        //ExamRepository repository = new ExamRepositoryImpl();


        //examRepository = mock(ExamRepository.class);
        //questionRepository = mock(QuestionRepository.class);

        //examService = new ExamServiceImpl(examRepository, questionRepository);

        // dependency injection mockito's way of testing services and repos
        //MockitoAnnotations.openMocks(this);
    }*/

    @DisplayName("Find exam by name")
    @Test
    void testFindExamByName() {
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);

        Optional<Exam> exam = examService.findByName("Math");
        Exam expectedExam = ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.MATH_EXAM_INDEX);

        assertTrue(exam.isPresent(), () -> "Exam should be present");
        assertEquals(expectedExam.getId(), exam.orElseThrow().getId(),
                () -> "Exam should not be equals to " + expectedExam.getId());
        assertEquals(expectedExam.getName(), exam.orElseThrow().getName(),
                () -> "Exam name should be equals to '" + expectedExam.getName() + "'");
    }

    @DisplayName("Find exam by name when empty list is retrieved")
    @Test
    void testFindExamByNameWhenEmptyListIsReturned() {
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EMPTY_EXAM_LIST);

        Optional<Exam> exam = examService.findByName("Math");

        assertTrue(exam.isEmpty(), () -> "Exam should not be present");
    }

    @DisplayName("Find exam questions by exam name")
    @Test
    void testFindExamQuestionsByExamName() {
        Exam mathExam = ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.MATH_EXAM_INDEX);

        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);
        //when(questionRepository.findByExamId(ArgumentMatchers.anyLong())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);
        when(questionRepository.findByExamId(mathExam.getId())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);


        Exam examFound = examService.findByNameWithQuestions(mathExam.getName());

        assertNotNull(examFound.getQuestions(), () -> "Exam found questions should not be null");
        assertTrue(examFound.getQuestions().contains("Differential Equations"),
                () -> "exam found questions should contains 'Differential Equations'");
        assertEquals(4, examFound.getQuestions().size(),
                () -> "Exam found questions are waiting for 4 items, received different size");
    }

    @DisplayName("Verify exam questions by exam name")
    @Test
    void testVerifyExamQuestionsByExamName() {
        // Given
        Exam mathExam = ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.MATH_EXAM_INDEX);

        // When
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);
        when(questionRepository.findByExamId(mathExam.getId())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);

        Exam examFound = examService.findByNameWithQuestions(mathExam.getName());

        // Then
        assertNotNull(examFound.getQuestions(), () -> "Exam found questions should not be null");
        verify(examRepository, times(1)).findAll();
        verify(questionRepository, times(1)).findByExamId(mathExam.getId());
    }

    // Given when and then: Behavioral Driven Development
    @DisplayName("Assert save exam")
    @Test
    void testSaveExam() throws CloneNotSupportedException {
        // Given
        Exam newExam = ExamServiceTestingData.PHYSICS_EXAM.clone();
        newExam.setQuestions(List.copyOf(ExamServiceTestingData.PHYSICS_EXAM_QUESTIONS));

        when(examRepository.save(any(Exam.class))).then(new Answer<Exam>() {

            Long sequence = 8L;

            @Override
            public Exam answer(InvocationOnMock invocation) throws Throwable {
                // 0 stands for the argument we are passing to examRepository.save() at when method
                Exam toReturnExam = ((Exam) invocation.getArgument(0)).clone();
                toReturnExam.setId(sequence++);

                return toReturnExam;
            }
        });

        // when
        Exam actualExam = examService.save(newExam);

        // then
        assertNotNull(actualExam.getId());
        assertEquals(8L, actualExam.getId());
        assertEquals("Physics", actualExam.getName());
        assertNotEquals(actualExam, newExam, () -> "exam questions lists should not reference same list object");
        assertIterableEquals(ExamServiceTestingData.PHYSICS_EXAM_QUESTIONS, actualExam.getQuestions());

        verify(examRepository, times(1)).save(any(Exam.class));
        verify(questionRepository, times(1)).saveAll(anyList());
    }

    @DisplayName("Exception Handling Test")
    @Test
    void testExceptionHandling() {
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.ID_NULL_EXAM_LIST);
        //when(questionRepository.findByExamId(isNull())).thenThrow(IllegalArgumentException.class);
        doThrow(new IllegalArgumentException()).when(questionRepository).findByExamId(isNull());

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> examService.findByNameWithQuestions(ExamServiceTestingData.EXAM_LIST.get(2).getName()));

        assertEquals(IllegalArgumentException.class, ex.getClass());

        verify(examRepository).findAll();
        verify(questionRepository).findByExamId(isNull());
    }

    @DisplayName("Argument Matchers test")
    @Test
    void testArgumentMatchers() {
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);
        when(questionRepository.findByExamId(anyLong())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);
        //when(questionRepository.findByExamId(null)).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);

        examService.findByNameWithQuestions(
                ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.MATH_EXAM_INDEX).getName()
        );

        verify(examRepository).findAll();
        // ArgumentMatchers.argThat()
        verify(questionRepository).findByExamId(argThat(arg -> arg != null && arg.equals(6L)));
        //verify(questionRepository).findByExamId(eq(6L));
    }
}