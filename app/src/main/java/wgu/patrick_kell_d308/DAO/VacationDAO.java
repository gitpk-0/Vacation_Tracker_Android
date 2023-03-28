package wgu.patrick_kell_d308.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import wgu.patrick_kell_d308.Entities.Vacation;

/**
 * @author Patrick Kell
 */

@Dao
public interface VacationDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Vacation vacation);

    @Update
    void update(Vacation vacation);

    @Delete
    void delete(Vacation vacation);

    @Query("SELECT * FROM vacations ORDER BY vacationID ASC")
    List<Vacation> getAllVacations();

    @Query("SELECT * FROM vacations WHERE vacationID= :vacationID")
    Vacation getVacationById(int vacationID);
}
