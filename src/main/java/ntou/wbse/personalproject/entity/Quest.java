package ntou.wbse.personalproject.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Quest")
public class Quest {

	private String id;
	private String name;
	private String attribute;
	private String keyword;
	
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
	
	public String getAttribute() {
		return attribute;
	}
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
    public String toString() {
    	return "quest{" + 
                "id : '" + id + "'" +
    			"name : '" + name + "'" +
                "attribute : '" + attribute + "'" +
    			"keyword : '" + keyword + "'" +
                "}";
    }
}
