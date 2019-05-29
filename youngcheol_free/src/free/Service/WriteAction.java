package free.Service;

import free.persistence.*;

public class WriteAction {
	public int write(String boardTitle,String userName, String boardContent) {

		if (boardTitle == "" || boardContent == "" || boardTitle == null || boardContent == null)
			return 0;
		else {
			boardDAO bDAO = new boardDAO();
			return bDAO.write(boardTitle, userName, boardContent);
		}
	}
}
