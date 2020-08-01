package mk.padc.themovie.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import mk.padc.themovie.datas.vos.GenerVO
import mk.padc.themovie.fragments.MovieFragment

class DynamicPagerAdapter (val generList: List<GenerVO>, fragmentmanager: FragmentManager)
    :FragmentStatePagerAdapter(fragmentmanager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
{
    override fun getItem(position: Int): Fragment {
       return  MovieFragment.newInstance(generList[position].id)
    }

    override fun getCount(): Int {
       return  generList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return generList[position].name
    }
}