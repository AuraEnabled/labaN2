package com.boris.Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Patients {

    private ArrayList<Patient> listOfPatients = new ArrayList<Patient>();

    public ArrayList<Patient> getListOfPatients() {
        return listOfPatients;
    }
////    private Patient[] list;
//  пустой конструктор
//    public Patients(){
//       Patient[] patient = new Patient[0];
//    }
//  объявление массива пациентов
//    public Patients(int quantity){
//        this.list = new Patient[quantity];
//    }
//  добавление нового пациента
//    public void add(Patient patient, int position){
//        this.list[position-1] = patient;
//    }
//  пациент по фамилии
    public String getPatientBySurname(String surname){
        String patients="";
        for(Patient patient: listOfPatients){
            if(patient.getFullName()!=null){
                if(patient.getFullName().contains(surname)) {
                    patients += ("Ф.И.О: " + patient.getFullName() +
                            "\nНомер учётной карточки: " + patient.getId() +
                            "\nВид работы: " + patient.getProcedures() +
                            "\nСтоимость выполненой работы: " + patient.getInTotal() +
                            "\nОтметка об оплате: " + patient.isPaid() +
                            "\nСумма задолженности за лечение: " + patient.getDebt() + "\n\n");
                    return patients;
                }
            }
        }
        return "Такой пациент не найден";
    }
//  справка о должниках
    public String getDebtors(){
        String debtors = "";
        for (Patient patient : listOfPatients){
            if(!patient.isPaid()){
                debtors +=("Ф.И.О: " + patient.getFullName() +
                        "\nНомер учётной карточки: " + patient.getId() +
                        "\nВид работы: " + patient.getProcedures() +
                        "\nСтоимость выполненой работы: " + patient.getInTotal() +
                        "\nОтметка об оплате: " + patient.isPaid() +
                        "\nСумма задолженности за лечение: " + patient.getDebt() + "\n\n");
            }
        }
     return debtors;
    }
//  удаление записей без задолженности
    public void removeAllPaidNotes(){
        for (int i =0;i<listOfPatients.size(); i++) {
            if (listOfPatients.get(i).isPaid()) {
                System.out.println(listOfPatients.toString());//get(i)
                listOfPatients.remove(i);
                i--;
            }
        }

        System.out.println("Delete succeed");
    }

//      абрвалг абрвалг
    @Override
    public String toString() {
        String patients="";
        for (Patient patient:listOfPatients) {
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
        for (Patient patient:listOfPatients) {
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
