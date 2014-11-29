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
import java.util.*;

public class RestaurantSystem implements ManagementInterface{
 
    private Scanner choice = new Scanner(System.in);
    
    public RestaurantSystem(){
        System.out.println("Welcome to use Restaurant System to manage your Restaurant!");
        System.out.println("===========================================================\n");
        int ch = getChoice();
        switchManagement(ch);
    }
    
    @Override
    public void switchManagement(int a){
        
        switch (a){
            case 1:{
                new ItemManagement();
                break;
            }
            case 2:{
                new ItemManagement();
                break;
            }
            case 3:{
                new ItemManagement();
                break;
            }
            case 4:{
                new ItemManagement();
                break;
            }
            case 5:{
                new ItemManagement();
                break;
            }
            case 6:{
                System.exit(0);
                break;
            }
            default:{
                new RestaurantSystem();
                break;
            }
                
        }
    }
    
    @Override
    public int getChoice(){
        int ch = 0;
        System.out.println("Please press the following number to choose the service:");
        System.out.println("1: Items Management");
        System.out.println("2: Labors Management");
        System.out.println("3: Orders Management");
        System.out.println("4: Bill Management");
        System.out.println("5: Reporting");
        System.out.println("6: Exit");
        
        do{
            ch = choice.nextInt();
        }while(!checkValidChoice(ch));
        return ch;
    }
    
    @Override
    public boolean checkValidChoice(int c){
        return c > 0 && c <7;
    }
}
