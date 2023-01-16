package se.oscargynning.pia11recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.Viewholder>() {

    var people = mutableListOf<String>("Arne","Bartil","Cesar")

    class Viewholder(view : View) : RecyclerView.ViewHolder(view){

    val personName : TextView
    val personNumber : TextView
        init {
            personName = view.findViewById(R.id.personNameTV)
            personNumber = view.findViewById(R.id.personNumberTv)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        Log.i("pia11debug","Skapa rad")
                    val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent,
        false)

        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        Log.i("pia11debug","Skapa rad" + position.toString())

        holder.personName.text = people[position]
        holder.personNumber.text = position.toString()

        holder.itemView.setOnClickListener {
            people.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return people.size
    }

}