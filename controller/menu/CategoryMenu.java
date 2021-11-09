package mall.controller.menu;

import java.util.List;

import mall.constant.MenuList;
import mall.controller.Position;
import mall.model.CategoryDAO;
import mall.model.CategoryDTO;
import mall.view.input_view.InputMenuView;

public class CategoryMenu {
	public static List<CategoryDTO> categoryList;

	static {
		categoryList = CategoryDAO.selectAllElement();
	}

	public static CategoryDTO execute() {
		String selectedSubMenu = InputMenuView.selectSubMenu(categoryList);

		int index = Integer.parseInt(selectedSubMenu);
		
		Position.setCurrentMenu(MenuList.PRODUCT);
		return CategoryMenu.categoryList.get(index+1);
	}
}
