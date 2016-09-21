package main;

import java.util.Arrays;
import java.util.Calendar;

import bubbleSort.BubbleSort;
import bucketSort.BucketSort;
import countingSort.CountingSort;
import insertionSort.InsertionSort;
import mergeSort.MergeSort;
import quickSort.QuickSort;
import radixSort.RadixSort;
import selectionSort.SelectionSort;
import util.CheckUtil;
import util.PrintUtil;

public class Main {

	private final static int loopTime = 10000000;
	
	private static int[] data = new int[loopTime];
	private static int[] copyData;
	
	private static long beginTime;
	private static long endTime;
	
	private static void getRandomList() {
		for (int i = 0; i < loopTime; i++) {
			data[i] = (int) (Math.random() * 10000000);
		}
	}
	
    public static void main(String[] args) {
    	getRandomList();
    	System.out.println(loopTime + "个数据");
//    	bubbleSort();  //  基本冒泡排序、优化冒泡排序
    	insertionSort();  //  基本插入排序、二分插入排序、希尔排序
//    	selectionSort();  //  直接选择排序、树形选择排序、堆排序（大根堆）
//    	quickSort();  //  快速排序
//    	countingSort();  //  计数排序
//    	bucketSort();  //  桶排序
//    	radixSort();  //  基数排序
//    	mergeSort();  //  归并排序
	}
    
    /**
     * 各类冒泡排序
     */
    private static void bubbleSort() {
    	
    	BubbleSort bs = new BubbleSort();
    	
    	PrintUtil.printMessage("基本冒泡排序：");
    	copyData = Arrays.copyOf(data, loopTime);
		bs.setData(copyData);
		isSort(bs.getData());
//		bs.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		bs.sort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(bs.getData());
		PrintUtil.printMessage((endTime - beginTime) + "ms");
//		bs.print();
		
		PrintUtil.printMessage("改进版冒泡排序：");
    	copyData = Arrays.copyOf(data, loopTime);
		bs.setData(copyData);
		isSort(bs.getData());
//		bs.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		bs.improveSort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(bs.getData());
		PrintUtil.printMessage((endTime - beginTime) + "ms");
//		bs.print();
    }
    
    /**
     * 各类插入排序
     */
    private static  void insertionSort() {
    	
    	InsertionSort is = new InsertionSort();
    	
//    	PrintUtil.printMessage("基本插入排序：");
//    	copyData = Arrays.copyOf(data, loopTime);
//    	is.setData(copyData);
//		isSort(is.getData());
////		is.print();
//		beginTime = Calendar.getInstance().getTimeInMillis();
//		is.sort();
//		endTime = Calendar.getInstance().getTimeInMillis();
//		isSort(is.getData());
//		PrintUtil.printMessage((endTime - beginTime) + "ms");
//
//    	PrintUtil.printMessage("二分插入排序：");
//    	copyData = Arrays.copyOf(data, loopTime);
//		is.setData(copyData);
//		isSort(is.getData());
////		is.print();
//		beginTime = Calendar.getInstance().getTimeInMillis();
//		is.binaryInsertSort();
//		endTime = Calendar.getInstance().getTimeInMillis();
//		isSort(is.getData());
////		is.print();
//		PrintUtil.printMessage((endTime - beginTime) + "ms");
		
    	PrintUtil.printMessage("希尔排序：");
    	copyData = Arrays.copyOf(data, loopTime);
		is.setData(copyData);
		isSort(is.getData());
//		is.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		is.shellSort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(is.getData());
//		is.print();
		PrintUtil.printMessage((endTime - beginTime) + "ms");
    }
    
