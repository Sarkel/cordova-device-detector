package org.stayOut.plugin.deviceDetector;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.Boolean;
import java.lang.Exception;
import java.lang.reflect.Method;

import android.content.res.Configuration;
import android.content.Context;

/**
 * This class echoes a string called from JavaScript.
 */
public class DeviceDetector extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
//    try {
//      Method method = this.getClass().getMethod(action, param1.class);
//      method.invoke(this, callbackContext);
//      return true;
//    } catch (SecurityException e) {
//      return false;
//    } catch (NoSuchMethodException e) {
//      return false;
//    } catch (IllegalArgumentException e) {
//      return false;
//    } catch (IllegalAccessException e) {
//      return false;
//    } catch (InvocationTargetException e) {
//      return false;
//    }
    if(action.equals("isTablet")) {
      this.isTablet(callbackContext);
      return true;
    }
    return false;
  }

  private void isTablet(CallbackContext callbackContext) throws JSONException {
    try {
      Context context = this.cordova.getActivity().getApplicationContext();
      Boolean isTablet = (context.getResources().getConfiguration().screenLayout
        & Configuration.SCREENLAYOUT_SIZE_MASK)
        >= Configuration.SCREENLAYOUT_SIZE_LARGE;
      callbackContext.success(new JSONObject().put("isTablet", isTablet));
    } catch (Exception e) {
      callbackContext.error(new JSONObject().put("err", "Error has occured"));
    }
  }
}
