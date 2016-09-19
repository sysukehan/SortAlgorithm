package countingSort;

import java.util.Arrays;

import main.BaseSortClass;

/**
 * 计数排序
 * stable sort、out-place sort
 * 最坏运行时间：O(N+k)，最好运行时间：O(N+k)，平均运行时间：O(N+k)
 * @author Administrator
 *
 */
public class CountingSort extends BaseSortClass {
	
	public void sort() {
		int[] copyData = Arrays.copyOf(data, data.length);
		if (isNullOrEmpty()) {
			return;
		}
		int min = copyData[0];
		int max = copyData[0];
		for (int x : copyData) {
			if (x > max) {
				max = x;
				continue;
			}
			if (x < min) {
				min = x;
			}
		}
//		PrintUtil.printMessage("min:" + min + ";max:" + max);
		int[] counts = new int[max - min + 1];
		//  计算数组中每个值和最小值的差，并计数
		for (int x : copyData) {
			counts[x - min]++;
		}
//		PrintUtil.printArrays(counts);
		//  得到数组中大于某个数的值一共有多少个
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i - 1];
		}
		//  根据数量放置值，每放置一个，对应的值的数量减一
		for (int i = 0; i < copyData.length; i++) {
			int index = copyData[i] - min;
//			PrintUtil.printMessage("index:" + index + ";counts[index]:" + counts[index]);
			data[counts[index] - 1] = copyData[i];
			counts[index]--;
		}
	}
	
}
