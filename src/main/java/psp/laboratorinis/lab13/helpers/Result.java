package psp.laboratorinis.lab13.helpers;

import psp.laboratorinis.lab13.model.User;

import java.util.List;

public class Result {
    private User newUser;
    private List<ErrorCode> error;

    public Result(){

    }

    public Result(List<ErrorCode> error) {
        this.error = error;
    }
    public Result(User user){
        this.newUser = user;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public List<ErrorCode> getError() {
        return error;
    }

    public void setError(List<ErrorCode> error) {
        this.error = error;
    }
}
