package com.mock.service.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mockList = mock(List.class);

    @Test
    public void listSizeTest(){
        when(mockList.size()).thenReturn(5);
        Assertions.assertEquals(5,mockList.size());
    }

    @Test
    public void listSizeTestMultipleReturns(){
        when(mockList.size()).thenReturn(5).thenReturn(10);
        Assertions.assertEquals(5,mockList.size());
        Assertions.assertEquals(10,mockList.size());
    }

    @Test
    public void listSizeTestParameters(){
        when(mockList.get(0)).thenReturn("Hello world mockito!");
        Assertions.assertEquals("Hello world mockito!",mockList.get(0));
        Assertions.assertEquals(null,mockList.get(1));
    }

    @Test
    public void listSizeTestParametersWithAnyInt(){
        when(mockList.get(anyInt())).thenReturn("Hello world mockito!");
        Assertions.assertEquals("Hello world mockito!",mockList.get(0));
        Assertions.assertEquals("Hello world mockito!",mockList.get(1));
    }

    @Test
    public void listSizeMethoCallVerifyWhenReturnIsNotThere(){

        String value1=mockList.get(0);
        String value2=mockList.get(1);

        verify(mockList).get(0);
        verify(mockList,times(2)).get(anyInt());
        verify(mockList,atLeast(1)).get(anyInt());
        verify(mockList,atLeastOnce()).get(anyInt());
        verify(mockList,atMost(2)).get(anyInt());
        verify(mockList,never()).get(2);
    }


    @Test
    public void testMultipleArgumentCapturing(){

        mockList.add("Hello");
        mockList.add("Shaswat!");

        ArgumentCaptor<String>captor = ArgumentCaptor.forClass(String.class);
        verify(mockList,times(2)).add(captor.capture());

        List<String> allValues= captor.getAllValues();
        Assertions.assertEquals("Hello",allValues.get(0));
        Assertions.assertEquals("Shaswat!",allValues.get(1));

    }

    @Test
    public void testMockingBehaviourLost(){

        ArrayList<String>mockArrayList= mock(ArrayList.class);

        System.out.println(mockArrayList.get(0));
        System.out.println(mockArrayList.size());
        mockArrayList.add("Test");
        mockArrayList.add("Test 2");

        System.out.println(mockArrayList.get(0));
        System.out.println(mockArrayList.size());

        when(mockArrayList.size()).thenReturn(5);
        System.out.println(mockArrayList.size());
    }

    //The original behaviour of the class being spied is retained.

    @Test
    public void testSpyBehaviourRetained(){

        ArrayList<String>spyArrayList= spy(ArrayList.class);

        //System.out.println(spyArrayList.get(0));-> ArrayIndexOutOfBoundsException.
        System.out.println(spyArrayList.size());
        spyArrayList.add("Test");
        spyArrayList.add("Test 2");

        System.out.println(spyArrayList.get(0));
        System.out.println(spyArrayList.size());

        when(spyArrayList.size()).thenReturn(5);
        System.out.println(spyArrayList.size());

        spyArrayList.add("Test Spy");
        System.out.println(spyArrayList.size()); //This works!

        verify(spyArrayList).add("Test Spy");
        verify(spyArrayList).add("Test 9"); //verification failed

    }


}
