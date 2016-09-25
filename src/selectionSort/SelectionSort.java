package selectionSort;

import java.util.Arrays;

import main.BaseSortClass;
import util.PrintUtil;
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
		if (isNullOrEmpty()) {
			return;
		}
		int pos = 0;
		for (int i = 0; i < data.length; i++) {
			pos = i;
			//  找出从i开始，到数组末尾这段数组中最小的数，pos标志的是这个最小的数在数组中的位置
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[pos]) {
					pos = j;
				}
			}
			swap(i, pos);  //  交换两个数的位置
		}
	}
	
	/**
	 * 树形选择排序，又称锦标赛排序
	 */
	public void tournamentSort() {
		if (isNullOrEmpty()) {
			return;
		}
		
		int depth = 0;
		int nodes = 0;
		//  计算出装下待排序数组所需的二叉树的深度
		for (; Math.pow(2, depth) < data.length; depth++);
		//  计算树的总结点数
		for (int i = (int) Math.pow(2, depth); i > 0; i = i / 2) {
			nodes = nodes + i;
		}
		//  根据的到的树的总结点数创建数组
		int[] tree = new int[nodes];
		//  初始化树种结点的值
		Arrays.fill(tree, Integer.MAX_VALUE);
		//  开始存放待排序数组的树的位置
		int beginPos = nodes - (int) Math.pow(2, depth);
		//  将待排序数组中的数复制到树的叶子节点中
		for (int i = 0, j = beginPos; i < data.length; i++, j++) {
			tree[j] = data[i];
		}
		
		int loopBeginPos;
		int loopBound;
		int count;
		//  取数的次数为待排序数组的长度
		for (int i = 0; i < data.length; i++) {
			//  loopBeginPos为开始比较的位置，loopBound为结束比较的位置，
			//  下一次开始比较的位置为上一次开始比较的位置的父节点，
			//  当下一次开始比较的位置为0的时候，说明比较已经到了最顶层，可以结束这一次的比较了
			for (loopBeginPos = beginPos, loopBound = tree.length - 1; loopBeginPos > 0;
					loopBeginPos = getParentNode(loopBeginPos)) {
				//  每两个节点进行一次比较，将较小的节点赋值给他们的父节点
				for (count = loopBeginPos; count + 1 <= loopBound; count = count + 2) {
					tree[getParentNode(count)]
							= tree[count] < tree[count + 1] ? tree[count] : tree[count + 1];
				}
				//  下一次比较的结束位置，为这次比较结束节点的父节点
				loopBound = getParentNode(count - 2);
			}
			//  将这次比较得到的最小的数取出
			data[i] = tree[0];
			//  将这次比较得到的最小的数原先存放的位置存放的数赋值为max
			for (int j = beginPos; j < tree.length; j++) {
				if (tree[j] == tree[0]) {
					tree[j] = Integer.MAX_VALUE;
					break;
				}
			}
		}
	}
	
	/**
	 * 堆排序（大根堆）
	 * 最好时间复杂度O(NlogN)，最差时间复杂度O(NlogN)，平均时间复杂度O(NlogN)
	 */
	public void heapSort() {
		if (isNullOrEmpty()) {
			return;
		}
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
