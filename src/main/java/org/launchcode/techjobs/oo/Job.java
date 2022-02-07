package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name = "";
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer emp, Location loc, PositionType pt, CoreCompetency cc) {
        this();
        name = aName;
        employer = emp;
        location = loc;
        positionType = pt;
        coreCompetency = cc;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        boolean nameDataNotAvailable = false;
        boolean employerDataNotAvailable = false;
        boolean locationDataNotAvailable = false;
        boolean positionTypeDataNotAvailable = false;
        boolean coreCompetencyDataNotAvailable = false;

        if(getName().equals("")) {
            setName("Data not available");
            nameDataNotAvailable = true;
        }
        if(getEmployer().getValue().equals("")) {
            employer.setValue("Data not available");
            employerDataNotAvailable = true;
        }
        if(getLocation().getValue().equals("")) {
            location.setValue("Data not available");
            locationDataNotAvailable = true;
        }
        if(getPositionType().getValue().equals("")) {
            positionType.setValue("Data not available");
            positionTypeDataNotAvailable = true;
        }
        if(getCoreCompetency().getValue().equals("")) {
            coreCompetency.setValue("Data not available");
            coreCompetencyDataNotAvailable = true;
        }

        if(nameDataNotAvailable && employerDataNotAvailable && locationDataNotAvailable &&
                positionTypeDataNotAvailable && coreCompetencyDataNotAvailable)
            return "\nOOPS! This job does not seem to exist.\n";
        else
            return "\nID: " + id + "\nName: " + name + "\nEmployer: " + employer + "\nLocation: " + location +
                    "\nPosition Type: " + positionType + "\nCore Competency: " + coreCompetency + "\n\n";
    }

    // Getters and Setters:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
