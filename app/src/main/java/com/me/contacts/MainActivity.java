package com.me.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.me.contacts.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String NEXT_SCREEN = "details_screen";
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<ContactsModel> data = new ArrayList<>();
        data.clear();
        data.add(new ContactsModel("musa","7024"));
        data.get(0).setContactName("hussein");
        data.get(0).setContactNumber("7026265398");
        data.add(new ContactsModel("hussein", "79495"));
        data.get(1).setContactName("Kia");
        data.get(1).setContactNumber("7024081188");

        binding.RVContacts.setLayoutManager(new LinearLayoutManager(this));
        binding.RVContacts.setHasFixedSize(true);

        final ContactAdapter contactAdapter = new ContactAdapter(this, data);
        binding.RVContacts.setAdapter(contactAdapter);

//        final String NEXT_SCREEN = "details_screen";
        contactAdapter.setOnClickListener(new ContactAdapter.OnClickListener() {
            @Override
            public void onClick(int position, ContactsModel model) {
                Intent intent = new Intent(MainActivity.this, ContactDetail.class);
                intent.putExtra(NEXT_SCREEN, (CharSequence) model);
                startActivity(intent);
            }
        });



//        RecyclerView recyclerView = findViewById(R.id.RVContacts);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new ContactAdapter(this, data));



    }
}