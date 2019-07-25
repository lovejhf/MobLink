package com.aajzapp.omk;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.mob.MobApplication;
import com.mob.MobSDK;
import com.mob.moblink.MobLink;
import com.mob.moblink.RestoreSceneListener;
import com.mob.moblink.Scene;

import java.util.HashMap;
import java.util.Map;

public class BaseApplication extends MobApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this, "29e1d4d9f63cb", "74b23167c989bf739b9a5f3a2d04c941");
        MobLink.skipRestoreSceneFromWx(StartAlphActivity.class);
//        MobLink.setRestoreSceneListener(new SceneListener());
    }

    class SceneListener extends Object implements RestoreSceneListener {

        @Override
        public Class<? extends Activity> willRestoreScene(Scene scene) {
//            // 在发现场景时回调. <br/>
            Log.e("BaseApplication.params", JSONObject.toJSONString(scene.params));
            String patch = scene.path;
            Map<String,Class<? extends Activity>> PATCH= new HashMap<>();
            PATCH.put("tuanDetail",GroupDetailActivity.class);
//
            return PATCH.get(patch);
        }

        @Override
        public void notFoundScene(Scene scene) {
            // 未找到处理scene的activity时回调
            System.out.println("=================notFoundScene全局回调"+scene.params);
        }

        @Override
        public void completeRestore(Scene scene) {
            // 在"拉起"处理场景的Activity之后调用

            System.out.println("=================completeRestore全局回调"+scene.params);
        }
    }
}
