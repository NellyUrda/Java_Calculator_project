package calculator;

public class Operation {

	private double nr1;
	private double nr2;

	public Operation() {

	}

	public void setNumber1(double nr1) {
		this.nr1 = nr1;
	}

	public double getNumber1() {
		return nr1;
	}

	public void setNumber2(double nr2) {
		this.nr2 = nr2;
	}

	public double getNumber2() {
		return nr2;
	}

	public double addition(double nr1, double nr2) {
		return nr1 + nr2;
	}

	public double substraction(double nr1, double nr2) {
		return nr1 - nr2;
	}

	public double multiply(double nr1, double nr2) {
		return nr1 * nr2;
	}

	public double divide(double nr1, double nr2) {
		return nr1 / nr2;
	}

}
