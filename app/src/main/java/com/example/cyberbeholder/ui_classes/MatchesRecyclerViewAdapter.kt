package com.example.cyberbeholder.ui_classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cyberbeholder.HeroDetailsFragment
import com.example.cyberbeholder.MatchesFragmentDirections
import com.example.cyberbeholder.R
import com.example.cyberbeholder.databinding.FragmentHeroDetailsBinding
import com.example.cyberbeholder.models.HeroModel
import com.squareup.picasso.Picasso


class MatchesRecyclerViewAdapter (private val data_list: List<HeroModel>) :
        RecyclerView.Adapter<MatchesRecyclerViewAdapter.MatchesViewHolder>(){

    class MatchesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val heroNameTextView: TextView
        val heroRoleTextView: TextView
        val image: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            heroNameTextView = view.findViewById(R.id.hero_name)
            heroRoleTextView = view.findViewById(R.id.hero_role)
            image = view.findViewById(R.id.hero_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
                .inflate(R.layout.matches_recycler_view_item, parent, false)

        return MatchesViewHolder(
                inflater
        )
    }

    override fun getItemCount() = data_list.count()

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        val myData: HeroModel = data_list[position]

        holder.heroNameTextView.text = myData.name
        holder.heroRoleTextView.text = myData.role
        Picasso.get().load(myData.portrait_url).into(holder.image)

        holder.itemView.setOnClickListener{
            val action = MatchesFragmentDirections.actionMatchesFragmentToHeroDetailsFragment(myData.id)
            holder.itemView.findNavController().navigate(action)
        }
    }
}



/*
class MatchesRecyclerViewAdapter (private val data_list: List<TestDataClass>) :
        RecyclerView.Adapter<MatchesRecyclerViewAdapter.MatchesViewHolder>(){

    class MatchesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val matcheInfoTextView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            matcheInfoTextView = view.findViewById(R.id.match_info_text_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
                .inflate(R.layout.matches_recycler_view_item, parent, false)

        return MatchesViewHolder(
                inflater
        )
    }

    override fun getItemCount() = data_list.count()

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        val myData: TestDataClass = data_list[position]

        holder.matcheInfoTextView.text = myData.dataStr
    }
}
* */