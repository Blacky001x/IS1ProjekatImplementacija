package repository;

import java.util.List;

import model.User;

public interface UserRepository {
	
	User findUser(String username, String password);
	User registerUser(String firstName, String lastName, String username, String password);
	List<User> getUsers();

}
