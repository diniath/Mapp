
package mapp.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AppointmentDto {
    
    private LocalDate appointmentDate;
    
    private Integer companyId;
    
    private Integer productId;

    private Integer orderlistId;
    
}
