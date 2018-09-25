package com.sihan.model;
import lombok.Data;
@Data
public class User
{
    private int id;
    private String name;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
    private String usename;
    private String password;

    @Override
    public String toString()
    {
        return ("id"+id+","+
                "age"+age+","+
                "sex"+sex+","+
                "permission"+permission+","+
                "isDelete"+isDelete+","+
                "usename"+usename+","+
                "password"+password+"}");
    }
}
