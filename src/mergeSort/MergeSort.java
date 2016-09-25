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
		if (isNullOrEmpty()) {
			return;
		}
		data = iterationSort(0, data.length - 1);  //  data为待排序数组
	}
	
	/**
	 * 迭代的归并排序
	 * @param begin 开始排序的起始位置
	 * @param end 结束排序的终止位置
	 * @return
	 */
	private int[] iterationSort(int begin, int end) {
		if (begin >= end) {  //  如果段中数的数量为1，构造一个新数组返回
			return new int[] {data[begin]};
		}
		int middle = (begin + end) / 2;  //  得到中间位置
		//  分别向下递归分段，然后合并
		return merge(iterationSort(begin, middle), iterationSort(middle + 1, end));
	}
	
	/**
	 * 合并分段
	 * @param left 第一段（已排好序）
	 * @param right 第二段（已排好序）
	 * @return
	 */
	private int[] merge(int[] left, int[] right) {
		int leftLength = left.length;  //  第一段数组长度
		int rightLength = right.length;  //  第二段数组长度
		int[] result = new int[leftLength + rightLength];  //  合并后新数组长度是原来两段数组长度之和
		int counter = 0;  //  用于移动新数组下标
		int leftSign = 0;  //  用于移动第一段数组的下标
		int rightSign = 0;  //  用于移动第二段数组的下标
		while (leftSign < leftLength && rightSign < rightLength) {  //  当两个下标都还在范围内时
			if (left[leftSign] < right[rightSign]) {  //  此时第一段下标位置的数比第二段下标位置的数小
				result[counter] = left[leftSign];  //  将该数复制进新数组
				leftSign++;  //  移动第一段的下标
			} else {  //  此时第一段下标位置的数不比第二段下标位置的数小
				result[counter] = right[rightSign];  //  将该数复制进新数组
				rightSign++;  //  移动第二段的下标
			}
			counter++;  //  移动新数组的下标
		}
		if (leftSign < leftLength) {  //  如果第一段的下标还没有移动到第一段末尾，将剩余的数复制到新数组末端
			for (; leftSign < leftLength; leftSign++, counter++) {
				result[counter] = left[leftSign];
			}
		}
		if (rightSign < rightLength) {  //  如果第二段的下标还没有移动到第二段末尾，将剩余的数复制到新数组末端
			for (; rightSign < rightLength; rightSign++, counter++) {
				result[counter] = right[rightSign];
			}
		}
		return result;  //  返回新数组
	}
}
