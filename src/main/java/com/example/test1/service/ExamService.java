package com.example.test1.service;

import com.example.test1.dto.ExamDto;
import com.example.test1.entity.Exam;

import java.util.List;

public interface ExamService {
    ExamDto save(ExamDto examDto);
    void delete(long[] ids);
    List<ExamDto> findAllExams();
}
