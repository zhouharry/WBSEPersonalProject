package ntou.wbse.personalproject.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weapon")
public class Weapon {
    private String id;
    private String series;
    private String attribute;
    private String type;
    private String name;
    private String picName;

    public String getPicName() {
        return picName;
    }

    public void setPic_name(String picName) {
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
    
    public String getType() {
    	return type;
    }
    
    public void setType(String type) {
    	this.type = type;
    }
    
    @Override
    public String toString() {
    	return "weapon{" + 
                "id : '" + id + "'" +
    			"series : '" + series + "'" +
                "attribute : '" + attribute + "'" +
    			"type : '" + type + "'" +
                "picture name : '" + picName + "'" +
                "}";
    }
}
