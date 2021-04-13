
import business.exceptions.UserException;
import business.persistence.BmiMapper;
import business.persistence.Database;


public class BmiFacade
{
    private BmiMapper bmiMapper;

    public BmiFacade(Database database) {
        this.bmiMapper = new BmiMapper(database);

    }

    public void insertBmiEntry() throws UserExeption {
        bmiMapper.insertBmiEntry();
    }

}

