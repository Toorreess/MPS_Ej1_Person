package org.mps.jtorres.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class PersonTest {
    Person pMale;
    Person pFemale;
    Person pNegativeAge;
    Person pIncorrectGender;
    @BeforeAll
    void setup(){
        pMale = new Person("test", 20, "male");
        pFemale = new Person("test", 20, "female");
        pNegativeAge = new Person("AgeError", -2, "male");
        pIncorrectGender = new Person("GenderError", 60, "WrongGender");
    }

    @AfterEach
    void shutdown() {
        pMale = null;
        pFemale = null;
        pNegativeAge = null;
        pIncorrectGender = null;
    }
}
