package com.hintsite.app;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;

import com.parse.PushService;

import android.util.Log;


public class ChannelSubscription extends Plugin {
	public static final String SUBSCRIBE_TO_CHANNEL="subscribeToChannel"; 
    
	@Override
	public PluginResult execute(String action, JSONArray data, final String callbackId) {
		Log.d("SUBSCRIBING", "execute() called.");

		if (SUBSCRIBE_TO_CHANNEL.equals(action)) {
			String channel = "";
			try {
				channel = data.getString(0);
			} catch (Exception ex) {
//				callbackContext.error(ex.getMessage());
				Log.d("SUBSCRIBING", ex.getMessage());
				return new PluginResult(PluginResult.Status.OK);
			}
			
			
			// uncommenting next line breaks app - problems with context
			//PushService.subscribe(, channel, Hintsite.class);
			Log.d("Daicazzo", "te prego");
//			callbackContext.success();
			return new PluginResult(PluginResult.Status.OK);
		} else {
//			callbackContext.error("Invalid action");
			return new PluginResult(PluginResult.Status.ERROR);
		}
	}

}
