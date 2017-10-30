
package by.tc.task02.entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

import by.tc.task02.dao.DAOException;

public class Reader implements Serializable {

	private static final long serialVersionUID = 7651321864851799228L;
	private String content;
	public static final String PATH = "task2.xml";

	public Reader() {
		super();

	}

	public Reader(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reader other = (Reader) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reader [content=" + content + "]";
	}

	public String readFile() throws DAOException {
		try {
			InputStream in = Reader.class.getClassLoader().getResourceAsStream(PATH);
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			String xml_data = "";
			StringBuilder sb = new StringBuilder();

			while ((xml_data = bf.readLine()) != null) {
				sb.append(xml_data);
			}
			setContent(sb.toString());
			return content;
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}
}
