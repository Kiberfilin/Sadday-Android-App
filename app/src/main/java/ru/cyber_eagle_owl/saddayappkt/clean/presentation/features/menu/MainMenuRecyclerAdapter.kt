package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.menu

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_menu_item.view.*
import ru.cyber_eagle_owl.saddayappkt.R
import timber.log.Timber

class MainMenuRecyclerAdapter(private val context: Context) :
    androidx.recyclerview.widget.RecyclerView.Adapter<MainMenuRecyclerAdapter.MainMenuItemViewHolder>() {

    //    private lateinit var titlesOfMainMenuItems: HashMap<Int, Int>
    private var titlesOfMainMenuItems = hashMapOf<Int, Int>()
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
        Timber.d("onCreateViewHolder")

        val view = LayoutInflater.from(context).inflate(R.layout.main_menu_item, parent, false)

        return MainMenuItemViewHolder(view, onMenuItemClickListener)
    }

    override fun getItemCount(): Int {
        Timber.d("getItemCount()")

        return titlesOfMainMenuItems.size
    }

    override fun onBindViewHolder(holder: MainMenuItemViewHolder, position: Int) {
        Timber.d("onBindViewHolder")

        titlesOfMainMenuItems[position]?.let { holder.view.mainMenuItemTextview.setText(it) }
        holder.view.setTag(R.string.tag_main_menu_item_title_type, titlesOfMainMenuItems[position])
    }

    class MainMenuItemViewHolder(val view: View, onMenuItemClickListener: OnMenuItemClickListener) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                val tmpResId: Int = it.getTag(R.string.tag_main_menu_item_title_type) as Int
                onMenuItemClickListener.onMenuItemClick(tmpResId)
            }
        }
    }

    interface OnMenuItemClickListener {

        fun onMenuItemClick(itemTitle: Int)
    }
}