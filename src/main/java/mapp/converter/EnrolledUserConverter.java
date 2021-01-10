/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.converter;

import mapp.entity.EnrolledUser;
import mapp.dto.EnrolledUserDto;
import java.util.List;
import java.util.stream.Collectors;
import mapp.entity.ImageUrl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Hello Java !
 */
@Component
public class EnrolledUserConverter {

    public EnrolledUserDto entityToDto(EnrolledUser enrolledUser) {

        EnrolledUserDto dto = new EnrolledUserDto();
        dto.setId(enrolledUser.getId());
        dto.setUsername(enrolledUser.getUsername());

//        enrolledUser.getImageUrl().setCategoryList(null);
//        enrolledUser.getImageUrl().setCompanyList(null);
//        enrolledUser.getImageUrl().setCompanyList1(null);
//        enrolledUser.getImageUrl().setEnrolledUserList(null);
//        enrolledUser.getImageUrl().setProductList(null);
//        enrolledUser.getImageUrl().setSubcategoryList(null);

        dto.setFname(enrolledUser.getFname());
        dto.setLname(enrolledUser.getLname());
//        dto.setEmail(enrolledUser.getEmail());
//        dto.setDateofbirth(enrolledUser.getDateofbirth());
//        dto.setPostalcode(enrolledUser.getPostalcode());
//        dto.setAddress(enrolledUser.getAddress());
//        dto.setCity(enrolledUser.getCity());
//        dto.setMunicipality(enrolledUser.getMunicipality());
//        dto.setTelephone(enrolledUser.getTelephone());
//        dto.setMobile(enrolledUser.getMobile());
//        dto.setImageUrl(enrolledUser.getImageUrl());

        return dto;

//        PropertyMap<EnrolledUserDto, EnrolledUser> skipModifiedFieldsMap = new PropertyMap<EnrolledUserDto, EnrolledUser>() {
//            @Override
//            protected void configure() {
//                skip(destination.getImageUrl().getCategoryList());
//                skip(destination.getImageUrl().getCompanyList());
//                skip(destination.getImageUrl().getCompanyList1());
//                skip(destination.getImageUrl().getEnrolledUserList());
//                skip(destination.getImageUrl().getProductList());
//                skip(destination.getImageUrl().getSubcategoryList());
//            }
//        };
//        EnrolledUserDto enrolledUserDto = new EnrolledUserDto();
//        ModelMapper mapper = new ModelMapper();
//        
////        EnrolledUserDto map = mapper.map(enrolledUser, EnrolledUserDto.class);
//
//        mapper.addMappings(skipModifiedFieldsMap);
//        mapper.map(EnrolledUserDto.class, enrolledUser);
//        return enrolledUserDto;
//    return map;
    }

    public List<EnrolledUserDto> entityToDto(List<EnrolledUser> enrolledUser) {

        return enrolledUser.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public EnrolledUser dtoToEntity(EnrolledUserDto dto) {
//		EnrolledUser st = new EnrolledUser();
//		st.setId(dto.getId());
//		st.setName(dto.getName());
//		st.setPassword(dto.getPassword());
//		st.setUsername(dto.getUsername());
//		
//		return st;

        ModelMapper mapper = new ModelMapper();
        EnrolledUser map = mapper.map(dto, EnrolledUser.class);
        return map;
    }

    public List<EnrolledUser> dtoToEntity(List<EnrolledUserDto> dto) {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
