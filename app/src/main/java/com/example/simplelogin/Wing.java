package com.example.simplelogin;

public class Wing {

    String Name,Hostel,id,Branch;

    public Wing(String name, String hostel, String id, String branch) {
        Name = name;
        Hostel = hostel;
        this.id = id;
        Branch = branch;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHostel() {
        return Hostel;
    }

    public void setHostel(String hostel) {
        Hostel = hostel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }
}
