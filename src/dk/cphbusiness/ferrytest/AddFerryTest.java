package dk.cphbusiness.ferrytest;


import dk.cphbusiness.test.FerryManagerHolder;
import ferry.contract.AdminContract;
import ferry.dto.FerryDetail;
import ferry.dto.FerryIdentifier;
import ferry.eto.DataAccessException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mhck
 */
public class AddFerryTest {
    private AdminContract manager;
    
    
    public AddFerryTest() {
    }
    
    @Before
    public void setUp() {
           manager = FerryManagerHolder.manager;
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void addFerrySucess() throws Exception {
        FerryDetail ferry = new FerryDetail(1,"awesomeFerry",null);
        manager.addFerry(ferry);
        FerryIdentifier id = new FerryIdentifier(1);
        FerryDetail result = manager.findFerry(id);
        assertEquals(result, ferry);
    }
    
    @Test(expected = DataAccessException.class)
    public void addFerryFailure() throws DataAccessException{
        FerryDetail ferry = new FerryDetail(1,"awesomeFerry",null);
        manager.addFerry(ferry);
        manager.addFerry(ferry);
    }
}