    /**
     * 各类选择排序
     */
    private static void selectionSort() {
    	SelectionSort ss = new SelectionSort();
    	
//    	PrintUtil.printMessage("直接选择排序：");
//    	copyData = Arrays.copyOf(data, loopTime);
//    	ss.setData(copyData);
//		isSort(ss.getData());
////		ss.print();
//		beginTime = Calendar.getInstance().getTimeInMillis();
//		ss.straightSelectSorting();
//		endTime = Calendar.getInstance().getTimeInMillis();
//		isSort(ss.getData());
////		ss.print();
//		PrintUtil.printMessage((endTime - beginTime) + "ms");
		
    	PrintUtil.printMessage("锦标赛排序：");
    	copyData = Arrays.copyOf(data, loopTime);
    	ss.setData(copyData);
		isSort(ss.getData());
//		ss.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		ss.tournamentSort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(ss.getData());
//		ss.print();
		PrintUtil.printMessage((endTime - beginTime) + "ms");
    	
//    	PrintUtil.printMessage("大根堆排序：");
//    	copyData = Arrays.copyOf(data, loopTime);
//    	ss.setData(copyData);
//		isSort(ss.getData());
////		ss.print();
//		beginTime = Calendar.getInstance().getTimeInMillis();
//		ss.heapSort();
//		endTime = Calendar.getInstance().getTimeInMillis();
//		isSort(ss.getData());
////		ss.print();
//		PrintUtil.printMessage((endTime - beginTime) + "ms");
    }
    
    /**
     * 快速排序
     */
    private static void quickSort() {
    	QuickSort qs = new QuickSort();
    	
    	PrintUtil.printMessage("快速排序：");
    	copyData = Arrays.copyOf(data, loopTime);
    	qs.setData(copyData);
		isSort(qs.getData());
//		qs.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		qs.sort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(qs.getData());
//		qs.print();
		PrintUtil.printMessage((endTime - beginTime) + "ms");
    }
    
    private static void countingSort() {
    	CountingSort cs = new CountingSort();
    	
    	PrintUtil.printMessage("计数排序：");
    	copyData = Arrays.copyOf(data, loopTime);
    	cs.setData(copyData);
		isSort(cs.getData());
//		cs.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		cs.sort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(cs.getData());
//		cs.print();
		PrintUtil.printMessage((endTime - beginTime) + "ms");
    }
    
    private static void bucketSort() {
    	BucketSort bs = new BucketSort();
    	
    	PrintUtil.printMessage("桶排序：");
    	copyData = Arrays.copyOf(data, loopTime);
    	bs.setData(copyData);
		isSort(bs.getData());
//		bs.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		bs.sort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(bs.getData());
//		bs.print();
		PrintUtil.printMessage((endTime - beginTime) + "ms");
    }
    
    private static void radixSort() {
    	RadixSort rs = new RadixSort();
    	
    	PrintUtil.printMessage("lsd基数排序：");
    	copyData = Arrays.copyOf(data, loopTime);
    	rs.setData(copyData);
		isSort(rs.getData());
//		rs.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		rs.lsdSort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(rs.getData());
//		rs.print();
		PrintUtil.printMessage((endTime - beginTime) + "ms");
		
    	PrintUtil.printMessage("msd基数排序：");
    	copyData = Arrays.copyOf(data, loopTime);
    	rs.setData(copyData);
		isSort(rs.getData());
//		rs.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		rs.msdSort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(rs.getData());
//		rs.print();
		PrintUtil.printMessage((endTime - beginTime) + "ms");
    }
    
    private static void mergeSort() {
    	MergeSort ms = new MergeSort();
    	
    	PrintUtil.printMessage("归并排序：");
    	copyData = Arrays.copyOf(data, loopTime);
    	ms.setData(copyData);
		isSort(ms.getData());
//		ms.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		ms.sort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(ms.getData());
//		ms.print();
		PrintUtil.printMessage((endTime - beginTime) + "ms");
    }
    
    private static void isSort(int[] arrays) {
		if (CheckUtil.isSort(arrays)) {
			PrintUtil.printMessage("sort");
		} else {
			PrintUtil.printMessage("not sort");
		}
    }

}
