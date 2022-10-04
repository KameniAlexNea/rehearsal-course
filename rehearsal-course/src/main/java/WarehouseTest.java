import coen352.WarehouseInventory;


public class WarehouseTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WarehouseInventory wareHouse1 = new WarehouseInventory();

        wareHouse1.insertRecord("IN0001", "Item 1", "Desc 1", 51.0f, 25, 1275.0f, 29, 13, 50, "Yes");
        wareHouse1.insertRecord("IN0002", "Item 2", "Desc 2", 93.0f, 132, 12276.0f, 231, 4, 50, "Yes");
        wareHouse1.insertRecord("IN0003", "Item 3", "Desc 3", 93.0f, 132, 12276.0f, 231, 4, 50, "Yes");
        wareHouse1.display();

        wareHouse1.FindRecord("IN0002");
        wareHouse1.FindRecord("IN0005");
        wareHouse1.numberOfInventories();
        wareHouse1.allInventoryValue();

        wareHouse1.deleteRecord("IN0004");
        wareHouse1.clearRecord();
        wareHouse1.display();

    }

}
