package io.flutter.plugins.inapppurchase

import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.SkuDetails
import androidx.annotation.Keep

/**
 * @author bezier
 * @date 2023/10/16 19:18
 * @version 1.0
 * @description:谷歌商品信息
 * [productDetails] 新版本google商店查询返回的类
 * [skuDetails] 旧版本google商店查询返回的类
 */
@Keep
data class GoogleProductDetails(
    val productDetails: ProductDetails?,
    val skuDetails: SkuDetails?,
) {
    /**
     * 判断是否使用新的google支付流程api
     */
    fun isNewApi(): Boolean {
        return productDetails != null
    }

    fun getProductType(): String? {
        return productDetails?.productType ?: skuDetails?.type
    }

    fun getProductId(): String? {
        return productDetails?.productId ?: skuDetails?.sku
    }
}