package rohit.movie_flix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rohit.movie_flix.entity.User;
import rohit.movie_flix.exception.EntityAlreadyExistException;
import rohit.movie_flix.exception.EntityNotFoundException;
import rohit.movie_flix.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userrepository;
	
	@Override
	public User findUser(String userId) {
		User user = userrepository.findUser(userId);
		if (user == null) {
			throw new EntityNotFoundException("User not found");
		}
		return user;
	}

	@Transactional
	@Override
	public User createUser(User user) {
		User existing = userrepository.findUserByEmail(user.getEmail());
		if (existing != null) {
			throw new EntityAlreadyExistException("User already exists with this email");
		}
		return userrepository.createUser(user);
	}

	@Transactional
	@Override
	public User updateUser(String userId, User user) {
		User existing = userrepository.findUser(userId);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		return userrepository.updateUser(user);
	}

	@Transactional
	@Override
	public void deleteUser(String userId) {
		User existing = userrepository.findUser(userId);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		userrepository.deleteUser(existing);
	}

	@Override
	public String userValidate(String email, String password) {
		User existingUser = userrepository.userValidate(email, password);
		if (existingUser == null) {
			throw new EntityNotFoundException("User not found");
		} else {
			return existingUser.getId();
		}
		
	}

}
