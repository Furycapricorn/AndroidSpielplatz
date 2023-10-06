package com.example.hello_world;

import static android.content.ContentValues.TAG;
import static androidx.core.content.ContextCompat.getSystemService;

import static com.example.hello_world.BackVault.setBackButtonFunctionality;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hello_world.databinding.FragmentSecondBinding;

import android.app.Notification;
import android.app.NotificationManager;

import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        setBackButtonFunctionality(true);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.buttonNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Noty");
                /*
                final PackageManager pm = getActivity().getPackageManager();
                List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

                for (ApplicationInfo packageInfo : packages){
                    Log.d(TAG, "Installed Package: " + packageInfo.packageName);
                    Log.d(TAG, "Source dir: " + packageInfo.sourceDir);
                    Log.d(TAG, "Launch Activity: " + pm.getLaunchIntentForPackage(packageInfo.packageName));
                }

                */
                //com.android.shell
                //com.sonelli.juicessh

                Activity appsActivity = getActivity();
                Intent appIntent = appsActivity.getPackageManager().getLaunchIntentForPackage("com.sonelli.juicessh");

                if (appIntent != null){
                    System.out.println("meep");
                    startActivity(appIntent);
                }else {
                    System.out.println("geeze");
                    Uri webpage = Uri.parse("https://play.google.com/store/apps/details?id=com.sonelli.juicessh&hl=de&gl=de");
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                    if (webIntent != null){
                        startActivity(webIntent);
                    }
                }

                /*
                Uri webpage = Uri.parse("https://www.android.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                if (webIntent != null){
                    startActivity(webIntent);
                }
                */
                /*
                String tittle="Benachrichtigung";
                String subject="Boom erschreckt!";
                String body="Sheeesh, damit hat ja keiner gerechnet";

                NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notify=new Notification.Builder
                        (getApplicationContext()).setContentTitle(tittle).setContentText(body).
                        setContentTitle(subject).setSmallIcon(R.drawable.abc).build();

                notify.flags |= Notification.FLAG_AUTO_CANCEL;
                notif.notify(0, notify);
                */
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}