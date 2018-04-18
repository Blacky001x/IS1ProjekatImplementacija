package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Movie;
import model.Showtime;
import model.User;

public class UserRepositoryMock implements UserRepository {

	private List<User> users;

	public UserRepositoryMock() {
		users = new ArrayList<>();
		
		User u1 = new User();
		u1.setFirstname("Marina");
		u1.setPassword("Vlajic");
		u1.setUsername("maki");
		u1.setPassword("maki365");
		
		User u2 = new User();
		u2.setFirstname("Maca");
		u2.setPassword("Savic");
		u2.setUsername("maca");
		u2.setPassword("macamaca");
		
		User u3 = new User();
		u3.setFirstname("Admin");
		u3.setPassword("AdminAdmin");
		u3.setUsername("admin");
		u3.setPassword("admin");
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
	}

	/**
	 * Method that tries to find user which username is 'username', and password is
	 * 'password'
	 * 
	 * @param username
	 *            - username of a user
	 * @param password
	 *            - password of a user
	 * @return User object if there is such user, null otherwise
	 */
	public User findUser(String username, String password) {

		Optional<User> found = users.stream().
				filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
				.findFirst();
		
		if (found.isPresent()) {
			return found.get();
		}
		else {
			return null;
		}
		
	}

	/**
	 * Method that adds new user to database.
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @return User object if operation is successfull, null otherwise (username already exists)
	 */
	public User registerUser(String firstName, String lastName, String username, String password) {

		User user = new User();
		user.setFirstname(firstName);
		user.setFirstname(lastName);
		user.setUsername(username);
		user.setPassword(password);
		users.add(user);
		return user;

	}

	
	public void reserve(Movie movie, Showtime showtime, User user) {
		
	}
	
	
	/**
	 * Method that returns all registered users
	 * @return List of users.
	 */
	public List<User> getUsers() {
		return users;
	}

	
	
	
	

}
