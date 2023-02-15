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
        if(age < 0)
            throw new NegativeAgeException("Negative age not allowed.");
        if(!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"))
            throw new GenderNotAllowedException("Gender not allowed.");

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name(){return name;}
    public int age(){return age;}
    public String gender(){return gender;}

    public double[] averageAgePerGender(List<Person> persons) {
        double[] meanAge = new double[2];
        double numberOfMale = 0.0;
        double numberOfFemale = 0.0;

        if (persons.isEmpty()) throw new EmptyListException("The list can not be empty.");

        for (Person p : persons) {
            if (p.gender().equalsIgnoreCase("male")) {
                meanAge[0] += p.age();
                numberOfMale++;
            } else {
                meanAge[1] += p.age();
                numberOfFemale++;
            }
        }

        if (numberOfMale != 0)
            meanAge[0] = meanAge[0] / numberOfMale;
        else
            meanAge[0] = 0.0;

        if (numberOfFemale != 0)
            meanAge[1] = meanAge[1] / numberOfFemale;
        else
            meanAge[1] = 0.0;
        return meanAge;
    }
}
