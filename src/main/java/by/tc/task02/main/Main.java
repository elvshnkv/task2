package by.tc.task02.main;

import by.tc.task02.dao.DAOException;
import by.tc.task02.service.impl.FileServiceImpl;

public class Main {

	public static void main(String[] args) throws DAOException {

		FileServiceImpl service = new FileServiceImpl();
		service.getTree();

	}

}