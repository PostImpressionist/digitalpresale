package repository.inmemory;

import model.User;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * created by E.K.
 * 2021 November 19
 **/

public class InMemoryUserRepository extends InMemoryBaseRepository<User> implements repository.UserRepository {

    private static final InMemoryUserRepository instance = new InMemoryUserRepository();

    private InMemoryUserRepository() {
    }

    public static InMemoryUserRepository getInstance() {
        return instance;
    }


    // SAVE DELETE GET -> FROM SUPER CLASS

    @Override
    public List<User> getAll() {
        return getCollection().stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getEmail))
                .toList();
    }

    @Override
    public User getByEmail(String email) {
        Objects.requireNonNull(email, "email must not be null");
        return getCollection().stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }
}
