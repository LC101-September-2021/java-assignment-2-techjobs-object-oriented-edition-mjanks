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
    Job j5 = new Job("Product tester", new Employer(), new Location(),
            new PositionType(), new CoreCompetency());
    Job j6 = new Job("", new Employer(), new Location(),
            new PositionType(), new CoreCompetency());

    @Test
    public void testSettingJobId() {
        assertEquals(j1.getId(), j2.getId() - 1);
    }

    @Test
    @SuppressWarnings("ConstantConditions")
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

    @Test
    public void testJobClassToStringReturnsStringBeginningAndEndingWithBlankLine() {
        assertEquals(j3.toString().charAt(0), '\n');
        assertEquals(j3.toString().charAt(j3.toString().length() - 1), '\n');
    }

    @Test
    public void testJobClassToStringFieldLabels() {
        assertEquals(j3.toString(), "\nID: " + j3.getId() + "\nName: " + j3.getName() + "\nEmployer: " +
                j3.getEmployer() + "\nLocation: " + j3.getLocation() + "\nPosition Type: " + j3.getPositionType() +
                "\nCore Competency: " + j3.getCoreCompetency() + "\n\n");
    }

    @Test
    public void testJobClassToStringEmptyFields() {
        assertEquals(j5.toString(), "\nID: " + j5.getId() + "\nName: " + j5.getName() + "\nEmployer: " +
                "Data not available" + "\nLocation: " + "Data not available" + "\nPosition Type: " +
                "Data not available" + "\nCore Competency: " + "Data not available" + "\n\n");
    }

    @Test
    public void testJobClassToStringIdOnly() {
        assertEquals(j6.toString(), "\nOOPS! This job does not seem to exist.\n");
    }
}
