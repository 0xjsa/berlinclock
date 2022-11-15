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

    public String getLampHourSecondRow(Integer hour) {
        var hoursSecondRow = hour % 5;
        return String.format("%-4s", RED.repeat(hoursSecondRow)).replace(' ', OFF);
    }


}
