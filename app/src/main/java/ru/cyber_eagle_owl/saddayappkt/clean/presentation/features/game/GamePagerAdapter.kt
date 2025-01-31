package ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.cyber_eagle_owl.saddayappkt.base.BaseFragment
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments.CardsInformationFragment
import ru.cyber_eagle_owl.saddayappkt.clean.presentation.features.game.fragments.GameHomeFragment

class GamePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): BaseFragment {
        return when (position) {
            0 -> GameHomeFragment.newInstance()
            1 -> CardsInformationFragment.newInstance()
            else -> throw IllegalArgumentException("Wrong Tab position!!!")
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Information"
            1 -> "Cards"
            else -> throw IllegalArgumentException("Wrong Tab position!!!")
        }
    }
}