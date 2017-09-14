package com.hsl.test.controller;

import com.hsl.test.model.Spitter;
import com.hsl.test.model.Spittle;
import com.hsl.test.repository.SpitterRepository;
import com.hsl.test.repository.SpittleRepository;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


/**
 * Created by huangshaolong on 2017/9/7.
 *
 */
public class SpitterControllerTest {


    @Test
    public void showRegistrationForm() throws Exception {
        Spitter unsaved = new Spitter("jbauer","24hours","Jack","Bauer");
        Spitter saved = new Spitter(24L,"jbauer","24hours","Jack","Bauer");
        SpitterRepository mockRepository = getRepository(unsaved,saved);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception{
        Spitter unsaved = new Spitter("jbauer","24hours","Jack","Bauer");
        Spitter saved = new Spitter(24L,"jbauer","24hours","Jack","Bauer");

        SpitterRepository mockRepository = getRepository(unsaved,saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMVC = standaloneSetup(controller)
                .build();


        mockMVC.perform(
                post("/spitter/register")
//                .param("firstName","Jack")
                .param("firstName","")
                .param("lastName","Bauer")
                .param("username","jbauer")
                .param("password","24hours")
        )
        .andExpect(redirectedUrl("/spitter/jbauer"));

        verify(mockRepository,atLeastOnce()).save(unsaved);

        mockMVC.perform(
                post("/spitter/register")
                        .param("firstName","12345678901234567890123456789012345678901234567890123456789012345678901234567890")
                        .param("lastName","Bauer")
                        .param("username","jbauer")
                        .param("password","24hours")
        )
                .andExpect(view().name("/spitter/registerForm"));
    }

    private SpitterRepository getRepository(Spitter unsaved,Spitter saved) {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        when(mockRepository.save(unsaved))
                .thenReturn(saved);
        return mockRepository;
    }

}