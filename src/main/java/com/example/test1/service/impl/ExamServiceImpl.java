package com.example.test1.service.impl;

import com.example.test1.dto.ExamDto;
import com.example.test1.entity.Category;
import com.example.test1.entity.Exam;
import com.example.test1.repository.CategoryRepository;
import com.example.test1.repository.ExamRepository;
import com.example.test1.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ExamDto save(ExamDto examDto) {
        Exam exam = new Exam();
        Category category = new Category();
        category.setName(String.valueOf(examDto.getCategory()));
        categoryRepository.save(category);

        exam.setCategory(category);
        exam.setTitle(examDto.getTitle());
        exam.setAnswers(examDto.getAnswers());
        exam.setContent(examDto.getContent());

        examRepository.save(exam);
        return convertEntityToDto(exam);
    }

    @Override
    public void delete(long[] ids) {
        for (long item: ids) {
            examRepository.deleteById(item);
        }
    }

    @Override
    public ExamDto updateExam(ExamDto examDto) {
        return null;
    }

    private ExamDto convertEntityToDto(Exam exam){
        ExamDto examDto = new ExamDto();
        examDto.setCategory(String.valueOf(exam.getCategory()));
        examDto.setTitle(exam.getTitle());
        examDto.setAnswers(exam.getAnswers());
        examDto.setContent(exam.getContent());
        return examDto;
    }
}
