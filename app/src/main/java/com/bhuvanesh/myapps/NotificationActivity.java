package com.bhuvanesh.myapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {

    Button GenerateNotification;
    Button ToastNotification;
    Button SoundNotification;
    Button VibrateNotification;
    Button LedNotification;
    Button AllNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    /*public void gerateNotification(View view){
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("Breaking News");
        notificationBuilder.setSmallIcon(R.drawable.notifaction);
        notificationBuilder.setContentText("Today Code Ignitor has to work till 6:30 PM");
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notifaction));
        notificationBuilder.setTicker("Important Announcement");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,new Intent(this,ActivityNavigator.class), PendingIntent.FLAG_CANCEL_CURRENT);
        notificationBuilder.setContentIntent(pendingIntent);
        Notification notification = notificationBuilder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }

    public void toastNotification(View view){
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("Breaking News");
        notificationBuilder.setSmallIcon(R.drawable.notifaction);
        notificationBuilder.setContentText("Today Code Ignitor has to work till 6:30 PM");
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notifaction));
        notificationBuilder.setTicker("Important Announcement");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,new Intent(this,ActivityNavigator.class), PendingIntent.FLAG_CANCEL_CURRENT);
        notificationBuilder.setContentIntent(pendingIntent);
        Utils.toastIt(getBaseContext(),"You Have New Notification");
        Notification notification = notificationBuilder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }

    public void soundNotification(View view){
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("Breaking News");
        notificationBuilder.setSmallIcon(R.drawable.notifaction);
        notificationBuilder.setContentText("Today Code Ignitor has to work till 6:30 PM");
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notifaction));
        notificationBuilder.setTicker("Important Announcement");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,new Intent(this,ActivityNavigator.class), PendingIntent.FLAG_CANCEL_CURRENT);
        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.setDefaults(Notification.DEFAULT_SOUND);
        Notification notification = notificationBuilder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }

    public void vibrateNotification(View view){
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("Breaking News");
        notificationBuilder.setSmallIcon(R.drawable.notifaction);
        notificationBuilder.setContentText("Today Code Ignitor has to work till 6:30 PM");
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notifaction));
        notificationBuilder.setTicker("Important Announcement");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,new Intent(this,ActivityNavigator.class), PendingIntent.FLAG_CANCEL_CURRENT);
        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
        Notification notification = notificationBuilder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }

    public void ledNotification(View view){
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("Breaking News");
        notificationBuilder.setSmallIcon(R.drawable.notifaction);
        notificationBuilder.setContentText("Today Code Ignitor has to work till 6:30 PM");
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notifaction));
        notificationBuilder.setTicker("Important Announcement");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,new Intent(this,ActivityNavigator.class), PendingIntent.FLAG_CANCEL_CURRENT);
        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.setDefaults(Notification.DEFAULT_LIGHTS);
        Utils.toastIt(getBaseContext(),"You Have New Notification");
        Notification notification = notificationBuilder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }

    public void generateAllNotification(View view) {

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("Breaking News");
        notificationBuilder.setSmallIcon(R.drawable.notifaction);
        notificationBuilder.setContentText("Today Code Ignitor has to work till 6:30 PM");
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notifaction));
        notificationBuilder.setTicker("Important Announcement");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,new Intent(this,ActivityNavigator.class), PendingIntent.FLAG_CANCEL_CURRENT);
        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.setDefaults(Notification.DEFAULT_ALL);
        Utils.toastIt(getBaseContext(), "You Have New Notification");
        Notification notification = notificationBuilder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);*/
    }

