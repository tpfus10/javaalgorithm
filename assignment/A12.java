//실습6_16_1heap정렬
package assignment;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);

	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap; // heap은 참조변수
	private int n; // MaxHeap의 현재 입력된 element 개수
	private int MaxSize; // Maximum allowable size of MaxHeap

	public Heap(int sz) { // 생성자
		n = 0;
		MaxSize = sz;
		heap = new int[MaxSize + 1]; // heap에 메모리 공간 할당
	}

	public void display() {// heap 배열을 출력한다. 배열 인덱스와 heap[]의 값을 출력한다.
		for (int i = 1; i <= n; i++) { // n이 1부터 시작하기 때문에 개수와 일치
			System.out.printf("[%d] : %d\n", i, heap[i]);
		}

	}

	@Override
	public void Insert(int x) {// max heap이 되도록 insert한다. 삽입후 complete binary tree가 유지되어야 한다.
		int i;
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		
		n++;
		for (i = n; i > 1; i = i / 2) { //루트까지 부모 노드와의 비교를 반복
			//heap[i / 2]: 부모 노드
			if (x <= heap[i / 2])
				break;
			heap[i] = heap[i/2];
		}
		heap[i] = x; //break 후에 오는 곳

	}

	@Override
	public int DeleteMax() {// heap에서 가장 큰 값을 삭제하여 리턴한다.
		int x;
		int i, j;
		if (n == 0) {
			HeapEmpty();
			int elm = 0;
			return elm;
		}

		return x;
	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}

public class A12 {
	static void showData(int[] d) {
		for (int num : d) {
			System.out.print(num + " ");
		}
	}

	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
		final int count = 10;// 난수 생성 갯수
		int data = 0;
		int[] x = new int[count + 1];// x[0]은 사용하지 않으므로 11개 정수 배열을 생성한다
		int[] sorted = new int[count];// heap을 사용하여 deleted 정수를 배열 sorted[]에 보관후 출력한다

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:// 난수를 생성하여 배열 x에 넣는다 > heap에 insert한다.
				for (int i = 1; i < count + 1; i++) {
					data = stdIn.nextInt(20);
					System.out.println("Input data: " + data);
					x[i] = data;
					heap.Insert(data);
				}
				showData(x);
				break;

			case 2: // heap 트리구조를 배열 인덱스를 사용하여 출력한다.
				heap.display();
				break;

			case 3:// heap에서 delete를 사용하여 삭제된 값을 배열 sorted에 넣는다 > 배열 sorted[]를 출력하면 정렬 결과를 얻는다
				for (int i = 0; i < count; i++) {
					sorted[i] = heap.DeleteMax();
				}
				showData(sorted);
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}
