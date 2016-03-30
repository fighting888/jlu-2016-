package SeventhQuestion;

import java.util.Stack;


public class QuickSort {
	
	public static void main(String[] args) {
		int[] list = {23,2,5,50,100,10,30,80,60,90,20,40,70,55,95,15,35,85,65,25,45,75 };
		for (int d : list) {
			System.out.print(d + "  ");
		}
		System.out.println("\n" + list.length);
		Qsort(list, list.length, M(list.length));
		for (int i : list) {
			System.out.print(i + "  ");
		}
	}
	
	public static int M(int x) {
		return x < 10 ? 10 : x /2;
	}
	

	public static void Qsort(int[] R, int n, int M) {
		Stack<stackType> stack = new Stack<>();
		stackType temp = new stackType(0, 0);
		stack.push(temp);
//		System.out.println(stack.peek().x);
		int f = 0, t = n-1, j = 0;
		while (f < t) {
			j = part(R, f, t);
			if ((j-f < M) && (t-j < M)) {
				temp = stack.peek();
//				System.out.println(temp.x);
				stack.pop();
				f = temp.x;
				t = temp.y;
				continue;
			}
			if ((j-f < M) && (t-j >= M)) {
				f = j+1;
				continue;
			}
			if ((j-f >= M) && (t-j < M)) {
				t = j-1;
				continue;
			}
			if ((j-f >= M) && (t-j) >= M) {
				if (j-f > t-j) {
					temp.x = f;
					temp.y = j-1;
					stack.push(temp);
					f = j+1;
				} else {
					temp.x = j + 1;
					temp.y = t;
					stack.push(temp);
					t = j-1;
				}
			}
//			print(R);
		}
		InsertSort(R, n);
	}
	
	public static void InsertSort(int[] R, int n) {
		int temp, j;
		for (int i = 0;i < n; ++i) {
			temp = R[i];
			j = i -1;
			while (j > -1&& temp < R[j]) {
				R[j + 1] = R[j];
				--j;
			}
			R[j+1] = temp;
		}
	}
	public static void InterChange(int[] list, int x, int y) {
		if (list.length > x && list.length > y) {
			int temp = list[x];
			list[x] = list[y];
			list[y] = temp;
		}
//		print(list);
	}
	
	public static int part(int[] list, int m, int n) {
		int i, j, k;
		InterChange(list, (int)(m + n)/2, m + 1);
		if (list[m+1] > list[n]) {
			InterChange(list, m+1, n);
		}
		if (list[m] > list[n]) {
			InterChange(list, m, n);
		}
		if (list[m+1] > list[m]) {
			InterChange(list, m+1, m);
		}
		i = m;
		j = n;
		k = list[m];
		while (i < j) {
			++i;
			while (list[i] < k) {
				++i;
			}
			while (list[j] > k) {
				--j;
			}
			if (i < j) {
				InterChange(list, i, j);
			}
		}
		InterChange(list, m, j);
		
		return j;
	}
	
//	public static void print(int[] list) {
//		for (int k1 : list) {
//			System.out.print(k1 + "  ");
//		}
//		System.out.println();
//	}

}
class stackType {
	int x, y;
	public stackType(int x, int y) {
		this.x = x;
		this.y = y;
	}
}