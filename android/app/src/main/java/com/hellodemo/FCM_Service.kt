package com.hellodemo


import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.netcore.android.smartechpush.SmartPush
import org.checkerframework.checker.nullness.qual.NonNull
import java.lang.ref.WeakReference


        class FCM_Service : FirebaseMessagingService() {

            override fun onNewToken(token: String) {
                super.onNewToken(token)
                SmartPush.getInstance(WeakReference(this)).setDevicePushToken(token)
            }

            override fun onMessageReceived(remoteMessage: RemoteMessage) {
                super.onMessageReceived(remoteMessage)
                val isPnHanledBySmartech:Boolean = SmartPush.getInstance(WeakReference(this)).handleRemotePushNotification( remoteMessage)
                if (!isPnHanledBySmartech){
                    // Notification from other sources, handle yourself
                }
            }
        }