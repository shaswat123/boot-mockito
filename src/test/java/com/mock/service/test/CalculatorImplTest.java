package com.mock.service.test;

import com.mock.service.CalculatorImpl;
import com.mock.service.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorImplTest {

    @InjectMocks
    CalculatorImpl calculator;

    @Mock
    SomeDataService testSomeDataService;

    //SomeDataService testSomeDataService= mock(SomeDataService.class);

    @BeforeEach
    public void before(){

    }

    @Test
    public void testCalculator(){
        Assertions.assertEquals(450,calculator.calculateSum(new int[]{10,20,30,40,50,60,70,80,90}));

    }

    @Test
    public void testCalculatorEmpty(){
        Assertions.assertEquals(0,calculator.calculateSum(new int[]{}));

    }

    @Test
    public void testCalculatorWithMock(){

        when(testSomeDataService.retrieveAllData()).thenReturn(new int[]{1,2,3,4,5,6,7,8,9});
        Assertions.assertEquals(45,calculator.calculateSum(testSomeDataService.retrieveAllData()));

    }

    @Test
    public void testCalculatorWithMockEmptyData(){

        when(testSomeDataService.retrieveAllData()).thenReturn(new int[]{});
        Assertions.assertEquals(0,calculator.calculateSum(testSomeDataService.retrieveAllData()));

    }

    @Test
    public void testCalculatorWithMockOneValue(){

        when(testSomeDataService.retrieveAllData()).thenReturn(new int[]{5});
        Assertions.assertEquals(5,calculator.calculateSum(testSomeDataService.retrieveAllData()));

    }
}
