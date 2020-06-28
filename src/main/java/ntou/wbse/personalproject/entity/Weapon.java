package ntou.wbse.personalproject.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weapon")
public class Weapon {
    private String id;
    private String series;
    private String attribute;
    private String weaponType;
    private String name;
    private String picName;
    private String weaponId;

    public String getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(String weaponId) {
        this.weaponId = weaponId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getId() {
    	return id;
    }
    
    public void setId(String id) {
    	this.id = id;
    }
    
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
    
    @Override
    public String toString() {
    	return "weapon{ " +
                "id : '" + id + "', " +
    			"series : '" + series + "', " +
                "attribute : '" + attribute + "', " +
    			"weaponType : '" + weaponType + "', " +
                "picture name : '" + picName + "' " +
                "weapon ID : " + weaponId + "' " +
                "}";
    }
}
