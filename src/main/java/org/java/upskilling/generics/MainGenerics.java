package org.java.upskilling.generics;

public class MainGenerics {

    public static void main(String[] args) {
        Milk milk = new Milk();
        Oranges oranges = new Oranges();
        
        FoodBox<Milk> foodBoxOfMilk = new FoodBox<>();
        FoodBox<Oranges> foodBoxOfOranges = new FoodBox<>();
        FoodBox<Food> foodBoxOfFood = new FoodBox<>();
        
        foodBoxOfMilk.addItem(milk);
        //boxOfMilk.addItem(oranges); // !Does not compile
        foodBoxOfOranges.addItem(oranges);
        foodBoxOfFood.addItem(milk);
        
        // Test
        foodBoxOfMilk.removeItem().drink();
        foodBoxOfOranges.removeItem().juggle();
        
        // Test with one interface in common
        ((Milk) foodBoxOfFood.removeItem()).drink();
        foodBoxOfFood.addItem(oranges);
        ((Oranges) foodBoxOfFood.removeItem()).juggle();
        
        /*
            !Does not compile
            Error case with a class that not extends Food interface.
            Uncomment the following code in order to check.
         */
        Bike bike = new Bike();
        //FoodBox<Bike> foodBoxOfBike = new FoodBox<Bike>();
        //foodBoxOfBike.addItem(bike);
        Box<Bike> boxOfBike = new Box<>();
        boxOfBike.addItem(bike);
        debugAdd(bike, boxOfBike);
    }
    
    /*
        For generic methods, first you have to add the parameter before return type
        like: <T> void debugAdd() {}
        and than the parameters for method arguments. So the result will be like:
        <T> void debugAdd(T item, Box<T> box)
     */
    static <T> void debugAddFood(Food item, FoodBox<Food> foodBox) {
        System.out.println("[DebugFoodAdd] Type [" + item.getClass().getSimpleName() + "]");
        foodBox.addItem(item);
    }
    
    static <T> void debugAdd(T item, Box<T> box) {
        System.out.println("[DebugAdd] Type [" + item.getClass().getSimpleName() + "]");
        box.addItem(item);
    }
    
}
