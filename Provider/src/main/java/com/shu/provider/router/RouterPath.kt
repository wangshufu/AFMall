package com.shu.provider.router

/**
 * Created by wangshufu on 2018/3/27.
 *
 * 注意:不同的模块间,前面的地址要不同
 *
 */
object RouterPath {

    //用户模块
    class UserCenter{
        companion object {
            const val PATH_LOGIN = "/UserCenter/Login"
        }
    }

    //订单模块
    class OrderCenter{
        companion object {
            const val PATH_ORDER_CONFIRM = "/OrderCenter/Confirm"
        }
    }

    //支付模块
    class PaySDK{
        companion object {
            const val PATH_PAY = "/paySDK/pay"
        }
    }

    //消息模块
    class MessageCenter{
        companion object {
            const val PATH_MESSAGE_PUSH = "/messageCenter/push"
            const val PATH_MESSAGE_ORDER = "/messageCenter/order"
        }
    }
}