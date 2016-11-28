package rohit.movie_flix.service;

import rohit.movie_flix.entity.User;

public interface UserService {
	public User findUser(String userId);

	public User createUser(User user);

	public User updateUser(String userId, User user);

	public void deleteUser(String userId);
	
	public String userValidate(String email, String password);

}
