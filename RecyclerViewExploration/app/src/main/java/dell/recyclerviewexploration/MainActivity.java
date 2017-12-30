package dell.recyclerviewexploration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import dell.recyclerviewexploration.Adapter.ContactsAdapter;
import dell.recyclerviewexploration.DataModel.Contact;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = Contact.createContactList(30);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(this, contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }
}
