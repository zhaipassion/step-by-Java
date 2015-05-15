package book01.chapter04.beans;

import book01.chapter04.ServletUtilities;

/**
 * Simple bean that represents information needed to calculate an employee's
 * insurance costs. Has String, int, and boolean properties. Used to demonstrate
 * automatically filling in bean properties from request parameters.
 */

public class InsuranceInfo {
	private String name = "No name specified";
	private String employeeID = "No ID specified";
	private int numChildren = 0;
	private boolean isMarried = false;

	public String getName() {
		return (name);
	}

	/**
	 * Just in case user enters special HTML characters, filter them out before
	 * storing the name.
	 */

	public void setName(String name) {
		this.name = ServletUtilities.filter(name);
	}

	public String getEmployeeID() {
		return (employeeID);
	}

	/**
	 * Just in case user enters special HTML characters, filter them out before
	 * storing the name.
	 */

	public void setEmployeeID(String employeeID) {
		this.employeeID = ServletUtilities.filter(employeeID);
	}

	public int getNumChildren() {
		return (numChildren);
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	/**
	 * Bean convention: name getter method "isXxx" instead of "getXxx" for
	 * boolean methods.
	 */

	public boolean isMarried() {
		return (isMarried);
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
}
