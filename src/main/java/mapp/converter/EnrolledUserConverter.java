package mapp.converter;

import mapp.entity.EnrolledUser;
import mapp.dto.EnrolledUserDto;
import java.util.List;
import java.util.stream.Collectors;
import mapp.entity.ImageUrl;
import mapp.service.ImageUrlServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class EnrolledUserConverter {

    @Autowired
    private ImageUrlServiceImpl service;

    public EnrolledUserDto entityToDto(EnrolledUser enrolledUser) {

        EnrolledUserDto dto = new EnrolledUserDto();
        dto.setId(enrolledUser.getId());
        dto.setUsername(enrolledUser.getUsername());
        dto.setFname(enrolledUser.getFname());
        dto.setLname(enrolledUser.getLname());
        dto.setEmail(enrolledUser.getEmail());
        dto.setDateofbirth(enrolledUser.getDateofbirth());
        dto.setPostalcode(enrolledUser.getPostalcode());
        dto.setAddress(enrolledUser.getAddress());
        dto.setCity(enrolledUser.getCity());
        dto.setMunicipality(enrolledUser.getMunicipality());
        dto.setTelephone(enrolledUser.getTelephone());
        dto.setMobile(enrolledUser.getMobile());

        Integer id = enrolledUser.getImageUrl().getId();
        ImageUrl img = service.findById(id).get();
        img.setEnrolledUserList(null);
        dto.setImageUrl(img);

        return dto;
    }

    public List<EnrolledUserDto> entityToDto(List<EnrolledUser> enrolledUser) {

        return enrolledUser.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public EnrolledUser dtoToEntity(EnrolledUserDto dto) {
        ModelMapper mapper = new ModelMapper();
        EnrolledUser map = mapper.map(dto, EnrolledUser.class);
        return map;
    }

    public List<EnrolledUser> dtoToEntity(List<EnrolledUserDto> dto) {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
