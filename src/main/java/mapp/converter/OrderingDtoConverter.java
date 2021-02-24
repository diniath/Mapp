package mapp.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mapp.entity.Ordering;
import mapp.dto.OrderingDto;
import mapp.entity.Orderlist;
import org.springframework.stereotype.Component;

@Component
public class OrderingDtoConverter {

    public List<OrderingDto> entityToDto(Ordering ordering) {
        List<OrderingDto> dtos = new ArrayList();
        List<Orderlist> orders = ordering.getOrderlistList();
        for (Orderlist order : orders) {
            OrderingDto dto = new OrderingDto();
            dto.setOrderingId(ordering.getId());
            dto.setOrderDate(ordering.getOrderdate());
            dto.setProductProfile(order.getProduct().getProfile());
            dto.setCompanyProfile(order.getProduct().getCompany().getProfile());
            dto.setPrice(order.getProduct().getPrice());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<List<OrderingDto>> entityToDto(List<Ordering> ordering) {
        return ordering.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }
}
