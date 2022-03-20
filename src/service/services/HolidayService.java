package service.services;

import entity.Holiday;

import java.util.List;

public interface HolidayService {

    Holiday addHoliday(Holiday holiday);

    Holiday getHolidayById(Integer id);

    List<Holiday> listHolidays();

    Holiday deleteHoliday(Integer id);
}
