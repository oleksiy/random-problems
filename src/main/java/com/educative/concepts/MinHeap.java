package com.educative.concepts;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A Min Heap is a complete binary tree in which the value of each internal node is smaller than or equal to the values
 * in the children of that node. In other words the root must be less than or equal to its children. This property is recursively
 * true for all sub-trees in that the binary tree that makes up the heap. The smallest value is always at the root
 * What's a complete binary tree? It's a binary tree where every level except possibly the last is completely filled,
 * and all the nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes at the last
 * level h.
 * A heap with N nodes has log N height and it's useful at removing lowest or highest priority items.
 *
 * Retrievals/Operations:
 * maximum/minimum element - O(1)
 * Insert element into max or min heap is O(log N)
 * Remove Maximum or minimum element O(log N)
 *
 * Mapping the elements in a min heap:
 * If an element is stored at index k, its left child is stored at index 2k+1. Its right child is stored at index 2k+2
 * The root is arr[0]
 * arr[(i-1)/2] - returns parent
 * arr[(2*i)+1] - returns left child
 * arr[(2*i)+2] - returns right child
 *
 * typical operations of Min/Max Heap
 * getMin() - returns the root
 * extractMin() - removes minimum element from MinHeap
 * insert() - add a new key to the end of the tree. If a new key is larger than its parent, don't need to do anything.
 * If it isn't larger than its parent then we traverse up the tree until it's fixed.
 */
public class MinHeap {
    private int[] heap;
    private int size = 0;
    private int maxSize = 0;

    private static Logger log = Logger.getLogger("minheap.log");
    public MinHeap(int maxSize) {
        log.setLevel(Level.ALL);
        this.heap = new int[this.maxSize + 1];
        this.size = this.heap.length;
        this.maxSize = maxSize;
        this.heap[0] = Integer.MIN_VALUE;
        log.log(Level.INFO, "heap created with size {0}", this.size);
    }

    private int getParent(int position) {
        return (position - 1) / 2;
    }

    private int getLeftChild(int position) {
        return (2 * position) + 1;
    }

    private int getRightChild(int position) {
        return (2 * position) + 2;
    }

    private boolean isLeaf(int position) {
        if (position > (size/2)) {
            return true;
        } else {
            return false;
        }
    }

    private void swap(int firstPos, int secondPos) {
        int temp = this.heap[firstPos];
        this.heap[firstPos] = this.heap[secondPos];
        this.heap[secondPos] = temp;
    }

    private void minHeapify(int pos) {
        if(!isLeaf(pos)) {

        }
    }

}
