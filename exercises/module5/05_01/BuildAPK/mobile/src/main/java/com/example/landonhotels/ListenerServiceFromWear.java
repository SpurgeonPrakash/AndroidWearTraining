package com.example.landonhotels;

import android.content.Intent;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class ListenerServiceFromWear extends WearableListenerService {

    private static final String WEARPATH = "/from-wear";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);

        if (messageEvent.getPath().equals(WEARPATH)) {
            String city = new String(messageEvent.getData());

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("city", city);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
