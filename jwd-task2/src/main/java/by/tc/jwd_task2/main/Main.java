package by.tc.jwd_task2.main;

import by.tc.jwd_task2.dao.DAOException;
import by.tc.jwd_task2.service.impl.FileServiceImpl;

public class Main {

	public static void main(String[] args) throws DAOException {

		FileServiceImpl service = new FileServiceImpl();
		service.getTree();

	}

}
