package mall.controller;

import mall.constant.MenuList;
import mall.model.MallUserDTO;

public class Application {

	public static void main(String[] args) {
		Main main = new Main();
		MallUserDTO currentUser = null;
		
		System.out.println(MenuList.MAIN.ordinal());
		while(true) {
			System.out.println("current pos: " + Position.currentMenu);
			switch(Position.currentMenu) {
			case MAIN:
				main.mainMenu();
				break;
			case SIGNIN:
				currentUser = main.signIn();
				break;
			case SIGNUP:
				main.signUp();
				break;
			case CATEGORY: //미구현
				break;
			case PRODUCT: //미구현
				break;
			case PRODUCT_ACT: //미구현
				break;
			}
		} //while
	} //main()
}
