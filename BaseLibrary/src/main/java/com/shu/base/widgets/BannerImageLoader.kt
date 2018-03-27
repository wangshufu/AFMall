package com.shu.base.widgets

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.shu.base.utils.GlideUtils
import com.youth.banner.loader.ImageLoader


/*
    Banner图片加载器
 */
class BannerImageLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        GlideUtils.loadUrlImage(context, path.toString(), imageView)
    }
}
