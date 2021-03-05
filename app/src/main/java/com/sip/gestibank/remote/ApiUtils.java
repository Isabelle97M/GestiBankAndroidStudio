package com.sip.gestibank.remote;

import com.sip.gestibank.models.Users;

public class ApiUtils {


    private ApiUtils(){
    };

    public static final String API_URL_USERS = "http://192.168.1.72:90";

    public static final String API_CURRENCY = "http://api.currencylayer.com/";


    public static CustomerService getCustomerService(){
        return RetrofitClient.getClient(API_URL_USERS).create(CustomerService.class);
    }

    public static AgentService getAgentService(){
        return RetrofitClient.getClient(API_URL_USERS).create(AgentService.class);
    }

    public static UsersService getUsersService(){
        return RetrofitClient.getClient(API_URL_USERS).create(UsersService.class);
    }

    public static CurrencyService getCurrencyService(){
        return RetrofitClient.getClient(API_CURRENCY).create(CurrencyService.class);
    }

}
