package trade;

import trade.controller.DeviceController;
import trade.view.TradeView;

public class App {
    public static void main(String[] args) {
        TradeView view = new TradeView();
        DeviceController controller = new DeviceController(view);
        
        controller.start();
    }
}