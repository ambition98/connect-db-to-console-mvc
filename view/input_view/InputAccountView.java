package mall.view.input_view;

import java.util.Scanner;

import mall.view.output_view.OutputView;

public class InputAccountView {
	static Scanner sc = new Scanner(System.in);
	
	public static String inputStringLine() {
		OutputView.printInputConsole();
		String line = sc.nextLine().trim();
		
		return line;
	}
}
