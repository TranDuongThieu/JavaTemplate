package hcmute.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.entity.User;

public class UserDAOImpl extends AbstractDao<User> {

	public UserDAOImpl() {
		super(User.class);
	}

}
