package mall.model;

import java.sql.Timestamp;

public class MallUserDTO {
	private int no;
	private String userId;
	private String userPw;
	private String ph;
	private String address;
	private String isManager;
	private Timestamp suspensionDate;

	private MallUserDTO(Builder builder) {
		this.userId = builder.userId;
		this.userPw = builder.userPw;
		this.ph = builder.ph;
		this.address = builder.address;
		this.isManager = builder.isManager;
		this.suspensionDate = builder.suspensionDate;
	}

	@Override
	public String toString() {
		return "MallUserDTO [no=" + no + ", userId=" + userId + ", userPw=" + userPw + ", ph=" + ph + ", address="
				+ address + ", isManager=" + isManager + ", suspensionDate=" + suspensionDate + "]";
	}

	public int getNo() {
		return no;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public String getPh() {
		return ph;
	}

	public String getAddress() {
		return address;
	}

	public String getIsManager() {
		return isManager;
	}

	public Timestamp getSuspensionDate() {
		return suspensionDate;
	}

	public static class Builder {
		private int no;
		private String userId;
		private String userPw;
		private String ph;
		private String address;
		private String isManager;
		private Timestamp suspensionDate;

		public Builder(String userId) {
			this.userId = userId;
		}
		
		public Builder no(int no) {
			this.no = no;
			return this;
		}
		
		public Builder userPw(String userPw) {
			this.userPw = userPw;
			return this;
		}

		public Builder ph(String ph) {
			this.ph = ph;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder isManager(String isManager) {
			this.isManager = isManager;
			return this;
		}

		public Builder suspensionDate(Timestamp suspensionDate) {
			this.suspensionDate = suspensionDate;
			return this;
		}

		public MallUserDTO build() {
			return new MallUserDTO(this);
		}
	}

}
