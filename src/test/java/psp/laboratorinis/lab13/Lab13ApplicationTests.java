package psp.laboratorinis.lab13;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import psp.laboratorinis.lab13.controller.UserController;
import psp.laboratorinis.lab13.helpers.ErrorCode;
import psp.laboratorinis.lab13.helpers.Result;
import psp.laboratorinis.lab13.model.User;
import psp.laboratorinis.lab13.repository.UserRepository;
import psp.laboratorinis.lab13.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
class Lab13ApplicationTests {
    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenUserFormIsValid_ReturnResponseWithUID(){
        User testUser = new User("Vardas","Pavarde","test@gmail.com","Vilnius","Password123", "+37065650277");
        Mockito.when(repository.save(testUser)).thenReturn(testUser);
        Result result = service.save(testUser);
        assertTrue(result.getNewUser().getId() != null);
    }

    @Test
    public void whenUserFormPasswordHasNoUppercase_ReturnResponseWithPasswordError(){
        User testUser = new User("Vardas","Pavarde","test@gmail.com","Vilnius","password123", "+37065650277");
        Mockito.when(repository.save(testUser)).thenReturn(testUser);
        Result result = service.save(testUser);
        assertTrue(result.getError().contains(ErrorCode.PASSWORD_INVALID));
    }

    @Test
    public void whenUserFormPhoneAndEmailInvalid_ReturnResponseWithEmailAndPasswordError(){
        User testUser = new User("Vardas","Pavarde","test@gmail.com","Vilnius","password123", "+3706565027723213123");
        Mockito.when(repository.save(testUser)).thenReturn(testUser);
        Result result = service.save(testUser);
        assertTrue(result.getError().contains(ErrorCode.PASSWORD_INVALID) && result.getError().contains(ErrorCode.PHONE_INVALID));
    }

    @Test
    public void whenUserFormEmailInvalid_ReturnResponseWithEmailError(){
        User testUser = new User("Vardas","Pavarde","testgmail.com","Vilnius","password123", "+3706565027723213123");
        Mockito.when(repository.save(testUser)).thenReturn(testUser);
        Result result = service.save(testUser);
        assertTrue(result.getError().contains(ErrorCode.EMAIL_INVALID));
    }
}
