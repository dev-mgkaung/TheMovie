package mk.padc.themovie.datas.dummy

import mk.padc.themovie.datas.vos.ActorVO


fun getActorList() : List<ActorVO> {

    val data1 = ActorVO(1,true,1,"Movie Desc1","Name1",10.0,"")
    val data2 = ActorVO(2,false,2,"Movie Desc2","Name2",10.0,"")
    return arrayListOf(data1,data2)
}