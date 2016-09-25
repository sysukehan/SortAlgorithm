package bucketSort;

import java.util.Arrays;

import main.BaseSortClass;

/**
 * 桶排序
 * out-place sort、stable sort
 * 最坏运行时间取决于子桶排序使用的排序算法，如果使用快排或者堆排序的话为O(NlgN)，如果使用插入排序的话是O(N^2)
 * 最优运行时间为O(N)
 * 空间复杂度O(N+M)，N为数据量，M为桶的数量
 * @author Administrator
 *
 */
public class BucketSort extends BaseSortClass {
	
	private int[][] bucket;
	private int[] index;
	
	
	public BucketSort(int[] data) {
		super(data);
		bucket = new int[10][data.length];
		index = new int[10];
		Arrays.fill(index, 0);
	}
	
	public BucketSort() {
		super();
	}
	
	@Override
	public void setData(int[] data) {
		super.setData(data);
		bucket = new int[10][data.length];
		index = new int[10];
		Arrays.fill(index, 0);
	}
	
	public void sort() {
		if (isNullOrEmpty()) {
			return;
		}
		int divider = (int) Math.pow(10, String.valueOf(getMax()).length() - 1);
		for (int i = 0; i < data.length; i++) {
			int pos = data[i] / divider;
			//  将新数值放入桶中之后，桶中的数据变为无序，
			//  由于除放在最后的那个数之外，其余的数都是有序的，因此考虑使用插入排序来使桶中的数据重新有序
			bucket[pos][index[pos]] = data[i];
			index[pos]++;
			if (index[pos] <= 1) {  //  桶中只有一个数据时，不需要插入排序，继续循环
				continue;
			}
			//  基本插入排序
			for (int j = index[pos] - 1; j > 0; j--) {
				if (bucket[pos][j] < bucket[pos][j - 1]) {
					swap(j, j - 1, bucket[pos]);
				} else {
					break;
				}
			}
//			//  二分插入排序
//			binarySort(bucket[pos], index[pos] - 1);
		}
		int counter = 0;
		for (int i = 0; i < 10; i++) {
			counter = getBucketResult(i, counter);
		}
	}
	
	private void swap(int i, int j, int[] bucketData) {
		int temp = bucketData[i];
		bucketData[i] = bucketData[j];
		bucketData[j] = temp;
	}
	
	private void binarySort(int[] data, int pos) {
		int begin = 0;
		int end = pos - 1;
		int key = data[pos];
		int dst;
		while (begin < end - 1) {
			int middle = (begin + end) / 2;
			if (key > data[middle]) {
				begin = middle;
			} else {
				end = middle;
			}
		}
		if (key < data[begin]) {
			dst = begin;
		} else if (key < data[end]) {
			dst = end;
		} else {
			dst = end + 1;
		}
		for (int i = pos; i > dst; i--) {
			data[i] = data[i - 1];
		}
		data[dst] = key;
	}
	
	/**
	 * 取出桶中的数据，并且返回下一个放入data中的数据应存放的位置
	 * @param pos 桶的编号
	 * @param counter 下一个放入data中的数据应存放的位置
	 * @return
	 */
	private int getBucketResult(int pos, int counter) {
		for (int i = 0; i < index[pos]; i++) {
			data[counter] = bucket[pos][i];
			counter++;
		}
		return counter;
	}
}
