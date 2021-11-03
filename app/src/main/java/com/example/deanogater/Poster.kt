package com.example.deanogater

import android.content.Context
import android.util.Log
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;




    fun zmenStav(typ: Int, pin: String, context: Context, url: String) {
        val requestQueue = Volley.newRequestQueue(context)
        var urlX = ""
        if (typ == 1) {
            urlX = "$url/doGate.php"
        }

        if (typ == 2) {
            urlX = "$url/doGarage.php"
        }

        val parameters: MutableMap<String, String> = HashMap()
        parameters["pin"] = pin

        val strReq = object : StringRequest(
            Request.Method.POST, urlX,
            { response ->  Log.d("POSTER", "response: $response")},
            { error ->Log.d("POSTER",  "error: $error") }
        )

        {
            override fun getParams(): MutableMap<String, String>{
                return parameters;
            }
        }

        requestQueue.add(strReq)

    }

