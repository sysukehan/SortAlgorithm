package radixSort;

import java.util.Arrays;

import main.BaseSortClass;

/**
 * 基数排序
 * stable sort、Out-place sort
 * 时间复杂度O(d*(n+r))，d是位数，r是分配后链表的数目，n是数据量
 * 空间复杂度O(N)
 * @author Administrator
 *
 */
public class RadixSort extends BaseSortClass {

	/**
	 * Most Significant Digit first，最高数位优先
	 */
	public void msdSort() {
		if (isNullOrEmpty()) {  //  用于判断待排序数组是否为空或长度为0
			return;
		}
		int maxLength = String.valueOf(getMax()).length();
		int divider = (int) Math.pow(10, maxLength - 1);
		data = msdIterationSort(data, divider);
	}
	
	/**
	 * 迭代的msd排序
	 * @param data 待排序数组
	 * @param divider 用于取出数位的除数
	 * @return
	 */
	private int[] msdIterationSort(int[] data, int divider) {
		int[][] radix = new int[10][data.length];
		int[] index = new int[10];
		Arrays.fill(index, 0);
		int sum = 0;
		//  将数分配到对应的桶中
		for (int j = 0; j < data.length; j++) {
			int pos = data[j] / divider % 10;
			radix[pos][index[pos]] = data[j];
			index[pos]++;
		}
		//  得到下一次迭代所用的除数
		divider = divider / 10;
		//  如果除数大于0，则需要对桶中的数据进行下一次迭代
		if (divider > 0) {
			//  对每个桶都要再次迭代
			for (int i = 0; i < 10; i++) {
				//  需要对桶的大小进行处理，因为创建桶的时候长度为待处理数据的长度，
				//  需要创建一个新数组来存放原来桶中的数据，然后用做下一次迭代
				int[] temp = new int[index[i]];
				for (int j = 0; j < index[i]; j++) {
					temp[j] = radix[i][j];
				}
				radix[i] = msdIterationSort(temp, divider);
			}
		}
		//  除数不大于0的时候说明对数的每一位都处理完了，接下来将每个桶中的数据拼接起来得到排好序的数据
		//  然后返回排好序的数据
		for (int i = 0; i < 10; i++) {
			sum = sum + index[i];
		}
		int[] result = new int[sum];
		int counter = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < index[i]; j++) {
				result[counter] = radix[i][j];
				counter++;
			}
		}
		return result;
	}
	
	/**
	 * Least Significant Digit first，最低数位优先
	 */
	public void lsdSort() {
		if (isNullOrEmpty()) {
			return;
		}
		int maxLength = String.valueOf(getMax()).length();
		int[][] radix;
		int[] index;
		for (int i = 0; i < maxLength; i++) {
			radix = new int[10][data.length];
			index = new int[10];
			Arrays.fill(index, 0);
			int divider = (int) Math.pow(10, i);  //  使用做除法然后取余的方法来取出某一位
			//  分配桶
			for (int j = 0; j < data.length; j++) {
				int temp = data[j];
				int key = temp / divider % 10;
				//  某个桶中数据增加之后，对应的计数器要加1
				radix[key][index[key]] = temp;
				index[key]++;
			}
			//  拼接桶中的数据
			int counter = 0;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < index[j]; k++) {
					data[counter] = radix[j][k];
					counter++;
				}
			}
		}
	}
}
