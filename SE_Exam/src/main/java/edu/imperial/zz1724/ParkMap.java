package edu.imperial.zz1724;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import com.google.gson.Gson;


public class ParkMap {
    private List<Lion> Lion_list;
    private List<Keeper> Keeper_list;
    private List<Drone> Drone_list;
    // park dim 600*600

    public static void displayMap(List Lion_list,List Keeper_list,List Drone_list)throws Exception {
        JFrame frame = new JFrame("Park Map");
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());
        // add lion keeper and drone to screen

        for (int i = 0; i < Lion_list.size(); i++) {
            Lion lion = (Lion) Lion_list.get(i);
            Keeper keeper = (Keeper) Keeper_list.get(i);
            Drone drone = (Drone) Drone_list.get(i);
            int lion_id = lion.getId();
            int keeper_id = keeper.getId();
            int drone_id = drone.getId();
            Point lion_coords = LocationSystem.getCoords(lion_id);
            Point keeper_coords = LocationSystem.getCoords(keeper_id);
            Point drone_coords = LocationSystem.getCoords(drone_id);
            // red circle of radius 3 for lions,name+ age
            // blue circle, radius2 for keeper, name+phone
            // black square edge 3 for drones, name  freq
            // use point as center draw oval
            // update map every second
            while (lion_coords != null) {
                try{
                Thread.sleep(1000);
                    lion_coords = LocationSystem.getCoords(lion_id);
                    keeper_coords = LocationSystem.getCoords(keeper_id);
                    drone_coords = LocationSystem.getCoords(drone_id);
                int lion_x = (int) lion_coords.getX();
                int lion_y = (int) lion_coords.getY();
                int keeper_x = (int) keeper_coords.getX();
                int keeper_y = (int) keeper_coords.getY();
                int drone_x = (int) drone_coords.getX();
                int drone_y = (int) drone_coords.getY();
// calculate distance
                    if(lion_x - keeper_x < 60 || lion_y - keeper_y < 60 || keeper_x - lion_x < 60 || keeper_y - lion_y < 60){
                        AlertSystem.alertADrone(drone.getfreq());
                        AlertSystem.alertAKeeper(String.valueOf(keeper.getNumber()));
                    }
                frame.add(new JComponent() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(Color.RED);
                        g.drawString(lion.display_name_and_age(), lion_x - 5, lion_y - 5);
                        g.drawOval(lion_x, lion_y, 60, 60);
                        g.setColor(Color.BLUE);
                        g.drawOval(keeper_x, keeper_y, 40, 40);
                        g.drawString(keeper.display_name_and_number(), keeper_x - 5, keeper_y - 5);
                        g.setColor(Color.BLACK);
                        g.drawRect(drone_x, drone_y, 30, 30);
                        g.drawString(drone.display_name_and_freq(), drone_x - 5, drone_y - 5);
                    }
                });
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }catch (Exception ignored){}
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Keeper keeper1 = new Keeper("Geoff",4392,80);
        Lion lion1 = new Lion("Simba",7,30);
        Drone drone1 = new Drone("Monitor1",128,124);
        displayMap(List.of(lion1),List.of(keeper1),List.of(drone1));
    }
    }