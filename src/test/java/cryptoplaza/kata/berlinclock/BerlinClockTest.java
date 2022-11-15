package cryptoplaza.kata.berlinclock;

import cryptoplaza.kata.berlinclock.services.BerlinClockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static cryptoplaza.kata.berlinclock.utils.Constants.ColorLampBerlinClock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BerlinClockTest {

    @Autowired
    BerlinClockService berlinClockService;


        /*The top lamp blinks to show seconds- it is illuminated on even seconds and off on odd seconds.
        The next two rows represent hours. The upper row represents 5 hour blocks and is made up of 4 red lamps.
        The lower row represents 1 hour blocks and is also made up of 4 red lamps.
        The final two rows represent the minutes. The upper row represents 5 minute blocks, and is made up of 11 lamps- every third lamp is red, the rest are yellow.
        The bottom row represents 1 minute blocks, and is made up of 4 yellow lamps. */


    @Test
    void testOneLampForSecond() {
        var secondLamp = berlinClockService.getLampSeconds(2);
        assertEquals(1, secondLamp.length());
    }

    @Test
    void testEvenSecondsOnLamp() {
        var secondLamp = berlinClockService.getLampSeconds(2);
        assertEquals(YELLOW, secondLamp);
    }

    @Test
    void testOddSecondOffLamp() {
        var secondLamp = berlinClockService.getLampSeconds(1);
        assertEquals(String.valueOf(OFF), secondLamp);
    }

}
