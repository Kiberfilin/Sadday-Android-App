package ru.cyber_eagle_owl.saddayappkt.features.menu

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_menu_item.view.*
import ru.cyber_eagle_owl.saddayappkt.R
import java.util.HashMap

class MainMenuRecyclerAdapter(private val context: Context) :
    RecyclerView.Adapter<MainMenuRecyclerAdapter.MainMenuItemViewHolder>() {

    private lateinit var titlesOfMainMenuItems: HashMap<Int, Int>
    var onMenuItemClickListener: OnMenuItemClickListener

    private val NEWS_ITEM_POSITION = 0
    private val PLACE_ITEM_POSITION = 1
    private val INFORMATION_ITEM_POSITION = 2
    private val TICKETS_ITEM_POSITION = 3
    private val SADDAY_GAME_ITEM_POSITION = 4
    private val FOTO_VIDEO_ITEM_POSITION = 5
    private val ACCOUNT_ITEM_POSITION = 6
    private val ABOUT_ITEM_POSITION = 7

    init {
        onMenuItemClickListener = context as OnMenuItemClickListener
        titlesOfMainMenuItems[NEWS_ITEM_POSITION] = R.string.main_menu_item_title_news
        titlesOfMainMenuItems[PLACE_ITEM_POSITION] = R.string.main_menu_item_title_place
        titlesOfMainMenuItems[INFORMATION_ITEM_POSITION] = R.string.main_menu_item_title_information
        titlesOfMainMenuItems[TICKETS_ITEM_POSITION] = R.string.main_menu_item_title_tickets
        titlesOfMainMenuItems[SADDAY_GAME_ITEM_POSITION] = R.string.main_menu_item_title_sadday_game
        titlesOfMainMenuItems[FOTO_VIDEO_ITEM_POSITION] = R.string.main_menu_item_title_foto_video
        titlesOfMainMenuItems[ACCOUNT_ITEM_POSITION] = R.string.main_menu_item_title_account
        titlesOfMainMenuItems[ABOUT_ITEM_POSITION] = R.string.main_menu_item_title_about
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuItemViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.main_menu_item, parent, false)

        return MainMenuItemViewHolder(view, onMenuItemClickListener)
    }

    override fun getItemCount(): Int {
        return titlesOfMainMenuItems.size
    }

    override fun onBindViewHolder(holder: MainMenuItemViewHolder, position: Int) {

        titlesOfMainMenuItems[position]?.let { holder.v.mainMenuItemTextview.setText(it) }
        holder.v.setTag(R.string.tag_main_menu_item_title_type, titlesOfMainMenuItems[position])
    }

    class MainMenuItemViewHolder(val v: View, onMenuItemClickListener: OnMenuItemClickListener) :
        RecyclerView.ViewHolder(v) {

        init {
            v.setOnClickListener {
                onMenuItemClickListener.onMenuItemClick(it.getTag(R.string.tag_main_menu_item_title_type) as Int)
            }
        }
    }

    interface OnMenuItemClickListener {

        fun onMenuItemClick(stringResIdOfItemTitle: Int)
    }
}