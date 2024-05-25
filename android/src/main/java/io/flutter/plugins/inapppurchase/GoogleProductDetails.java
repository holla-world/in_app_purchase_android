package io.flutter.plugins.inapppurchase;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;

import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.SkuDetails;


/**
 * 谷歌商品信息
 *
 * @author bezier
 * @version 1.0
 * @date 2023/10/16 19:18
 * @description: [productDetails] 新版本google商店查询返回的类
 * [skuDetails] 旧版本google商店查询返回的类
 */
@Keep
public class GoogleProductDetails {
    @Nullable
    private final ProductDetails productDetails;
    @Nullable
    private final SkuDetails skuDetails;

    public GoogleProductDetails(@Nullable ProductDetails productDetails, @Nullable SkuDetails skuDetails) {
        this.productDetails = productDetails;
        this.skuDetails = skuDetails;
    }

    /**
     * 判断是否使用新的google支付流程api
     */
    public boolean isNewApi() {
        return productDetails != null;
    }

    public String getProductType() {
        return productDetails != null ? productDetails.getProductType() : skuDetails != null ? skuDetails.getType() : null;
    }

    public String getProductId() {
        return productDetails != null ? productDetails.getProductId() : skuDetails != null ? skuDetails.getSku() : null;
    }

    // getters
    @Nullable
    public ProductDetails getProductDetails() {
        return productDetails;
    }

    @Nullable
    public SkuDetails getSkuDetails() {
        return skuDetails;
    }
}
