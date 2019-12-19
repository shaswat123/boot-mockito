package com.mock.controller.test;


import com.mock.controller.ItemController;
import com.mock.controller.MockitoHelloWorldController;
import com.mock.model.Item;
import com.mock.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

        @Test
        public void testGetItems() throws Exception{

            RequestBuilder request = MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON);

            MvcResult result=mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().json("{\"itemId\":\"122\",\"itemName\":\"Key Board\",\"itemPrice\":20.0}"))
                    .andReturn();

        }

    @Test
    public void testGetItemsService() throws Exception{

            when(itemService.getItem()).thenReturn(new Item("444","Peripheral Device",50.0));

        RequestBuilder request = MockMvcRequestBuilders.get("/items-service").accept(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"itemId\":\"444\",\"itemName\":\"Peripheral Device\",\"itemPrice\":50.0}"))
                .andReturn();

    }

    @Test
    public void testListItemsService() throws Exception{

        when(itemService.retrieveAll()).thenReturn(Arrays.asList(new Item("448","Mouse",70.0),
                new Item("449","Monitor device",90.0)));

        RequestBuilder request = MockMvcRequestBuilders.get("/listItems").accept(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"itemId\":\"448\",\"itemName\":\"Mouse\",\"itemPrice\":70.0}," +
                        "{}]"))
                .andReturn();

    }


    }

