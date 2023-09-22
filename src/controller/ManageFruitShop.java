/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import model.Fruit;

/**
 *
 * @author mactu
 */
public class ManageFruitShop {
    private List<Fruit> listFruit;
    
    Hashtable <String,List<Fruit>> hashTable; 
    Validation vl = new Validation();
    
    public ManageFruitShop() {
        listFruit = new ArrayList();
        hashTable = new Hashtable<>();
    }
    
    public void createProduct(){
        
    while(true){
        String nameFruit = vl.inputString("Enter fruit name: ");
        String idFruit = vl.inputString("Enter fruit id: ");
        double price = vl.inputDouble("Enter price: ", 0, 1000);
        int quantity = vl.inputInt("Enter quantity: ",0,100);
        String origin = vl.inputString("Enter origin: ");
        
        // ctrl + space 
        Fruit f = new Fruit(idFruit,nameFruit,price,quantity,origin);
        listFruit.add(f);
        
        String option = vl.inputString("Do you want create another fruit (Y|N)");
        if(option.equalsIgnoreCase("Y")){
            continue;
        }else{
            break;
        }
     
    }
        
    }
    
    public void shopping() {
    List<Fruit> listItemBought = new ArrayList<>();
    while (true) {
        System.out.println("List of Fruit:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (Fruit f : listFruit) {
            System.out.printf("       %-13s%-18s%-15s%-10s%n", f.getIdFruit(), f.getNameFruit(), f.getOrigin(), f.getPrice());
        }
        int selected = vl.inputInt("Enter item you want to order", 1, listFruit.size());
        Fruit selecFruit = listFruit.get(selected - 1);
        System.out.println("You selected: " + selecFruit.getNameFruit());
        int quantity = vl.inputInt("Please input quantity: ", 0, 100);
        selecFruit.setQuantity(quantity);
        listItemBought.add(selecFruit);
        String option = vl.inputString("Do you want to order now (Y|N)");
        if (option.equalsIgnoreCase("N")) {
            continue;
        } else {
            System.out.println("Product | Quantity | Price | Amount ");
            double total = 0;
            for (Fruit f : listItemBought) {
                System.out.printf("%-18s%-10s%-10s%-10s%n", f.getNameFruit(), quantity, f.getPrice(), (quantity * f.getPrice()));
                total += quantity * f.getPrice();
            }
            System.out.println("Total: " + total);
            String nameCustomer = vl.inputString("Input your name");
            hashTable.put(nameCustomer, listItemBought);
            break;
        }
    }
}

    public void viewOrders(){
        Enumeration<String> nameCustomerList = hashTable.keys();
        while(nameCustomerList.hasMoreElements()){
            String nameCustomer = nameCustomerList.nextElement();
            System.out.println("Customer: "+ nameCustomer);
            System.out.println("Product | Quantity | Price | Amount ");
            double total = 0;
            for(Fruit f : hashTable.get(nameCustomer)){
           System.out.println(f.getNameFruit()+"  "+f.getQuantity()+"    "+f.getPrice()+"     "+(f.getQuantity()*f.getPrice()));
           total +=f.getQuantity()*f.getPrice();
        }
            System.out.println("Total: "+ total);
        }
    }
    
}
