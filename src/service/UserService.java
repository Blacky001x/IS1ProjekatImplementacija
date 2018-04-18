package service;

import java.util.List;

import model.User;

public interface UserService {
	
	User findUser(String username, String password);
	User registerUser(String firstName, String lastName, String username, String password);
	List<User> getUsers();

}
