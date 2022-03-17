package service;

import entity.Holiday;
import repository.HolidayRepository;

import java.util.List;

public class HolidayServicesImpl implements HolidayService {

    HolidayRepository holidayRepository = new HolidayRepository();

    public Holiday addHoliday (Holiday holiday){
        return holidayRepository.save(holiday);
    }

    public Holiday getHolidayById(Integer id){
        return  holidayRepository.getHolidayById(id);
    }

    @Override
    public void listHolidays() {
      holidayRepository.getHoliday();
    }


    public Holiday deleteHoliday(Integer id) {
        return holidayRepository.delete(id);
    }
}
