package com.shu.base.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * Created by wangshufu on 2018/3/22.
 *
 * 页面管理器
 *
 */
class AppManager private constructor() {

    /**
     * 栈
     */
    private val activityStack:Stack<Activity> = Stack()

    /**
     * 单例
     */
    companion object {
        val instance : AppManager by lazy { AppManager() }
    }

    /**
     * 入栈
     */
    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }

    /**
     * 出栈
     */
    fun finishActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * 获取当前页面
     */
    fun currentActivity(activity: Activity):Activity{
        return activityStack.lastElement()
    }

    /**
     * 清空栈
     */
    fun finishAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }
        activityStack.clear()
    }

    /**
     * 退出应用
     */
    fun exitApp(context: Context){
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}