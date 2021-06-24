package aditi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import aditi.BoundedBufferTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author aditi
 */
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BoundedBufferTest.class);

        System.out.println("Calling BoundedBufferTest test cases");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
        
        System.out.println("Calling Big test cases");
        result = JUnitCore.runClasses(Big.class);

        
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
        
    }
}
