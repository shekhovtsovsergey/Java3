package Lesson5;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {

    public static final int CARS_COUNT = 4;
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    public static final AtomicInteger finishCount = new AtomicInteger(0);



    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);


        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10),cdl, finishCount );
        }
        for (int i = 0; i < cars.length; i++) {


            new Thread(cars[i]).start();

        }


        try {
            cdl.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }




    }

}


