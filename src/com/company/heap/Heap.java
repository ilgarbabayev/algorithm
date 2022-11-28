package com.company.heap;

public class Heap {

  public static void main(String[] args) {
    Heap heap1 = new Heap(10);

    heap1.insert(80);
    heap1.insert(75);
    heap1.insert(60);
    heap1.insert(68);
    heap1.insert(55);
    heap1.insert(40);
    heap1.insert(52);
    heap1.insert(67);
    heap1.insert(95);

    heap1.printHeap();

    heap1.delete(5);
    heap1.printHeap();

    System.out.println(heap1.peek());
    heap1.delete(0);
    System.out.println(heap1.peek());
  }

  private int[] heap;
  private int size;

  public Heap(int capasity) {
    this.heap = new int[capasity];
  }

  public void insert(int value) {
    if (isFull()) {
      throw new IndexOutOfBoundsException("Heap is full");
    }

    heap[size] = value;

    fixHeapAbove(size++);
  }

  public int peek() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Heap is empty");
    }

    return heap[0];
  }

  public int delete(int index) {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Heap is empty");
    }

    int parent = getParent(index);
    int deletedValue = heap[index];

    heap[index] = heap[size - 1];

    if (index == 0 || heap[index] < heap[parent]) {
      fixHeapBelow(index, size - 1);
    } else {
      fixHeapAbove(index);
    }

    size--;

    return deletedValue;
  }

  private void fixHeapAbove(int index) {
    int newValue = heap[index];

    while (index > 0 && newValue > heap[getParent(index)]) {
      heap[index] = heap[getParent(index)];
      index = getParent(index);
    }

    heap[index] = newValue;
  }

  private void fixHeapBelow(int index, int lastHeapIndex) {
    int childToSwap;

    while (index <= lastHeapIndex) {
      int leftChild = getChild(index, true);
      int rightChild = getChild(index, false);

      if (leftChild <= lastHeapIndex) {
        if (rightChild > lastHeapIndex) {
          childToSwap = leftChild;
        } else {
          childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
        }

        if (heap[index] < heap[childToSwap]) {
          int tmp = heap[index];
          heap[index] = heap[childToSwap];
          heap[childToSwap] = tmp;
        } else {
          break;
        }

        index = childToSwap;
      } else {
        break;
      }
    }
  }

  public void printHeap() {
    for (int i = 0; i < size; i++) {
      System.out.print(heap[i] + ", ");
    }
    System.out.println();
  }

  public boolean isFull() {
    return size == heap.length;
  }

  public int getParent(int index) {
    return (index - 1) / 2;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getChild(int index, boolean left) {
    return 2 * index + (left ? 1 : 2);
  }
}
