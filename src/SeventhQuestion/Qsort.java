package SeventhQuestion;

public class Qsort {
	
	static int[] R = {23,2,5,50,100,10,30,80,60};

    numFrame frame = new numFrame();
	
	public static void main(String[] args) {
		Qsort sQsort = new Qsort();

		sQsort.print();
//		sQsort.sort(R, 0, R.length);
		sQsort.quickSort(R, 0, R.length-1);
		
	}

	public int partition(int[] n, int left, int right) {
		int pivot = n[left];
		while (left < right) {
			while (left < right && n[right] >= pivot) {
				right--;
			}
			if (left < right) {
				n[left++] = n[right];
			}
			print();
			while (left < right && n[left] <= pivot) {
				left++;
			}
			if (left < right) {
				n[right--] = n[left];
			}
			print();
		}
		n[left] = pivot;
		return left;
	}
	
	public void quickSort(int[] n, int left, int right) {
		int dp;
		if (left < right) {
			dp = partition(n, left, right);
			quickSort(n, left, dp-1);
			quickSort(n, dp+1, right);
		}
	}
	
	public void print() {
		for (int s : R) {
			System.out.print(s + " ");	
		}
		System.out.println();
	}
}
