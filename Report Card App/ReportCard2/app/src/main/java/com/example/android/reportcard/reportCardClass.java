package com.example.android.reportcard;

public class reportCardClass{
    String sname;
    String smarks;
    String sgrade;

    public String getSgrade() {
        return sgrade;
    }

    public void setSgrade(String sgrade) {
        this.sgrade = sgrade;
    }

    public reportCardClass(String sgrade, String sname , String smarks) {
        this.sgrade = sgrade;
        this.sname = sname;
        this.smarks= smarks;

    }

    public String getSmarks() {
        return smarks;
    }

    public void setSmarks(String smarks) {
        this.smarks = smarks;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
