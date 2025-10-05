public class Fraction{
    int num; int den;
    public Fraction(int num, int den){
        this.num = num;
        if (den != 0) this.den = den;
    }
    public Fraction(){
        this(0,1);
    }
    public Fraction(int num){
        this(num, 1);
    }
    public Fraction add(Fraction f){
        Fraction newF;
        if (this.den == f.den){
            newF = new Fraction(this.num + f.num, this.den);
        }
        else{
            int newNum = (this.num * f.den) + (f.num * this.den);
            newF = new Fraction(newNum, this.den*f.den);
        }
        return newF;
    }
    public Fraction multiply(Fraction f){
        Fraction newF = new Fraction(this.num * f.num, this.den * f.den);
        return newF;
    }

    public void simplify(){
        int x = num, y = den;
        while (y != 0){
            int resto = x % y;
            x = y;
            y = resto;
        }
        num /= x; den /= x;
    }

    public String toString(){
        int u = num / den;
        int n = num % den;
        String str;
        if (u != 0) str = u + " + " + n + "/" + den;
        else str = n + "/" + den;
        return str;
    }
}