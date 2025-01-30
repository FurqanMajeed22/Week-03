package singlylinkedlist.inventorymanagementsystem;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtBeginning("Laptop", "I1", 5, 800);
        inventory.addAtEnd("Mouse", "I2", 50, 20);
        inventory.addAtPosition("Keyboard", "I3", 30, 50, 2);
        inventory.displayInventory();

        inventory.updateQuantity("I2", 60);
        inventory.searchByItemID("I2");
        inventory.searchByItemName("Keyboard");

        inventory.calculateTotalValue();

        inventory.sortByName();
        System.out.println("Sorted by Name:");
        inventory.displayInventory();

        inventory.sortByPrice();
        System.out.println("Sorted by Price:");
        inventory.displayInventory();

        inventory.removeByItemID("I1");
        inventory.displayInventory();
    }
}