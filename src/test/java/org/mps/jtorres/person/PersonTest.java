package org.mps.jtorres.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JTorres
 * Los casos de prueba a testear son los siguientes:
 * - Que cuando el genero no sea valido se lance la excepcion GenderNotAllowedException
 * - Que cuando la edad sea negativa se lance la excepcion NegativeAgeException
 * - El metodo name() devuelve correctamente el nombre del objeto person
 * - El metodo age() devuelve correctamente la edad del objeto person
 * - El metodo gender() devuelve correctamente el genero del objeto person
 *
 */
public class PersonTest {
    Person p;
    List<Person> lPersons;

    @BeforeEach
    void setup(){
        p = new Person("test", 20, "male");
        lPersons = new ArrayList<Person>();
    }
    @AfterEach
    void shutdown(){
        p = null;
        lPersons = null;
    }

    @Test
    void wrongGender(){
        assertThrows(GenderNotAllowedException.class,
                () -> new Person("test", 20, "notAGender"));
    }

    @Test
    void negativeAge(){
        assertThrows(NegativeAgeException.class,
                () -> new Person("test", -2, "male"));
    }

    @Test
    void returnName(){
        String nameExpected = "test";
        String nameActual = p.name();
        assertEquals(nameExpected, nameActual);
    }

    @Test
    void returnAge(){
        int ageExpected = 20;
        int ageActual = p.age();
        assertEquals(ageExpected, ageActual);
    }

    @Test
    void returnGender(){
        String genderExpected = "male";
        String genderActual = p.gender();
        assertEquals(genderExpected, genderActual);
    }
}
