package com.aajzapp.omk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mob.moblink.MobLink;
import com.mob.moblink.RestoreSceneListener;
import com.mob.moblink.Scene;
import com.mob.moblink.SceneRestorable;

public class GroupDetailActivity  extends AppCompatActivity  implements SceneRestorable {
    private String activity_id ="";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_page);
        MobLink.updateNewIntent(getIntent(), this);
        activity_id  = getIntent().getStringExtra("activity_id");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        MobLink.updateNewIntent(getIntent(), this);
    }

    @Override
    public void onReturnSceneData(Scene scene) {
        System.out.println("========GroupDetailActivity"+scene.params);
    }

}
