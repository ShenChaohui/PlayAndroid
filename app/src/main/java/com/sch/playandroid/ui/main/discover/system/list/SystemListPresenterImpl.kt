package com.sch.playandroid.ui.main.discover.system.list

import android.util.Log
import com.sch.playandroid.constants.Constants
import com.sch.playandroid.entity.ArticleBean
import com.sch.playandroid.util.GsonUtil
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import org.xutils.common.Callback
import org.xutils.http.RequestParams
import org.xutils.x

/**
 * Created by Sch.
 * Date: 2020/4/21
 * description:
 */
class SystemListPresenterImpl(var view: SystemListContract.ISystemListView) :
    SystemListContract.ISystemListPresenter {
    override fun getListData(curPage: Int, cid: Int) {
        var url: String = "https://www.wanandroid.com/article/list/$curPage/json?cid=$cid"
        val requestParams = RequestParams(url)
        x.http().get(requestParams, object : Callback.CommonCallback<String> {
            override fun onFinished() {
            }

            override fun onSuccess(result: String?) {
                doAsync {
                    val obj = JSONObject(result)
                    val data = obj.getJSONObject("data")

                    val datas = GsonUtil.parseJsonArrayWithGson(
                        data.getString("datas"),
                        ArticleBean::class.java
                    )
                    uiThread {
                        view?.setListData(datas)
                    }
                }
            }

            override fun onCancelled(cex: Callback.CancelledException?) {
            }

            override fun onError(ex: Throwable?, isOnCallback: Boolean) {
                Log.e("test", ex.toString())
                view?.setError(ex.toString())
            }
        })
    }

}