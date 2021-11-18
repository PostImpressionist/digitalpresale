package repository;

import model.Calculation;

import java.time.LocalDateTime;
import java.util.List;

public interface CalculationRepository {
    // null if updated calculation do not belong to userId
    Calculation save(Calculation calculation, int userId);

    // false if calculation do not belong to userId
    boolean delete(int id, int userId);

    // null if calculation do not belong to userId
    Calculation get(int id, int userId);

    // ORDERED dateTime desc
    List<Calculation> getAll(int userId);

    // ORDERED dateTime desc
    List<Calculation> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);
}
