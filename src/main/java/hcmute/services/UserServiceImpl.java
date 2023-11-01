package hcmute.services;

import java.util.List;

import hcmute.DAO.IUserDAO;
import hcmute.DAO.UserDAOImpl;
import hcmute.entity.Category;

public class UserServiceImpl implements IUserService {
	IUserDAO userDAO = new UserDAOImpl();

	@Override
	public List<Category> findAllCate() {
		// TODO Auto-generated method stub
		return userDAO.findAllCate();
	}

}
