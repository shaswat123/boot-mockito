package com.mock.service.test;

import com.mock.model.Item;
import com.mock.repo.ItemRepository;
import com.mock.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void testItemService(){

        when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item("448","Mouse",70.0),
                new Item("449","Monitor device",90.0)));

        List<Item> items=itemService.retrieveAll();

        Assertions.assertEquals("448",items.get(0).getItemId());
        Assertions.assertEquals("Mouse",items.get(0).getItemName());
        Assertions.assertEquals(70.0,items.get(0).getItemPrice());

        Assertions.assertEquals("449",items.get(1).getItemId());
        Assertions.assertEquals("Monitor device",items.get(1).getItemName());
        Assertions.assertEquals(90.0,items.get(1).getItemPrice());
    }



}
