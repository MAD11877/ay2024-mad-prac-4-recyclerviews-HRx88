package sg.edu.np.mad.madpractical4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //setContentView(R.layout.custom_activity_list);
        ImageView imagev1 = findViewById(R.id.ivsmallImage);
        ImageView imageView2 = findViewById(R.id.ivsmallImage);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder  = new AlertDialog.Builder(ListActivity.this);

                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(true);
                builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int n = new Random().nextInt(999999);
                        Intent main = new Intent(ListActivity.this,MainActivity.class);
                        main.putExtra("num",n);
                        startActivity(main);




                    }
                });
                builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alert=builder.create();
                alert.show();

            }
        });

        ArrayList<User> myUser_list= new ArrayList<>();
        for (int i=0;i<20;i++){
            int name = new Random().nextInt(99999);
            int description = new Random().nextInt(99999);
            boolean followed = new Random().nextBoolean();

            User user=new User("John Doe","MAD Developer",1,false);
            user.setName("Name"+String.valueOf(name));
            user.setDescription("Description "+String.valueOf(description));
            user.setFollowed(followed);
            myUser_list.add(user);


        }

        UserAdapter userAdapter = new UserAdapter(myUser_list,this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);
    }
}