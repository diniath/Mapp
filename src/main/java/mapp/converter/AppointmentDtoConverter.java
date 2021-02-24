
package mapp.converter;

import java.util.List;
import java.util.stream.Collectors;
import mapp.entity.Appointment;
import mapp.dto.AppointmentDto;

import org.springframework.stereotype.Component;

@Component
public class AppointmentDtoConverter {
    
        public AppointmentDto entityToDto(Appointment appointment) {
        AppointmentDto dto = new AppointmentDto();
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setCompanyId(appointment.getCompany().getId());
        dto.setOrderlistId(appointment.getOrderlist().getId());
        dto.setProductId(appointment.getProduct().getId());
        return dto;
    }

    public List<AppointmentDto> entityToDto(List<Appointment> appointment) {
        return appointment.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }
    
}
