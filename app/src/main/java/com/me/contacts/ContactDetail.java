package com.me.contacts;

import android.os.Bundle;

import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;

import com.me.contacts.databinding.ActivitycontactdetailBinding;
import com.me.contacts.databinding.ContactItemBinding;

public class ContactDetail extends AppCompatActivity {

    private ActivitycontactdetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitycontactdetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Object OnBackPressedDispatcher;
//        binding.toolbar.setNavigationOnClickListener(view -> OnBackPressedDispatcher);

        ContactsModel contactList = null;

        // checking if the intent has extra
        if (getIntent().hasExtra(MainActivity.NEXT_SCREEN)) {
            // get the Serializable data model class with the details in it
            contactList = (ContactsModel) getIntent().getSerializableExtra(MainActivity.NEXT_SCREEN);
        }
        // it the emplist is not null the it has some data and display it
        if (contactList != null) {
            binding.displayName.setText(contactList.getContactName());
//        (contactList.getName());  // displaying name
            binding.displayEmail.setText(contactList.getContactNumber()); // displaying email
        }
    }
}
