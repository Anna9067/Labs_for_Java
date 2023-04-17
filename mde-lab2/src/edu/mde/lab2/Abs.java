package edu.mde.lab2;
import java.text.NumberFormat;
public class Abs implements Function{
    private final Function fx;
    public Abs(Function fx) {
        this.fx = fx;
    }
    @Override
    public double calculate(double x) {
        return Math.abs(fx.calculate(x));
    }
    @Override
    public Function derivative() {
        return new Multiplication(new Multiplication(fx, new Power(new Abs(fx), -1)), fx.derivative()); //fx*(|fx|)^(-1)*(fx)'
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        return "abs("+fx.toPrettyString(nf)+")";
    }
    public static Abs of(Function fx) {
        return new Abs(fx);
    }
}
