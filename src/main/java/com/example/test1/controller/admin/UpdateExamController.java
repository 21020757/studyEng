package com.example.test1.controller.admin;

import com.example.test1.dto.ExamDto;

import com.example.test1.dto.UserDto;
import com.example.test1.service.impl.ExamServiceImpl;
import com.example.test1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller

public class UpdateExamController {

    @Autowired
    private ExamServiceImpl examService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/admin")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping(value = "/admin")
    public ExamDto createExam(@RequestBody ExamDto model) {
        return examService.save(model);
    }

    @PutMapping(value = "/admin/{id}")
    public ExamDto updateExam(@RequestBody ExamDto model, @PathVariable("id") long id) {
        model.setId(id);
        return examService.save(model);
    }

    @DeleteMapping(value = "/admin")
    public void deleteExam(@RequestBody long[] ids) {
        examService.delete(ids);
    }
}
