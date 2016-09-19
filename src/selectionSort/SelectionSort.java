package selectionSort;

import main.BaseSortClass;
/**
 * 选择排序
 * In-place sort，unstable sort
 * @author Administrator
 *
 */
public class SelectionSort extends BaseSortClass {
	
	/**
	 * 直接选择排序
	 * 最好时间复杂度O(N^2)，最差时间复杂度O(N^2)，平均时间复杂度O(N^2)
	 */
	public void straightSelectSorting() {
		int pos = 0;
		for (int i = 0; i < data.length; i++) {
			pos = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[pos]) {
					pos = j;
				}
			}
			swap(i, pos);
		}
	}
	
	/**
	 * 树形选择排序，又称锦标赛排序
	 */
	public void tournamentSort() {
		
	}
	
	/**
	 * 堆排序（大根堆）
	 * 最好时间复杂度O(NlogN)，最差时间复杂度O(NlogN)，平均时间复杂度O(NlogN)
	 */
	public void heapSort() {
		//  初始化数组，使数组成为大根堆
		buildMaxHeapify();
		//  将第一个数和最后一个数交换，然后使除最后一个数之外的数组成为大根堆
		for (int i = data.length - 1; i > 0; i--) {
			swap(0, i);
			maxHeapify(i - 1, 0);
		}
	}
	
	/**
	 * 初始化建立大根堆
	 */
	private void buildMaxHeapify() {
		//  获取从后往前第一个父节点
		int startIndex = getParentNode(data.length - 1);
		for (int i = startIndex; i >= 0; i--) {
			maxHeapify(data.length - 1, i);
		}
	}
	
	/**
	 * 调整大根堆
	 * @param size 调整的深度
	 * @param index 从该节点开始调整
	 */
	private void maxHeapify(final int size, final int index) {
		int left = getLeftNode(index);  //  获取左节点
		int right = getRightNode(index);  //  获取右节点
		int parentNode = index;
		//  如果左节点在数组范围之内，并且左节点上的值比父节点上的大，那么使父节点为左节点（标志，但未交换）
		if (left <= size && data[left] > data[parentNode]) {
			parentNode = left;
		}
		//  如果右节点在数组范围之内，并且右节点上的值比标志节点上的大，那么使父节点为右节点（标志，但未交换）
		if (right <= size && data[right] > data[parentNode]) {
			parentNode = right;
		}
		//  如果父节点有改变，那么交换两个值，然后调整以原来的子节点为父节点的堆
		if (parentNode != index) {
			swap(index, parentNode);
			maxHeapify(size, parentNode);
		}
	}
	
	/**
	 * 获取指定节点的父节点
	 * @param node
	 * @return
	 */
	private int getParentNode(int node) {
		return (node - 1) / 2;
	}
	
	/**
	 * 获取指定节点的左子节点
	 * @param parentNode
	 * @return
	 */
	private int getLeftNode(int parentNode) {
		return parentNode * 2 + 1;
	}
	
	/**
	 * 获取指定节点的右子节点
	 * @param parentNode
	 * @return
	 */
	private int getRightNode(int parentNode) {
		return parentNode * 2 + 2;
	}
}
