package com.boris;

import com.boris.Classes.Patient;
import com.boris.Classes.Patients;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
//  list.forEach(System.out::println);
public class Main {

    private String fullName;
    private int id;
    private String procedure;
    private double inTotal;
    private boolean paid;
    private double debt;

        public static void main(String[] args) {
        Patients patients = new Patients();
        Scanner scanner = new Scanner(System.in);
//
        patients.listOfPatients.add(new Patient("Жмышенко Валерий", 1, Patient.Procedures.Кастрация, 500, false, 500));
        patients.listOfPatients.add(new Patient("Ананасов Александер", 228, Patient.Procedures.Чистка, 1000.0d, true, 0));
        patients.listOfPatients.add(new Patient("Трипавловских Александр", 2, Patient.Procedures.Кастрация, 500, false, 500));
        patients.listOfPatients.add(new Patient("Денис Орешкин", 7, Patient.Procedures.Пломбирование, 799.99, true, 0 ));
        patients.listOfPatients.add(new Patient("Говнов Иван", 3, Patient.Procedures.Чистка, 500, true, 0));
        patients.listOfPatients.add(new Patient("Летов Егор", 4, Patient.Procedures.Протезирование, 500, false, 500));
        patients.listOfPatients.add(new Patient("Шмурдяк Антон", 14, Patient.Procedures.Кремация, 800, false, 400));
        patients.listOfPatients.add(new Patient("Горин Геннадий", 5, Patient.Procedures.Протезирование, 500, false, 500));
        patients.listOfPatients.add(new Patient("Белоглазов Анатолий", 88, Patient.Procedures.Чистка, 500, true, 0));
        patients.listOfPatients.add(new Patient("Борис Бритва", 15, Patient.Procedures.Пломбирование, 350, true, 0));

        System.out.println("Выберите действие\n\tПоиск по базе - 1\n\tСправки о должниках - 2\n\tУдалить записи без задолженностей - 3\n\tВывести данные по всем записям - 4");

        Scanner choice = new Scanner(System.in);
        while (true) {
            switch (choice.nextInt()) {
                case 1:
                    System.out.println("Введите фамилию: ");
                    boolean isCorrectly = false;
                    while (!isCorrectly) {
                        String surname = scanner.nextLine();
                        if (surname.matches("[А-Я][а-я]{2,}")) {
                            System.out.println(patients.getPatientBySurname(surname));
                            isCorrectly = true;
                        } else
                            System.out.println("Введите корректную фамилию");
                    }
                    break;
                case 2:
                    System.out.println(patients.getDebtors());
                    break;
                case 3:
                    patients.removeAllPaidNotes();
                    break;
                case 4:
                    System.out.println(patients);
                    break;
                case 5:
                    patients.dumpMem();
                    break;
                default:
                    continue;

            }
        }
    }
}
