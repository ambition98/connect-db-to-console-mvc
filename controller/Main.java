package mall.controller;

import mall.constant.SystemMsg;
import mall.model.MallUserDAO;
import mall.model.MallUserDTO;
import mall.view.input_view.InputAccountView;
import mall.view.input_view.InputMenuView;
import mall.view.output_view.OutputView;

public class Main {
	public void mainMenu() {
		String menuNumber = InputMenuView.getSelectMenuNumber(Position.currentMenu);
		Position.moveFromMain(menuNumber);
	}
	
	public MallUserDTO signIn() {
		MallUserDTO dto = null;
		
		while(true) {
			OutputView.printMessage(SystemMsg.EXIT_MESSAGE.getMsg());
			OutputView.printMessage(SystemMsg.INPUT_ID.getMsg());
			String id = InputAccountView.inputStringLine();
			
			if(id.equals("exit")) {
				Position.moveToPrevious();
				return null;
			}
			
			OutputView.printMessage(SystemMsg.INPUT_PASSWORD.getMsg());
			String pw = InputAccountView.inputStringLine();
			
			dto = MallUserDAO.selectByUserId(id);
			if(dto == null) {
				OutputView.printMessage(SystemMsg.WRONG_IDPW.getMsg());
				continue;
			}
			break;
		}
		
		OutputView.printMessage(SystemMsg.SUCCEED_LOGIN.getMsg());
		return dto;
	}
	
	public void signUp() {
		String id = "";
		while(true) {
			OutputView.printMessage(SystemMsg.EXIT_MESSAGE.getMsg());
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
