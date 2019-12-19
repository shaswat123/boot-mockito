package com.mock.service;

import org.springframework.stereotype.Service;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class CalculatorImpl {

    public Long calculateSum(int[]sum){

       return IntStream.of(sum).summaryStatistics().getSum();


    }
}
