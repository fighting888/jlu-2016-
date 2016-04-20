package SeventhQuestion;

import java.awt.*;
import java.util.Stack;

import javax.swing.JFrame;


public class numFrame extends JFrame {


	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private double[] num = {7, 8 , 10, 20, 30, 40, 1, 2, 3, 4, 5, 6};

	double[] n1 = {1, 2, 3};
	
	public numPanel nPanel = new numPanel();

	public static void main(String[] args) {
		numFrame frame = new numFrame();
		frame.quickSort(frame.num, 0, frame.num.length-1);
	}

	public numFrame() {
		setTitle("Table Frame");
		setBounds(500, 0, 1000, screenSize.height-100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(nPanel);
//		quickSort(num, 0, num.length-1);
	}
	
	public void changeNum(double[] num) {
		numPanel.setNum(num);
		nPanel.repaint();
		System.out.println("change Number done");
	}


	public void quickSort(double[] list2, int left, int right) {
		Stack<Integer> stack = new Stack<>();

		if (left < right) {
			int mid = partition(list2, left, right);
			if (left < mid - 1) {
				stack.push(left);
				stack.push(right-1);
//				sFrame.pushStack(list2[left]);
//				sFrame.pushStack(list2[right-1]);
			}
			if (mid + 1 < right) {
				stack.push(mid + 1);
				stack.push(right);
//				sFrame.pushStack(list2[mid+1]);
//				sFrame.pushStack(list2[right]);
			}
			while (!stack.isEmpty()) {
				int q = stack.peek();
				stack.pop();
//				sFrame.popStack(q);
				int p = stack.peek();
				stack.pop();
//				sFrame.popStack(p);
				mid = partition(list2, p, q);
//				frame.changeNum(list2);
				try {
					Thread.sleep(1000L);
					changeNum(list2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (p < mid - 1) {
					stack.push(p);
					stack.push(mid - 1);
//					sFrame.pushStack(p);
//					sFrame.pushStack(mid-1);
				}
				if (q > mid + 1) {
					stack.push(mid + 1);
					stack.push(q);
//					sFrame.pushStack(left);
//					sFrame.pushStack(right-1);
				}
			}
		}
	}

	public int partition(double[] list2, int left, int right) {

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


	public void print(double[] list2) {
		for (double k1 : list2) {
			System.out.print(k1 + "  ");
		}
		System.out.println();
	}

}
