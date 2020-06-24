package ntou.wbse.personalproject.entity;

import javax.validation.constraints.NotEmpty;

public class QuestRequest {
	@NotEmpty(message = "Quest name isn't provided. ")
	private String name;
	
	@NotEmpty(message = "Quest attribute isn't provided. ")
	private String attribute;
	
	@NotEmpty(message = "Quest keyword isn't provided. ")
	private String keyword;
	
	
	public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
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
    
}
