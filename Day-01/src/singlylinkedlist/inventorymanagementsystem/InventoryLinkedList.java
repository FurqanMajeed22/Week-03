package singlylinkedlist.inventorymanagementsystem;

class InventoryLinkedList {
    Item head;

    void addAtBeginning(String itemName, String itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    void addAtEnd(String itemName, String itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    void addAtPosition(String itemName, String itemID, int quantity, double price, int position) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (position == 1) {
            addAtBeginning(itemName, itemID, quantity, price);
            return;
        }
        Item temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    void removeByItemID(String itemID) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemID.equals(itemID)) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && !temp.next.itemID.equals(itemID)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("not found.");
        } else {
            temp.next = temp.next.next;
        }
    }

    void updateQuantity(String itemID, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID.equals(itemID)) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemID + " not found.");
    }

    void searchByItemID(String itemID) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID.equals(itemID)) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemID + " not found.");
    }

    void searchByItemName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equals(itemName)) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with name " + itemName + " not found.");
    }

    void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    void sortByName() {
        head = mergeSort(head, true);
    }

    void sortByPrice() {
        head = mergeSort(head, false);
    }

    private Item mergeSort(Item head, boolean byName) {
        if (head == null || head.next == null) {
            return head;
        }

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, byName);
        Item right = mergeSort(nextOfMiddle, byName);

        return SortedMerge(left, right, byName);
    }

    private Item SortedMerge(Item a, Item b, boolean byName) {
        Item dummy = new Item("", "", 0, 0);
        Item current = dummy;

        while (a != null && b != null) {
            if ((byName && a.itemName.compareTo(b.itemName) <= 0) || (!byName && a.price <= b.price)) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        if (a != null) {
            current.next = a;
        } else {
            current.next = b;
        }

        return dummy.next;
    }

    private Item getMiddle(Item head) {
        Item slow = head;
        Item fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }
        return slow;
    }

    void displayInventory() {
        Item temp = head;
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(Item item) {
        System.out.println("Item Name: " + item.itemName);
        System.out.println("Item ID: " + item.itemID);
        System.out.println("Quantity: " + item.quantity);
        System.out.println("Price: " + item.price);
        System.out.println();
    }
}
