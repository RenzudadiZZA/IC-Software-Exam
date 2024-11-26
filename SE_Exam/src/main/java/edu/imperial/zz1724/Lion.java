package edu.imperial.zz1724;

import javax.xml.namespace.QName;
import java.util.ArrayList;

public class Lion {
    private String name;
    private int age;
    private int id;
    public Lion(String name,int age,int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String display_name_and_age(){
        return "Lion name: "+ name+" "+"Age: "+age;
    }



}
