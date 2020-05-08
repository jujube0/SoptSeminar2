package com.example.soptseminar2.webToon


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soptseminar2.R
import kotlinx.android.synthetic.main.fragment_library.*

/**
 * A simple [Fragment] subclass.
 */
class Library : Fragment() {
    var datas= mutableListOf<WebtData>()
    lateinit var webtAdapter: WebtAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webtAdapter= WebtAdapter(view.context)
        webt_rv.adapter=webtAdapter
        loadDatas()
    }

    private fun loadDatas() {
        datas.apply {
            add( WebtData("유미의 세포들","이동건","https://recipe1.ezmember.co.kr/cache/data/goods/20/04/14/1000006742/1000006742_detail_083.jpg"))
            add(WebtData("복학왕","기안84","https://recipe1.ezmember.co.kr/cache/data/goods/20/03/12/1000006558/1000006558_detail_050.jpg"))
            add(WebtData("연놈","상하","https://recipe1.ezmember.co.kr/cache/recipe/2019/02/13/1061531003609d41ee128e7434dc75871.jpg"))
            add( WebtData("유미의 세포들","이동건","https://recipe1.ezmember.co.kr/cache/data/goods/20/04/14/1000006742/1000006742_detail_083.jpg"))
            add(WebtData("복학왕","기안84","https://recipe1.ezmember.co.kr/cache/data/goods/20/03/12/1000006558/1000006558_detail_050.jpg"))
            add(WebtData("연놈","상하","https://recipe1.ezmember.co.kr/cache/recipe/2019/02/13/1061531003609d41ee128e7434dc75871.jpg"))
            add( WebtData("유미의 세포들","이동건","https://recipe1.ezmember.co.kr/cache/data/goods/20/04/14/1000006742/1000006742_detail_083.jpg"))

        }
        webtAdapter.datas=datas
        webtAdapter.notifyDataSetChanged()
    }


}
