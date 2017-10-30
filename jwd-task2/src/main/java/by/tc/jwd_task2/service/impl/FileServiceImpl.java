package by.tc.jwd_task2.service.impl;

import by.tc.jwd_task2.dao.DAOException;
import by.tc.jwd_task2.dao.impl.FileDAOImpl;
import by.tc.jwd_task2.service.FileService;

public class FileServiceImpl implements FileService {

	public void getTree() throws DAOException {
		FileDAOImpl dao=new FileDAOImpl();
		dao.run();
	}

}
