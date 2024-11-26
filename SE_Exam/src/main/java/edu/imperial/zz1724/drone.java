package edu.imperial.zz1724;

public class Drone {
    private String name;
    private int freq;
    private int id;
    public Drone(String name,int freq,int id){
        this.name = name;
        this.freq = freq; // !! remember to add MHz when display
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getfreq(){
        return freq;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String display_name_and_freq(){
        return "Drone name: "+name+" "+"Drone frequency: "+ freq;
    }

}
