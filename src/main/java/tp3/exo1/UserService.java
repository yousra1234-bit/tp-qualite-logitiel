package tp3.exo1;

public class UserService {

    private final UserRepository userRepository;

    // Injection par constructeur
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long id) {
        return userRepository.findUserById(id);
    }
}
