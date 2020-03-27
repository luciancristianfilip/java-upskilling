package org.java.upskilling.generics;

public class Box<T> {
    
    private T content;

    public void addItem(T item) {
        if(content == null) {
            content = item;
        } else {
            System.out.println("The box is full!");
        }
    }

    T removeItem() {
        if(content == null) {
            System.out.println("The box is empty!");
            return null;
        } else {
            T item = content;
            content = null;
            return item;
        }
    }
}
