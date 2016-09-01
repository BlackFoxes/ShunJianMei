package cc.ruit.shunjianmei.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import cc.ruit.shunjianmei.R;
import cc.ruit.shunjianmei.base.BaseFragment;
import cc.ruit.shunjianmei.home.MainActivity;
import cc.ruit.shunjianmei.usermanager.UserManager;
import cc.ruit.shunjianmei.util.FragmentManagerUtils;

import com.umeng.analytics.MobclickAgent;
/**
 * 
 * @ClassName: WelcomeFragment
 * @Description: 欢迎页
 * @author: lee
 * @date: 2015年10月8日 下午6:40:40
 */
public class WelcomeFragment extends BaseFragment{
	
	public void onResume() {
	    super.onResume();
	    MobclickAgent.onPageStart("WelcomeFragment"); //统计页面
	}
	public void onPause() {
	    super.onPause();
	    MobclickAgent.onPageEnd("WelcomeFragment"); 
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	/**
	 * 
	 * @Title: initView
	 * @Description: 初始化欢迎界面
	 * @param inflater
	 * @return
	 * @see cc.ruit.miximixi.base.BaseFragment#initView(android.view.LayoutInflater)
	 */
	@Override
	public View initView(LayoutInflater inflater) {
		view=inflater.inflate(R.layout.welcome_fragment, null);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				if (UserManager.getUserID() <=0) {
					LoginFragment fg = new LoginFragment();
					Bundle bundle = new Bundle();
					bundle.putString("from",
							WelcomeFragment.class.getSimpleName());
					fg.setArguments(bundle);
					FragmentManagerUtils.add(activity, R.id.content_frame,
							fg, false);
				}else {
					Intent intent = MainActivity.getIntent(activity);
					startActivity(intent);
					activity.finish();
				}
			}

		}, 2000);
		return view;
	}

}
