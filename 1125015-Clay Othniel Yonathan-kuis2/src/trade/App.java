package trade;

import trade.controller.TradeController;
import trade.view.TradeView;

public class App {
    public static void main(String[] args) {
        TradeView view = new TradeView();
        TradeController controller = new TradeController(view);
        
        controller.start();
    }
}