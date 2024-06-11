package dev.wolffcode.spring_boot_demo.common;

import dev.wolffcode.spring_boot_demo.dto.User;
import dev.wolffcode.spring_boot_demo.persistance.entity.UserEntity;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface Mapper {
  Mapper mapper = Mappers.getMapper(Mapper.class);

  @Mapping(target = "firstName", expression = "java(user.firstName())")
  @Mapping(target = "lastName", expression = "java(user.lastName())")
  @Mapping(target = "email", expression = "java(user.email())")
  @Mapping(target = "birthday", expression = "java(user.birthday())")
  @Mapping(target = "gender", expression = "java(user.gender())")
  UserEntity mapUserToUserEntity(User user);

  User mapUserEntityToUser(UserEntity userEntity);
}
