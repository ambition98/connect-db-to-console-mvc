package mall.controller;

import mall.controller.menu.ActAboutProductMenu;
import mall.controller.menu.CategoryMenu;
import mall.controller.menu.MainMenu;
import mall.controller.menu.ProductMenu;
import mall.model.CategoryDTO;
import mall.model.MallUserDTO;
import mall.model.ProductDTO;

public class Application {
	public static CategoryDTO selectedCategory = null;
	public static ProductDTO selectedProduct = null;
	public static MallUserDTO currentUser = null;
	
	public static void main(String[] args) {
		while(true) {
//			printStatus();
			
			switch(Position.getCurrentMenu()) {
			case MAIN:
				MainMenu.execute();
				break;
			case CATEGORY:
				CategoryMenu.execute();
				break;
			case PRODUCT:
				ProductMenu.execute();
				break;
			case ACT_ABOUT_PRODUCT:
				ActAboutProductMenu.execute();
				break;
			}
		}
	}
	
	private static void printStatus() {
		System.out.println();
		System.out.println("\tCurrent pos.:\t" + Position.getCurrentMenu());
		System.out.println("\tCurrent user:\t" + currentUser);
		System.out.println("\tSelected Cat.:\t"+selectedCategory);
		System.out.println("\tSelected Pdt.:\t"+selectedProduct);
		System.out.println();
	}
}
