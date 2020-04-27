package se.kth.iv1350.sem3pos.view;

import se.kth.iv1350.sem3pos.controller.Controller;

/**
 * A view class capable of performing hardcoded calls to the controller,
 *              simulating a sale process and printing the results out to the console.
 */
public class View {
    private Controller controller;

    /**
     * Creates a new instance of the {@link View}.
     * @param cont An initialized instance of the {@link Controller}.
     */
    public View(Controller cont) {
        this.controller = cont;
    }

    /**
     * Simulates a sale process and prints out the results to the console.
     */
    public void simulateSaleProcess() {
        this.controller.startSale();

        System.out.println();

        String regInfo = this.controller.registerItem("item1", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item4", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item1", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item1", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item1", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item4", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item2", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item2", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item3", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item4", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item1", 1);
        System.out.println(regInfo);

        regInfo = this.controller.registerItem("item4", 1);
        System.out.println(regInfo);
        System.out.println();

        String totalPrice = this.controller.endSale();
        System.out.println(totalPrice);

        System.out.println();

        String changeAmount = this.controller.makePayment(1000.0d);
        System.out.println();

        System.out.println(changeAmount);
    }
}
