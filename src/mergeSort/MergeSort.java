package mergeSort;

import main.BaseSortClass;

/**
 * 归并排序
 * stable sort、Out-place sort
 * 最好时间复杂度O(NlogN)，最差时间复杂度O(NlogN)，平均时间复杂度O(NlogN)
 * 空间复杂度O(N)
 * @author Administrator
 *
 */
public class MergeSort extends BaseSortClass {
	
	public void sort() {
		data = iterationSort(0, data.length - 1);
	}
	
	private int[] iterationSort(int begin, int end) {
		if (begin >= end) {
			return new int[] {data[begin]};
		}
		int middle = (begin + end) / 2;
		return merge(iterationSort(begin, middle), iterationSort(middle + 1, end));
	}
	
	private int[] merge(int[] left, int[] right) {
		int leftLength = left.length;
		int rightLength = right.length;
		int[] result = new int[leftLength + rightLength];
		int counter = 0;
		int leftSign = 0;
		int rightSign = 0;
		while (leftSign < leftLength && rightSign < rightLength) {
			if (left[leftSign] < right[rightSign]) {
				result[counter] = left[leftSign];
				leftSign++;
			} else {
				result[counter] = right[rightSign];
				rightSign++;
			}
			counter++;
		}
		if (leftSign < leftLength) {
			for (; leftSign < leftLength; leftSign++, counter++) {
				result[counter] = left[leftSign];
			}
		}
		if (rightSign < rightLength) {
			for (; rightSign < rightLength; rightSign++, counter++) {
				result[counter] = right[rightSign];
			}
		}
		return result;
	}
}
