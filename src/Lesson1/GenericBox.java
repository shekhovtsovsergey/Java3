package Lesson1;

import java.util.ArrayList;

public class GenericBox <TYPE extends Fruit> {

    private ArrayList<TYPE> fruitList;
    private float totalWeight;
    private TYPE obj;


    public GenericBox(TYPE obj) {
            this.fruitList = new ArrayList<>();
            this.obj=obj;
    }



    public void addFruit(TYPE fruit) {
        fruitList.add(fruit);
        totalWeight = totalWeight + fruit.getWeight();
    }


    public float getTotalWeight() {
        return totalWeight;
    }


    public boolean compare(GenericBox<?> box) {
        return this.getTotalWeight() == box.getTotalWeight();
    }




    public void transfer(GenericBox<? super TYPE> box) {
        box.fruitList.addAll(fruitList);
        fruitList.clear();
    }


}

