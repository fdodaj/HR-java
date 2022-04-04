package service;

import entity.Holiday;
import repository.HolidayRepository;
import service.services.HolidayService;

import java.util.List;

public class HolidayServicesImpl implements HolidayService {

    HolidayRepository holidayRepository = new HolidayRepository();

    public Holiday addHoliday (Holiday holiday){
        return holidayRepository.save(holiday);
    }

    public Holiday getHolidayById(Integer id){
        if (!holidayRepository.getHolidayById(id).getDeleted())
            return  holidayRepository.getHolidayById(id);
        else
            return null;
    }

    @Override
    public List<Holiday> listHolidays() {
      return holidayRepository.listHolidays();
    }


    public Holiday deleteHoliday(Integer id) {
        return holidayRepository.delete(id);
    }
}
