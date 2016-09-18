package util;

public class CheckUtil {
	
	public static boolean isSort(int[] arrays) {
		if (arrays == null) {
			return false;
		}
		for (int i = 0; i < arrays.length - 1; i++) {
			if (arrays[i] > arrays[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
}
