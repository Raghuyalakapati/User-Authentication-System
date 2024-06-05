package dao;

import modalclasses.LoginModal;
import modalclasses.RegisterModal;

public interface DaoInterface {
	
	public String insertData(RegisterModal rm);
	public String checkData(LoginModal lm);

}