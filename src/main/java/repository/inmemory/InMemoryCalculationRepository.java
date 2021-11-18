package repository.inmemory;

import model.Calculation;
import repository.CalculationRepository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

/**
 * created by E.K.
 * 2021 November 19
 **/

public class InMemoryCalculationRepository extends InMemoryBaseRepository<Calculation> implements CalculationRepository {

    // Map  userId -> CalculationRepository
    private final Map<Integer, InMemoryBaseRepository<Calculation>> usersCalculationsMap = new ConcurrentHashMap<>();


    @Override
    public Calculation save(Calculation calculation, int userId) {
        Objects.requireNonNull(calculation, "meal must not be null");
        var calculations = usersCalculationsMap.computeIfAbsent(userId, uId -> new InMemoryBaseRepository<>());
        return calculations.save(calculation);
    }

    @Override
    public boolean delete(int id, int userId) {
        var calculations = usersCalculationsMap.get(userId);
        return calculations != null && calculations.delete(id);
    }

    @Override
    public Calculation get(int id, int userId) {
        var calculations = usersCalculationsMap.get(userId);
        return calculations == null ? null : calculations.get(id);
    }

    @Override
    public List<Calculation> getAll(int userId) {
        return filterByPredicate(userId, calculation -> true);
    }

    @Override
    public List<Calculation> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return null;
    }

    private List<Calculation> filterByPredicate(int userId, Predicate<Calculation> filter) {
        var calculations = usersCalculationsMap.get(userId);
        return calculations == null ? Collections.emptyList() :
                calculations.getCollection().stream()
                        .filter(filter)
                        .sorted(Comparator.comparing(Calculation::getDateTime).reversed())
                        .toList();
    }


}
