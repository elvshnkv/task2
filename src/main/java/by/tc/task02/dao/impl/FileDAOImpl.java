package by.tc.task02.dao.impl;

import javax.swing.tree.DefaultMutableTreeNode;

import by.tc.task02.dao.DAOException;
import by.tc.task02.dao.FileDAO;
import by.tc.task02.entity.Reader;
import by.tc.task02.view.FrameCreator;

public class FileDAOImpl implements FileDAO {

	public static final String PATH = "task2.xml";
	public static final int TAGCHARACTER = 1;
	public static final int ENDTAGSYMBOLS = 2;
	public static final int ENDOFFILE = -1;

	public void run() throws DAOException {
		String data = readFile();
		if (data.startsWith("<?")) {
			data = data.substring(data.indexOf("?>") + ENDTAGSYMBOLS, data.length());
		}
		DefaultMutableTreeNode root = null, tags = null, values = null, mainId = null;
		try {
			for (int i = 0; i <= data.length(); i++) {
				int start = data.indexOf("<");
				int end = data.indexOf(">");
				String tag = data.substring(start + TAGCHARACTER, end);
				if (i == 0) {
					root = new DefaultMutableTreeNode(tag);
				}
				data = data.substring(end + TAGCHARACTER);
				int find = data.indexOf("</" + tag + ">");
				if (find > ENDOFFILE) {
					if (!data.startsWith("<") & !tag.startsWith("/")) {
						if (!tag.equals(root.toString())) {
							tags = new DefaultMutableTreeNode(tag.substring(0, tag.length()));
							if (mainId != null) {
								mainId.add(tags);
							}
						}
					}
				} else {
					if (tag.contains("id=")) {
						String name = tag.substring(0, tag.indexOf(" "));
						mainId = new DefaultMutableTreeNode(
								name + " : " + tag.substring(tag.indexOf("\"") + TAGCHARACTER, tag.lastIndexOf("\"")));
						System.out.println(tag.substring(tag.indexOf("\"") + TAGCHARACTER, tag.lastIndexOf("\"")));
						root.add(mainId);
					}
				}
				checkValue(data, tags, values);
			}
			frame(root);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	private String readFile() throws DAOException {
		Reader reader = new Reader();
		reader.readFile();
		String data = reader.getContent();
		return data;
	}

	private void checkValue(String data, DefaultMutableTreeNode tags, DefaultMutableTreeNode values) {
		if (!data.startsWith("<") || !data.startsWith(" ")) {
			int filter = data.indexOf("<");
			if (filter > -1) {
				String value = data.substring(0, filter);
				String value2 = value.replaceAll(" ", "");
				if (value2.length() > 0) {
					System.out.println(value);
					values = new DefaultMutableTreeNode(value);
					if (tags != null) {
						tags.add(values);
					}
				}
			}
		}
	}

	private void frame(DefaultMutableTreeNode root) throws DAOException {
		FrameCreator frame = new FrameCreator(root);
		frame.setVisible();
	}
}
