package wgu.patrick_kell_d308.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Patrick Kell
 */
@Entity(tableName = "vacations")
public class Vacation {

    @PrimaryKey(autoGenerate = true)
    private int vacationID;
    private String vacationTitle;
    private String lodgingType;
    private String startDate;
    private String endDate;


    public Vacation(int vacationID, String vacationTitle, String lodgingType, String startDate, String endDate) {
        this.vacationID = vacationID;
        this.vacationTitle = vacationTitle;
        this.lodgingType = lodgingType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // public Vacation(){}


    public int getVacationID() {
        return vacationID;
    }

    public void setVacationID(int vacationID) {
        this.vacationID = vacationID;
    }

    public String getVacationTitle() {
        return vacationTitle;
    }

    public void setVacationTitle(String vacationTitle) {
        this.vacationTitle = vacationTitle;
    }

    public String getLodgingType() {
        return lodgingType;
    }

    public void setLodgingType(String lodgingType) {
        this.lodgingType = lodgingType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
