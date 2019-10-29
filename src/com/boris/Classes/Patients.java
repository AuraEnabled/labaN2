package com.boris.Classes;

import java.util.Arrays;

public class Patients {

    private Patient[] list;
//  пустой конструктор
    public Patients(){
       Patient[] patient = new Patient[0];
    }
//  объявление массива пациентов
    public Patients(int quantity){
        this.list = new Patient[quantity];
    }
//  добавление нового пациента
    public void add(Patient patient, int position){
        this.list[position-1] = patient;
    }
//  пациент по фамилии
    public String getPatientBySurname(String surname){
        String patients="";
        for(int i=0;i<this.list.length;i++){
            if(this.list[i].getFullName()!=null){
                if(this.list[i].getFullName().contains(surname)) {
                    patients += ("Ф.И.О: " + this.list[i].getFullName() +
                            "\nНомер учётной карточки: " + this.list[i].getId() +
                            "\nВид работы: " + this.list[i].getProcedures() +
                            "\nСтоимость выполненой работы: " + this.list[i].getInTotal() +
                            "\nОтметка об оплате: " + this.list[i].isPaid() +
                            "\nСумма задолженности за лечение: " + this.list[i].getDebt() + "\n\n");
                    return patients;
                }
            }
        }
        return "Такой пациент не найден";
    }
//  справка о должниках
    public String getDebtors(){
        String debtors = "";
        for (int i = 0; i < this.list.length; i++){
            if(!this.list[i].isPaid()){
                debtors +=("Ф.И.О: " + this.list[i].getFullName() +
                        "\nНомер учётной карточки: " + this.list[i].getId() +
                        "\nВид работы: " + this.list[i].getProcedures() +
                        "\nСтоимость выполненой работы: " + this.list[i].getInTotal() +
                        "\nОтметка об оплате: " + this.list[i].isPaid() +
                        "\nСумма задолженности за лечение: " + this.list[i].getDebt() + "\n\n");
            }
        }
     return debtors;
    }
//  удаление записей без задолженности
    public void removeAllPaidNotes(){
        for (Patient patient : this.list) {
            if (patient.isPaid()) {
                patient.setFullName(null);
                patient.setId(0);
                patient.setProcedure(null);
                patient.setInTotal(0);
                patient.setPaid(false);
                patient.setDebt(0);
            }
        }

        System.out.println("Delete succeed");
    }



    @Override
    public String toString() {
        String patients="";
        for (Patient patient:this.list) {
            if(
                    (patient.getFullName() == null) && (patient.getId() == 0) && /*(patient.getProcedures() == null) &&*/ (patient.getInTotal() == 0) && (!patient.isPaid()) && (patient.getDebt() == 0)
            )
                continue;

            patients+=("Ф.И.О: "+ patient.getFullName()+
                    "\nНомер учётной карточки: "+patient.getId()+
                    "\nВид работы: "+patient.getProcedures()+
                    "\nСтоимость выполненой работы: "+patient.getInTotal()+
                    "\nОтметка об оплате: "+patient.isPaid()+
                    "\nСумма задолженности за лечение: "+patient.getDebt()+"\n\n");
        }
        return patients;
    }

    public void dumpMem(){
        String patients="";
        for (Patient patient:this.list) {
            patients+=("Ф.И.О: "+ patient.getFullName()+
                    "\nНомер учётной карточки: "+patient.getId()+
                    "\nВид работы: "+patient.getProcedures()+
                    "\nСтоимость выполненой работы: "+patient.getInTotal()+
                    "\nОтметка об оплате: "+patient.isPaid()+
                    "\nСумма задолженности за лечение: "+patient.getDebt()+"\n\n");
        }
        System.out.println(patients);

    }
}
