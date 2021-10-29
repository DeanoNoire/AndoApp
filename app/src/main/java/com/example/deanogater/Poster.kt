package com.example.deanogater

import android.content.Context
import android.util.Log
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

class Poster {

    fun zmenStav(typ: Int, context: Context, url: String) {
        val queue = Volley.newRequestQueue(context)
        var urlX = ""
        if (typ == 1) {
            urlX = "http://nightingales.clanweb.eu/doGate.php"
        }


//        val stringRequest = StringRequest(Request.Method.GET, urlX,
//            { response ->
//                var strResp = response.toString()
//        Log.d(strResp)
//        },
//            { Log.d("Nefunguje") }
//            )
//        queue.add(stringRequest)

//

    }
}