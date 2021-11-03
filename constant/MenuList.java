package mall.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum MenuList {
	MAIN(Arrays.asList("[1] 로그인"
				     , "[2] 회원가입"
				     , "[3] 종료")),
	SIGNIN(null),
	SIGNUP(null),
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
