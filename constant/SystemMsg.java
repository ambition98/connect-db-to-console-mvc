package mall.constant;

public enum SystemMsg {
	//Nomal Message
	EXIT_MESSAGE("Exit program\n"),
	GO_TO_PREV_MESSAGE("Input \"exit\" to previous menu\n"),
	COMPLETE_SIGNUP("Succeed signup\n"),
	SUCCEED_LOGIN("Succeed login\n"),
	ADDED_TO_CART("Product added to your cart\n"),
	
	//Input Message
	INPUT_ID("Input Id"),
	INPUT_PASSWORD("Input Password"),
	INPUT_PHONE_NUMBER("Input your phone number"),
	INPUT_ADDRESS("Input your address"),
	
	//Error Message
	ILLEGAL_INPUT("You typed wrong number.\n"),
	DUPLICATED_ID("This Id is already Used\n"),
	WRONG_IDPW("Worng Id or Password\n"),
	CRITICAL_ERROR("*Unknown Error*\n");
	
	private final String msg;
	
	SystemMsg(String msg) { this.msg = msg; }
	
	public String getMsg() { return msg; }
}