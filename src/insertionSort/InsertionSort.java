package insertionSort;

import main.BaseSortClass;

/**
 * 插入排序
 * stable sort、In-place sort
 * @author kehan
 *
 */
public class InsertionSort extends BaseSortClass {
	
	/**
	 * 直接插入排序
	 * 最差时间复杂度为O(N^2)，最优时间复杂度为O(N)，平均时间复杂度为O(N^2)
	 */
	public void sort() {
		if (isNullOrEmpty()) {
			return;
		}
		for (int key = 1; key < data.length; key++) {
			for (int i = key; i > 0; i--) {
				if (data[i] < data[i - 1]) {
					swap(i - 1, i);  //  交换两个位置的数
				} else {
					break;
				}
			}
		}
	}
	
	/**
	 * 二分插入排序
	 * 最差时间复杂度为O(N^2)，最优时间复杂度为O(N)，平均时间复杂度为O(N^2)
	 */
	public void binaryInsertSort() {
		if (isNullOrEmpty()) {
			return;
		}
		
		//  从第一位开始二分插入排序
		for (int key = 1; key < data.length; key++) {
			binarySort(key);
		}
	}
	
	/**
	 * 二分查找key下标的值应该插入在哪个位置并插入
	 * @param key
	 */
	private void binarySort(int key) {
		int temp = data[key];
		int beginPos = 0;  //  查找开始的位置
		int endPos = key - 1;  //  查找结束的位置
		while (endPos - beginPos > 1) {  //  如果数组分割到两端相差小于等于1的时候，跳出循环
			int middle = (beginPos + endPos) / 2;  //  找到中间位置
			//  如果中间位置的数比哨位位置的数要小，那么说明哨位位置的数应该在中间位置的右边，改变beginPos的值
			if (data[middle] < temp) {
				beginPos = middle;
			} else {
				//  如果中间位置的数比哨位位置的数要大，
				//  那么说明哨位位置的数应该在中间位置的左边，改变endPos的值
				endPos = middle;
			}
		}
		if (temp < data[beginPos]) {  //  如果temp值比beginPos小，那么应该插在beginPos前面
			moveData(beginPos, key);
		} else if (temp < data[endPos]) {  //  如果temp值比endPos小，那么应该插在endPos前面
			moveData(endPos, key);
		} else {    //  如果temp值比endPos大，那么应该插在endPos后面一位
			moveData(endPos + 1, key);
		}
	}
	
	/**
	 * 将数组中从begin到end位置的数循环右移一位
	 * @param begin
	 * @param end
	 */
	private void moveData(int begin, int end) {
		int temp = data[end];  //  先取出最后一位，防止被覆盖掉
		for (int i = end; i > begin; i--) {  //  从后开始，使后一位的数等于前一位的数
			data[i] = data[i - 1];
		}
		data[begin] = temp;  //  让第一位等于之前取出的最后一位
	}
	
	/**
	 * 希尔排序
	 * 最差时间复杂度为O(N^2)，最好时间复杂度为O(N)，平均时间复杂度为O(N^1.3)，在N较小时速度较快
	 */
	public void shellSort() {
		if (isNullOrEmpty()) {
			return;
		}
		//  增量设置为待排序数组长度的一半，之后不断折半，直到等于1
		for (int cap = data.length / 2; cap > 0; cap = cap / 2) {
			//  从数组下标为0的位置开始，到增量长度大小的位置停止，这其中每个数都是希尔排序分段中每一段的开头
			for (int i = 0; i < cap; i++) {
				//  从这里开始，是对每一段进行直接插入排序
				//  由于希尔排序是不占用多余空间的，而且将这些数虽然被分为一段，但是在待排序的数组中是分散的，
				//  并且还不知道分段的最后一位是在哪一位，所以综合考虑，只能是使用直接插入排序来使它们有序
				//  key是每一段开头的下一个数，这里的下一个是指分段中的下一个，分段中每一个数都是不连续的
				for (int key = i + cap; key < data.length; key = key + cap) {
					for (int j = key - cap; j >= 0; j = j - cap) {
						if (data[j + cap] < data[j]) {  //  如果后一位比前一位小，那么交换这两个数
							swap(j + cap, j);
						} else {  //  否则，跳出循环
							break;
						}
					}
				}
			}
		}
	}
}
