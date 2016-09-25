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
		if (isNullOrEmpty()) {
			return;
		}
		iterationSort(0, data.length - 1);
	}
	
	/**
	 * 递归的快速排序
	 * @param begin 排序的开始位置
	 * @param end 排序的结束位置
	 */
	private void iterationSort(int begin, int end) {
		if (begin >= end) {  //  如果分段中的数小于等于1个，直接返回
			return;
		}
		int top = begin;
		int bottom = end;
		int key = data[top];
		while (top < bottom) {
			while (bottom > top) {
				if (data[bottom] <= key) {  //  注意在这两处判断的地方要有一处有等于号
					swap(top, bottom);
					break;
				}
				bottom--;  //  不管是否发生交换，这里都需要移动
			}
			while (top < bottom) {
				if (data[top] > key) {
					swap(top, bottom);
					break;
				}
				top++;  //  不管是否发生交换，这里都需要移动
			}
		}
		iterationSort(begin, top - 1);  // 递归时记得减1和加1
		iterationSort(top + 1, end);
	}
}
