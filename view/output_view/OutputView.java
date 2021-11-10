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
		
		menuList.forEach(element -> System.out.println(INDENT + "[" + index++ + "] "
									+ getNameFromDTO(element)));
		
		if(Position.getCurrentMenu() != MenuList.MAIN)
			System.out.println("\n" + INDENT + "[" + index++ + "] Go to previous menu");
		
		printOutline(outlineLength);
		printInputConsole();
		
		index = 1;
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
			return 32;
		case PRODUCT:
			return 60;
		case ACT_ABOUT_PRODUCT:
			return 35;
		default:
			return 0;
		}
	}

	private static <T> String getNameFromDTO(T element) {
		if(element instanceof String)
			return (String) element;
		else if (element instanceof CategoryDTO)
			return ((CategoryDTO) element).getName();
		else if (element instanceof ProductDTO)
			return ((ProductDTO) element).getPdName();

		return null;
	}
}
