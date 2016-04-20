package SeventhQuestion;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class QuickSort {

	static double[] list = {7, 8 , 10, 20, 30, 40, 1, 2, 3, 4, 5, 6};

	public static numFrame frame;

	private static stackFrame sFrame;

	private static inputFrame iFrame;

	private static codeFrame cFrame;

	public static QuickSort qSort = new QuickSort();

	public boolean judge = true;

	public static void main(String[] args) {
		sFrame = new stackFrame();
		iFrame = new inputFrame();
		cFrame = new codeFrame();
		frame = new numFrame();
		while (true) {
			while (qSort.judge) {
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			quickSort(list, 0, list.length-1);
		}
	}

	public static double[] setList(double[] list) {
		QuickSort.list = list;
		return list;
	}

	public static double[] getList() {
		return list;
	}

	public static void makeSort(double[] list2) {
		quickSort(list2, 0, list2.length-1);
	}

	public static void quickSort(double[] list2, int left, int right) {
		Stack<Integer> stack = new Stack<>();
		if (left < right) {
			cFrame.transColor(0);
			int mid = partition(list2, left, right);
			cFrame.transColor(1);
			if (left < mid - 1) {
				cFrame.transColor(2);
				cFrame.transColor(3);
				stack.push(left);
				stack.push(right-1);
				sFrame.pushStack(list2[left]);
				sFrame.pushStack(list2[right-1]);
			}
			if (mid + 1 < right) {
				cFrame.transColor(4);
				stack.push(mid + 1);
				stack.push(right);
				cFrame.transColor(5);
				sFrame.pushStack(list2[mid+1]);
				sFrame.pushStack(list2[right]);
			}
			while (!stack.isEmpty()) {
				cFrame.transColor(6);
				int q = stack.peek();
				stack.pop();
				cFrame.transColor(7);
				sFrame.popStack();
				int p = stack.peek();
				stack.pop();
				cFrame.transColor(8);
				sFrame.popStack();
				mid = partition(list2, p, q);
				cFrame.transColor(9);
				try {
					Thread.sleep(1000L);
					frame.changeNum(list2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				frame.changeNum(list2);
				if (p < mid - 1) {
					cFrame.transColor(10);
					stack.push(p);
					stack.push(mid - 1);
					cFrame.transColor(11);
					sFrame.pushStack(p);
					sFrame.pushStack(mid-1);
				}
				if (q > mid + 1) {
					cFrame.transColor(12);
					stack.push(mid + 1);
					stack.push(q);
					cFrame.transColor(13);
					sFrame.pushStack(mid+1);
					sFrame.pushStack(q);
				}
			}
			cFrame.transColor(14);
			qSort.judge = true;
		}
	}
	
	public static  int partition(double[] list2, int left, int right) {

        System.out.println(left + "  " + right);
		double pivot = list2[left];
		while (left < right) {
			while (left < right && list2[right] >= pivot) {
				right--;
			}
			if (left < right) {
				list2[left++] = list2[right];
			}
			while (left < right && list2[left] <= pivot) {
				left++;
			}
			if (left < right) {
				list2[right--] = list2[left];
			}
			System.out.println("left:" + left + "  right:" + right + " pivot:" + pivot);

//			frame.nPanel.repaint();
			print(list2);
		}
		list2[left] = pivot;
		return left;
	}
	

	public static  void print(double[] list2) {
		for (double k1 : list2) {
			System.out.print(k1 + "  ");
		}
		System.out.println();
	}

}