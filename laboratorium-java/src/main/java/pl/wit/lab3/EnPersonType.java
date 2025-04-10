package pl.wit.lab3;

public enum EnPersonType {
	student("student"),teacher("nauczyciel");
	private String plName;

	public String getPlName() {
		return plName;
	}
	private EnPersonType(String plName) {
		this.plName = plName;
	}
}
