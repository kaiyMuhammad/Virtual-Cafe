//Intro to Java final project: Virtual cafe
//Aiyanah "Kaiy" Muhammad 
//May 12 2019

package csit210;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.concurrent.TimeUnit;

class Item {
    String itemName = "blank";
    int itemPrice = 0;

    Item(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
}

public class final_project {
    public static void main(String[] args) {
        //variables
        int moveOn;
        int amount;
        int total = 0;
        int tip = 0;
        String hi = "Hey there! Welcome to the JavaBean Cafe";
        String menu = "Today's menu options are a cookie ($1), coffee ($2), and/or latte ($3)";
        String letMeKnow = "Just let me know when you're ready";
        String userInput = "";
        String huh = "Say that again please?";
        String gotIt = "Got it. Next...?";
        String call = "We'll call your name when your order is done";
        String name;
        String bye = "Thank you and have a nice day!";
        double totalAndTip = 0.00;
        Item cookie = new Item("cookie", 1);
        Item coffee = new Item("coffee", 2);
        Item latte = new Item("latte", 3);
        //main
        JOptionPane.showMessageDialog(null, hi);
        JOptionPane.showMessageDialog(null, menu);

        do {
            JOptionPane.showMessageDialog(null, letMeKnow);
            moveOn = JOptionPane.showConfirmDialog(null, "Are you ready to order?");
        }
        while (moveOn == JOptionPane.NO_OPTION);
        //ordering
        userInput = JOptionPane.showInputDialog("How many items would you like?");
        amount = Integer.parseInt(userInput);
        //creates an array with 'amount' number of elements
        String[] order = new String[amount];

        //loops to assign array element to each order item
        for (int i = 1; i <= amount; i++) {
            int current = i - 1;
            userInput = JOptionPane.showInputDialog("For item " + i + ", what would you like?");
            if (userInput.equals(cookie.itemName)) {
                total = total + cookie.itemPrice;
                order[current] = cookie.itemName;
                JOptionPane.showMessageDialog(null, gotIt);
            } else if (userInput.equals(coffee.itemName)) {
                total = total + coffee.itemPrice;
                order[current] = coffee.itemName;
                JOptionPane.showMessageDialog(null, gotIt);
            } else if (userInput.equals(latte.itemName)) {
                total = total + latte.itemPrice;
                order[current] = latte.itemName;
                JOptionPane.showMessageDialog(null, gotIt);
            } else {
                JOptionPane.showMessageDialog(null, huh);
                i--;
            }
        }

        //paying
        userInput = JOptionPane.showInputDialog("That comes up to $" + total + ". What percentage would you like to give as a tip?");
        tip = Integer.parseInt(userInput);
        totalAndTip = (double) total + (double) total * (double) tip * 0.01;

        JOptionPane.showMessageDialog(null, "Okay, so now you're at $" + totalAndTip);
        //asking for a name
        name = JOptionPane.showInputDialog("What's your name?");
        JOptionPane.showMessageDialog(null, call);

        //waiting for the order to be made
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        JOptionPane.showMessageDialog(null, "Here you go, " + name);
        //repeating entire order
        JOptionPane.showMessageDialog(null, Arrays.toString(order));
        JOptionPane.showMessageDialog(null, bye);


    }
}
