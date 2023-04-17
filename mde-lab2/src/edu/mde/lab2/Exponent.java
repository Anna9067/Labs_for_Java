package edu.mde.lab2;
import java.text.NumberFormat;
public class Exponent implements Function{
    private final Function fx;
    public Exponent(Function fx) {
        this.fx = fx;
    }
    @Override
    public double calculate(double x) {
        return Math.exp(fx.calculate(x));
    }
    @Override
    public Function derivative() {
        return new Multiplication(new Exponent(fx), fx.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        return "e^("+fx.toPrettyString(nf)+")";
    }
    public static Exponent of(Function fx) {
        return new Exponent(fx);
    }
}
