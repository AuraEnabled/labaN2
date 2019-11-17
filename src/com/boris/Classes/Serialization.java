package com.boris.Classes;

import java.io.*;
import java.util.ArrayList;

public class Serialization implements Serializable {

    private String pathname;
    private File file;

    public Serialization(){
    }

    public Serialization(String pathname){
        this.pathname=pathname;
        file = new File(pathname);

    }

    public String Serialization(Patients patients) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if(fileOutputStream!=null){
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(patients.getListOfPatients());
                return "Запись прошла успешно!";
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(objectOutputStream!=null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return "Ошибка записи";
    }

    public String Deserialization(Patients patients) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        try {
            patients.getListOfPatients().addAll((ArrayList<Patient>) ois.readObject());
            return "Чтение прошло успешно!";
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            ois.close();
        }
        return "Ошибка чтения из файла";
    }

}
