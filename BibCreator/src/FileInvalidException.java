
public class FileInvalidException extends Exception {
	
	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information.");
	}
	
	public FileInvalidException(String msg) {
		super(msg);
	}
	
	
	//We need to override the getMessage method
	
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	

}
