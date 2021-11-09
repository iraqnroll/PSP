package psp.laboratorinis.lab13.service;

import psp.laboratorinis.lab13.validators.EmailValidator;
import psp.laboratorinis.lab13.validators.PasswordChecker;
import psp.laboratorinis.lab13.validators.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psp.laboratorinis.lab13.helpers.ErrorCode;
import psp.laboratorinis.lab13.helpers.Result;
import psp.laboratorinis.lab13.model.User;
import psp.laboratorinis.lab13.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> findAll(){
        return (List<User>) repository.findAll();
    }

    public Optional<User> findById(UUID id){
        return repository.findById(id);
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public Result save(User user){
        EmailValidator emailValidator = new EmailValidator();
        PasswordChecker passChecker = new PasswordChecker();
        passChecker.needsUppercase();
        passChecker.minLength(7);
        PhoneValidator phoneValidator = new PhoneValidator();
        List<ErrorCode> errors = new ArrayList<ErrorCode>();

        if(!emailValidator.validate(user.geteMail())){
            errors.add(ErrorCode.EMAIL_INVALID);
        }

        if(!passChecker.validate(user.getPassword())){
            errors.add(ErrorCode.PASSWORD_INVALID);
        }

        if(!phoneValidator.validate(user.getPhone())){
            errors.add(ErrorCode.PHONE_INVALID);
        }

        if(errors.isEmpty())
        {
            if(user.getId() == null)
            {
                user.setId(UUID.randomUUID());
            }

            repository.save(user);
            Result result = new Result(errors);
            result.setNewUser(user);

            return result;
        }
        else{
            Result result = new Result(errors);
            return result;
        }
    }
}
