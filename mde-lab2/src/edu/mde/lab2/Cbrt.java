package edu.mde.lab2;
import java.text.NumberFormat;
public class Cbrt implements Function{
    private final Function fx;
    public Cbrt(Function fx) {
        this.fx = fx;
    }
    @Override
    public double calculate(double x) {
        return Math.cbrt(fx.calculate(x));
    }
    @Override
    public Function derivative() {
        return new Multiplication(new Multiplication(new Power(fx, -2.0/3), new Const(1.0/3)), fx.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        return "cbrt("+fx.toPrettyString(nf)+")";
    }
    public static Cbrt of(Function fx) {
        return new Cbrt(fx);
    }
}
