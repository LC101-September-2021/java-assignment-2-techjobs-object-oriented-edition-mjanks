package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job j1 = new Job();
    Job j2 = new Job();
    Job j3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job j4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

    @Test
    public void testSettingJobId() {
        assertEquals(j1.getId(), j2.getId() - 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(j3.getName(), "Product tester");
        assertEquals(j3.getEmployer().getValue(), "ACME");
        assertEquals(j3.getLocation().getValue(), "Desert");
        assertEquals(j3.getPositionType().getValue(), "Quality control");
        assertEquals(j3.getCoreCompetency().getValue(), "Persistence");

        assertTrue(j3 instanceof Job);
        assertTrue(j3.getEmployer() instanceof Employer);
        assertTrue(j3.getLocation() instanceof Location);
        assertTrue(j3.getPositionType() instanceof PositionType);
        assertTrue(j3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(j3.equals(j4));
    }
}
