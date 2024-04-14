package ua.goit.polymorpism.Module9.HomeWork9;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] elements;


    public MyArrayList() {
        this.elements = (T[]) new Object[0];
    }


    public void add(T value) {
        int len = this.elements.length;
        this.elements = Arrays.copyOf(this.elements, len + 1);
        this.elements[len] = value;

    }

    public T remove(int index) {
        if (index >= this.elements.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T[] tempArr = (T[]) new Object[this.elements.length - 1];
        T tempValue = null;

        int indexForNewArr = 0;
        for (int i = 0; i < this.elements.length; i++) {
            if (i == index) {

                tempValue = this.elements[index];
                continue;
            }
            tempArr[indexForNewArr++] = this.elements[i];

        }
        this.elements = Arrays.copyOf(tempArr, tempArr.length);

        return tempValue;
    }

    public T get(int index) {
        if (index >= 0 && index < this.elements.length) {
            return this.elements[index];
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public void clear() {
        this.elements = (T[]) new Object[0];
    }

    public int size() {
        return this.elements.length;
    }

    public void resize() {
        this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.elements, this.elements.length));
    }

}
