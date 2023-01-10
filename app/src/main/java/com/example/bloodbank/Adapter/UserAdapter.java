package com.example.bloodbank.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bloodbank.Model.User;
import com.example.bloodbank.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewHolder>{
        private Context context;
        private List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_displayed_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final User user = userList.get(position);
        holder.userType.setText(user.getType());

        if (user.getType().equals("donor")){
            holder.emailNow.setVisibility(View.VISIBLE);
        }
        holder.userEmail.setText(user.getEmail());
        holder.phoneNumber.setText(user.getPhonenumber());
        holder.userName.setText(user.getName());
        holder.bloodGroup.setText(user.getBloodgroup());

        Glide.with(context).load(user.getProfilepictureurl()).into(holder.userProfileImage);

    }

    @Override
    public int getItemCount() {

        return userList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        public CircleImageView userProfileImage;
        public TextView userType,userName,userEmail,bloodGroup,phoneNumber;
        public Button emailNow;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            userProfileImage = itemView.findViewById(R.id.userProfileImage);
            userType = itemView.findViewById(R.id.userType);
            userName = itemView.findViewById(R.id.userName);
            userEmail = itemView.findViewById(R.id.userEmail);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);
            bloodGroup = itemView.findViewById(R.id.bloodGroup);
            emailNow = itemView.findViewById(R.id.emailNow);
        }
    }
}
