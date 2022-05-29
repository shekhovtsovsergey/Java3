package Lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import static Lesson5.MainClass.cyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch cdl;
    private AtomicInteger finishCount;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch cdl, AtomicInteger finishCount) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdl = cdl;
        this.finishCount = finishCount;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            System.out.println("Поехал " );
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        cdl.countDown();
        int finishPlace = finishCount.incrementAndGet();
        if (finishPlace == 1) {
            System.out.println(this.name + " ПОБЕДИЛ В ГОНКЕ!!!");
        } else {
            System.out.printf("%s занял %d место%n", this.name, finishPlace);
        }

    }
}
