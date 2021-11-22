package mall.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HashingUtil {
	final static int SALT_SIZE = 16;

	public String makeNewSalt() {
		StringBuffer sb = new StringBuffer();
		SecureRandom rand = new SecureRandom();

		byte[] temp = new byte[SALT_SIZE];
		rand.nextBytes(temp);
		String salt = byteToString(temp);

		return salt;
	}

	public String encrypt(String pwd, String salt) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");

//		String temp = pwd + salt;
//		md.update(temp.getBytes());
//		byte[] digest_ = md.digest();
//		String digest = byteToString(digest_);
//
//		return digest;
		
		for(int i=0;i<10000;i++) {
			String temp = pwd + salt;
			md.update(temp.getBytes());
			byte[] digest_ = md.digest();
			pwd = byteToString(digest_);
		}
		
		return pwd;
	}

	private String byteToString(byte[] b) {
		StringBuilder sb = new StringBuilder();
		for (byte bb : b)
			sb.append(String.format("%02x", bb));

		return sb.toString();
	}
}
