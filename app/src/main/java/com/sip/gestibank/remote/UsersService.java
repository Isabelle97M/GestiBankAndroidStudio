package com.sip.gestibank.remote;

import com.sip.gestibank.models.Users;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface UsersService {

    @GET("/user/{email}")
    Call<Users> getUsersByEmail(@Path("email") String email);

}
