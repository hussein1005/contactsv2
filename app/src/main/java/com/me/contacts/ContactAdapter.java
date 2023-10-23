package com.me.contacts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;
import java.util.List;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<ContactsModel> contactList;
    private View.OnClickListener onClickListener;

    public ContactAdapter(Context context, ArrayList<ContactsModel> contactList) {
        this.context = context;
        this.contactList = contactList;
    }


    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);

        return new ViewHolder(view);
    }

    public void filterList(ArrayList<ContactsModel> filterlist) {
        contactList = filterlist;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {

ContactsModel model = contactList.get(position);
holder.contactName.setText(model.getContactName());

        ColorGenerator generator = ColorGenerator.MATERIAL;

        int color = generator.getRandomColor();
        int gradient = R.drawable.lettercard;
        TextDrawable drawable = new TextDrawable.Builder()
                .setShape(TextDrawable.SHAPE_ROUND)
                .setColor(color)
                .setText("A")
                .setFontSize(60)
                .setRadius(2)
                .build();

        holder.contactImage.setImageDrawable(drawable);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context, ContactDetail.class);
//                i.putExtra("name", model.getContactName());
//                i.putExtra("contact", model.getContactNumber());
//                context.startActivity(i);
//            }
//        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = (View.OnClickListener) onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, ContactsModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView contactImage;
        public TextView contactName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contactImage = itemView.findViewById(R.id.contactImage);
            contactName = itemView.findViewById(R.id.contactName);
        }
    }
}
