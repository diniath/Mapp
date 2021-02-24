package mapp.converter;

import mapp.dto.EnrolledUserUpdateDto;
import mapp.entity.EnrolledUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EnrolledUserUpdateDtoConverter {

    public EnrolledUserUpdateDto entityToDto(EnrolledUser enrolledUser) {

        ModelMapper mapper = new ModelMapper();
        EnrolledUserUpdateDto map = mapper.map(enrolledUser, EnrolledUserUpdateDto.class);
        return map;
    }
}
