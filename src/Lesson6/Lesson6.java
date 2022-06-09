package Lesson6;

import java.util.Arrays;

import static java.lang.Long.valueOf;

public class Lesson6 {

    public static void main(String[] args) {

        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        testArrayOperation(array);
        testArray(array);

    }




    private static int[] testArrayOperation(int[] array) {
        int y = 0; //позиция 4-ки в массиве
        int x = 0; //размерность нового массива

        //найти позицию 4-ки в массиве
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                y = i+1;
            }
        }

        //Проверка массива на 4-ку
        if (y==0) {
            throw new RuntimeException("There is no four in the array");
        }

        //создать новый массив и скопировать в него элементы из старого
        x = array.length - y;
        int[] newArray = new int[x];
        System.arraycopy(array, y, newArray, 0, x);


        //печать нового массива
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]);
        }

        return newArray;

    }




    private static boolean testArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4 || array[i] == 1) {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }






}
