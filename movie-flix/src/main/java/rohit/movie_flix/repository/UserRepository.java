package rohit.movie_flix.repository;

import rohit.movie_flix.entity.User;

public interface UserRepository {
	public User findUser(String userId);

	public User createUser(User user);

	public User updateUser( User user);

	public void deleteUser(User user);

	public User findUserByEmail(String email);

	public User userValidate(String email, String password);
}
