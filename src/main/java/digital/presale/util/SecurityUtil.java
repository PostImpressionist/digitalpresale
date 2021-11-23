package digital.presale.util;

import digital.presale.model.User;
import digital.presale.repository.inmemory.InMemoryCalculationRepository;
import digital.presale.repository.inmemory.InMemoryUserRepository;

/**
 * created by E.K.
 * 2021 November 19
 **/

public class SecurityUtil {
    private static final InMemoryUserRepository userRepository = InMemoryUserRepository.getInstance();

    private static final InMemoryCalculationRepository calcRepository = InMemoryCalculationRepository.getInstance();


    private SecurityUtil() {

    }

    public static User loginDataValidation(String email, String password){
        User user = userRepository.getByEmail(email);
        if(null != user && user.getPassword().equals(password)){
            return user;
        }
        //in case data invalid
        return null;
    }

}
