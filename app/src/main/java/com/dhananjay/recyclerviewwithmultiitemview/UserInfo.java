package com.dhananjay.recyclerviewwithmultiitemview;

import java.util.ArrayList;

public class UserInfo {

    private static final UserInfo _instance = new UserInfo();

    public ArrayList<Doctor> doctorArrayList = new ArrayList<>();

    private UserInfo() {
        createList();
    }

    public static UserInfo getInstance() {
        return _instance;
    }

    private void createList() {

        Doctor doctor = new Doctor();
        doctor.setName("Robert");
        doctor.setGender(0);
        doctor.setRating(3.1f);
        doctor.setIsInPerson(0);
        doctorArrayList.add(doctor);

        doctor = new Doctor();
        doctor.setName("Natasha");
        doctor.setGender(1);
        doctor.setRating(3.9f);
        doctor.setIsInPerson(1);
        doctorArrayList.add(doctor);

        doctor = new Doctor();
        doctor.setName("Tom");
        doctor.setGender(0);
        doctor.setRating(4.2f);
        doctor.setIsInPerson(1);
        doctorArrayList.add(doctor);

        doctor = new Doctor();
        doctor.setName("Smith");
        doctor.setGender(0);
        doctor.setRating(2.3f);
        doctor.setIsInPerson(0);
        doctorArrayList.add(doctor);

        doctor = new Doctor();
        doctor.setName("Venus");
        doctor.setGender(1);
        doctor.setRating(4.9f);
        doctor.setIsInPerson(0);
        doctorArrayList.add(doctor);

        doctor = new Doctor();
        doctor.setName("Ryan");
        doctor.setGender(0);
        doctor.setRating(3.5f);
        doctor.setIsInPerson(0);
        doctorArrayList.add(doctor);

        doctor = new Doctor();
        doctor.setName("Mark");
        doctor.setGender(0);
        doctor.setRating(2.1f);
        doctor.setIsInPerson(0);
        doctorArrayList.add(doctor);

        doctor = new Doctor();
        doctor.setName("Adam");
        doctor.setGender(0);
        doctor.setRating(2.5f);
        doctor.setIsInPerson(0);
        doctorArrayList.add(doctor);

        doctor = new Doctor();
        doctor.setName("Kevin");
        doctor.setGender(0);
        doctor.setRating(3.7f);
        doctor.setIsInPerson(0);
        doctorArrayList.add(doctor);

        doctor = new Doctor();
        doctor.setName("Tina");
        doctor.setGender(1);
        doctor.setRating(3.3f);
        doctor.setIsInPerson(1);
        doctorArrayList.add(doctor);

    }
}
