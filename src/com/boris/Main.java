package com.boris;

import com.boris.Classes.Patient;
import com.boris.Classes.Patients;

import java.util.Scanner;

public class Main {

    private String fullName;
    private int id;
    private String procedure;
    private double inTotal;
    private boolean paid;
    private double debt;

    public static void main(String[] args) {
        Patients patients = new Patients(10);
        Scanner scanner = new Scanner(System.in);

        patients.add(new Patient("Трипавловских Александр", 1, Patient.Procedures.Кастрация, 500, false, 500), 1);
        patients.add(new Patient("Ананасов Александер", 228, Patient.Procedures.Чистка, 1000.0d, false, 499), 2);
        patients.add(new Patient("Трипавловских Александр", 2, Patient.Procedures.Кастрация, 500, false, 500), 3);
        patients.add(new Patient("Денис Орешкин", 7, Patient.Procedures.Пломбирование, 799.99, true, 0 ), 4);
        patients.add(new Patient("Говнов Иван", 3, Patient.Procedures.Чистка, 500, false, 500), 5);
        patients.add(new Patient("Летов Егор", 4, Patient.Procedures.Протезирование, 500, false, 500), 6);
        patients.add(new Patient(), 7);
        patients.add(new Patient("Трипавловских Александр", 5, Patient.Procedures.Протезирование, 500, false, 500), 8);
        patients.add(new Patient(), 9);
        patients.add(new Patient(), 10);

        System.out.println("Введите фамилию: ");
        boolean isCorrectly=false;
        while (!isCorrectly) {
            String surname = scanner.nextLine();
            if (surname.matches("[А-Я][а-я]{2,}")) {
                System.out.println(patients.getPatientBySurname(surname));
                isCorrectly=true;
            }
            else
                System.out.println("Введите корректную фамилию");
        }
    }

}
