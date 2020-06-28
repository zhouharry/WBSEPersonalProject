package ntou.wbse.personalproject.entity;

import javax.validation.constraints.NotEmpty;

public class WeaponRequest {
    
	@NotEmpty(message = "Weapon series isn't provided. ")
	private String series;
	
	@NotEmpty(message = "Weapon attribute isn't provided. ")
	private String attribute;
	
	@NotEmpty(message = "Weapon type isn't provided. ")
	private String weaponType;
	
	@NotEmpty(message = "Quest name isn't provided. ")
	private String name;

	@NotEmpty(message = "Picture name isn't provided. ")
	private String picName;

	@NotEmpty(message = "Weapon ID isn't provided. ")
	private String weaponId;
	
	public String getSeries() {
    	return series;
    }
    
    public void setSeries(String series) {
    	this.series = series;
    }
    
    public String getAttribute() {
    	return attribute;
    }
    
    public void setAttribute(String attribute) {
    	this.attribute = attribute;
    }
    
    public String getWeaponType() {
    	return weaponType;
    }
    
    public void setWeaponType(String weaponType) {
    	this.weaponType = weaponType;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(String weaponId) {
		this.weaponId = weaponId;
	}
}
