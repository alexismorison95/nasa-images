package com.alexis.morison.nasaimages.apod.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.alexis.morison.nasaimages.container.ContainerActivity
import com.alexis.morison.nasaimages.R
import com.alexis.morison.nasaimages.apod.models.APOD
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.apod_menu_card.view.*

class ApodItemsAdapter(private val items: List<APOD>) : RecyclerView.Adapter<ApodItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.apod_menu_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size


    class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {

        fun bind(item: APOD) = with(v) {

            apod_card_date.text = item.date
            apod_card_title.text = item.title

            Picasso.get()
                .load(item.url)
                .error(R.drawable.apod)
                .into(apod_card_image)


            apod_card.setOnClickListener {

                val intent = Intent(context, ContainerActivity::class.java).apply {

                    putExtra("id", 1)
                    putExtra("item", item)
                }

                ContextCompat.startActivity(context, intent, null)
            }
        }
    }
}