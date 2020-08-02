package mk.padc.themovie.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModelProviders
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.video_player_view.*
import mk.padc.themovie.R
import mk.padc.themovie.mvp.presenters.VideoPresenter
import mk.padc.themovie.mvp.presenters.impl.VideoPresenterImpl
import mk.padc.themovie.mvp.views.VideosView


class FullScreenVideoActivity : BaseActivity() , VideosView {

    companion object {

        const val movieid = "Movie Id Extra"

        fun newItent(context: MainActivity, mId: Int): Intent {
            val intent = Intent(context, FullScreenVideoActivity::class.java)
            intent.putExtra(movieid, mId)
            return intent
        }
    }

    private lateinit var mPresenter: VideoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_player_view)
        val movie_id = intent.getIntExtra(MovieDetailActivity.movieid, 0)
        setUpPresenter()
        mPresenter.onUiReady(this,movie_id)

    }

    private fun setUpVideoView(videoId: String)
    {
        Log.e("videoId=",videoId);
        lifecycle.addObserver(youtube_player_view)

        youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }



    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(VideoPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayVideo(videoId: String) {
        setUpVideoView(videoId)
    }

}
