package mk.padc.themovie.datas.dummy
import mk.padc.themovie.datas.vos.CastVO
import mk.padc.themovie.datas.vos.CrewVO

fun getDummyCastList() : List<CastVO> {

    val data1 = CastVO(1,1,"Movie1","Movie Desc1",1,"",1,"")
    val data2 = CastVO(2,2,"Movie2","Movie Desc2",2,"",2,"")
    return arrayListOf(data1,data2)
}

fun getDummyCrewList(): List<CrewVO>
{
    val data1 = CrewVO(1,"1","Movie1",1,"male","Name1","1/2/10")
    val data2 = CrewVO(2,"2","Movie2",2,"female","Name2","1/3/10")
    return arrayListOf(data1,data2)
}