package mk.padc.themovie.datas.dummy

import mk.padc.themovie.datas.vos.DiscoverVO

fun getDummyDiscoverList() : List<DiscoverVO> {

    val data1 = DiscoverVO(1,"","Movie1","Movie Desc1",10.0,"","1/2/10","",10.0,10)
    val data2 = DiscoverVO(2,"","Movie2","Movie Desc2",20.0,"","1/3/10","",20.0,20)
    return arrayListOf(data1,data2)
}