package mall.view.input_view;

import java.util.List;
import java.util.Scanner;

import mall.constant.SystemMsg;
import mall.view.output_view.OutputView;


public class InputMenuView {
	private static final Scanner sc = new Scanner(System.in);
	
	public static <T> String selectSubMenu(List<T> dtoList) {
		String input = "";
		try {
			OutputView.printMenu(dtoList);
			
			input = sc.nextLine().trim();
			checkValidMenuNumber(dtoList, input);
			
			return input;
		} catch(IllegalArgumentException e) {
			OutputView.printMessage(e.getMessage());
			return selectSubMenu(dtoList);
		}
	}
	
	private static <T> void checkValidMenuNumber(List<T> dtoList, String input) 
												throws IllegalArgumentException {
		if(!isNumber(input))
			throw new IllegalArgumentException(SystemMsg.ILLEGAL_INPUT.getMsg());
		
		
		if(Integer.parseInt(input) > dtoList.size() 
				&& Integer.parseInt(input) <= 0) {
			throw new IllegalArgumentException(SystemMsg.ILLEGAL_INPUT.getMsg());
		}
	}
	
	private static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}

