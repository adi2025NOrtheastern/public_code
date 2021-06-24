/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aditi
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelExample5 extends RecursiveAction {

    Employee input;
    
    public ParallelExample5()
    {
         System.out.println(Thread.currentThread().getName() + " : Object created");
        
    }
    
    private static final String DIR = System.getProperty("user.dir") + "/test/";

    public static void main(String[] args) throws IOException {

        System.out.println("DIR= "+DIR);
        Files.createDirectories(Paths.get(DIR));
        
        ForkJoinPool fjPool = new ForkJoinPool();

        ParallelExample5[] obj = new ParallelExample5[10]; //10000
        
        List<ParallelExample5> exList = new ArrayList<>();
        
        for(ParallelExample5 ex: obj)
        {
            
            ex = new ParallelExample5();
            exList.add(ex);
             System.out.println(Thread.currentThread().getName() + " : fjPool.invoke()");
            fjPool.invoke(ex);
            
            //fjPool.execute(ex);
            //ex.fork();
        }
 
        
        
        // fjPool.invoke(exList);
        //List<Employee> employees = //obj.generateEmployee(10000);

        // normal, sequential
        //employees.stream().forEach(ParallelExample5::save); 		// 27s-29s

        // parallel
        //employees.parallelStream().forEach(ParallelExample5::save); // 7s-8s
        
        fjPool.shutdown();

    }

    private static void save(Employee input) {

        try (FileOutputStream fos = new FileOutputStream(new File(DIR + input.getName() + ".txt"));
             ObjectOutputStream obs = new ObjectOutputStream(fos)) {
            System.out.println(Thread.currentThread().getName() + " : writing to file");
            obs.writeObject(input.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    

    private List<Employee> generateEmployee(int num) {

         System.out.println(Thread.currentThread().getName() + " : generating employyee");
        return Stream.iterate(0, n -> n + 1)
                .limit(num)
                .map(x -> {
                    return new Employee(
                            generateRandomName(4),
                            generateRandomAge(15, 100),
                            generateRandomSalary(900.00, 200_000.00)
                    );
                })
                .collect(Collectors.toList());

    }

    private String generateRandomName(int length) {

         System.out.println(Thread.currentThread().getName() + " : generating employyee name");
        return new Random()
                .ints(5, 97, 122) // 97 = a , 122 = z
                .mapToObj(x -> String.valueOf((char) x))
                .collect(Collectors.joining());

    }

    private int generateRandomAge(int min, int max) {
         System.out.println(Thread.currentThread().getName() + " : generating age");
        return new Random()
                .ints(1, min, max)
                .findFirst()
                .getAsInt();
    }

    private BigDecimal generateRandomSalary(double min, double max) {
         System.out.println(Thread.currentThread().getName() + " : generating salary");
        return new BigDecimal(new Random()
                .doubles(1, min, max)
                .findFirst()
                .getAsDouble()).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    protected void compute() {
         System.out.println(Thread.currentThread().getName() + " : In compute");
       this.input = new Employee(generateRandomName(4),
                            generateRandomAge(15, 100),
                            generateRandomSalary(900.00, 200_000.00));
        System.out.println(Thread.currentThread().getName() + " : calling save(employee)");
        ParallelExample5.save(this.input);
    }

}
