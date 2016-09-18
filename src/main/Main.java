package main;

import java.util.Arrays;
import java.util.Calendar;

import bubbleSort.BubbleSort;
import insertionSort.InsertionSort;
import util.CheckUtil;
import util.PrintUtil;

public class Main {

	private final static int loopTime = 10;
	
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
//    	bubbleSort();
    	insertionSort();
	}
    
    private static void bubbleSort() {
    	PrintUtil.printMessage("基本冒泡排序：");
    	copyData = Arrays.copyOf(data, loopTime);
		BubbleSort bs = new BubbleSort(copyData);
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
    
    private static  void insertionSort() {
    	PrintUtil.printMessage("基本插入排序：");
    	copyData = Arrays.copyOf(data, loopTime);
		InsertionSort is = new InsertionSort(copyData);
		isSort(is.getArrays());
		is.print();
		beginTime = Calendar.getInstance().getTimeInMillis();
		is.sort();
		endTime = Calendar.getInstance().getTimeInMillis();
		isSort(is.getArrays());
		PrintUtil.printMessage((endTime - beginTime) + "ms");
		is.print();
//		PrintUtil.printMessage("改进版冒泡排序：");
//    	copyData = Arrays.copyOf(data, loopTime);
//		is.setArrays(copyData);
//		isSort(is.getArrays());
////		bs.print();
//		beginTime = Calendar.getInstance().getTimeInMillis();
//		is.improveSort();
//		endTime = Calendar.getInstance().getTimeInMillis();
//		isSort(bs.getArrays());
//		PrintUtil.printMessage((endTime - beginTime) + "ms");
//		bs.print();
    }
    
    private static void isSort(int[] arrays) {
		if (CheckUtil.isSort(arrays)) {
			PrintUtil.printMessage("sort");
		} else {
			PrintUtil.printMessage("not sort");
		}
    }

}
