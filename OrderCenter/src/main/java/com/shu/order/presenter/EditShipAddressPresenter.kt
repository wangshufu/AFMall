package com.shu.order.presenter

import com.shu.base.ext.excute
import com.shu.base.presenter.BasePresenter
import com.shu.base.rx.BaseSubscriber
import com.shu.order.data.protocol.ShipAddress
import com.shu.order.presenter.view.EditShipAddressView
import com.shu.order.service.ShipAddressService
import javax.inject.Inject

/*
    编辑收货人信息Presenter
 */
class EditShipAddressPresenter @Inject constructor() : BasePresenter<EditShipAddressView>() {

    @Inject
    lateinit var shipAddressService: ShipAddressService


    /*
        添加收货人信息
     */
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.addShipAddress(shipUserName,shipUserMobile,shipAddress).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                    mView.onAddShipAddressResult(t)
            }
        }, lifecycleProvider)

    }

    /*
        修改收货人信息
     */
    fun editShipAddress(address: ShipAddress) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.editShipAddress(address).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onEditShipAddressResult(t)
            }
        }, lifecycleProvider)

    }


}
