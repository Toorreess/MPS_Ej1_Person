package org.mps.jtorres.person;

import java.util.List;

/**
 * @author J. Torres
 */
public class Person {
    private final String name;
    private final int age;
    private final String gender; //Male, female

    /**
     * Constructs a person with name, age and gender
     * @param name
     * @param age
     * @param gender
     */
    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name(){return name;}
    public int age(){return age;}

    public String gender(){return gender;}

    public double[] averageAgePerGender(List<Person> persons){
        double[] meanAge = {0.0, 0.0};
        double maleMeanAge = 0.0;
        double femaleMeanAge = 0.0;
        double numberOfMale = 0.0;
        double numberOfFemale = 0.0;

        if(persons.isEmpty()) throw new RuntimeException();

        for(Person p : persons){
            if(p.age < 0) throw new RuntimeException("Negative age not allowed");

            if(p.name().equalsIgnoreCase("male")) {
                maleMeanAge += p.age();
                numberOfMale++;
            }
            else if (p.name().equalsIgnoreCase("female")) {
                femaleMeanAge += p.age();
                numberOfFemale++;
            }
            else
                throw new RuntimeException("The gender is not correct");
        }

        if(numberOfMale != 0)
            meanAge[0] = maleMeanAge / numberOfMale;
        if(numberOfFemale != 0)
            meanAge[1] = femaleMeanAge / numberOfFemale;

        return meanAge;
    }
}
