package hcmute.services;

import java.util.List;

import hcmute.entity.Category;
import hcmute.entity.Product;
import hcmute.entity.User;

public interface IUserService {
	List<User> findAll();

	void delete(int id);

	User findById(int id);

	void update(User user);
}
