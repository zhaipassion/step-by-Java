package book01.chapter04.beans;

/**
 * Driver information for a vendor. Defines the vendor keyword, description,
 * driver class, and URL construct for connecting to a database.
 */

public class DriverInfoBean {
	private String vendor;
	private String description;
	private String driverClass;
	private String url;

	public DriverInfoBean(String vendor, String description,
			String driverClass, String url) {
		this.vendor = vendor;
		this.description = description;
		this.driverClass = driverClass;
		this.url = url;
	}

	public String getVendor() {
		return (vendor);
	}

	public String getDescription() {
		return (description);
	}

	public String getDriverClass() {
		return (driverClass);
	}

	public String getURL() {
		return (url);
	}
}