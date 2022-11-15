package cryptoplaza.kata.berlinclock.services;


import org.springframework.stereotype.Service;

import static cryptoplaza.kata.berlinclock.utils.Constants.ColorLampBerlinClock.*;

@Service
public class BerlinClockServiceImpl implements  BerlinClockService{

    @Override
    public String getLampSeconds(Integer second) {
        return second %2 == 0 ? YELLOW : String.valueOf(OFF);
    }
}
