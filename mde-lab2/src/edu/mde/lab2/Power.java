package edu.mde.lab2;
import java.text.NumberFormat;

public class Power implements Function{
    private final Function fx;
    private final double n; //степінь у яку зводимо
    public Power(Function fx, double n) {
        this.fx = fx;
        this.n = n;
    }
    @Override
    public double calculate(double x) {
        return Math.pow(fx.calculate(x), n);
    }
    @Override
    public Function derivative() {
        return new Multiplication(new Multiplication(new Const(n), new Power(fx, n-1)), fx.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        String index;
        if(nf != null) { // nf==null -> ""
            index = nf.format(n);
        } else {
            index = Double.toString(n);
        }
        return "(" + fx.toPrettyString(nf) + ")^" + index;
    }
    public static Power of(Function fx, double n) {
        return new Power(fx, n);
    }
}
