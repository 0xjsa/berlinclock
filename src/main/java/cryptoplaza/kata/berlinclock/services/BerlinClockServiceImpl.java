package cryptoplaza.kata.berlinclock.services;


import org.springframework.stereotype.Service;

import static cryptoplaza.kata.berlinclock.utils.Constants.ColorLampBerlinClock.*;

@Service
public class BerlinClockServiceImpl implements  BerlinClockService{

    @Override
    public String getLampSeconds(Integer second) {
        return second %2 == 0 ? YELLOW : String.valueOf(OFF);
    }

    @Override
    public String getLampHourFirstRow(Integer hour) {
        var hoursFirstRow = hour / 5;
        return String.format("%-4s", RED.repeat(hoursFirstRow)).replace(' ', OFF);
    }

    @Override
    public String getLampHourSecondRow(Integer hour) {
        var hoursSecondRow = hour % 5;
        return String.format("%-4s", RED.repeat(hoursSecondRow)).replace(' ', OFF);
    }

    @Override
    public String getLampMinutesFirstRow(Integer minutes) {
        var minutesFirstRow = minutes / 5;
        return String.format("%-11s", getColorsMinutesFirstRow(minutesFirstRow)).replace(' ', OFF);
    }

    @Override
    public String getLampMinutesSecondRow(Integer minutes) {
        var minutesSecondRow = minutes % 5;
        return String.format("%-4s", YELLOW.repeat(minutesSecondRow)).replace(' ', OFF);
    }

    private String getColorsMinutesFirstRow(Integer minute) {

        StringBuilder result = new StringBuilder();
        for(int i = 1; i<=minute; i++){
            if (i % 3 != 0) {
                result.append(YELLOW);
            } else {
                result.append(RED);
            }
        }
        return result.toString();
    }

    @Override
    public String getTimeBerlinClock(Integer seconds, Integer hours, Integer minutes){
        return String.format("%s %s %s %s %s", getLampSeconds(seconds),
                getLampHourFirstRow(hours), getLampHourSecondRow(hours),
                getLampMinutesFirstRow(minutes), getLampMinutesSecondRow(minutes)
        );
    }


}
