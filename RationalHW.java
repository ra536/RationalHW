public class RationalHW {
	public static void main(String[] args){
		Rational a = new Rational(7, 3);
		Rational b = new Rational(2, 3);
		Rational ab = a.add(b);
		System.out.println(ab); // 9/3
		System.out.println(ab.simplify()); // 3

		Rational c = new Rational(1, 3);
		Rational d = new Rational(1, 2);

		System.out.println(c.add(d)); // 1/3 + 1/2 = 5/6
		System.out.println(c.sub(d)); // 1/3 - 1/2 = -1/6
		System.out.println(c.mul(d)); // 1/3 * 1/2 = 1/6
		System.out.println(c.div(d)); // 1/3 / 1/2 = 2/3

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
		if (den != other.den){
			int numSum = (num * other.den) + (other.num * den);
			return new Rational(numSum, den * other.den);
		} else {
			return new Rational(num + other.num, den);
		}
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
		return mul(other.inv());
	}

	private Rational inv(){
		return new Rational(den, num);
	}

	public int gcd(){
		int m = this.num;
		int n = this.den;
		while(n != 0){
			int r = m % n;
			m = n;
			n = r;
		}
		return m;
	}

	public Rational simplify(){
		int gcd = gcd();
		return new Rational(num / gcd, den / gcd);
	}

	public String toString(){
		if (den == 1){
			return Integer.toString(num);
		} else {
			return num + "/" + den;
		}
	}
}