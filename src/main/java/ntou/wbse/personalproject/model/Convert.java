package ntou.wbse.personalproject.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import ntou.wbse.personalproject.entity.Quest;
import ntou.wbse.personalproject.entity.QuestRequest;
import ntou.wbse.personalproject.entity.Weapon;
import ntou.wbse.personalproject.entity.WeaponRequest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Convert {

    public Quest convertToQuest(String jsonData) {
        Gson gson = new Gson();
        Quest quest = new Quest();

        try {
            Type type = new TypeToken<Quest>() {}.getType();
            quest = gson.fromJson(jsonData, type);
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        return quest;
    }

    public ArrayList<Quest> convertToQuests(String jsonData) {
        Gson gson = new Gson();
        ArrayList<Quest> questArrayList= new ArrayList<Quest>();

        try {
            Type type = new TypeToken<ArrayList<Quest>>() {}.getType();
            questArrayList = gson.fromJson(jsonData, type);
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        return questArrayList;
    }

    public Weapon convertToWeapon(String jsonData) {
        Gson gson = new Gson();
        Weapon weapon = new Weapon();

        try {
            Type type = new TypeToken<Weapon>() {}.getType();
            weapon = gson.fromJson(jsonData, type);
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        return weapon;
    }

    public ArrayList<Weapon> convertToWeapons(String jsonData) {

        Gson gson = new Gson();
        ArrayList<Weapon> weaponArrayList= new ArrayList<Weapon>();

        try {
            Type listType = new TypeToken<List<Weapon>>() {
            }.getType();
            weaponArrayList = gson.fromJson(jsonData, listType);
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        return weaponArrayList;
    }

    public JsonObject questConvertToJson (QuestRequest request) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", request.getName());
        jsonObject.addProperty("attribute", request.getAttribute());
        jsonObject.addProperty("keyword", request.getKeyword());

        return jsonObject;
    }

    public JsonObject weaponConvertToJson (WeaponRequest request) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("series", request.getSeries());
        jsonObject.addProperty("attribute", request.getAttribute());
        jsonObject.addProperty("weaponType", request.getWeaponType());
        jsonObject.addProperty("name", request.getName());
        jsonObject.addProperty("picName", request.getPicName());
        jsonObject.addProperty("weaponId", request.getWeaponId());

        return jsonObject;
    }
}
