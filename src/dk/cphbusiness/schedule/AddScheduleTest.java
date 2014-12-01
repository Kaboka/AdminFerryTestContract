package dk.cphbusiness.schedule;

import dk.cphbusiness.test.FerryManagerHolder;
import ferry.contract.AdminContract;
import ferry.dto.ScheduleDetail;
import java.util.Collection;
import java.util.Date;
import org.junit.After;
import org.junit.Assert;
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
        ScheduleDetail schedule = new ScheduleDetail(1, new Date(), new Date(), null);
        manager.addSchedule(schedule);
        Collection<ScheduleDetail> schedules = manager.showSchedules();
        ScheduleDetail tempSchedule = null;
        for (ScheduleDetail s : schedules) {
            if (s.getId() == 1) {
                tempSchedule = s;
            }
        }
        Assert.assertEquals(schedule.getId(), tempSchedule.getId());
    }
    
    public void testAddScheduleFailure() {
    
    }
}
