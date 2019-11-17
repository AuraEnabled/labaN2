package com.boris;

import com.boris.Classes.Patient;
import com.boris.Classes.Patients;


import java.io.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
//  list.forEach(System.out::println);
import java.io.FileOutputStream;

import com.boris.Classes.Serialization;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.lang.Thread.currentThread;
//  import org.apache.commons.compress.archivers.ArchiveException;

public class Main {

    private String fullName;
    private int id;
    private String procedure;
    private double inTotal;
    private boolean paid;
    private double debt;

        public static void main(String[] args) throws IOException {
        Patients patients = new Patients();
        Scanner scanner = new Scanner(System.in);
        Serialization serialization = new Serialization("Patients.ser");
//        patients.getListOfPatients().add(new Patient("Жмышенко Валерий", 1, Patient.Procedures.Кастрация, 500, false, 500));
//        patients.getListOfPatients().add(new Patient("Ананасов Александер", 228, Patient.Procedures.Чистка, 1000.0d, true, 0));
//        patients.getListOfPatients().add(new Patient("Трипавловских Александр", 2, Patient.Procedures.Кастрация, 500, false, 500));
//        patients.getListOfPatients().add(new Patient("Денис Орешкин", 7, Patient.Procedures.Пломбирование, 799.99, true, 0 ));
//        patients.getListOfPatients().add(new Patient("Говнов Иван", 3, Patient.Procedures.Чистка, 500, true, 0));
//        patients.getListOfPatients().add(new Patient("Летов Егор", 4, Patient.Procedures.Протезирование, 500, false, 500));
//        patients.getListOfPatients().add(new Patient("Шмурдяк Антон", 14, Patient.Procedures.Кремация, 800, false, 400));
//        patients.getListOfPatients().add(new Patient("Горин Геннадий", 5, Patient.Procedures.Протезирование, 500, false, 500));
//        patients.getListOfPatients().add(new Patient("Белоглазов Анатолий", 88, Patient.Procedures.Чистка, 500, true, 0));
//        patients.getListOfPatients().add(new Patient("Борис Бритва", 15, Patient.Procedures.Пломбирование, 350, true, 0));

        System.out.println("Выберите действие\n\tПоиск по базе - 1\n\tСправки о должниках - 2\n\tУдалить записи без задолженностей - 3\n\tВывести данные по всем записям - 4\n\tИмя потока - 5\n\tСериализация - 6\n\tДесериализация - 7\n\t");

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
                    System.out.println(currentThread());
                    break;
                case 6:
                    System.out.println(serialization.Serialization(patients));
                    break;
                case 7:
                    System.out.println(serialization.Deserialization(patients));
                    break;
                default:
                    continue;
            }
        }
    }
}
