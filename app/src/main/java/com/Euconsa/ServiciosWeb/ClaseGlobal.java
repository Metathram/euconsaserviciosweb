package com.Euconsa.ServiciosWeb;

import android.app.Application;

/**
 * Created by 8656 on 06/04/2017.
 */

public class ClaseGlobal extends Application{
    private String name;
    private String email;


    public String getName() {

        return name;
    }

    public void setName(String aName) {

        name = aName;

    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String aEmail) {

        email = aEmail;
    }
}
