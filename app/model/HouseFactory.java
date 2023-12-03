package app.model;

import app.houses.Property;
import app.houses.Share;
import app.interfaces.IHouse;
import app.utils.Type;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HouseFactory{
    private final File readFile = new File(System.getProperty("user.dir") + "/app/data/property.txt");
    private ArrayList<IHouse> houses = new ArrayList<IHouse>();
    public void createHouse(){
        try{
            Scanner reader = new Scanner(readFile);
            int cont = 0;
            while (reader.hasNextLine()){
                if(cont < 22){
                    houses.add(new Property(reader.nextLine(), 200, 200, 10, Type.BASIC));
                } else {
                    houses.add(new Share(reader.nextLine(), 100, 100));
                }
                cont++;
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void listHouses(){
        for (IHouse e :
                houses) {
            System.out.println(e.getName());
        }
    }

}
