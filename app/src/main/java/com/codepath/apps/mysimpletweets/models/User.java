package com.codepath.apps.mysimpletweets.models;


import org.json.JSONException;
import org.json.JSONObject;

public class User {
    // list the attributes

    // deserialize the user json into object

    private  String name;
    private  long uid;
    private  String screenName;
    private String profileImageUrl;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User fromJSON(JSONObject json) {

        User u = new User();
        try {

            u.name = json.getString("name");
            u.uid   = json.getLong("id");
            u.screenName = json.getString("screen_name");
            u.profileImageUrl = json.getString("profile_image_url");

        } catch (JSONException e) {
            e.printStackTrace();
        }



        return u;

    }

}

