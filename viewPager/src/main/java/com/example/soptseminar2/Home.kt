package com.example.soptseminar2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.soptseminar2.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class Home : Fragment() {
    var datas: MutableList<InstaData> = mutableListOf()
    lateinit var instaAdapter:InstaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter= InstaAdapter(view.context)
//        var lm=LinearLayoutManager(view.context)
//        lm.orientation= VERTICAL
//        rv_home.layoutManager= lm
        rv_home.adapter=instaAdapter
        rv_home.addItemDecoration(InstaDeco())
        loadDatas()
    }

    private fun loadDatas() {
        datas.apply {
            add(
                InstaData(
                    title= "rlarkdud",
                    content = "오렌지 dlrjtdlqslek",
                    img_url = "https://recipe1.ezmember.co.kr/cache/data/goods/20/04/14/1000006742/1000006742_detail_083.jpg"
                )
            )
            add(
                InstaData(
                    title= "김가영",
                    content = "안ㅇ러내ㅑ렁 dlrjtdlqslek",
                    img_url = "https://recipe1.ezmember.co.kr/cache/data/goods/20/03/12/1000006558/1000006558_detail_050.jpg"
                )
            )
            add(
                InstaData(
                    title= "낭러ㅣ나얼",
                    content = "sodyddms 내용입니다.",
                    img_url = "https://recipe1.ezmember.co.kr/cache/recipe/2019/02/13/1061531003609d41ee128e7434dc75871.jpg"
                )
            )
            add(
                InstaData(
                    title= "rlarkdud",
                    content = "오렌지 dlrjtdlqslek",
                    img_url = "https://recipe1.ezmember.co.kr/cache/data/goods/20/04/14/1000006742/1000006742_detail_083.jpg"
                )
            )
            add(
                InstaData(
                    title= "김가영",
                    content = "안ㅇ러내ㅑ렁 dlrjtdlqslek",
                    img_url = "https://recipe1.ezmember.co.kr/cache/data/goods/20/03/12/1000006558/1000006558_detail_050.jpg"
                )
            )
            add(
                InstaData(
                    title= "낭러ㅣ나얼",
                    content = "sodyddms 내용입니다.",
                    img_url = "https://recipe1.ezmember.co.kr/cache/recipe/2019/02/13/1061531003609d41ee128e7434dc75871.jpg"
                )
            )
        }
        instaAdapter.datas=datas
        instaAdapter.notifyDataSetChanged()

    }


}
