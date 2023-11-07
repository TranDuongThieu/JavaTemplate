package hcmute.services;

import hcmute.DAO.AccountDAOImpl;
import hcmute.DAO.IAccountDAO;
import hcmute.entity.User;

public class AccountServiceImpl implements IAccountServices {

	IAccountDAO accountDAO = new AccountDAOImpl();

	@Override
	public User Login(String email, String passwd) {
		// TODO Auto-generated method stub
		return accountDAO.Login(email, passwd);
	}
}
