package com.sip.gestibank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sip.gestibank.models.Users;
import com.sip.gestibank.remote.ApiUtils;
import com.sip.gestibank.remote.UsersService;


import java.nio.Buffer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    UsersService usersService;
    Users user;
    EditText email, password;
    String userEmail, userPassword;
    String role = "INVALID";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emailAuthentification);
        password = findViewById(R.id.pwdAuthentification);
        usersService = ApiUtils.getUsersService();

    }

  public void dashboardUSer(View v) {

      userEmail = email.getText().toString();
      userPassword = password.getText().toString();

      //Toast.makeText(Login.this, "Login : "+ userEmail +" Password : "+ userPassword, Toast.LENGTH_SHORT).show();


      Call<Users> call = usersService.getUsersByEmail(userEmail);

      call.enqueue(new Callback<Users>() {
          @Override
          public void onResponse(Call<Users> call, Response<Users> response) {
              if (response.isSuccessful()) {
                  //System.out.println(response.body());
                  user = response.body();
                  if (user != null) {
                      if (user.getEmail().equals(userEmail) && user.getPassword().equals(userPassword)) {
                          role = user.getRole();

                          switch (role) {

                              case "AGENT":
                                  Intent intentAgent = new Intent(Login.this, AgentHome.class);
                                  intentAgent.putExtra("username", user.getName() + " " + user.getFirstname());
                                  startActivity(intentAgent);

                                  break;

                              case "CUSTOMER":
                                  Intent intentCustomer = new Intent(Login.this, CustomerHome.class);
                                  intentCustomer.putExtra("username", user.getName() + " " + user.getFirstname());
                                  startActivity(intentCustomer);

                                  break;

                              case "ADMINISTRATOR":
                                  Intent intentAdmin = new Intent(Login.this, AdministratorHome.class);
                                  intentAdmin.putExtra("username", user.getName() + " " + user.getFirstname());
                                  startActivity(intentAdmin);

                                  break;
                              default:

                          }

                      } else {
                          Toast.makeText(Login.this, "Email ou mot de passe incorrects !", Toast.LENGTH_SHORT).show();
                      }

                  } else {
                      Toast.makeText(Login.this, "Identifiants inconnus !", Toast.LENGTH_SHORT).show();
                  }
                  } else{
                      System.out.println(response.code());
                  }


          }

          @Override
          public void onFailure(Call<Users> call, Throwable t) {
              Log.e("ERROR: ", t.getMessage());
          }
      });

  }



    /*public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }*/

}