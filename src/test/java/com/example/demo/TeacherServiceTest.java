package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.TeacherController;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TeacherServiceTest {

     @MockBean
     private TeacherRepository teacherRepository;
     
     @Autowired
     private TeacherService teacherService;

	
    @Test
    public void testGetTeacherByIdService(){
    	Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("John");
        teacher.setSubject("Math");
        when(teacherRepository.findById(1L)).thenReturn(Optional.of(teacher));
        
        assertEquals("John",teacherService.getTeacherByIdService(1L).getName());

    }
}
