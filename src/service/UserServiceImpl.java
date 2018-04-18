package service;

import java.util.List;

import model.User;
import repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	private UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User findUser(String username, String password) {
		return null;
	}

	@Override
	public User registerUser(String firstName, String lastName, String username, String password) {
		if (!isUnique(username)) {
			return null;
		} else {
			return repository.registerUser(firstName, lastName, username, password);
		}
	}

	private boolean isUnique(String username) {
		return true;
	}

	@Override
	public List<User> getUsers() {
		return repository.getUsers();
	}

}
