package pl.mardom92.MeetingsApp.model.mapper;

import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.builder.builder.UserEntityBuilder;
import pl.mardom92.MeetingsApp.model.builder.dtoBuilder.UserDtoBuilder;
import pl.mardom92.MeetingsApp.model.dto.UserDto;
import pl.mardom92.MeetingsApp.model.entity.UserEntity;

import java.util.Objects;

@Component
public class UserMapper {

    public UserEntity fromDtoToEntity(UserDto userDto) {

        if (userDto == null) {
            return null;
        }

        UserEntityBuilder userEntityBuilder = new UserEntityBuilder();

        if (Objects.nonNull(userDto.getEmail())) {
            userEntityBuilder.withEmail(userDto.getEmail());
        }

        if (Objects.nonNull(userDto.getUsername())) {
            userEntityBuilder.withUsername(userDto.getUsername());
        }

        if (Objects.nonNull(userDto.getFirstname())) {
            userEntityBuilder.withFirstname(userDto.getFirstname());
        }

        if (Objects.nonNull(userDto.getLastname())) {
            userEntityBuilder.withLastname(userDto.getLastname());
        }

        if (Objects.nonNull(userDto.getUserRole())) {
            userEntityBuilder.withUserRole(userDto.getUserRole());
        }

        return userEntityBuilder.build();
    }

    public UserDto fromEntityToDto(UserEntity userEntity) {

        if (userEntity == null) {
            return null;
        }

        UserDtoBuilder userDtoBuilder = new UserDtoBuilder();

        if (Objects.nonNull(userEntity.getEmail())) {
            userDtoBuilder.withEmail(userEntity.getEmail());
        }

        if (Objects.nonNull(userEntity.getUsername())) {
            userDtoBuilder.withUsername(userEntity.getUsername());
        }

        if (Objects.nonNull(userEntity.getFirstname())) {
            userDtoBuilder.withFirstname(userEntity.getFirstname());
        }

        if (Objects.nonNull(userEntity.getLastname())) {
            userDtoBuilder.withLastname(userEntity.getLastname());
        }

        if (Objects.nonNull(userEntity.getUserRole())) {
            userDtoBuilder.withUserRole(userEntity.getUserRole());
        }

        return userDtoBuilder.build();
    }
}
