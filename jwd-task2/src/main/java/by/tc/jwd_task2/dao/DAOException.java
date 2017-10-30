package by.tc.jwd_task2.dao;

public class DAOException extends Exception{
	
	private static final long serialVersionUID = 8690383699151673812L;

	public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable ex) {
        super(message, ex);
    }

    public DAOException(Throwable ex) {
        super(ex);
    }

}
