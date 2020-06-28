package ntou.wbse.personalproject.model;

import ntou.wbse.personalproject.entity.Quest;
import ntou.wbse.personalproject.entity.QuestRequest;
import ntou.wbse.personalproject.entity.Weapon;
import ntou.wbse.personalproject.entity.WeaponRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Project {

    private CloseableHttpClient httpClient;

    private Convert convert = new Convert();

    public Project() {
       httpClient = HttpClients.createDefault();
    }

    public void closeConnect() {
        try{
            httpClient.close();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }

    }

    public Quest getQuestByName(String questName, String port) {
        Quest quest = new Quest();
        HttpGet httpGet = new HttpGet(
                    "http://localhost:" + port + "/personalProject/quest/" + questName
            );
        httpGet.addHeader("accept", "application/json");

        try{
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : Http error code : "
                + response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent()))
            );

            quest = convert.convertToQuest(bufferedReader.readLine());

            response.close();

        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }
        return quest;
    }

    public ArrayList<Quest> getQuestByAttribute(String attribute, String port) {
        ArrayList<Quest> questArrayList = new ArrayList<Quest>();

        HttpGet httpGet = new HttpGet(
                "http://localhost:" + port + "/personalProject/quests/" + attribute
        );
        httpGet.addHeader("accept", "application/json");

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Faile : Http error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent())
            );

            questArrayList = convert.convertToQuests(bufferedReader.readLine());

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }

        return questArrayList;
    }

    public Quest createQuest(QuestRequest quest, String port) {

        Quest newQuest = new Quest();

        HttpPost httpPost = new HttpPost(
                "http://localhost:" + port + "/personalProject/quest/create"
        );

        StringEntity entity = new StringEntity(convert.questConvertToJson(quest).toString(), HTTP.UTF_8);
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);

            if(response.getStatusLine().getStatusCode() != 201) {
                throw new RuntimeException("Faile : Http error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent())
            );

            newQuest = convert.convertToQuest(bufferedReader.readLine());

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }

        return newQuest;
    }

    public Quest replaceQuest(QuestRequest request, String name, String port) {
        Quest quest = new Quest();

        HttpPost httpPost = new HttpPost(
                "http://localHost:" + port + "/personalProject/quest/" + name
        );

        StringEntity entity = new StringEntity(convert.questConvertToJson(request).toString(), HTTP.UTF_8);
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Faile : Http error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent())
            );

            quest = convert.convertToQuest(bufferedReader.readLine());

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }

        return quest;
    }

    public void deleteQuest(String name, String port) {
        HttpDelete httpDelete = new HttpDelete(
                "http://localHost:" + port + "/personalProject/quest/" + name
        );
        httpDelete.addHeader("accept", "application/json");

        try {
            CloseableHttpResponse response = httpClient.execute(httpDelete);

            if(response.getStatusLine().getStatusCode() != 204) {
                throw new RuntimeException("Faile : Http error code : "
                        + response.getStatusLine().getStatusCode());
            }
            else {
                System.out.println(response.getStatusLine().getStatusCode());
            }

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }
    }

    public ArrayList<Weapon> getWeaponArrayListByAttribute(String attribute, String port) {
        ArrayList<Weapon> weaponArrayList = new ArrayList<Weapon>();

        HttpGet getRequest = new HttpGet(
                "http://localhost:" + port + "/personalProject/weapons/attribute/" + attribute);
        getRequest.addHeader("accept", "application/json");

        try{
            CloseableHttpResponse response = httpClient.execute(getRequest);
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent()))
            );

            weaponArrayList = convert.convertToWeapons(bufferedReader.readLine());

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }

        return weaponArrayList;
    }

    public Weapon getWeaponById(String weaponId, String port) {
        Weapon weapon = new Weapon();

        HttpGet httpGet= new HttpGet(
                "http://localHost:" + port + "/personalProject/weapon/" + weaponId
        );

        httpGet.addHeader("accept", "application/json");
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent())
            );

            weapon = convert.convertToWeapon(bufferedReader.readLine());

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }

        return weapon;
    }

    public ArrayList<Weapon> getWeaponByType(String weaponType, String port) {

        ArrayList<Weapon> weaponArrayList = new ArrayList<Weapon>();
        HttpGet httpGet = new HttpGet(
                "http://localHost:" + port + "/personalProject/weapons/weaponType/" + weaponType
        );

        httpGet.addHeader("accept", "application/json");

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent())
            );

            weaponArrayList = convert.convertToWeapons(bufferedReader.readLine());

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }

        return weaponArrayList;
    }

    public ArrayList<Weapon> getWeapons(String attribute, String weaponType, String port) {
        ArrayList<Weapon> weaponArrayList = new ArrayList<Weapon>();

        HttpGet httpGet = new HttpGet(
                "http://localHost:" + port + "/personalProject/weapons?attribute=" + attribute +
                        "&weaponType=" + weaponType
        );

        httpGet.addHeader("accept", "application/json");

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent())
            );

            weaponArrayList = convert.convertToWeapons(bufferedReader.readLine());

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }
        return weaponArrayList;
    }

    public Weapon createWeapon(WeaponRequest request, String port) {

        Weapon weapon = new Weapon();
        HttpPost httpPost = new HttpPost(
                "http://localHost:" + port + "/personalProject/weapon/create"
        );

        StringEntity entity = new StringEntity(convert.weaponConvertToJson(request).toString(), HTTP.UTF_8);
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);

            if(response.getStatusLine().getStatusCode() != 201) {
                throw new RuntimeException("Failed : HTTP error code : " +
                        response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent())
            );

            weapon = convert.convertToWeapon(bufferedReader.readLine());

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }

        return weapon;
    }

    public Weapon replaceWeapon(WeaponRequest request, String weaponId, String port) {
        Weapon weapon = new Weapon();

        HttpPost httpPost = new HttpPost(
                "http://localHost:" + port + "/personalProject/weapon/" + weaponId
        );

        StringEntity entity = new StringEntity(convert.weaponConvertToJson(request).toString(), HTTP.UTF_8);
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Faile : Http error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent())
            );

            weapon = convert.convertToWeapon(bufferedReader.readLine());

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }

        return weapon;
    }

    public void deleteWeapon(String weaponId, String port) {
        HttpDelete httpDelete = new HttpDelete(
                "http://localHost:" + port + "/personalProject/weapon/" + weaponId
        );
        httpDelete.addHeader("accept", "application/json");

        try {
            CloseableHttpResponse response = httpClient.execute(httpDelete);

            if(response.getStatusLine().getStatusCode() != 204) {
                throw new RuntimeException("Faile : Http error code : "
                        + response.getStatusLine().getStatusCode());
            }
            else {
                System.out.println(response.getStatusLine().getStatusCode());
            }

            response.close();
        } catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }
    }

    /*public static void main(String[] args) {
        Project project = new Project();

        //Weapon weapon = project.getWeaponById("001", "8084");

        //WeaponRequest weapon = new WeaponRequest();
        //weapon.setSeries("matrix_2");
        //weapon.setAttribute("CCC");
        //weapon.setWeaponType("staff");
        //weapon.setName("Tiamat");
        //weapon.setPicName("AAA.jpg");
        //weapon.setWeaponId("051");

        //Weapon newWeapon = project.replaceWeapon(weapon, "050", "8084");

        ArrayList<Weapon> weaponArrayList = project.getWeaponArrayListByAttribute("fire", "8084");


        //System.out.println(newWeapon);
        System.out.println(weaponArrayList);

        project.deleteWeapon("051", "8084");

        project.closeConnect();
    }*/
}
