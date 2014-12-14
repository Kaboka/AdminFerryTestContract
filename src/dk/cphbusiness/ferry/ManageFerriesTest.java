package dk.cphbusiness.ferry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dk.cphbusiness.test.FerryManagerHolder;
import ferry.contract.AdminContract;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kasper
 */
public class ManageFerriesTest {
    private AdminContract manager;
    
    public ManageFerriesTest() {
    }
    
    @Before
    public void setUp() {
        manager = FerryManagerHolder.manager;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testListFerriesSuccess()throws Exception {
        assertEquals(1, manager.showFerries().size());
    }
}
