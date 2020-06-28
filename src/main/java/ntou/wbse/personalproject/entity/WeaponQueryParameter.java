package ntou.wbse.personalproject.entity;

public class WeaponQueryParameter {

    private String attribute;
    private String weaponType;

    public String getAttribute() {
        return attribute;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String toString() {
        return "WeaponParameter {" + "attribute = '" + attribute + '\'' +
                                     "weaponType = '" + weaponType + '\'' +
                                     '}';
    }
}
