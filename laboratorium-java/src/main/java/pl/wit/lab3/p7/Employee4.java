package pl.wit.lab3.p7;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.javatuples.Pair;

public class Employee4 extends Person4 {
	// Data zatrudnienia
	private Date employmentDate = null;
	// Wyngrodzenie
	private BigDecimal sallary = null;

	public Employee4(String firstName, String lastName, Date dateOfBirth, Date employmentDate, BigDecimal sallary) {
		super(firstName, lastName, dateOfBirth);
		this.employmentDate = employmentDate;
		this.sallary = sallary;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("employmentDate=").append(employmentDate.toString()).append("\n");
		sb.append("sallary=").append(sallary.toString()).append("\n");
		return sb.toString();
	}

	protected boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo, Date employmentFrom,
			Date employmentTo, BigDecimal sallaryFrom, BigDecimal sallaryTo) {
		return super.matches(firstName, lastName, birthFrom, birthTo) && matchesEmployment(employmentFrom, employmentTo)
				&& matchesSallary(sallaryFrom, sallaryTo);
	}

	protected boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo, Date employmentFrom,
			Date employmentTo, BigDecimal sallaryFrom, BigDecimal sallaryTo, boolean strict) {
		return super.matches(firstName, lastName, birthFrom, birthTo, strict)
				&& matchesEmployment(employmentFrom, employmentTo) && matchesSallary(sallaryFrom, sallaryTo);
	}

	private boolean matchesEmployment(Date employmentFrom, Date employmentTo) {
		if (employmentFrom != null) {
			if (this.employmentDate != null) {
				if (!(this.employmentDate.after(employmentFrom) || this.employmentDate.equals(employmentFrom)))
					return false;
			} else
				return false;
		}
		if (employmentTo != null) {
			if (this.employmentDate != null) {
				if (!(this.employmentDate.before(employmentTo) || this.employmentDate.equals(employmentTo)))
					return false;
			} else
				return false;
		}

		return true;
	}

	private boolean matchesSallary(BigDecimal sallaryFrom, BigDecimal sallaryTo) {
		if (sallaryFrom != null) {
			if (this.sallary != null) {
				if (!(this.sallary.compareTo(sallaryFrom) <= 0))
					;
				return false;
			} else
				return false;
		}
		if (sallaryTo != null) {
			if (this.sallary != null) {
				return (this.sallary.compareTo(sallaryTo) >= 0);
			} else
				return false;
		}

		return true;
	}

	@Override
	public boolean search(Map<String, Pair<Object, Byte>> conditions) throws Exception {
		if (conditions == null || conditions.isEmpty()) {
			return true;
		}

		String firstName = null;
		String lastName = null;
		Date birthFrom = null, birthTo = null;
		Date employmentFrom = null, employmentTo = null;
		BigDecimal sallaryFrom = null, sallaryTo = null;

		 
		for (Map.Entry<String, Pair<Object, Byte>> entry : conditions.entrySet()) {
			String field = entry.getKey();
			Pair<Object, Byte> pair = entry.getValue();
			Object value = pair.getValue0();
			Byte operatorCode = pair.getValue1();

			
			switch (field) {
			case "firstName":
				if (!(value instanceof String))
					throw new Exception("Invalid type for firstName");
				if (operatorCode == 1) { // EQUALS
					if (!this.getFirstName().equals(value))
						return false;
				} else {
					throw new Exception("Unsupported operator for firstName");
				}
				break;

			case "lastName":
				if (!(value instanceof String))
					throw new Exception("Invalid type for lastName");
				if (operatorCode == 1) { // EQUALS
					if (!this.getLastName().equals(value))
						return false;
				} else {
					throw new Exception("Unsupported operator for lastName");
				}
				break;

			case "dateOfBirthFrom":
				if (!(value instanceof Date))
					throw new Exception("Invalid type for dateOfBirthFrom");
				birthFrom = (Date) value;
				break;

			case "dateOfBirthTo":
				if (!(value instanceof Date))
					throw new Exception("Invalid type for dateOfBirthTo");
				birthTo = (Date) value;
				break;

			case "employmentDateFrom":
				if (!(value instanceof Date))
					throw new Exception("Invalid type for employmentDateFrom");
				employmentFrom = (Date) value;
				break;

			case "employmentDateTo":
				if (!(value instanceof Date))
					throw new Exception("Invalid type for employmentDateTo");
				employmentTo = (Date) value;
				break;

			case "sallaryFrom":
				if (!(value instanceof BigDecimal))
					throw new Exception("Invalid type for sallaryFrom");
				sallaryFrom = (BigDecimal) value;
				break;

			case "sallaryTo":
				if (!(value instanceof BigDecimal))
					throw new Exception("Invalid type for sallaryTo");
				sallaryTo = (BigDecimal) value;
				break;

			default:
				throw new Exception("Unknown field: " + field);
			}
		}

		 
		return matches(firstName, lastName, birthFrom, birthTo, employmentFrom, employmentTo, sallaryFrom, sallaryTo);
	}
	////////////////////////////////////////
	// getters and setters
	////////////////////////////////////////

	public Date getEmploymentDate() {
		return employmentDate;
	}

	public BigDecimal getSallary() {
		return sallary;
	}
}