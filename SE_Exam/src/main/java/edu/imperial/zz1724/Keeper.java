package edu.imperial.zz1724;

public class Keeper {
    private String name;
    private int number;
    private int id;
    public Keeper(String name,int number,int id){
        this.name = name;
        this.number = number;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String display_name_and_number(){
        return "Keeper name: "+ name+" "+"Phone number: "+number;
    }

}
