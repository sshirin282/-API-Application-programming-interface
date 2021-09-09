package com.example.api

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Request.Method.GET
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.okhttp.Response
import org.json.JSONArray
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ap1.newInstance] factory method to
 * create an instance of this fragment.
 */
class ap1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url: String = "https://jsonplaceholder.typicode.com/posts"
        val recyclerView:RecyclerView=view.findViewById(R.id.recy)
        val list:ArrayList<DataModel1> = ArrayList<DataModel1>()
        var adepter:Adapter1
        val i:Int=0
       val request:StringRequest= StringRequest(Request.Method.GET,url,{
               Log.e("shirin",it)
           val jb:JSONArray=JSONArray(it)

           for(i in 0 until jb.length()){
               val jsonObject:JSONObject=jb.getJSONObject(i)
               val userID:String=jsonObject.
                       getString("userId")
               val id:String=jsonObject.getString("id")
               val title:String=jsonObject.getString("title")
               val body:String=jsonObject.getString("body")

               val dataModel1=DataModel1()
               dataModel1.userId=userID
               dataModel1.id=id
               dataModel1.title=title
               dataModel1.body=body
               list.add(dataModel1)
           }
           adepter=Adapter1(context,list)
           val layoutManager= LinearLayoutManager(context)
           recyclerView.layoutManager=layoutManager
           recyclerView.adapter=adepter



       },{
           Log.e("error",it.toString())

        })
        val queue=Volley.newRequestQueue(context)
        queue.add(request)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ap1, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ap1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ap1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}