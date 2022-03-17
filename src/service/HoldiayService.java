package service;

import entity.Holiday;
import entity.User;
import repository.HolidayRepository;

public class HoldiayService {

    HolidayRepository holidayRepository = new HolidayRepository();

    public Holiday addHoliday (Holiday holiday){
        return holidayRepository.save(holiday);
    }

    public Holiday getHolidayById(Integer id){
        return  holidayRepository.getHolidayById(id);
    }

    public String listHolidays(){
        return  holidayRepository.getHoliday();
    }

    public Holiday deleteHoliday(Integer id) {
        return holidayRepository.delete(id);
    }
}
