package com.example.optimus158.virtualcontactmanager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by optimus158 on 08-Aug-15.
 * <p/>
 * Activity Class for setting different fragments to activity as per user interaction
 */
public class ContactDetails extends AppCompatActivity {

    private FragmentManager fragmentManager = getFragmentManager();
    private ContactsModel contactModel;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_contact_details);

        // gets the ContactsModel object to use in corresponding frames
        Intent intent = getIntent();
        contactModel = (ContactsModel) intent
                .getSerializableExtra("selectedContact");
        String option = intent.getStringExtra("option");

        FragmentTransaction transaction;
        if (option.equalsIgnoreCase("add")) {
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frameLayout, new ContactAddFragment());
            transaction.commit();
        } else if (option.equalsIgnoreCase("browse")) {
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frameLayout, new ContactBrowseFragment());
            transaction.commit();
        } else if (option.equalsIgnoreCase("edit")) {
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frameLayout, new ContactEditFragment());
            transaction.commit();
        }
    }

    /**
     * Method for facilitating the onActivityResult in fragment
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Method for accessing the ContactsModel object within fragment (activity-fragment communication)
     *
     * @ return
     */
    public ContactsModel getContactModel() {
        return contactModel;
    }
}
