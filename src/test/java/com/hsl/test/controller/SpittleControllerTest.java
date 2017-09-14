package com.hsl.test.controller;

import com.hsl.test.model.Spittle;
import com.hsl.test.repository.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


/**
 * Created by huangshaolong on 2017/8/31.
 *
 */
public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE,20))
                .thenReturn(expectSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMVC = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INFO/views/spittles.jsp")
                ).build();

        mockMVC.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",hasItems(expectSpittles.toArray())));
        ;
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectSpittles = createSpittleList(50);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(238900,50))
                .thenReturn(expectSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMVC = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/web/WEB-INF/views/spittles.jsp")
                ).build();

        mockMVC.perform(get("/spittles?max=238900&count=50"))
        .andExpect(view().name("spittles"))
        .andExpect(model().attributeExists("spittleList"))
        .andExpect(model().attribute("spittleList",hasItems(expectSpittles.toArray())));
        ;
    }

    private List<Spittle> createSpittleList(int i) {
        List<Spittle> spittles = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            spittles.add(new Spittle("spittle" + i, new Date()));
        }

        return spittles;
    }

    @Test
    public void testSpittle() throws Exception{
        Spittle expectedSpittle = new Spittle("Hello",new Date());
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/12345"))
        .andExpect(view().name("spittle"))
        .andExpect(model().attributeExists("spittle"))
        .andExpect(model().attribute("spittle",expectedSpittle))
        ;



    }

}