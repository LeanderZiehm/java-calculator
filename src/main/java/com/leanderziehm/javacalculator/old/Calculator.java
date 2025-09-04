/*
package com.leanderziehm.javacalculator;

import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.sql.SQLException;

@Retention(RetentionPolicy.RUNTIME)
@interface todo {
    String task();
}

@todo(task = "implement this")
@RestController
public class Calculator {

    private final DataSource myDataSource2;

    public Calculator(DataSource myDataSource2) {
        this.myDataSource2 = myDataSource2;
    }

    public static void main(String[] args) {
        var c = Calculator.class;

        var methods = c.getDeclaredMethods();
//java lang object
        // declared
        for (var method : methods) {
            System.out.println("//");
            System.out.println(method.getName());
            var prams = method.getParameters();
            for (var param : prams) {
                System.out.println(param.getName());
                //System.out.println(param.get());
            }
        }
        var x = c.getAnnotation(todo.class);
        System.out.println(x.task());
    }

    public record CalculateResponse(int value){

    }

    //reflection. code.
    //http://localhost:8080/55?y=2
    //query pram or body
    @GetMapping("/{x}" )
    public CalculateResponse calculate(@PathVariable int x, @RequestParam int y) throws SQLException {

        myDataSource2.getConnection();
        return new CalculateResponse(x*y);
    }

    //spring jdbc, raw, jpa orm, jooq, .getConnection, JUnit
}
*/
