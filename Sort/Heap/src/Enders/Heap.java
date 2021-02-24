package Enders;

import java.util.*;

public class Heap {
	private static final int d = 2;
	private int[] heap;
	private int heapSize;

	public Heap(int capacity) {
		heapSize = 0;
		heap = new int[capacity + 1];
		Arrays.fill(heap, -1);
	}

	public boolean isEmpty() { 
		return heapSize == 0;
	}

	public boolean isFull() {
		return heapSize == heap.length;
	}

	private int parent(int i) { // returns the parent index of the given index
		return (i - 1) / d;
	}

	private int kthChild(int i, int k) { // returns 
		return d * i + k;
	}

	public void insert(int x) throws Exception {
		if (isFull()) {
			throw new Exception("Heap is full");
		}
		heap[heapSize++] = x;
		upHeap(heapSize - 1);
	}

	public int delete(int x) throws Exception {
		if (isEmpty())
			throw new Exception("Heap is empty");
		int key = heap[x];
		heap[x] = heap[heapSize - 1];
		heapSize--;
		downHeap(x);
		return key;
	}

	// maintain heap property during insertion
	private void upHeap(int i) {
		
		try {
			if (heap[i] <= heap[parent(i)] || i <= 0 ) { // if these conditions met it means it is finished
				return;
			}
			else {
				int keep = heap[parent(i)]; // saving parent value
				
				heap[parent(i)] = heap[i]; // parent value is changed to child value
				heap[i] = keep; // change child value to parent value
				
				upHeap(parent(i)); // go one step up
			}
		}
		
		catch (Exception e){ // if anything problematic happens it ends
			return;
		}
	}

	// maintain heap property during deletion
	private void downHeap(int i) {
		
		try {
			if (heap[i] <= heap[maxChild(i)] || i >= heap.length ) {  // if these conditions met it means it is finished
				return;
			}
			else {
				int hold = maxChild(i);;
				
				if (kthChild(i, 1) >= kthChild(i, 2)) { // save the smaller child's index
					hold = kthChild(i, 2);
				}
				else {
					hold = kthChild(i, 1);
				}
				
				int keep = heap[hold]; // saving the value of smaller child
				
				heap[hold] = heap[i]; // change smaller child value to parent
				heap[i] = keep; // change parent value to old smaller child value
		
				downHeap(hold);
			}
		}
		catch (Exception e) { // if anything problematic happens it ends
			return;
		}
	}

	private int maxChild(int i) {
		int leftChild = kthChild(i, 1);
		int rightChild = kthChild(i, 2);
		return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
	}

	public void printHeap() {     
		for (int i = 0; i < heapSize; i++)    
			System.out.print(heap[i] + " ");    
		System.out.println();   
		}
	
// return max from the heap 
public int findMax() {
	if (isEmpty()) throw new NoSuchElementException("Heap is empty.");
	return heap[0];
}

public int[] getHeap() {    // returns int [] heap  
	// This method is used for autotesting     
	return heap;  
	}

}

