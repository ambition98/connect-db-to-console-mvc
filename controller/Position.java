package mall.controller;

import mall.constant.MenuList;

public class Position {
	private static MenuList currentMenu = MenuList.MAIN;
	
//	public static void moveFromMain(String menuNumber) {
//		switch(menuNumber) {
//		case "1":
//			currentMenu = MenuList.SIGNIN;
//			break;
//		case "2":
//			currentMenu = MenuList.SIGNUP;
//			break;
//		case "3":
//			System.exit(0);
//		}
//	}
	
	public static MenuList getCurrentMenu() {
		return currentMenu;
	}

	public static void setCurrentMenu(MenuList currentMenu) {
		Position.currentMenu = currentMenu;
	}
	
	public static void moveToPrevious() {
		if(currentMenu == MenuList.MAIN)
			return;
		
		int currentIndex = currentMenu.ordinal();
		currentMenu = MenuList.values()[--currentIndex];
	}
}
