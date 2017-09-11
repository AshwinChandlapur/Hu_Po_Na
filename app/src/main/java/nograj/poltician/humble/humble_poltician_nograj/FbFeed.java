package nograj.poltician.humble.humble_poltician_nograj;

import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nikith_Shetty on 10/09/2017.
 */

public class FbFeed {
    private JSONObject from;
    private String full_picture;
    private String type;
    private String description;
    private String message;
    private String picture;
    private String id;
    private String fromName;

    public String getFromName() {
        return fromName;
    }

    private void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromId() {
        return fromId;
    }

    private void setFromId(String fromId) {
        this.fromId = fromId;
    }

    private String fromId;

    public JSONObject getFrom() {
        return from;
    }

    public void setFrom(JSONObject from) {
        this.from = from;
    }

    public String getFull_picture() {
        return full_picture;
    }

    public void setFull_picture(String full_picture) {
        this.full_picture = full_picture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static FbFeed fromJSONObj (JSONObject resObj) {
        FbFeed feed = new FbFeed();
        try {
            feed.setDescription(resObj.getString("description"));
            feed.setFull_picture(resObj.getString("full_picture"));
            feed.setType(resObj.getString("type"));
            feed.setPicture(resObj.getString("picture"));
            feed.setMessage(resObj.getString("message"));
            feed.setId(resObj.getString("id"));
            feed.setFrom(resObj.getJSONObject("from"));
            feed.setFromId(resObj.getJSONObject("from").getString("name"));
            feed.setFromName(resObj.getJSONObject("from").optString("name"));
            return feed;
        } catch (Exception e) {
            return null;
        }
    }

    public String toString(){
        return "{ description : " + getDescription() + "\n" +
                " message : " + getMessage() + "\n" +
                " id : " + getId() + "\n" +
                " full_picture : " + getFull_picture() + "\n" +
                " picture : " + getPicture() + "\n" +
                " from : { name : " + getFromName() + "\n" +
                "          id : " + getFromId() + "\n" +
                "       } " + "\n" +
                "}";
    }
}
