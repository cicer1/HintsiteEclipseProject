package com.hintsite.app;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import com.parse.PushService;


public class ChannelSubscription extends CordovaPlugin {
	public static final String SUBSCRIBE_TO_CHANNEL="subscribeToChannel"; 
    
	@Override
	public boolean execute(String action, JSONArray data, CallbackContext callbackContext) {
		Log.d("SUBSCRIBING", "execute() called.");

		if (SUBSCRIBE_TO_CHANNEL.equals(action)) {
			String channel = null;
			try {
				channel = data.getString(0);
				Log.d("SUBSCRIBING", "Retrieved channel name: " + channel);
			} catch (JSONException ex) {
				Log.d("SUBSCRIBING", ex.getMessage());
				callbackContext.error(ex.getMessage());
				return false;
			}
			
			PushService.subscribe(this.webView.getContext(), channel, Hintsite.class);
			
			callbackContext.success();
			return true;
		} else {
			callbackContext.error("Invalid action");
			return false;
		}
	}

}
