package com.mobcb.android.keyboard.demo.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * create by lvmenghui
 * on 2018-03-22
 */
public class SIMCardUtils {
	/**
	 * TelephonyManager提供设备上获取通讯服务信息的入口。 应用程序可以使用这个类方法确定的电信服务商和国家 以及某些类型的用户访问信息。
	 * 应用程序也可以注册一个监听器到电话收状态的变化。不需要直接实例化这个类
	 * 使用Context.getSystemService(Context.TELEPHONY_SERVICE)来获取这个类的实例。
	 */
	private TelephonyManager telephonyManager;
	/**
	 * 国际移动用户识别码
	 */
	private String IMSI;

	public SIMCardUtils(Context context) {
		telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
	}

	/**
	 * Role:获取当前设置的电话号码 <BR>
	 * Date:2012-3-12 <BR>
	 * @author CODYY)peijiangping
	 */
	@SuppressLint("MissingPermission")
    public String getNativePhoneNumber() {
		String nativePhoneNumber = null;
		try{
			nativePhoneNumber = telephonyManager.getLine1Number();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return nativePhoneNumber;
	}

	/**
	 * Role:Telecom service providers获取手机服务商信息 <BR>
	 * 需要加入权限<uses-permission
	 * android:name="android.permission.READ_PHONE_STATE"/> <BR>
	 * Date:2012-3-12 <BR>
	 *
	 * @author CODYY)peijiangping
	 */
	public String getProvidersName() {
		String providersName = null;
		try{
			// 返回唯一的用户ID;就是这张卡的编号神马的
			IMSI = telephonyManager.getSubscriberId();
			if (IMSI != null) {
				// IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。
				System.out.println(IMSI);
				if (IMSI.startsWith("46000") || IMSI.startsWith("46002")) {
					providersName = "中国移动";
				} else if (IMSI.startsWith("46001")) {
					providersName = "中国联通";
				} else if (IMSI.startsWith("46003")) {
					providersName = "中国电信";
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return providersName;
	}
}
