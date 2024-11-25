package org.example;

import org.example.DAO.ManufacturerDAO;
import org.example.DAO.PhoneDAO;
import org.example.models.Manufacturer;
import org.example.models.Phone;

public class Main {
    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer();

        String name = "Oppo";
        String location = "US";
        int employee = 250;

        manufacturer.setName(name);
        manufacturer.setLocation(location);
        manufacturer.setEmployee(employee);

        Phone phone = new Phone();

        String name_phone = "oppo reno";
        int price = 1000000;
        String color = "pink";
        String country = "US";
        int quantity = 100;

        phone.setName(name_phone);
        phone.setPrice(price);
        phone.setColor(color);
        phone.setCountry(country);
        phone.setQuantity(quantity);
        phone.setManufacturer(manufacturer);

        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        PhoneDAO phoneDAO = new PhoneDAO();

        if (manufacturerDAO.add(manufacturer)) {
            System.out.println("Manufacturer added successfully!");
        } else {
            System.out.println("Failed to add manufacturer.");
        }
        if (phoneDAO.add(phone)) {
            System.out.println("Phone added successfully!");
        } else {
            System.out.println("Failed to add phone.");
        }
        for (Phone p : phoneDAO.getPhonesSortedByCountryAndPrice()) {
            System.out.println(p.getName());

        }
        manufacturerDAO.update(manufacturer);
        phoneDAO.update(phone);
        System.out.println(phoneDAO.getPhoneWithHighestPrice().getName());
        System.out.println(manufacturerDAO.getLastManufacturerBasedInUS().getName());
    }
}