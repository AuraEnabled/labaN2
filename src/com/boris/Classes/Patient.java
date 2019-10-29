package com.boris.Classes;

import java.lang.String;

public class Patient {
    private String fullName;
    private int id;
    private String procedure;
    private double inTotal;
    private boolean paid;
    private double debt;


    public enum Procedures{
        Кастрация,
        Чистка,
        Пломбирование,
        Протезирование,
        Кремация;
    }

    Procedures typeProcedures;

    public Patient(String fullName, int id, Procedures procedures, double inTotal, boolean paid, double debt){
        this.fullName = fullName;
        this.id = id;
        typeProcedures = procedures;
        this.inTotal = inTotal;
        this.paid = paid;
        this.debt = debt;
    }

    public Patient(){
        this.fullName=null;
        this.id=0;
        this.procedure=null;
        this.inTotal=0;
        this.paid=false;
        this.debt=0;
    }

//  геттеры

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public Procedures getProcedures() {
        return typeProcedures;
    }

    public double getInTotal() {
        return inTotal;
    }

    public boolean isPaid() {
        return paid;
    }

    public double getDebt() {
        return debt;
    }

//  с е т т е р ы

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public void setInTotal(double inTotal) {
        this.inTotal = inTotal;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public void setTypeProcedures(Procedures typeProcedures) {
        this.typeProcedures = typeProcedures;
    }
}
