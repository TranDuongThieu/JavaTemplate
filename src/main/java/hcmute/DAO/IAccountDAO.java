package hcmute.DAO;

import hcmute.entity.User;

public interface IAccountDAO {

	User Login(String email, String passwd);
}
