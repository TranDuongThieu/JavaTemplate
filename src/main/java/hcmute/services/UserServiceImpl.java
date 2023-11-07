package hcmute.services;

import java.util.List;

import hcmute.DAO.UserDAOImpl;
import hcmute.entity.Category;
import hcmute.entity.Product;
import hcmute.entity.User;

public class UserServiceImpl implements IUserService {
	UserDAOImpl userDAO = new UserDAOImpl();

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	public void delete(int id) {
		userDAO.delete(id);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}
	public void update(User user) {
		userDAO.update(user);
	}

}
