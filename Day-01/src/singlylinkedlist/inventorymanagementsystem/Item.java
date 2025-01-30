package singlylinkedlist.inventorymanagementsystem;

class Item {
    String itemName;
    String itemID;
    int quantity;
    double price;
    Item next;

    Item(String itemName, String itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
