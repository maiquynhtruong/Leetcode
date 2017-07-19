public class Solution {
    public enum BillsType {
        ONE, TWO, FIVE, TEN, TWENTY, FIFTY
    }
    public class VendingMachine {
        int shelves, rows, cols, totalSales;
        Product products[][][] = new Product[shelves][rows][cols];
        List<Product> productList = new ArrayList<Product>();
        int currentBalance;
        HashMap<BillsType, Integer> coins = new HashMap<BillsType, Integer>();
        public Product vend(Product product) {
            if (product.quantity <= 0) {
                displayMessage("SOLD OUT. SORRY");
                return null;
            } else {
                displayMessage("INSERT MONEY");
                HashMap<BillsType> bills = getPayment();
                acceptPayment(product, bills);
            }
        }
        public int tellPrice(int shelf, int row, int col) {
            return products[shelf][row][col].price;
        }
        public int acceptPayment(Product product, HashMap<BillsType> billsList) {
            int amountReceived = getTotal(billsList);
            while (product.price > amountReceived) {
                displayMessage("NOT ENOUGH. GIVE ME MORE");
                HashMap<BillsType> bills = getPayment();
                amountReceived += getTotal(bills);
                billsList.addAll(bills);
            }
            if (!canMakeChange(amountReceived - product.price, billsList)) {
                displayMessage("OUT OF CHANGE");
                refund();
            } else {
                int change = amountReceived - product.price;
                returnChange(change);
                updateCurrentBalance(amountReceived, billsMap);
            }
        }
        public void refund() {}
        public void returnChange(int change) {}
        public void requestRestock(Product product) {}
        public boolean checkInventory(Product product) {
            return Inventory.hasItem(product);
        }
        
    }
    public class NotFullPaidException extends Exception {}
    public class SoldOutException extends Exception {}
    public class NotEnoughChangeException extends Exception {}
    public class Product {
        int quantity, dateImported, expirationDate, price;
        String name, seller;
    }
    public class Inventory {
        public static int getQuantity(Product product) {}
        public static void addProduct(Product product, int amount) {}
        public static void deductProduct(Product product) {}
        public static void hasItem(Product product) {}
    }
    public static void main(String args[]) {
        
    }
}
