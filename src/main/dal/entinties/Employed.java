package main.dal.entinties;

import javax.validation.constraints.Size;

public class Employed {

    private int id;

    private String name;


    private String login;

    private String passw;

    public Employed(int id, String name, String login, String passw ){
        this.id = id;
        this.name = name;
        this.login = login;
        this.passw = passw;
    }
    public Employed(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
}

