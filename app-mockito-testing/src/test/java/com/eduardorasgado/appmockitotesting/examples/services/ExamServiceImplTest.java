package com.eduardorasgado.appmockitotesting.examples.services;

import com.eduardorasgado.appmockitotesting.examples.models.Exam;
import com.eduardorasgado.appmockitotesting.examples.repositories.ExamRepository;
import com.eduardorasgado.appmockitotesting.examples.repositories.ExamRepositoryImpl;
import com.eduardorasgado.appmockitotesting.examples.repositories.QuestionRepository;
import com.eduardorasgado.appmockitotesting.examples.repositories.QuestionRepositoryImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// to enable mockito annotations in order to be able to inject dependencies
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExamServiceImplTest {

    @Mock
    private ExamRepository examRepository;


    //@Mock
    //private QuestionRepositoryImpl questionRepository;
    // if we are using Mockito.doCallRealMethod() when we want the implemented original method instead of mocks, we should
    // use the implemented class instead of the interface as seen at testDoCallRealMethod()
    @Mock
    private QuestionRepositoryImpl questionRepository;

    // without injecting it using mockito annotations, we are able to use the interface as dependency inversion principle states
    //private ExamService examService;

    // by using inject mocks annotation, now we have to use an implementation to inject mocks
    @InjectMocks
    private ExamServiceImpl examService;

    @Captor
    private ArgumentCaptor<Long> longArgCaptor;

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
    @Order(1)
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
    @Order(2)
    @Test
    void testFindExamByNameWhenEmptyListIsReturned() {
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EMPTY_EXAM_LIST);

        Optional<Exam> exam = examService.findByName("Math");

        assertTrue(exam.isEmpty(), () -> "Exam should not be present");
    }

    @DisplayName("Find exam questions by exam name")
    @Order(3)
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
    @Order(4)
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
    @Order(5)
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
    @Order(6)
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
    @Order(7)
    @Test
    void testArgumentMatchers() {
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);
        when(questionRepository.findByExamId(anyLong())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);
        //when(questionRepository.findByExamId(isNull())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);

        examService.findByNameWithQuestions(
                ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.MATH_EXAM_INDEX).getName()
        );

        verify(examRepository).findAll();
        // ArgumentMatchers.argThat()
        verify(questionRepository).findByExamId(argThat(arg -> arg != null && arg.equals(6L)));
        //verify(questionRepository).findByExamId(eq(6L));
    }

    @DisplayName("Custom Argument Matchers test")
    @Order(8)
    @Test
    void testCustomArgumentMatchers() {
        //when(examRepository.findAll()).thenReturn(ExamServiceTestingData.NEGATIVE_ID_EXAM_LIST);
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);
        when(questionRepository.findByExamId(anyLong())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);

        examService.findByNameWithQuestions(
                ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.MATH_EXAM_INDEX).getName()
        );

        verify(examRepository).findAll();
        verify(questionRepository).findByExamId(argThat(new MyArgMatcher()));
    }

    // custom argument matcher, not necessary to have it as inner class
    public static class MyArgMatcher implements ArgumentMatcher<Long> {

        boolean argumentNotNull = false;
        @Override
        public boolean matches(Long argument) {
            argumentNotNull = argument != null;

            return argumentNotNull && argument > 0;
        }

        @Override
        public String toString() {
            StringBuilder message = new StringBuilder("[Custom Arg Matcher Error Msg]: Argument should");
            message.append(argumentNotNull ? " be greater than zero" : " not be null");

            return message.toString();
        }
    }

    @DisplayName("Argument Captor in method test")
    @Order(9)
    @Test
    void testArgumentCaptorInMethod() {
        Exam spanishExam = ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.SPANISH_EXAM_INDEX);

        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);
        when(questionRepository.findByExamId(eq(spanishExam.getId()))).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);

        examService.findByNameWithQuestions(
                spanishExam.getName()
        );

        verify(questionRepository).findByExamId(anyLong());
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(questionRepository).findByExamId(captor.capture());

        assertEquals(5L, captor.getValue(), () -> "expected exam id passed to question repo should be equals to 6");
    }

    @DisplayName("Annotated Argument Captor test")
    @Order(10)
    @Test
    void testArgumentCaptorAnnotated() {
        Exam spanishExam = ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.SPANISH_EXAM_INDEX);

        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);
        when(questionRepository.findByExamId(eq(spanishExam.getId()))).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);

        examService.findByNameWithQuestions(
                spanishExam.getName()
        );

        verify(questionRepository).findByExamId(anyLong());
        verify(questionRepository).findByExamId(longArgCaptor.capture());

        assertEquals(5L, longArgCaptor.getValue(), () -> "expected exam id passed to question repo should be equals to 6");
    }

    @DisplayName("Do throw test")
    @Order(11)
    @Test
    void testDoThrow(TestReporter testReporter) throws CloneNotSupportedException {
        Exam exam = ExamServiceTestingData.PHYSICS_EXAM.clone();
        exam.setQuestions(List.copyOf(ExamServiceTestingData.PHYSICS_EXAM_QUESTIONS));

        // this is not possible because when it starts with when method it is required to get a return type
        // different to void
        //when(questionRepository.saveAll(anyList())).thenThrow(IllegalArgumentException.class);
        // so for this reason we can use doThrow
        doThrow(new IllegalArgumentException()).when(questionRepository).saveAll(anyList());

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> examService.save(exam), () -> "IllegalArgumentException was expected");

        testReporter.publishEntry("Error was thrown correctly thrown: " + ex);
    }

    @DisplayName("Do Answer test")
    @Order(12)
    @Test
    void testDoAnswer() throws CloneNotSupportedException {
        Exam exam = ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.MATH_EXAM_INDEX).clone();

        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);
        //when(questionRepository.findByExamId(anyLong())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);
        doAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0) != null
                    ? List.copyOf(ExamServiceTestingData.MATH_EXAM_QUESTIONS)
                    : new ArrayList<>();
        }).when(questionRepository).findByExamId(anyLong());

        Exam actualExam = examService.findByNameWithQuestions(exam.getName());

        assertIterableEquals(ExamServiceTestingData.MATH_EXAM_QUESTIONS, actualExam.getQuestions(),
                () -> "actual exam questions should match expected");
        assertEquals(exam.getId(), actualExam.getId());
        assertEquals(exam.getName(), actualExam.getName());
        assertEquals(4, actualExam.getQuestions().size());
    }

    @DisplayName("Do answer save exam test ")
    @Order(13)
    @Test
    void testDoAnswerSaveExam() throws CloneNotSupportedException {
        // Given
        Exam newExam = ExamServiceTestingData.PHYSICS_EXAM.clone();
        newExam.setQuestions(List.copyOf(ExamServiceTestingData.PHYSICS_EXAM_QUESTIONS));

        doAnswer(new Answer<Exam>() {

            Long sequence = 8L;

            @Override
            public Exam answer(InvocationOnMock invocation) throws Throwable {
                // 0 stands for the argument we are passing to examRepository.save() at when method
                Exam toReturnExam = ((Exam) invocation.getArgument(0)).clone();
                toReturnExam.setId(sequence++);

                return toReturnExam;
            }
        }).when(examRepository).save(any(Exam.class));

        // when
        Exam actualExam = examService.save(newExam);

        // then
        assertNotNull(actualExam.getId());
        assertEquals(8L, actualExam.getId());
        assertEquals("Physics", actualExam.getName());
        assertNotEquals(actualExam, newExam, () -> "exam questions lists should not reference same list object");
        assertIterableEquals(ExamServiceTestingData.PHYSICS_EXAM_QUESTIONS, actualExam.getQuestions());

        verify(examRepository).save(any(Exam.class));
        verify(questionRepository).saveAll(anyList());
    }

    @DisplayName("Do Call Real Method test")
    @Order(14)
    @Test
    void testDoCallRealMethod() {
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);
        //when(questionRepository.findByExamId(anyLong())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);
        doCallRealMethod().when(questionRepository).findByExamId(anyLong());

        Exam exam = examService.findByNameWithQuestions("Math");

        assertEquals(6L, exam.getId());
        assertEquals("Math", exam.getName());
        assertIterableEquals(ExamServiceTestingData.MATH_EXAM_QUESTIONS, exam.getQuestions());
    }

    @DisplayName("Spies testing")
    @Order(15)
    @Test
    void testSpy(TestInfo testInfo, TestReporter testReporter) throws CloneNotSupportedException {
        testReporter.publishEntry("Evaluating " + testInfo.getTestMethod().get().getName());

        // Spy requires an implemented class
        ExamRepository examRepo = spy(ExamRepositoryImpl.class);
        QuestionRepository questionRepo = spy(QuestionRepositoryImpl.class);
        ExamService localExamService = new ExamServiceImpl(examRepo, questionRepo);

        // if we check on the output, we will find that even when we are mocking findByExamId method, the real one
        // has been called too, and later on when the localExamService.findByNameWithQuestions method calls the findByExamId
        // method, the mocked one is called. To avoid this, because we dont want the original one to be executed, we will use
        // doReturn
        //when(questionRepo.findByExamId(anyLong())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);
        doReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS).when(questionRepo).findByExamId(anyLong());

        Exam expectedExam = ExamServiceTestingData.EXAM_LIST.get(ExamServiceTestingData.MATH_EXAM_INDEX).clone();
        expectedExam.setQuestions(List.copyOf(ExamServiceTestingData.MATH_EXAM_QUESTIONS));

        Exam exam = localExamService.findByNameWithQuestions(expectedExam.getName());

        assertAll(
                () -> assertEquals(expectedExam.getId(), exam.getId(), "actual id should be " + expectedExam.getId()),
                () -> assertEquals(expectedExam.getName(), exam.getName(), "actual name should be " + expectedExam.getName()),
                () -> assertEquals(expectedExam.getQuestions().size(), exam.getQuestions().size(),
                        "actual question size should be " + expectedExam.getQuestions().size()),
                () -> assertTrue(exam.getQuestions().contains("Derivatives"),
                        "actual exam questions should contains an element called Derivatives")
        );

        verify(examRepo).findAll();
        verify(questionRepo).findByExamId(anyLong());
    }

    @DisplayName("Mock invocation order test")
    @Order(16)
    @Test
    void testMockInvocationOrder() {
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);

        examService.findByNameWithQuestions("Math");
        examService.findByNameWithQuestions("Spanish");

        // to test and verify mock invoking order
        // we can either verify one single mock item or many of them
        //InOrder inOrder = inOrder(questionRepository);
        InOrder inOrder = inOrder(examRepository, questionRepository);

        inOrder.verify(examRepository).findAll();
        inOrder.verify(questionRepository).findByExamId(6L);
        inOrder.verify(examRepository).findAll();
        inOrder.verify(questionRepository).findByExamId(5L);
    }

    @DisplayName("Mock invocation: invocation times verify")
    @Order(17)
    @Test
    void testMockInvocationTimes() throws CloneNotSupportedException {
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EXAM_LIST);
        when(questionRepository.findByExamId(anyLong())).thenReturn(ExamServiceTestingData.MATH_EXAM_QUESTIONS);

        examService.findByNameWithQuestions("Math");

        verify(questionRepository, times(1)).findByExamId(6L);
        verify(examRepository, times(1)).findAll();
        // same as atLeast(1):
        verify(questionRepository, atLeastOnce()).findByExamId(6L);

        Exam newExam = ExamServiceTestingData.PHYSICS_EXAM.clone();
        newExam.setQuestions(List.copyOf(ExamServiceTestingData.PHYSICS_EXAM_QUESTIONS));

        examService.save(newExam);

        // also we have atMostOnce
        verify(questionRepository, atMost(2)).saveAll(anyList());
        verify(examRepository, atMostOnce()).save(any(Exam.class));
    }

    @DisplayName("No interaction with mock test")
    @Order(18)
    @Test
    void testVerifyZeroMockInteraction() {
        when(examRepository.findAll()).thenReturn(ExamServiceTestingData.EMPTY_EXAM_LIST);

        examService.findByNameWithQuestions("Spanish");

        verify(questionRepository, never()).findByExamId(anyLong());
        verifyNoInteractions(questionRepository);
    }
}