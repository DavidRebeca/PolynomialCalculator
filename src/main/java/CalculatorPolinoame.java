import Controller.CalcController;
import Model.Polinomial;
import View.CalcView;

public class CalculatorPolinoame {
    public static void main(String[] args) {
        Polinomial modelCalculator = new Polinomial();
        CalcView viewCalculator = new CalcView(modelCalculator);
        CalcController controllerCalculator = new CalcController(viewCalculator, modelCalculator);

    }
}
