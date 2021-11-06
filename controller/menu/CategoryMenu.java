package mall.controller.menu;

import mall.view.input_view.InputMenuView;

public class CategoryMenu {
	public static String execute() {
		String selectedSubMenu = InputMenuView.selectSubMenu();
		
		return selectedSubMenu;
	}
}
