package dell.recyclerviewexploration.DataModel;

import java.util.ArrayList;

/**
 * Created by dell on 31-12-2017.
 */

public class Contact {
    private String mName;
    private Boolean mOnline;

    public Contact(String name, Boolean online){
        mName = name;
        mOnline = online;
    }

    public String getmName(){
        return mName;
    }

    public Boolean getmOnline(){
        return mOnline;
    }

    private static int lastContactId=0;

    public static ArrayList<Contact> createContactList(int numContacts){
        ArrayList<Contact> mContacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            mContacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return mContacts;
    }

}
