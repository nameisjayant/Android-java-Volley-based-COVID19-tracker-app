package com.jayant.sudo.Utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Singleton {

    private static Singleton msingleton;
    private RequestQueue requestQueue;
    private Context context;

    public RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
        {
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public Singleton(Context context)
    {
        this.context=context;
        requestQueue=getRequestQueue();
    }

    public static synchronized Singleton getInstance(Context context)
    {
        if(msingleton == null)
        {
            msingleton=new Singleton(context);
        }
        return msingleton;
    }

    public void addToRequestQueue(Request request)
    {
        requestQueue.add(request);
    }
}
