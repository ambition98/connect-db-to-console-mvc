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
	 	
	 */
	MAIN(Arrays.asList("[1] 로그인"
				     , "[2] 회원가입"
				     , "[3] 종료")),
	CATEGORY(null),
	PRODUCT(null),
	PRODUCT_ACT(null);
	
	static {
		CATEGORY.list = makeCategoryList();
	}
	
	private List<String> list;
	
	private MenuList(List<String> list) { this.list = list; }
	
	public Stream<String> getListToStream() { return list.stream();	}
	
	public List<String> getMenuNumber() {
		List<String> numberList = new ArrayList<String>();
		
		for(String menu : list)
			numberList.add(menu.substring(1, 2));
		
		return numberList;
	}
	
	private static List<String> makeCategoryList() {
		ArrayList<CategoryDTO> dtoList = CategoryDAO.selectAllElement();
		List<String> categoryList = new ArrayList<String>();
		int index = 0;
		for(CategoryDTO dto : dtoList) {
			categoryList.add("[" + (++index) + "] " + dto.getName());
		}
		
		return categoryList;
	}
}
