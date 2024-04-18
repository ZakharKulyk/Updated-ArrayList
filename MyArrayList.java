package ua.goit.polymorpism.Module9.HomeWork9;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] elements;
    private int iterationIndex = 0;


    public MyArrayList() {
        this.elements = (T[]) new Object[0];
    }


    public void add(T value) {
        int len = this.elements.length;
        if (len == 0) {
            this.elements = Arrays.copyOf(this.elements, len + 1);

        }
        if (len == this.iterationIndex) {
            resize();
        }
        this.elements[iterationIndex] = value;
        iterationIndex++;

    }

    public T remove(int index) {
        if (index >= this.iterationIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T[] tempArr = (T[]) new Object[this.iterationIndex-1];
        T tempValue = null;

        int indexForNewArr = 0;
        for (int i = 0; i < this.iterationIndex; i++) {
            if (i == index) {
                tempValue = this.elements[index];
                continue;
            }
            tempArr[indexForNewArr++] = this.elements[i];
        }
        iterationIndex--;
        this.elements = Arrays.copyOf(tempArr, iterationIndex);

        return tempValue;
    }

    public T get(int index) {
        if (index >= 0 && index < this.iterationIndex) {
            return this.elements[index];
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public void clear() {
        this.elements = (T[]) new Object[0];
        this.iterationIndex = 0;
    }

    public int size() {
        return this.iterationIndex;
    }

    public void resize() {
        this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.elements, this.iterationIndex));
    }

}
