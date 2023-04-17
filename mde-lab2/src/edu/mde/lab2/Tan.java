package edu.mde.lab2;
import java.text.NumberFormat;
public class Tan implements Function{
    private final Function fx;
    public Tan(Function fx) {
        this.fx = fx;
    }
    @Override
    public double calculate(double x) {
        return Math.tan(fx.calculate(x));
    }
    @Override
    public Function derivative() {
        return new Multiplication(new Power(new Power(new Cos(fx), 2), -1), fx.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        return "tan("+fx.toPrettyString(nf)+")";
    }
    public static Tan of(Function fx) {
        return new Tan(fx);
    }
}
