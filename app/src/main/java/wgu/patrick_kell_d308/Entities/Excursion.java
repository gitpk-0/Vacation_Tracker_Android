package wgu.patrick_kell_d308.Entities;

import androidx.room.Entity;

/**
 * @author Patrick Kell
 */

@Entity(tableName = "excursions")
public class Excursion {

    private String excursionTitle;
    private String excursionDate;

    public Excursion(String excursionTitle, String excursionDate) {
        this.excursionTitle = excursionTitle;
        this.excursionDate = excursionDate;
    }

    // public Excursion() {}


    public String getExcursionTitle() {
        return excursionTitle;
    }

    public void setExcursionTitle(String excursionTitle) {
        this.excursionTitle = excursionTitle;
    }

    public String getExcursionDate() {
        return excursionDate;
    }

    public void setExcursionDate(String excursionDate) {
        this.excursionDate = excursionDate;
    }
}
