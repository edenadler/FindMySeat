package com.prototype.joint.findmyseat;

public class User {
    private String name;
    private Department department;
    private String job;
    private String profession;
    private Location location;
    //private int frequency;
    private String phoneNumber;
    private String emailAddress;
    public User() {
        this.name = null;
        this.department = Department.HEADQUARTERS;
        this.job = null;
        this.profession = null;
        this.location = Location.TLV;
        this.phoneNumber = null;
        this.emailAddress = null;
    }
    public User(String name, Department department, String job, String profession, Location location,
                String phoneNumber, String emailAddress){
        this.name=name;
        this.department = department;
        this.job = job;
        this.profession = profession;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

}

