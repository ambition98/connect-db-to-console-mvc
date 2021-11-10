package mall.controller.menu;

import java.util.List;

import mall.constant.MenuList;
import mall.controller.Application;
import mall.controller.Position;
import mall.model.CategoryDAO;
import mall.model.CategoryDTO;
import mall.view.input_view.InputMenuView;

public class CategoryMenu {
	public static List<CategoryDTO> categoryList;

	static {
		categoryList = CategoryDAO.selectAllElement();
	}

	public static void execute() {
		String selectedSubMenu = InputMenuView.selectSubMenu(categoryList);
		int index = Integer.parseInt(selectedSubMenu);
		
		System.out.println("index: " + index);
		System.out.println("size: " + categoryList.size());
		if(index == categoryList.size() + 1) {
			Position.moveToPrevious();
			return;
		}
			
		Position.setCurrentMenu(MenuList.PRODUCT);
		
		Application.selectedCategory = CategoryMenu.categoryList.get(index-1);
	}
}
