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
        if (loadPackageParam.packageName.equals("com.xinmei.swig")) {
            XposedBridge.log("ccccccx}##");
            XposedHelpers.findAndHookMethod("com.comet.keyboard.dictionary.RnnModuleJNI",
                    loadPackageParam.classLoader,
                    "a",
                    char[].class,
                    int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            XposedBridge.log("ccccccx}+++" + new String((char[]) param.args[0]) +
                                    "|||" + param.args[1]);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                            XposedBridge.log("ccccccx}+++" + param.args[0] + param.args[1]);
                        }
                    });
        }
    }
}
