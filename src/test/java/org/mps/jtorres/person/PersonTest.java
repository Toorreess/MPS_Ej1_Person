package org.mps.jtorres.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JTorres
 * Los casos de prueba a testear son los siguientes:
 * 1) Que cuando el genero no sea valido se lance la excepcion GenderNotAllowedException
 * 2) Que cuando la edad sea negativa se lance la excepcion NegativeAgeException
 * 3) Que si la lista es vacia lance la excepcion EmptyListException
 * 4) El metodo name() devuelve correctamente el nombre del objeto person
 * 5) El metodo age() devuelve correctamente la edad del objeto person
 * 6) El metodo gender() devuelve correctamente el genero del objeto person
 * 7) Dada lista valida de personas, se devuelva la media correctamente por genero
 * 8) Dada una lista de solo hombres, la edad media de las mujeres es 0
 * 9) Dada una lista de solo mujeres, la edad media de los hombres es 0
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

    // 1) Que cuando el genero no sea valido se lance la excepcion GenderNotAllowedException
    @Test
    void wrongGender(){
        assertThrows(GenderNotAllowedException.class,
                () -> new Person("test", 20, "notAGender"));
    }

    // 2) Que cuando la edad sea negativa se lance la excepcion NegativeAgeException
    @Test
    void negativeAge(){
        assertThrows(NegativeAgeException.class,
                () -> new Person("test", -2, "male"));
    }

    // 3) Que si la lista es vacia lance la excepcion EmptyListException
    @Test
    void emptyList(){
        assertThrows(EmptyListException.class,
                () -> p.averageAgePerGender(new ArrayList<Person>()));
    }

    // 4) El metodo name() devuelve correctamente el nombre del objeto person
    @Test
    void returnCorrectName(){
        String nameExpected = "test";
        String nameActual = p.name();
        assertEquals(nameExpected, nameActual);
    }

    // 5) El metodo age() devuelve correctamente la edad del objeto person
    @Test
    void returnCorrectAge(){
        int ageExpected = 20;
        int ageActual = p.age();
        assertEquals(ageExpected, ageActual);
    }

    // 6) El metodo gender() devuelve correctamente el genero del objeto person
    @Test
    void returnMaleGender(){
        String genderExpected = "male";
        String genderActual = p.gender();
        assertEquals(genderExpected, genderActual);
    }

    // 7) Comprobar que el correcto comportamiento del sistema devuelva unos valores esperados
    @Test
    void correctMeanAge(){
        lPersons.add(new Person("pMale1", 20, "male"));
        lPersons.add(new Person("pMale2", 40, "male"));
        lPersons.add(new Person("pFemale3", 30, "female"));
        lPersons.add(new Person("pFemale4", 70, "female"));

        double[] valuesExpected = {30.0, 50.0};
        double[] valuesActual = p.averageAgePerGender(lPersons);

        //Correct male mean age
        assertEquals(valuesExpected[0], valuesActual[0]);

        //Correct female mean age
        assertEquals(valuesExpected[1], valuesActual[1]);
    }

    // 8) Dada una lista de solo hombres, la edad media de las mujeres es 0
    @Test
    void NoFemaleInList(){
        lPersons.add(new Person("pMale1", 20, "male"));
        lPersons.add(new Person("pMale2", 20, "Male"));

        assertEquals(0.0, p.averageAgePerGender(lPersons)[1]);
    }

    // 9) Dada una lista de solo mujeres, la edad media de los hombres es 0
    @Test
    void NoMaleInList(){
        lPersons.add(new Person("pFemale1", 20, "female"));
        lPersons.add(new Person("pFemale2", 20, "Female"));

        assertEquals(0.0, p.averageAgePerGender(lPersons)[0]);
    }

}
