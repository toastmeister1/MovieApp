package com.joseph.tmdb_mvvm.ui.frag.home.model

import com.joseph.tmdb_mvvm.R


object DummyViewPagerInfo{

    //604362
    var p1 = ViewPagerInfo(
            "왓챠 최고 인기작",
            "히트맨, 엑시트 등\n 지금 가장 많이 보는 작품!",
            R.drawable.dummy_p1_image
    )

    // 435603
    var p2 = ViewPagerInfo(
            "10월 3주 신작",
            "싱글 라이더, 브이아이피등",
            R.drawable.dummy_p2_image
    )

    var p3 = ViewPagerInfo(
            "최고 인기 시리즈",
            "상견니, 미세스 아메리카 등",
            R.drawable.dummy_p3_image
    )

    //19913
    var p4 = ViewPagerInfo(
        "가을과 마음의 관계",
        "멜로 영화가 보고싶어졌다.\n가을이었다.",
        R.drawable.dummy_p4_image
    )

    var DUMMY_PAGER_INFO_LIST = arrayListOf<ViewPagerInfo>(p4, p2, p3, p1)

}