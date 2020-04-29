package com.sch.playandroid.ui.main.discover.navigation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sch.playandroid.R
import com.sch.playandroid.adapter.NavigationAdapter
import com.sch.playandroid.base.LazyFragment
import com.sch.playandroid.constants.Constants
import com.sch.playandroid.entity.NavigationBean
import com.sch.playandroid.ui.web.WebActivity
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * 导航
 */

class NavigationFragment : LazyFragment(), NavigationContract.INavigationView {
    private val navigationAdapter by lazy { NavigationAdapter() }
    private val navigationList by lazy { mutableListOf<NavigationBean>() }
    private val presenterImpl by lazy { NavigationPresenterImpl(this) }

    override fun lazyInit() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = navigationAdapter
        recyclerView.overScrollMode = RecyclerView.OVER_SCROLL_NEVER//取消滑动到顶部边界越界效果

        initListener()
        //加载中动画
        loadingTip.loading()
        presenterImpl.getNavigationData()
    }

    private fun initListener() {
        navigationAdapter.setStstemClickListener(object :
            NavigationAdapter.OnNavigationClickListener {
            override fun onCollectClick(navigationPosition: Int, navigationChildrenPosition: Int) {
                intent(Bundle().apply {
                    putString(
                        Constants.WEB_TITLE,
                        navigationList[navigationPosition].articles[navigationChildrenPosition].title
                    )
                    putString(
                        Constants.WEB_URL,
                        navigationList[navigationPosition].articles[navigationChildrenPosition].link
                    )
                }, WebActivity::class.java, false)
            }
        })
        // 设置无网络时重新加载点击事件
        loadingTip.setReloadListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                loadingTip.loading()
                presenterImpl.getNavigationData()
            }
        })


    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_list
    }

    override fun setNavigationData(list: MutableList<NavigationBean>) {
        loadingTip.dismiss()
        navigationList.clear()
        navigationList.addAll(list)
        navigationAdapter.updata(navigationList)
    }

    override fun onError(ex: String) {
        loadingTip.showInternetError()
    }

}