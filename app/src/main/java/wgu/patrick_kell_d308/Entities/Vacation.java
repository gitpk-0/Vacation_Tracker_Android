package wgu.patrick_kell_d308.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

/**
 * @author Patrick Kell
 */
@Entity(tableName = "vacations")
public class Vacation {

    @PrimaryKey(autoGenerate = true)
    private int vacationID;
    private String vacationTitle;
    private String lodgingType;
    private LocalDate startDate;
    private LocalDate endDate;

}
