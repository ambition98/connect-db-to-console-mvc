package mall.view.output_view;

import java.util.stream.Stream;

import mall.constant.MenuList;

public class OutputView {
	private static final char OUTLINE_CHARACTER = '-';
	private static final String INDENT = "    ";
	
	public static void printMenu(Stream<String> stream, int outlineLength) {
		printOutline(outlineLength);
		stream.forEach(menu -> System.out.println(INDENT + menu));
		printOutline(outlineLength);
	}
	
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	public static void printOutline(int outlineLength) {
		for(int i=0;i<outlineLength;i++)
			System.out.print(OUTLINE_CHARACTER);
		System.out.println();
	}
	
	public static void printInputConsole() {
		System.out.print("> ");
	}
	
	public static int getOutlineLength(MenuList menu) {
		switch(menu) {
		case MAIN:
			return 20;
		case SIGNIN:
			return 20;
		case SIGNUP:
			return 20;
		case CATEGORY:
			return 20;
		case PRODUCT:
			return 20;
		case PRODUCT_ACT:
			return 20;
		default:
			return 0;
		}
	}
}
