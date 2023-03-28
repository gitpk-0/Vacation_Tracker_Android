package wgu.patrick_kell_d308.Database;

import android.app.Application;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import wgu.patrick_kell_d308.DAO.ExcursionDAO;
import wgu.patrick_kell_d308.DAO.VacationDAO;
import wgu.patrick_kell_d308.Entities.Excursion;
import wgu.patrick_kell_d308.Entities.Vacation;

/**
 * @author Patrick Kell
 */
public class Repository {

    int MILLIS = 100;

    private VacationDAO mVacationDAO; // m's in front of instance variables, s's in front of static variables
    private ExcursionDAO mExcursionDAO;
    private List<Vacation> mAllVacations;
    private List<Excursion> mAllExcursions;
    private Vacation vacation;

    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application) {
        VacationDatabaseBuilder db = VacationDatabaseBuilder.getDatabase(application);
        mVacationDAO = db.vacationDAO();
        mExcursionDAO = db.excursionDAO();
    }
    public Repository() {}

    public List<Vacation> getAllVacations() {
        databaseExecutor.execute(() -> {
            mAllVacations = mVacationDAO.getAllVacations();
        });
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllVacations;
    }

    public Vacation getVacationById(int id) {
        databaseExecutor.execute(() -> {
            vacation = mVacationDAO.getVacationById(id);
        });
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return vacation;
    }

    public void insert(Vacation vacation) {
        databaseExecutor.execute(() -> {
            mVacationDAO.insert(vacation);
        });
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update(Vacation vacation) {
        databaseExecutor.execute(() -> {
            mVacationDAO.update(vacation);
        });
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(Vacation vacation) {
        databaseExecutor.execute(() -> {
            mVacationDAO.delete(vacation);
        });
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Excursion> getAllExcursions() {
        databaseExecutor.execute(() -> {
            mAllExcursions = mExcursionDAO.getAllExcursions();
        });
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllExcursions;
    }

    public List<Excursion> getExcursionsByVacaId(int id) {
        databaseExecutor.execute(() -> {
            mAllExcursions = mExcursionDAO.getExcursionsByVacaId(id);
        });
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllExcursions;
    }



    public void insert(Excursion excursion) {
        databaseExecutor.execute(() -> {
            mExcursionDAO.insert(excursion);
        });
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update(Excursion excursion) {
        databaseExecutor.execute(() -> {
            mExcursionDAO.update(excursion);
        });
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(Excursion excursion) {
        databaseExecutor.execute(() -> {
            mExcursionDAO.delete(excursion);
        });
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
