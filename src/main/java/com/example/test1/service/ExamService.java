package com.example.test1.service;

import com.example.test1.dto.ExamDto;

import java.util.List;

public interface ExamService {
    ExamDto save(ExamDto examDto);
    void delete(long[] ids);
    List<ExamDto> findAllExams();
}
