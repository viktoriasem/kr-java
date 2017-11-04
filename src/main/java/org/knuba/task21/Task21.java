package org.knuba.task21;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task21 {
    public static void main(String[] args) {
        int N = 50;
        ExecutorService executor = Executors.newFixedThreadPool(N);//creating a pool of N threads
        for (int i = 0; i < N; i++) {
            Runnable worker = new WorkThread();
            executor.execute(worker);//calling execute method of ExecutorService
        }
        executor.shutdown();

        // System.out.println("Finished all threads");HELLO
    }
}
class Text{
    static ArrayList<Field []> fieldsList = new ArrayList<>();
}

class WorkThread implements Runnable {


    public void run() {

        try {
            Class cls = Thread.currentThread().getClass();
            System.out.println("Fields =");

            // returns the array of Field objects representing the public fields
            Field f[] = cls.getFields();
            for (int i = 0; i < f.length; i++) {
                System.out.println(f[i]);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

    }
}