public class RationalHW {
	public static void main(String[] args){

		Complex a = new Complex(2.0, 3.0);
		Complex b = new Complex(1.0, 2.0);

		Rational c = new Rational(1, 3);
		Rational d = new Rational(1, 2);

		System.out.println(c.add(d)); // 1/3 + 1/2 = 5/6
		System.out.println(c.sub(d)); // 1/3 - 1/2 = -1/6
		System.out.println(c.mul(d)); // 1/3 * 1/2 = 1/6
		System.out.println(c.div(d)); // 1/3 / 1/2 = 2/3
	}
}

class Complex {
	private double real;
	private double imag;

	public Complex(double real, double imag){
		this.real = real;
		this.imag = imag;
	}

	public Complex add(Complex other){
		return new Complex(real + other.real, imag + other.imag);
	}

	public String toString(){
		return "(" + real + " + " + imag + "i)";
	}
}

class Rational {

	private int num;
	private int den;

	public Rational(int num, int den){
		this.num = num;
		this.den = den;
	}

	public Rational add(Rational other){
		int numSum = (num * other.den) + (other.num * den);
		return new Rational(numSum, den * other.den);
	}

	private Rational neg(){
		return new Rational(-num, den);
	}

	public Rational sub(Rational other){
		return add(other.neg());
	}

	public Rational mul(Rational other){
		return new Rational(num * other.num, den * other.den);
	}

	public Rational div(Rational other){
		Rational otherInv = other.inv();
		return mul(otherInv);
		// return new Rational(num * otherInv.num, den * otherInv.den);
	}

	private Rational inv(){
		return new Rational(den, num);
	}

	public String toString(){
		return num + "/" + den;
	}
}

/*
gcd(m, n):
while n != 0:
	r = m mod n
	m = n
	n = r
return m
*/