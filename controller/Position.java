package mall.controller;

import mall.constant.MenuList;

public class Position {
	private static MenuList currentMenu = MenuList.MAIN;
	
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
