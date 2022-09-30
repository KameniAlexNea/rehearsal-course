package coen352;

import coen352.lelement.LLDictionary;
import coen352.lelement.LList;

public class WarehouseInventory {

    LList<String> inventoryID;
    LLDictionary<String, String> name;
    LLDictionary<String, String> description;
    LLDictionary<String, Float> unitPrice;
    LLDictionary<String, Integer> quantityInStock;
    LLDictionary<String, Float> inventoryValue;
    LLDictionary<String, Integer> reOrderLevel;
    LLDictionary<String, Integer> reOrderTimeinDay;
    LLDictionary<String, Integer> quantityInReorder;
    LLDictionary<String, String> discontinued;

    public WarehouseInventory() {
        inventoryID = new LList<String>();
        name = new LLDictionary<String, String>(100);
        description = new LLDictionary<String, String>(100);
        unitPrice = new LLDictionary<String, Float>(100);
        quantityInStock = new LLDictionary<String, Integer>(100);
        inventoryValue = new LLDictionary<String, Float>(100);
        reOrderLevel = new LLDictionary<String, Integer>(100);
        reOrderTimeinDay = new LLDictionary<String, Integer>(100);
        quantityInReorder = new LLDictionary<String, Integer>(100);
        discontinued = new LLDictionary<String, String>(100);

    }

    public void insertRecord(String inventoryID, String name, String description, Float unitPrice, Integer quantityInStock, Float inventoryValue, Integer reOrderLevel, Integer reOrderTimeinDay, Integer quantityInReorder, String discontinued) {
        this.inventoryID.insert(inventoryID);
        this.name.insert(inventoryID, name);
        this.description.insert(inventoryID, description);
        this.unitPrice.insert(inventoryID, unitPrice);
        this.quantityInStock.insert(inventoryID, quantityInStock);
        this.inventoryValue.insert(inventoryID, inventoryValue);
        this.reOrderLevel.insert(inventoryID, reOrderLevel);
        this.reOrderTimeinDay.insert(inventoryID, reOrderTimeinDay);
        this.quantityInReorder.insert(inventoryID, quantityInReorder);
        this.discontinued.insert(inventoryID, discontinued);
    }

    public void deleteRecord(String inventoryID) {
        if (this.FindRecord(inventoryID)) {
            this.inventoryID.remove();
            this.name.remove(inventoryID);
            this.description.remove(inventoryID);
            this.unitPrice.remove(inventoryID);
            this.quantityInStock.remove(inventoryID);
            this.inventoryValue.remove(inventoryID);
            this.reOrderLevel.remove(inventoryID);
            this.reOrderTimeinDay.remove(inventoryID);
            this.quantityInReorder.remove(inventoryID);
            this.discontinued.remove(inventoryID);
        } else {
            System.out.println("There is nothing to be removed");
            System.out.println("=======================================================");
        }

    }

    public void clearRecord() {
        this.inventoryID.clear();
        this.name.clear();
        this.description.clear();
        this.unitPrice.clear();
        this.quantityInStock.clear();
        this.inventoryValue.clear();
        this.reOrderLevel.clear();
        this.reOrderTimeinDay.clear();
        this.quantityInReorder.clear();
        this.discontinued.clear();
    }

    public boolean FindRecord(String inventoryID) {
        this.inventoryID.moveToStart();
        boolean recordFound = false;
        for (int i = 0; i < this.inventoryID.length(); i++) {
            if (inventoryID == this.inventoryID.getValue()) {
                recordFound = true;
                System.out.println("Inventory ID \t Name \t Description \t Unit Price \t Quantity in Stock \t Inventory Value \t Reorder Level  \t Reorder Time in Days \t Quantity in Reorder  \t Discontinued?");
                System.out.print(inventoryID);
                System.out.print(" \t \t" + this.name.find(inventoryID));
                System.out.print(" \t " + this.description.find(inventoryID));
                System.out.print(" \t  $" + this.unitPrice.find(inventoryID));
                System.out.print(" \t \t " + this.quantityInStock.find(inventoryID));
                System.out.print(" \t \t $" + this.inventoryValue.find(inventoryID));
                System.out.print(" \t \t " + this.reOrderLevel.find(inventoryID));
                System.out.print(" \t \t \t \t" + this.reOrderTimeinDay.find(inventoryID));
                System.out.print(" \t \t \t" + this.quantityInReorder.find(inventoryID));
                System.out.println(" \t \t \t " + this.discontinued.find(inventoryID));
                System.out.println("=======================================================");
                return true;
            }
            this.inventoryID.next();
        }
        System.out.println("no record found");
        System.out.println("=======================================================");
        return false;
    }

    public int numberOfInventories() {
        System.out.println("number of inventories: " + this.inventoryID.length());
        System.out.println("=======================================================");
        return this.inventoryID.length();
    }

    public float allInventoryValue() {
        float sum = 0;
        this.inventoryID.moveToStart();
        for (int i = 0; i < this.inventoryID.length(); i++) {
            sum = sum + this.inventoryValue.find(inventoryID.getValue());
            this.inventoryID.next();
        }
        System.out.println("total value of all inventories: " + sum);
        System.out.println("=======================================================");
        return sum;
    }

    public void display() {
        System.out.println("Inventory ID \t Name \t Description \t Unit Price \t Quantity in Stock \t Inventory Value \t Reorder Level  \t Reorder Time in Days \t Quantity in Reorder  \t Discontinued?");
        this.inventoryID.moveToStart();
        for (int i = 0; i < this.inventoryID.length(); i++) {
            System.out.print(this.inventoryID.getValue());
            System.out.print(" \t \t" + this.name.find(inventoryID.getValue()));
            System.out.print(" \t " + this.description.find(inventoryID.getValue()));
            System.out.print(" \t  $" + this.unitPrice.find(inventoryID.getValue()));
            System.out.print(" \t \t " + this.quantityInStock.find(inventoryID.getValue()));
            System.out.print(" \t \t $" + this.inventoryValue.find(inventoryID.getValue()));
            System.out.print(" \t \t " + this.reOrderLevel.find(inventoryID.getValue()));
            System.out.print(" \t \t \t \t" + this.reOrderTimeinDay.find(inventoryID.getValue()));
            System.out.print(" \t \t \t" + this.quantityInReorder.find(inventoryID.getValue()));
            System.out.println(" \t \t \t " + this.discontinued.find(inventoryID.getValue()));
            this.inventoryID.next();
        }
        System.out.println("=======================================================");
    }
}
