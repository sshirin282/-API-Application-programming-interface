package com.example.api

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ap3.newInstance] factory method to
 * create an instance of this fragment.
 */
class ap3 : Fragment() {
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
        val url:String="https://rickandmortyapi.com/api/character/"
        val gridView:GridView=view.findViewById(R.id.gridView)
        var adapter:Adapter3
        val i:Int=0
        val list:ArrayList<DataModel2> = ArrayList<DataModel2>()

        val request: StringRequest = StringRequest(Request.Method.GET,url, {
            Log.e("shirin",it)

            val ja: JSONObject = JSONObject(it)
            val jsonArray: JSONArray =ja.getJSONArray("results")

            for (i in 0 until jsonArray.length()) {
                val js: JSONObject = jsonArray.getJSONObject(i)
                val id: String = js.getString("id")
                val name: String = js.getString("name")
                val status: String = js.getString("status")
                val species: String = js.getString("species")
                val type: String = js.getString("type")
                val gender: String = js.getString("gender")
                val image: String = js.getString("image")

                val dataModel = DataModel2()
                dataModel.id = id
                dataModel.name = name
                dataModel.status = status
                dataModel.species = species
                dataModel.type = type
                dataModel.gender = gender
                dataModel.image = image
                list.add(dataModel)
            }
            adapter=Adapter3(context,list)
//            val layoutManager= LinearLayoutManager(context)
//            recyclerView.layoutManager=layoutManager
            gridView.adapter=adapter

        }, {
            Log.e("error",it.toString())
        })
        val queue= Volley.newRequestQueue(context)
        queue.add(request)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ap3, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ap3.
         */
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ap3.
         */

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ap3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}