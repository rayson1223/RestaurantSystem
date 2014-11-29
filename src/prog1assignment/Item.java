/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1assignment;

/**
 *
 * @author rayson
 */
public class Item {
    private String name;
    private int ID;
    private double cost;
    private double price;

    public Item(){
        this.name = "";
        this.ID = -1;
        this.cost = 0.0;
        this.price = 0.0;
    }
    
    public Item(String i){
        String[] temp = i.split(" ");
        this.name = temp[0];
        this.cost = Double.parseDouble(temp[1]);
        this.price = Double.parseDouble(temp[2]);
    } 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return this.ID + " " + this.name + " " + this.cost + " " + this.price +  "\n";
    }
    
}
