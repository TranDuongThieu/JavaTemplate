package hcmute.services;

import hcmute.entity.User;

public interface IAccountServices {

	User Login(String email, String passwd);
}
