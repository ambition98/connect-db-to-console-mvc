package mall.view.output_view;

import java.util.List;

import mall.constant.MenuList;
import mall.controller.Position;
import mall.model.CategoryDTO;
import mall.model.ProductDTO;

public class OutputView {
	private static final char OUTLINE_CHARACTER = '-';
	private static final String INDENT = "    ";
	static int index = 1;

	public static <T> void printMenu(List<T> menuList) {
		int outlineLength = getOutlineLength(Position.getCurrentMenu());

		printOutline(outlineLength);
		menuList.forEach(menu -> System.out.println(INDENT + "[" + index++ + "] "
									+ getNameToDTO(menu)));
		printOutline(outlineLength);
		printInputConsole();
		
		index = 1;
	}

	private static <T> String getNameToDTO(T menu) {
		if(menu instanceof String)
			return (String) menu;
		else if (menu instanceof CategoryDTO)
			return ((CategoryDTO) menu).getName();
		else if (menu instanceof ProductDTO)
			return ((ProductDTO) menu).getPdName();

		return null;
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printOutline(int outlineLength) {
		for (int i = 0; i < outlineLength; i++)
			System.out.print(OUTLINE_CHARACTER);
		System.out.println();
	}

	public static void printInputConsole() {
		System.out.print("> ");
	}

	public static int getOutlineLength(MenuList menu) {
		switch (menu) {
		case MAIN:
			return 20;
		case CATEGORY:
			return 25;
		case PRODUCT:
			return 60;
		case PRODUCT_ACT:
			return 20;
		default:
			return 0;
		}
	}
}
