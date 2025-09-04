//package com.leanderziehm.javacalculator.old;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class Calculator2 {
//
//    @GetMapping(path ="/calculate/")
//    public CalculateResponse calculate(@PathVariable CalculateInput calculateInput ) {
//
////        double result;
////        switch (calculateInput.operation.toLowerCase()){
////            case "add" :
////                result = add(calculateInput.numbers);
//
////            case ""
////        }
//
//
//        return new CalculateResponse(0,"yes");
//    }
//
//    record CalculateInput(List<Double> numbers,String operation ){}
//
//    record CalculateResponse(double result){}
//
//    public  int add(List<Double> numbers){
//
//    }
//    public int sub(List<Double> numbers){
//        double result = 0;
//        for(var number: numbers){
//            result -=number;
//        }
//    }
//    public int mul(List<Double> numbers){
//        return a * b;
//    }
//    public int div(List<Double> numbers) {
//        return a / b;
//    }
//
//}
