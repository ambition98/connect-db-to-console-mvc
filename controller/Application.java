package mall.controller;

import java.util.ArrayList;

import mall.constant.MenuList;
import mall.controller.menu.CategoryMenu;
import mall.controller.menu.MainMenu;
import mall.model.CategoryDAO;
import mall.model.CategoryDTO;

public class Application {

	public static void main(String[] args) {
		init();
		
		System.out.println(MenuList.MAIN.ordinal());
		while(true) {
			System.out.println("current pos: " + Position.getCurrentMenu());
			if(ConnectedUser.currentUser == null)
				System.out.println("not logined");
			else
				System.out.println("current user: " 
							+ ConnectedUser.currentUser.getUserId());
			
			switch(Position.getCurrentMenu()) {
			case MAIN:
				MainMenu.execute();
				break;
			case CATEGORY: //미구현
				CategoryMenu.execute();
				break;
			case PRODUCT: //미구현
				break;
			case PRODUCT_ACT: //미구현
				break;
			}
		} //while
	} //main()
	
	public static void init() {
		ArrayList<CategoryDTO> dtoList = CategoryDAO.selectAllElement();
		String[] CategoryList = new String[dtoList.size()];
		int index = 0;
		for(CategoryDTO dto : dtoList) {
			CategoryList[index] = "[" + (index+1) + "]" + dto.getName();
		}
		
		
	}
}
