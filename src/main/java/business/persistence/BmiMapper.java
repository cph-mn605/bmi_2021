package business.persistence;

import business.exceptions.UserException;

public class BmiMapper {
    private Database database;

    public BmiMapper(Database database) {
        this.database = database;
    }

    public void insertBmiEntry() throws UserException {
        //TODO: insert data into database
    }
}
