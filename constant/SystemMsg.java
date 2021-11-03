package mall.constant;

public enum SystemMsg {
	//Nomal Message
	EXIT_MESSAGE("[\"exit\" 입력하여 뒤로가기]"),
	COMPLETE_SIGNUP("회원가입이 완료되었습니다."),
	SUCCEED_LOGIN("로그인에 성공하였습니다."),
	
	//Input Message
	INPUT_ID("Id를 입력하세요"),
	INPUT_PASSWORD("Password를 입력하세요"),
	INPUT_PHONE_NUMBER("휴대폰 번호를 입력하세요"),
	INPUT_ADDRESS("주소를 입력하세요"),
	
	//Error Message
	ILLEGAL_INPUT("잘못 입력하셨습니다.\n"),
	DUPLICATED_ID("이미 존재하는 Id 입니다.\n"),
	WRONG_IDPW("Id 또는 Password가 틀렸습니다.");
	
	private final String msg;
	
	SystemMsg(String msg) { this.msg = msg; }
	
	public String getMsg() { return msg; }
}