package br.com.rafael.ubs.controller.form;

import javax.validation.constraints.NotNull;

public class UbsForm {

	@NotNull
	private double latitude;
	@NotNull
	private double longitude;
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
