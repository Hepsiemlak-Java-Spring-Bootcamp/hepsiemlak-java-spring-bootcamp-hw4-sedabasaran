package emlakburada.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.repository.UserRepository;

@Service
public class UserService extends UserBaseService {

	@Autowired
	private UserRepository userRepository;

	public List<UserResponse> getAllUser() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> convertToUserResponse(user)).collect(Collectors.toList());
	}

	public void saveUser(UserRequest userRequest) {
		userRepository.save(convertToUserEntity(userRequest));
	}
	
	public Optional<User> getUserByUserId(Integer id) {
	     return userRepository.findById(id);
	}
	
	public void updateUser(Integer id, User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}


}
