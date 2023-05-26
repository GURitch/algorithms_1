package org.example;

import java.util.NoSuchElementException;

public class StringListImpl implements StringList {
    private static final int DEFAULT_CAPACITY = 10;
    private String[] elements;
    private int size;

    public StringListImpl() {
        this.elements = new String[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public StringListImpl(int capacity) {
        this.elements = new String[capacity];
        this.size = 0;
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (size == elements.length) {
            resizeArray();
        }
        elements[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (size == elements.length) {
            resizeArray();
        }
        // Сдвигаем элементы вправо
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        String previousItem = elements[index];
        elements[index] = item;
        return previousItem;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                // Сдвигаем элементы влево
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[size - 1] = null;
                size--;
                return item;
            }
        }
        throw new NoSuchElementException("Item not found");
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        String removedItem = elements[index];
        // Сдвигаем элементы влево
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removedItem;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return elements[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Other list cannot be null");
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!elements[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = new String[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    private void resizeArray() {
        int newCapacity = elements.length * 2;
        String[] newElements = new String[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}
