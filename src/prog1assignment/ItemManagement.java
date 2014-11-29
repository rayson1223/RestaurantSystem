/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author rayson
 */
public class ItemManagement implements ManagementInterface{
    
    private Scanner choice = new Scanner(System.in);
    private Scanner scanItem = new Scanner(System.in);
    
    public ItemManagement(){
        System.out.println("Welcome to use Restaurant System to manage your Restaurant!");
        System.out.println("===========================================================\n");
        int ch = getChoice();
        switchManagement(ch);
    }

    @Override
    public int getChoice() {
        int ch = 0;
        System.out.println("Select the services:");
        System.out.println("1: Show All Items");
        System.out.println("2: Add Items");
        System.out.println("3: Modify Items");
        System.out.println("4: Delete Items");
        System.out.println("5: Back");
        System.out.println("6: Exit");

        do{
            ch = choice.nextInt();
        }while(!checkValidChoice(ch));
        return ch;
    }

    @Override
    public boolean checkValidChoice(int i) {
        return i > 0 && i <6;
    }

    @Override
    public void switchManagement(int i) {
        switch (i){
            case 1:{
                showAllItem();
                break;
            }
            case 2:{
                addItem();
                break;
            }
            case 3:{
                modifyItem();
                break;
            }
            case 4:{
                deleteItem();
                break;
            }
            case 5:{
                new RestaurantSystem();
                break;
            }
            case 6:{
                System.exit(0);
                break;
            }
            default:{
                new ItemManagement();
                break;
            }
                
        }
    }
    
    private void showAllItem(){
        try{
            Scanner in = new Scanner(new File("items.txt"));
            if (in.hasNextLine()){
                while(in.hasNextLine()){
                    System.out.println(in.nextLine());//display all content in text file

                }
            }
            else{
                System.out.println("Currently no items in the list");
            }
            in.close();
	}catch(Exception e){
            System.out.println(e);
	}
	new ItemManagement();
    }
    
    private void addItem(){
        FileWriter fw = null;
        PrintWriter wr = null;
        try{
            fw = new FileWriter("items.txt", true);
            wr = new PrintWriter(fw);
            Item temp = getItem();
            Scanner in = new Scanner(new File("items.txt"));
            int count = 0;
            while(in.hasNextLine()){
                in.nextLine();
                count++;
            }
            temp.setID(count+1);
            wr.print(temp.toString());
            wr.close();
            fw.close();
            System.out.println("Successfully Added a new item!\n");
        }
        catch(Exception e){
            System.out.println(e);
        }
        new ItemManagement();
    }
    
    private Item getItem(){
        
        System.out.println("Please insert your items as the format of: ");
        System.out.println("(name) (cost) (price)");
        System.out.println("============================================");
        String item = "";
        do{
            item = scanItem.nextLine();
        }while(!checkValidItem(item));
        Item temp = new Item(item);
        return temp;
    }
    
    private boolean checkValidItem(String i){
        try{
            String[] temp = i.split(" ");
            Double.parseDouble(temp[1]);
            Double.parseDouble(temp[2]);
        }
        catch(Exception e){
            System.out.println("String Format Invalid");
            return false;
        }
        return true;
    }
    
    private void modifyItem(){
        System.out.println("Please insert the ID of the item that you wish to modify");
        int id = choice.nextInt();
        try{
            Scanner in = new Scanner(new File("items.txt"));
            if (in.hasNextLine()){
                String temp = "";
                boolean found = false;
                while(in.hasNextLine()){
                    temp = in.nextLine();
                    String[] s = temp.split(" ");
                    if(Integer.parseInt(s[0]) == id){
                        found = true;
                        break;
                    }
                }
                if(found){
                    System.out.println("Please insert your items as the format of: ");
                    System.out.println("(name) (cost) (price)");
                    System.out.println("============================================");
                    String item = "";
                    do{
                        item = scanItem.nextLine();
                    }while(!checkValidItem(item));
                    updateItem(id, item);
                }
                else{
                    System.out.println("No such items in the list!\nPlease try again!");
                }
            }
            else{
                System.out.println("Currently no items in the list");
            }
            in.close();
	}catch(Exception e){
            System.out.println(e);
	}
	new ItemManagement();
    }
    
    private void updateItem(int id, String it){
        FileWriter fw = null;
        PrintWriter wr = null;
        try{
            Scanner in = new Scanner(new File("items.txt"));
            fw = new FileWriter("items.txt", true);
            wr = new PrintWriter(fw);
            if (in.hasNextLine()){
                String temp = "";
                while(in.hasNextLine()){
                    temp = in.nextLine();
                    String[] s = temp.split(" ");
                    if(Integer.parseInt(s[0]) == id){
                        Item nw = new Item(it);
                        nw.setID(id);
                        System.out.print(nw.toString());
                        wr.print(nw.toString());
                    }else{
                        wr.print(temp);
                    } 

                }
            }
            else{
                System.out.println("Currently no items in the list");
            }
            in.close();
	}catch(Exception e){
            System.out.println(e);
	}
	new ItemManagement();
    }
    
    private void deleteItem(){
    
    }
}
