package cryptoplaza.kata.berlinclock.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static class ColorLampBerlinClock {
        public final static String RED      = "R";
        public final static String YELLOW   = "Y";
        public final static char OFF        = 'O';
    }
}
