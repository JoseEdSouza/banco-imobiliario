package app;



import app.config.DataPath;
import app.model.HouseFactory;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        HouseFactory n = new HouseFactory();
        n.createHouse();
        n.listHouses();
    }

}
