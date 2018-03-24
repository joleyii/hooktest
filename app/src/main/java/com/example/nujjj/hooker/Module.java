package com.example.nujjj.hooker;


import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by nujjj on 2018/3/7.
 */

public class Module implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (loadPackageParam.packageName.equals("target_packagename")) {
            XposedHelpers.findAndHookMethod("target_classname",
                    loadPackageParam.classLoader,
                    "taget_mathedname",
                    char[].class,
                    int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            XposedBridge.log("beforeHookedMethod" + new String((char[]) param.args[0]) +
                                    "|||" + param.args[1]);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        }
                    });
        }
    }
}
