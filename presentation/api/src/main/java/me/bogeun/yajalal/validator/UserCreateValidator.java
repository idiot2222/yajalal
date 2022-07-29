package me.bogeun.yajalal.validator;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.port.outgoing.UserPersistencePort;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Component
public class UserCreateValidator implements Validator {

    private final UserPersistencePort userPersistencePort;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == UserCreateDto.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateDto createDto = (UserCreateDto) target;

        duplicatedUsername(createDto.getUsername(), errors);
        duplicatedEmail(createDto.getEmail(), errors);
    }

    private void duplicatedEmail(String email, Errors errors) {
        if (userPersistencePort.hasDuplicateEmail(email)) {
            errors.rejectValue("email", "duplicate email.");
        }
    }

    private void duplicatedUsername(String username, Errors errors) {
        if(userPersistencePort.hasDuplicateUsername(username)) {
            errors.rejectValue("username", "duplicate username.");
        }
    }
}
