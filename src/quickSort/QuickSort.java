package quickSort;

import main.BaseSortClass;

/**
 * 快速排序
 * unstable sort、In-place sort
 * 最坏时间复杂度O(N^2)，最好时间复杂度O(NlogN)，平均时间复杂度O(NlogN)
 * @author Administrator
 *
 */
public class QuickSort extends BaseSortClass {
	
	public void sort() {
		iterationSort(0, data.length - 1);
	}
	
	private void iterationSort(int begin, int end) {
		if (begin >= end) {
			return;
		}
		int top = begin;
		int bottom = end;
		int key = data[top];
		while (top < bottom) {
			while (bottom > top) {
				if (data[bottom] <= key) {  //  
					swap(top, bottom);
					break;
				}
				bottom--;
			}
			while (top < bottom) {
				if (data[top] > key) {
					swap(top, bottom);
					break;
				}
				top++;
			}
		}
		iterationSort(begin, top - 1);
		iterationSort(top + 1, end);
	}
}
