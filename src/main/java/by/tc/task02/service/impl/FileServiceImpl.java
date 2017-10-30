package by.tc.task02.service.impl;

import by.tc.task02.dao.DAOException;
import by.tc.task02.dao.impl.FileDAOImpl;
import by.tc.task02.service.FileService;

public class FileServiceImpl implements FileService {

	public void getTree() throws DAOException {
		FileDAOImpl dao=new FileDAOImpl();
		dao.run();
	}

}