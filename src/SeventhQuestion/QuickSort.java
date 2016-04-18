package SeventhQuestion;

import java.awt.*;
import java.util.Stack;

import SeventhQuestion.*;
public class QuickSort {
	
	public static double[] list = {23,2,5,50,100,10 };

	public static numFrame frame;

	private static inputFrame iFrame;

	private static stackFrame sFrame;

    public static QuickSort qSort = new QuickSort();
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame = new numFrame();
				frame.changeNum(list);
//				quickSort(list, 0, list.length-1);
				iFrame = new inputFrame();
				sFrame = new stackFrame();
			}
		});


//		list = iFrame.submitArray();

	}

    public double[] setList(double[] list) {
        this.list = list;
        return this.list;
    }

    public double[] getList() {
        return list;
    }
	
	
	public static void quickSort(double[] list2, int left, int right) {
		Stack<Integer> stack = new Stack<>();

		if (left < right) {
			int mid = partition(list2, left, right);
			if (left < mid - 1) {
				stack.push(left);
				stack.push(right-1);
			}
			if (mid + 1 < right) {
				stack.push(mid + 1);
				stack.push(right);
			}
			while (!stack.isEmpty()) {
				int q = stack.peek();
				stack.pop();
				int p = stack.peek();
				stack.pop();
				mid = partition(list2, p, q);
				if (p < mid - 1) {
					stack.push(p);
					stack.push(mid - 1);
				}
				if (q > mid + 1) {
					stack.push(mid + 1);
					stack.push(q);
				}
			}
		}
	}
	
	public static  int partition(double[] list2, int left, int right) {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
            frame.changeNum(list2);
//			frame.nPanel.repaint();
			print(list);
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