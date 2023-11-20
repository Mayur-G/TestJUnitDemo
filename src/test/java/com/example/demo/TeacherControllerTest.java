//package com.example.demo;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.example.demo.controller.TeacherController;
//import com.example.demo.model.Teacher;
//import com.example.demo.repository.TeacherRepository;
//import com.example.demo.service.TeacherService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//
//    @WebMvcTest(TeacherController.class)
//    public class TeacherControllerTest {
//
//        @Autowired
//        private MockMvc mockMvc;
//
//        @MockBean
//        private TeacherRepository teacherRepository;
//        
//        @MockBean
//        private TeacherService teacherService;
//
//        @Test
//        public void testGetAllTeacher() throws Exception {
//            // Mock the behavior of the teacherRepository
//            Teacher teacher = new Teacher();
//            teacher.setId(1L);
//            teacher.setName("John");
//            teacher.setSubject("Math");
//            when(teacherRepository.findAll()).thenReturn(Collections.singletonList(teacher));
//
//          MvcResult result=  mockMvc.perform(get("/teach"))
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{\"id\":1,\"name\":\"John\",\"subject\":\"Math\"}]")).andReturn();
//      
//        // Check if the response contains the expected JSON data
//        String responseContent = result.getResponse().getContentAsString();
//        assertEquals("[{\"id\":1,\"name\":\"John\",\"subject\":\"Math\"}]", responseContent);
//    }
//        
//        @Test
//        public void testSaveTeacher() throws Exception {
//        	   Teacher teacher = new Teacher();
//               teacher.setId(1L);
//               teacher.setName("John");
//               teacher.setSubject("Math");
//               when(teacherRepository.findAll()).thenReturn(Collections.singletonList(teacher));
//
//        	
//             mockMvc.perform(post("/teacher")
//                     .contentType(MediaType.APPLICATION_JSON)
//                     .content(new ObjectMapper().writeValueAsString(teacher)))
//                     .andExpect(status().isOk());
//
//         }
//        
//        @Test
//        public  void testGetTeacherById() throws Exception {
//           
//        	  Teacher teacher = new Teacher();
//              teacher.setId(2L);
//              teacher.setName("John");
//              teacher.setSubject("Math");
//              when(teacherService.getTeacherByIdService(2L)).thenReturn(teacher);
//        	
//            mockMvc.perform(get("/teacher/{id}",2L)
//            .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$.name").value("John"));
//            
//        	
//        }
//        
//        
//        @Test
//        public void testDeleteTeacher() throws Exception {
//        	  Teacher teacher = new Teacher();
//              teacher.setId(1L);
//              teacher.setName("John");
//              teacher.setSubject("Math");
//              doNothing().when(teacherRepository).delete(teacher);
//              
//            mockMvc.perform(delete("/delteacher")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(new ObjectMapper().writeValueAsString(teacher)))
//                    .andExpect(status().isOk());
//}
//        
//        
//    }
