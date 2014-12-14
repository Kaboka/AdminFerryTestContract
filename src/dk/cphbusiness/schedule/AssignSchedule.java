package dk.cphbusiness.schedule;


import dk.cphbusiness.test.FerryManagerHolder;
import ferry.contract.AdminContract;
import ferry.dto.DepartureDetail;
import ferry.dto.FerryIdentifier;
import ferry.dto.ScheduleDetail;
import ferry.dto.ScheduleIdentifier;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mhck
 */
public class AssignSchedule {
    private AdminContract manager;
    
    
    public AssignSchedule() {
    }
    
    @Before
    public void setUp() {
           manager = FerryManagerHolder.manager;
    }
    
    @After
    public void tearDown() {
    }
   
/*    @Test
    public void testAssignScheduleSucess() throws Exception{
        int id = 1;
        Set<DepartureDetail> departures = new HashSet<DepartureDetail>();
        ScheduleDetail scheduleDetail = new ScheduleDetail(id, new Date(), new Date(), departures);
        manager.assignFerryToSchedule(new FerryIdentifier(id), new ScheduleDetail());
        Collection<ScheduleDetail> schedules = manager.showSchedules();
        ScheduleDetail tempSchedule = null;
        for (ScheduleDetail s : schedules) {
            if (s.getID() == id)
                tempSchedule = s;
        }
        Assert.assertEquals(scheduleDetail, tempSchedule);
    }*/
}