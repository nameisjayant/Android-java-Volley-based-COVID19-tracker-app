package com.jayant.sudo.Modal;

public class Data {
    private String location;
    private int confirm_cases_indian;
    private int confirm_cases_foreign;
    private int discharge;
    private int deaths;
    private int total_confirm;

    public Data(String location, int confirm_cases_indian, int confirm_cases_foreign, int discharge, int deaths, int total_confirm) {
        this.location = location;
        this.confirm_cases_indian = confirm_cases_indian;
        this.confirm_cases_foreign = confirm_cases_foreign;
        this.discharge = discharge;
        this.deaths = deaths;
        this.total_confirm = total_confirm;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getConfirm_cases_indian() {
        return confirm_cases_indian;
    }

    public void setConfirm_cases_indian(int confirm_cases_indian) {
        this.confirm_cases_indian = confirm_cases_indian;
    }

    public int getConfirm_cases_foreign() {
        return confirm_cases_foreign;
    }

    public void setConfirm_cases_foreign(int confirm_cases_foreign) {
        this.confirm_cases_foreign = confirm_cases_foreign;
    }

    public int getDischarge() {
        return discharge;
    }

    public void setDischarge(int discharge) {
        this.discharge = discharge;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTotal_confirm() {
        return total_confirm;
    }

    public void setTotal_confirm(int total_confirm) {
        this.total_confirm = total_confirm;
    }
}
