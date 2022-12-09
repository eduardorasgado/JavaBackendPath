package com.eduardorasgado.appmockitotesting.examples.services;

import com.eduardorasgado.appmockitotesting.examples.models.Exam;
import com.eduardorasgado.appmockitotesting.examples.repositories.ExamRepository;
import com.eduardorasgado.appmockitotesting.examples.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;

public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;

    public ExamServiceImpl(ExamRepository examRepository, QuestionRepository questionRepository) {
        this.examRepository = examRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<Exam> findByName(String name) {

        return examRepository.findAll()
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();
    }

    @Override
    public Exam findByNameWithQuestions(String name) {
        Optional<Exam> optionalExam = findByName(name);
        Exam exam = null;

        if (optionalExam.isPresent()) {
            exam = optionalExam.orElseThrow();

            List<String> questions = questionRepository.findByExamId(exam.getId());
            exam.setQuestions(questions);
        }

        return exam;
    }

    @Override
    public Exam save(Exam exam) throws CloneNotSupportedException {
        if(!exam.getQuestions().isEmpty()) {
            questionRepository.saveAll(exam.getQuestions());
        }
        return examRepository.save(exam);
    }
}
