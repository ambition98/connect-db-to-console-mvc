package mall.controller.menu;

import java.util.ArrayList;
import java.util.List;

import mall.constant.MenuList;
import mall.constant.SystemMsg;
import mall.controller.ConnectedUser;
import mall.controller.Position;
import mall.model.MallUserDAO;
import mall.model.MallUserDTO;
import mall.view.input_view.InputAccountView;
import mall.view.input_view.InputMenuView;
import mall.view.output_view.OutputView;

public class MainMenu {
	public static List<String> mainMenuList = new ArrayList<String>(); 
	
	static {
		mainMenuList.add("SignIn");
		mainMenuList.add("SignUp");
		mainMenuList.add("Exit");
	}
	
	public static void execute() {
		String selectedSubMenu = InputMenuView.selectSubMenu(mainMenuList);
		
		switch(selectedSubMenu) {
		case "1":
			signIn();
			break;
		case "2":
			signUp();
			break;
		case "3":
			OutputView.printMessage(SystemMsg.EXIT_MESSAGE.getMsg());
			System.exit(0);
		}
	}
	
	private static void signIn() {
		MallUserDTO dto = null;
		
		while(true) {
			OutputView.printMessage(SystemMsg.GO_TO_PREV_MESSAGE.getMsg());
			OutputView.printMessage(SystemMsg.INPUT_ID.getMsg());
			String id = InputAccountView.inputStringLine();
			
			if(id.equals("exit")) {
				Position.moveToPrevious();
				return;
			}
			
			OutputView.printMessage(SystemMsg.INPUT_PASSWORD.getMsg());
			String pw = InputAccountView.inputStringLine();
			
			dto = MallUserDAO.selectforSignin(id, pw);
			if(dto == null) {
				OutputView.printMessage(SystemMsg.WRONG_IDPW.getMsg());
				continue;
			}
			break;
		}
		
		ConnectedUser.currentUser = dto;
		OutputView.printMessage(SystemMsg.SUCCEED_LOGIN.getMsg());
		Position.setCurrentMenu(MenuList.CATEGORY);
	}
	
	private static void signUp() {
		String id = "";
		while(true) {
			OutputView.printMessage(SystemMsg.GO_TO_PREV_MESSAGE.getMsg());
			OutputView.printMessage(SystemMsg.INPUT_ID.getMsg());
			id = InputAccountView.inputStringLine();
			
			if(id.equals("exit")) {
				Position.moveToPrevious();
				return;
			}
			
			if(MallUserDAO.selectByUserId(id) != null) {
				OutputView.printMessage(SystemMsg.DUPLICATED_ID.getMsg());
				continue;
			}
			break;
		}
		
		OutputView.printMessage(SystemMsg.INPUT_PASSWORD.getMsg());
		String pw = InputAccountView.inputStringLine();
		OutputView.printMessage(SystemMsg.INPUT_PHONE_NUMBER.getMsg());
		String ph = InputAccountView.inputStringLine();
		OutputView.printMessage(SystemMsg.INPUT_ADDRESS.getMsg());
		String address = InputAccountView.inputStringLine();
		
		int cnt = MallUserDAO.inputNewUser(new MallUserDTO.Builder(id)
											.userPw(pw)
											.ph(ph)
											.address(address)
											.build());
		
		if(cnt > 0)
			OutputView.printMessage(SystemMsg.COMPLETE_SIGNUP.getMsg());
	}
}
