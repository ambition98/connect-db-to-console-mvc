package mall.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import mall.model.CategoryDAO;
import mall.model.CategoryDTO;

public enum MenuList {
	/*
	 	[ Need Refactoring ]
	 	기능이 늘어감에 따라 MenuList의 하는 일이 어마어마하게 많아짐
	 	array로 메뉴 요소를 가지게 했던 것이 문제점
	 	메뉴의 세부사항은 각자의 클래스를 생성하는 것이 바람직 할 것 같다.
	 */
	MAIN,
	CATEGORY,
	PRODUCT,
	PRODUCT_ACT;
	
//	private List<String> list;
//	
//	private MenuList(List<String> list) { this.list = list; }
//	
//	public Stream<String> getListToStream() { return list.stream();	}
//	
//	public List<String> getMenuNumber() {
//		List<String> numberList = new ArrayList<String>();
//		
//		for(String menu : list)
//			numberList.add(menu.substring(1, 2));
//		
//		return numberList;
//	}
//	
//	private static List<String> makeCategoryList() {
//		ArrayList<CategoryDTO> dtoList = CategoryDAO.selectAllElement();
//		List<String> categoryList = new ArrayList<String>();
//		int index = 0;
//		for(CategoryDTO dto : dtoList) {
//			categoryList.add("[" + (++index) + "] " + dto.getName());
//		}
//		
//		return categoryList;
//	}
//	
}
