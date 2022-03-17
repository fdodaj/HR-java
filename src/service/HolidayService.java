package service;

import entity.Holiday;

import java.util.List;

public interface HolidayService {

    Holiday addHoliday(Holiday holiday);

    Holiday getHolidayById(Integer id);

    void listHolidays();

    Holiday deleteHoliday(Integer id);
}
