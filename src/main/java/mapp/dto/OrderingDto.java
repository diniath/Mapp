package mapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class OrderingDto {

    private int orderingId;
    private LocalDate orderDate;
    private String companyProfile;
    private String productProfile;
    private BigDecimal price;

}
