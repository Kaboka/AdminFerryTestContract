package dk.cphbusiness.schedule;

import dk.cphbusiness.test.FerryManagerHolder;
import ferry.contract.AdminContract;
import ferry.dto.DepartureDetail;
import ferry.dto.FerryConfigDetail;
import ferry.dto.RouteDetail;
import ferry.dto.ScheduleDetail;
import ferry.eto.InvalidDateException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mhck
 */
public class AddScheduleTest {
    
    private AdminContract manager;
    
    public AddScheduleTest() {
        
    }
    
    @Before
    public void setUp() {
        manager = FerryManagerHolder.manager;
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddScheduleSuccessfully() throws Exception {
        
        ArrayList<RouteDetail> routes = (ArrayList<RouteDetail>) manager.showRoutes();
        assertTrue("Not empty", !routes.isEmpty());
        ArrayList<FerryConfigDetail> configs = (ArrayList<FerryConfigDetail>) manager.showFerryConfigs();
        assertTrue("Not empty", !configs.isEmpty());
        FerryConfigDetail chosenConfig = configs.get(0); 
        ArrayList<DepartureDetail> depatures = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
        
        depatures.add(new DepartureDetail(10, dateFormat.parse("21-12-3500"), 1,routes.get(0),chosenConfig));   
        ScheduleDetail schedule = new ScheduleDetail(1, dateFormat.parse("21-12-9000"), dateFormat.parse("21-12-3000"), depatures);
        manager.addSchedule(schedule);
    }
    
    @Test(expected = InvalidDateException.class)
    public void testAddingScheduleInvalidDate() throws Exception {
        ArrayList<RouteDetail> routes = (ArrayList<RouteDetail>) manager.showRoutes();
        assertTrue("Not empty", !routes.isEmpty());
        ArrayList<FerryConfigDetail> configs = (ArrayList<FerryConfigDetail>) manager.showFerryConfigs();
        assertTrue("Not empty", !configs.isEmpty());
        FerryConfigDetail chosenConfig = configs.get(0); 
        ArrayList<DepartureDetail> depatures = new ArrayList<>();
        depatures.add(new DepartureDetail(10, new Date(), 1,routes.get(0),chosenConfig));   
 
        DateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
        Date startDate  = dateFormat.parse("05-01-1864");
        Date endDate = dateFormat.parse("22-01-2015");
        ScheduleDetail schedule = new ScheduleDetail(1, endDate,startDate, depatures);
        manager.addSchedule(schedule);
    }
    
   @Test(expected = InvalidDateException.class)
    public void testAddingDepaturedateNotInScheduleDate() throws Exception {
        ArrayList<RouteDetail> routes = (ArrayList<RouteDetail>) manager.showRoutes();
        assertTrue("Not empty", !routes.isEmpty());
        ArrayList<FerryConfigDetail> configs = (ArrayList<FerryConfigDetail>) manager.showFerryConfigs();
        assertTrue("Not empty", !configs.isEmpty());
        FerryConfigDetail chosenConfig = configs.get(0); 
                
        DateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
        ArrayList<DepartureDetail> depatures = new ArrayList<>();
        depatures.add(new DepartureDetail(10, dateFormat.parse("10-12-2014"), 1,routes.get(0),chosenConfig));           
        
        Date startDate  = new Date();
        Date endDate = dateFormat.parse("22-01-9000");
        
        ScheduleDetail schedule = new ScheduleDetail(1,endDate,startDate, depatures);
        manager.addSchedule(schedule);
    }
}