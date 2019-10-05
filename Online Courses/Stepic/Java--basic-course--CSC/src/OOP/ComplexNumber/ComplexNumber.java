package OOP.ComplexNumber;

import java.util.Objects;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 &&
                Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(re, im);
    }
    /*

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + this.getRe());
        result = (int) (prime * result + this.getIm());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj instanceof ComplexNumber){
            ComplexNumber other = (ComplexNumber) obj;
            if(other.getRe() == this.re && other.getIm() == this.im) return true;
            return false;
        }
        else
            return false;
    }*/
}
