package com.rizz.test.core.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

import com.rizz.test.R


class GifProgressDialog(private val context: Context) {
    private val dialog: Dialog?

    private val view: View
        @SuppressLint("InflateParams")
        get() {
            val view = LayoutInflater.from(context).inflate(R.layout.dialog_gif, null)
            val gifImageView: ImageView = view.findViewById(R.id.gifImageView)

            try {
                Glide.with(context)
                    .asGif()
                    .load(R.drawable.loading)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(gifImageView)
            } catch (e: Exception) {
                Log.e("GifProgressDialog", "Failed to load GIF", e)
            }

            return view
        }

    val isShowing: Boolean
        get() = dialog!!.isShowing

    init {

        dialog = Dialog(context, R.style.ProgressDialog)
        dialog.setCancelable(false)
        dialog.setContentView(view)
    }

    fun showDialog() {
        if (dialog != null && !dialog.isShowing && !(context as Activity).isFinishing)
            dialog.show()
    }

    fun dismissDialog() {

        if (dialog != null && !(context as Activity).isFinishing)
            dialog.dismiss()
    }


    fun setCancelable(cancelable: Boolean) {
        dialog!!.setCancelable(cancelable)
    }

}
