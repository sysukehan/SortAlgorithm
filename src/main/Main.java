package main;

import java.util.Arrays;
import java.util.Calendar;

import bubbleSort.BubbleSort;
import insertionSort.InsertionSort;
import selectionSort.SelectionSort;
import util.CheckUtil;
import util.PrintUtil;

public class Main {

	private final static int loopTime = 100000;
	
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
    	bubbleSort();
    	insertionSort();
    	selectionSort();
	}
    
    /**
     * 各类冒泡排序
     */
    private static void bubbleSort() {
    	
    	BubbleSort bs = new BubbleSort();
    	
    	PrintUtil.printMessage("基本冒泡排序：");
    	copyData = Arrays.copyOf(data, loopTime);
		bs.setArrays(copyData);
		isSort(bs.getArrays());
//		bs.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		bs.sort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(bs.getArrays());
		PrintUtil.printMessage((endTime - beginTime) + "ms");
//		bs.print();
		
		PrintUtil.printMessage("改进版冒泡排序：");
    	copyData = Arrays.copyOf(data, loopTime);
		bs.setArrays(copyData);
		isSort(bs.getArrays());
//		bs.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		bs.improveSort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(bs.getArrays());
		PrintUtil.printMessage((endTime - beginTime) + "ms");
//		bs.print();
    }
    
    /**
     * 各类插入排序
     */
    private static  void insertionSort() {
    	
    	InsertionSort is = new InsertionSort();
    	
    	PrintUtil.printMessage("基本插入排序：");
    	copyData = Arrays.copyOf(data, loopTime);
    	is.setArrays(copyData);
		isSort(is.getArrays());
//		is.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		is.sort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(is.getArrays());
		PrintUtil.printMessage((endTime - beginTime) + "ms");

    	PrintUtil.printMessage("二分插入排序：");
    	copyData = Arrays.copyOf(data, loopTime);
		is.setArrays(copyData);
		isSort(is.getArrays());
//		is.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		is.binaryInsertSort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(is.getArrays());
//		is.print();
		PrintUtil.printMessage((endTime - beginTime) + "ms");
		
    	PrintUtil.printMessage("希尔排序：");
    	copyData = Arrays.copyOf(data, loopTime);
		is.setArrays(copyData);
		isSort(is.getArrays());
//		is.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		is.shellSort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(is.getArrays());
//		is.print();
		PrintUtil.printMessage((endTime - beginTime) + "ms");
    }
    
    /**
     * 各类选择排序
     */
    private static void selectionSort() {
    	SelectionSort ss = new SelectionSort();
    	
    	PrintUtil.printMessage("直接选择排序：");
    	copyData = Arrays.copyOf(data, loopTime);
    	ss.setArrays(copyData);
		isSort(ss.getArrays());
//		ss.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		ss.straightSelectSorting();;
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(ss.getArrays());
//		ss.print();
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
