/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Senior Steps
 */
public class FirstApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, Person> personsMap = new HashMap<>();
        personsMap.put("Aly", new Person("Aly", "Sayed", 20));
        personsMap.put("Ahmed", new Person("Ahmed", "Amgad", 25));
        personsMap.put("ahmed", new Person("Magdi", "Amir", 25));

        Collections.sort((List<Person>) personsMap.values(), (Person o1, Person o2) -> {
            int firstNameSort = o1.getFirstName().compareTo(o2.getFirstName());
            if (firstNameSort == 0) {
                return o1.getLastName().compareTo(o2.getLastName());
            }

            return firstNameSort;
        });

        personsMap.entrySet().stream().map((record) -> {
            String name = record.getKey();
            if (name.equals("Aly")) {
                return null;
            }
            return record;
        }).map((record) -> {
            return record;
        });

        try (
                FileInputStream fileInput = new FileInputStream("test.txt");
                Reader reader = new InputStreamReader(fileInput);
                BufferedReader bufferedReader = new BufferedReader(reader);) {
            // some code goes here
            String x = bufferedReader.readLine();
        } catch (IOException ex) {
        } finally {
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(14);
        numbers.add(16);
        numbers.add(178);
        numbers.add(1654);
        numbers.add(654);
        numbers.add(56);
        numbers.add(56);
        numbers.add(56);
        numbers.add(56);
        int sum = 0;
        sum = numbers.stream().reduce(sum, Integer::sum);
    }
}
