package mall.view.input_view;

import java.util.Scanner;

import mall.constant.MenuList;
import mall.constant.SystemMsg;
import mall.view.output_view.OutputView;


public class InputMenuView {
	private static final Scanner sc = new Scanner(System.in);
	
	public static String getSelectMenuNumber(MenuList menu) {
		try {
			OutputView.printMenu(MenuList.MAIN.getListToStream(), 20);
			OutputView.printInputConsole();
			
			String input = sc.nextLine().trim();
			checkValidMenuNumber(menu, input);
			
			return input;
		} catch(IllegalArgumentException e) {
//			e.printStackTrace();
			OutputView.printMessage(SystemMsg.ILLEGAL_INPUT.getMsg());
			return getSelectMenuNumber(menu);
		}
	}
	
	private static void checkValidMenuNumber(MenuList menu, String input) {
		boolean isValidInput = false;
		
		for(String menuNumber : menu.getMenuNumber()) {
//			System.out.println(menuNumber);
			if(menuNumber.equals(input)) {
				isValidInput = true;
				break;
			}
		}
		
		if(!isValidInput)
			throw new IllegalArgumentException(SystemMsg.ILLEGAL_INPUT.getMsg());
	}	
}

