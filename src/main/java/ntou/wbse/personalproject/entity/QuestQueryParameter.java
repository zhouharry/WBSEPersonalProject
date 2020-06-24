package ntou.wbse.personalproject.entity;

public class QuestQueryParameter {
	private String name;
	private String attribute;

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

	@Override
	public String toString() {
		return "QueryParameter{" + "name='" + name + '\'' + ", attribute='" + attribute + '}';
	}
}
