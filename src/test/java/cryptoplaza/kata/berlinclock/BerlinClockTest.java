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

    @Test
    void testFourLampForFirstRowHour() {
        var firstRowHour = berlinClockService.getLampHourFirstRow(8);
        assertEquals(4, firstRowHour.length());
    }

    @Test
    void testFirstRowHour() {
        assertEquals("OOOO", berlinClockService.getLampHourFirstRow(0));
        assertEquals("ROOO", berlinClockService.getLampHourFirstRow(6));
        assertEquals("RROO", berlinClockService.getLampHourFirstRow(11));
        assertEquals("RRRR", berlinClockService.getLampHourFirstRow(23));
    }

    @Test
    void testFourLampForSecondRowHour() {
        var firstRowHour = berlinClockService.getLampHourSecondRow(8);
        assertEquals(4, firstRowHour.length());
    }

    @Test
    void testSecondRowHour(){
        assertEquals("OOOO", berlinClockService.getLampHourSecondRow(0));
        assertEquals("ROOO", berlinClockService.getLampHourSecondRow(6));
        assertEquals("ROOO", berlinClockService.getLampHourSecondRow(11));
        assertEquals("RRRO", berlinClockService.getLampHourSecondRow(23));
    }

    @Test
    void testElevenLampForFirstRowMinutes(){
        var firstRowMinutes = berlinClockService.getLampMinutesFirstRow(45);
        assertEquals(11, firstRowMinutes.length());
    }

    @Test
    void testFirstRowMinutes(){
        assertEquals("OOOOOOOOOOO", berlinClockService.getLampMinutesFirstRow(0));
        assertEquals("YYRYYRYYRYY", berlinClockService.getLampMinutesFirstRow(59));
        assertEquals("OOOOOOOOOOO", berlinClockService.getLampMinutesFirstRow(4));
        assertEquals("YYRYOOOOOOO", berlinClockService.getLampMinutesFirstRow(23));
        assertEquals("YYRYYRYOOOO", berlinClockService.getLampMinutesFirstRow(35));
    }

    @Test void testFourLampForSecondRowMinutes(){
        var secondRowMinutes = berlinClockService.getLampMinutesSecondRow(45);
        assertEquals(4, secondRowMinutes.length());
    }

    @Test
    void testSecondRowMinutes(){
        assertEquals("OOOO", berlinClockService.getLampMinutesSecondRow(0));
        assertEquals("YYYY", berlinClockService.getLampMinutesSecondRow(59));
        assertEquals("YYOO", berlinClockService.getLampMinutesSecondRow(32));
        assertEquals("YYYY", berlinClockService.getLampMinutesSecondRow(34));
        assertEquals("OOOO", berlinClockService.getLampMinutesSecondRow(35));
    }

    @Test
    void testCheckEveryRedLampFirstRowMinutes(){
        var lampFirstRow = berlinClockService.getLampMinutesFirstRow(55);
        assertEquals(RED, String.valueOf(lampFirstRow.charAt(2)));
        assertEquals(RED, String.valueOf(lampFirstRow.charAt(5)));
        assertEquals(RED, String.valueOf(lampFirstRow.charAt(8)));
    }

    @Test
    void testCheckEveryYellowLampFirsRowMinutes(){
        var lampFirstRow = berlinClockService.getLampMinutesFirstRow(55);
        assertEquals(YELLOW,String.valueOf(lampFirstRow.charAt(0)));
        assertEquals(YELLOW,String.valueOf(lampFirstRow.charAt(1)));
        assertEquals(YELLOW,String.valueOf(lampFirstRow.charAt(3)));
        assertEquals(YELLOW,String.valueOf(lampFirstRow.charAt(4)));
        assertEquals(YELLOW,String.valueOf(lampFirstRow.charAt(6)));
        assertEquals(YELLOW,String.valueOf(lampFirstRow.charAt(7)));
        assertEquals(YELLOW,String.valueOf(lampFirstRow.charAt(9)));
        assertEquals(YELLOW,String.valueOf(lampFirstRow.charAt(10)));
    }

    @Test
    void testTimeBerlinClock(){
        var hour    = 00;
        var minutes = 00;
        var second  = 00;
        var expect = "Y OOOO OOOO OOOOOOOOOOO OOOO";
        assertEquals(expect,berlinClockService.getTimeBerlinClock(second,hour,minutes));
    }

}
