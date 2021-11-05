package mall.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum MenuList {
	/*
	 	[ Need Refactoring ]
	 	* 메뉴의 선택지는 MenuList에서 분리하여 다른 Enum 생성
	 		e.g. signin, signup
	 	* 변경하면 Position을 변경하는 과정이 간편해짐
	 	* 단일 책임 원칙
	 */
	MAIN(Arrays.asList("[1] 로그인"
				     , "[2] 회원가입"
				     , "[3] 종료")),
	CATEGORY(null),
	PRODUCT(null),
	PRODUCT_ACT(null);
	
	private final List<String> list;
	
	private MenuList(List<String> list) { 
		this.list = list;
	}
	
	public Stream<String> getListToStream() {
		return list.stream(); 
	}
	
	public List<String> getMenuNumber() {
		List<String> numberList = new ArrayList<String>();
		
		for(String menu : list)
			numberList.add(menu.substring(1, 2));
		
		return numberList;
	}
}
