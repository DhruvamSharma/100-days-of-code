package dell.recyclerviewexploration.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import dell.recyclerviewexploration.DataModel.Contact;
import dell.recyclerviewexploration.R;

/**
 * Created by dell on 31-12-2017.
 */
// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {



    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        TextView nameTextView;
        Button messageButton;


        ViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.contact_name);
            messageButton = itemView.findViewById(R.id.message_button);
        }



    }

    // Store a member variable for the contacts
    private List<Contact> mContacts;
    // Store the context for easy access
    private Context mContext;


    // Pass in the contact array into the constructor
    public ContactsAdapter(Context context, List<Contact> contacts) {
        mContacts = contacts;
        mContext = context;
    }
    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        Log.v("creatingViewHolderTimes", "..........CREATE..........");
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.row_layout_file, parent, false);
        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Contact contact = mContacts.get(position);
        Log.v("bindingTimes", "..........BIND..........");
        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(contact.getmName());
        Button button = viewHolder.messageButton;
        button.setText(contact.getmOnline() ? "Message" : "Offline");
        button.setEnabled(contact.getmOnline());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }


}
