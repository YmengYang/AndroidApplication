package com.example.Lifecycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver(val lifecycle: Lifecycle) : LifecycleObserver {

    //生命周期事件ON_CREATE、ON_START、ON_RESUME、ON_PAUSE、
    //ON_STOP和ON_DESTROY
    //activityStart()和activityStop()方法就应该分别在Activity的
    //onStart()和onStop()触发的时候执行。
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart() {
        Log.d("MyObserver", "activityStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop() {
        Log.d("MyObserver", "activityStop")
    }
}