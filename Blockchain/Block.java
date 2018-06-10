import java.util.*;

public class Block {
	
	public String data;
	public String previousHash;
	public String currentHash;
	private long timeStamp;
	
	//Constructor
	Block(String data, String previousHash){
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.currentHash = calculateHash();
	}
	
	public String calculateHash() {
		String currentHash = StringUtil.applySHA256(
				previousHash +
				Long.toString(timeStamp) +
				data
				);
		return currentHash;
	}
}
