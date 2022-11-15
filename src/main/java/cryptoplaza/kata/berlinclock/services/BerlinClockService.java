package cryptoplaza.kata.berlinclock.services;

public interface BerlinClockService {


   String getLampSeconds(Integer second);

   String getLampHourFirstRow(Integer hour);

   String getLampHourSecondRow(Integer hour);

   String getLampMinutesFirstRow(Integer minutes);

   String getLampMinutesSecondRow(Integer minutes);

   String getTimeBerlinClock(Integer seconds, Integer hours, Integer minutes);
}
