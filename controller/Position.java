package mall.controller;

import mall.constant.MenuList;

public class Position {
	public static MenuList currentMenu = MenuList.MAIN;
	
	public static void moveFromMain(String menuNumber) {
		switch(menuNumber) {
		case "1":
			currentMenu = MenuList.SIGNIN;
			break;
		case "2":
			currentMenu = MenuList.SIGNUP;
			break;
		case "3":
			System.exit(0);
		}
	}
	
	public static void moveToPrevious() {
		if(currentMenu == MenuList.MAIN)
			return;
		
		int currentIndex = currentMenu.ordinal();
		if(currentMenu == MenuList.SIGNUP)
			currentIndex--;
		
		currentMenu = MenuList.values()[--currentIndex];
	}
}
