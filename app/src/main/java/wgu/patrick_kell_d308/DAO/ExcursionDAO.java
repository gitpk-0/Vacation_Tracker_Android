package wgu.patrick_kell_d308.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import wgu.patrick_kell_d308.Entities.Excursion;

/**
 * @author Patrick Kell
 */
@Dao
public interface ExcursionDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Excursion excursion);

    @Update
    void update(Excursion excursion);

    @Delete
    void delete(Excursion excursion);

    @Query("SELECT * FROM excursions ORDER BY excursionID ASC")
    List<Excursion> getAllExcursions();

    @Query("SELECT * FROM excursions WHERE vacationID= :vacationID ORDER BY excursionID ASC")
    List<Excursion> getExcursionsByVacaId(int vacationID);

    @Query("SELECT * FROM excursions WHERE excursionID= :excursionID")
    Excursion getExcursionById(int excursionID);
}
