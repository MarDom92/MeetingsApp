package pl.mardom92.MeetingsApp.model.mapper;

import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.builder.builder.UserBuilder;
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

        UserBuilder userBuilder = new UserBuilder();

        if (Objects.nonNull(userDto.getEmail())) {
            userBuilder.withEmail(userDto.getEmail());
        }

        if (Objects.nonNull(userDto.getUsername())) {
            userBuilder.withUsername(userDto.getUsername());
        }

        if (Objects.nonNull(userDto.getFirstname())) {
            userBuilder.withFirstname(userDto.getFirstname());
        }

        if (Objects.nonNull(userDto.getLastname())) {
            userBuilder.withLastname(userDto.getLastname());
        }

        if (Objects.nonNull(userDto.getUserRole())) {
            userBuilder.withUserRole(userDto.getUserRole());
        }

        return userBuilder.build();
    }

    public UserDto fromEntityToDto(UserEntity user) {

        if (user == null) {
            return null;
        }

        UserDtoBuilder userDtoBuilder = new UserDtoBuilder();

        if (Objects.nonNull(user.getEmail())) {
            userDtoBuilder.withEmail(user.getEmail());
        }

        if (Objects.nonNull(user.getUsername())) {
            userDtoBuilder.withUsername(user.getUsername());
        }

        if (Objects.nonNull(user.getFirstname())) {
            userDtoBuilder.withFirstname(user.getFirstname());
        }

        if (Objects.nonNull(user.getLastname())) {
            userDtoBuilder.withLastname(user.getLastname());
        }

        if (Objects.nonNull(user.getUserRole())) {
            userDtoBuilder.withUserRole(user.getUserRole());
        }

        return userDtoBuilder.build();
    }
}
