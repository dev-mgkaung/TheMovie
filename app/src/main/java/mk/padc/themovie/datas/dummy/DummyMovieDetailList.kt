package mk.padc.themovie.datas.dummy
import mk.padc.themovie.datas.vos.MovieDetailsVO

fun getDummyMovieDetail() : MovieDetailsVO {

    return MovieDetailsVO(1,true,1,"home","Movie Desc1","en",
        "aa","overview",
        10.0,"","1/2/10",
        0,0,"aa","","",true,10.0,1)
}