package mk.padc.themovie.uitest

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import mk.padc.themovie.R
import mk.padc.themovie.activities.MainActivity
import mk.padc.themovie.views.viewholders.PopularMovieViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class BackScreenFromDetailToMain {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnBurger_navigateToBurgerDetails() {

        Espresso.onView(ViewMatchers.withId(R.id.popular_movies_recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<PopularMovieViewHolder>(0,
                    ViewActions.click()
                ))

        Espresso.onView(ViewMatchers.withId(R.id.movietitle))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        Espresso.onView(ViewMatchers.withId(R.id.back))
            .perform(click())

        Espresso.onView(ViewMatchers.withId(R.id.apptitle))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}