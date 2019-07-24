package com.aajzapp.omk;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import com.mob.MobSDK;
import com.mob.moblink.MobLink;
import com.mob.moblink.RestoreSceneListener;
import com.mob.moblink.Scene;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this, "29e1d4d9f63cb", "74b23167c989bf739b9a5f3a2d04c941");
        MobLink.setRestoreSceneListener(new SceneListener());
    }

    class SceneListener extends Object implements RestoreSceneListener {

        @Override
        public Class<? extends Activity> willRestoreScene(Scene scene) {
            // 在发现场景时回调. <br/>
            // return !null 将跳转到对应Activity; return null 依据path从服务器查询对应处理Activity.
            return TwoPage.class;
        }

        @Override
        public void notFoundScene(Scene scene) {
            // 未找到处理scene的activity时回调
        }

        @Override
        public void completeRestore(Scene scene) {
            // 在"拉起"处理场景的Activity之后调用

        }
    }
}
