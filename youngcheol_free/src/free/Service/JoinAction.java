package free.Service;

import free.persistence.*;

public class JoinAction {
	public int joinAction(String userEmail, String userPassword, String userName){
		UserDAO userDAO = new UserDAO();
		
		int result = userDAO.join(userEmail,userPassword,userName);
		
		if(result==-1){
			return -1;
		}
		else return 1;
	}
}
