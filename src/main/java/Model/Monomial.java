package Model;

public class Monomial implements Comparable{
    private double coeficient;
    private int grad;

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    @Override
    public int compareTo(Object o) {
        int objGrad=((Monomial)o).getGrad();
        return objGrad-this.grad;
    }
}
