package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lesson1 {


    public static void main(String[] args) {

        //Первые два задания про массив и список
        Integer[] arr = new Integer[]{0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
        System.out.println("arr = " + Arrays.toString(arr) + " Создали массив в таком виде");
        changeElement(arr,1,5);
        arrMoveToList1(arr);
        System.out.println(" ");



        //Задание про коробки.
        //Создаем яблоки
        Apple apple1 = new Apple(1f);
        Apple apple2 = new Apple(1f);
        Apple apple3 = new Apple(1f);
        Apple apple4 = new Apple(1f);
        Apple apple5 = new Apple(1f);

        //Создаем коробку
        GenericBox<Apple> appleGenericBox = new GenericBox<Apple>(apple1);

        //Добавляем яблоки
        appleGenericBox.addFruit(apple1);
        appleGenericBox.addFruit(apple2);
        appleGenericBox.addFruit(apple3);
        appleGenericBox.addFruit(apple4);
        appleGenericBox.addFruit(apple5);

        //Печатаем сколько вес коробки
        System.out.println("Проверка сколько в коробке яблок = " + appleGenericBox.getTotalWeight());



        //Создаем апельсины
        Orange orange1 = new Orange(1.5F);
        Orange orange2 = new Orange(1.5F);
        Orange orange3 = new Orange(1.5F);
        Orange orange4 = new Orange(1.5F);
        Orange orange5 = new Orange(1.5F);

        //Создаем коробку
        GenericBox<Orange> orangeGenericBox = new GenericBox<Orange>(orange1);

        //Добавляем апельсины
        orangeGenericBox.addFruit(orange1);
        orangeGenericBox.addFruit(orange2);
        orangeGenericBox.addFruit(orange3);
        orangeGenericBox.addFruit(orange4);
        orangeGenericBox.addFruit(orange5);

        //Печатаем сколько вес коробки
        System.out.println("Проверка сколько в коробке апельсинов = " + orangeGenericBox.getTotalWeight());


        //Сравниваем коробки
        System.out.println(appleGenericBox.compare(orangeGenericBox));



        //Пересыпать фрукты
        GenericBox<Orange> orangeGenericBox2 = new GenericBox<Orange>(orange1);
        //System.out.println("Создали вторую коробку апельсинов = " + orangeGenericBox2.getTotalWeight());

        orangeGenericBox2.transfer(orangeGenericBox);

        System.out.println("Проверка сколько в первой коробке = " + orangeGenericBox.getTotalWeight());
        System.out.println("Проверка сколько во второй коробке = " + orangeGenericBox2.getTotalWeight());


    }


    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    private static void changeElement(Integer[] arr, int src, int dst) {
        int tmp_src;
        int tmp_dst;

        tmp_src = arr[src];
        tmp_dst = arr[dst];
        arr[src]=tmp_dst;
        arr[dst]=tmp_src;

        System.out.println("arr = " + Arrays.toString(arr) + ", src = " + src + ", dst = " + dst);
    }


    //2. Написать метод, который преобразует массив в ArrayList;
    private static void arrMoveToList1 (Integer[] arr){
        List<Integer> listOfStrings = new ArrayList<>();
        Collections.addAll(listOfStrings, arr);
        for (Integer str : listOfStrings)
            System.out.print(" " + str);

    }





}
