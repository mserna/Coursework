import java.security.MessageDigest;

public class StringUtil {
	
	static String applySHA256(String input) {
		try {
			MessageDigest newDigest = new MessageDigest.getInstance("SHA-256");
			byte[] hash = newDigest.digest(input.getBytes("UTF-8"));
			StringBuffer hex = new StringBuffer();
			
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
