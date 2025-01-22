//package com.rizz.test.feature.user.presentation.ui.activity
//
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import com.rizz.test.R
//import com.rizz.test.core.presentation.BaseActivity
//import com.rizz.test.core.presentation.ViewModelFactory
//import javax.inject.Inject
//
//class UserActivity : BaseActivity() {
//
//    @Inject
//    lateinit var viewModelFactory: ViewModelFactory
//
//    companion object{
//        fun newInstance(context: Context): Intent {
//            return Intent(context, UserActivity::class.java)
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user)
//    }
//
//}
