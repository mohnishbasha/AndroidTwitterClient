package com.codepath.apps.mysimpletweets.models;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Tweet {

    // list of tweet attribs
    private String body;
    private long uid;
    private  User user;
    private String createdAt;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public static Tweet fromJSON(JSONObject jsonObject) {
        Tweet tweet = new Tweet();
        try {

            tweet.body = jsonObject.getString("text");
            tweet.uid   = jsonObject.getLong("id");
            tweet.createdAt = jsonObject.getString("created_at");
            tweet.user  = User.fromJSON(jsonObject.getJSONObject("user"));
            Log.d("Debug Tweet: ", tweet.createdAt);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // tweet.user
        return tweet;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray) {

        ArrayList<Tweet> tweets = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {

                JSONObject tweetJson = jsonArray.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(tweetJson);

                if(tweet != null)
                {
                    tweets.add(tweet);
                }

            } catch (JSONException e) {
                e.printStackTrace();
                continue;

            }
        }

        return tweets;


    }

}
