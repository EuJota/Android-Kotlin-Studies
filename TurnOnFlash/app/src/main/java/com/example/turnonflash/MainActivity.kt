package com.example.turnonflash

import android.content.Context
import android.content.Context.CAMERA_SERVICE
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : AppCompatActivity() {
    private var mCameraManager : CameraManager ?= null
    private var mCameraId : String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isFlashAvailable = applicationContext.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)

        if (!isFlashAvailable)
            println("no flash")

        mCameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager?

        try {
            mCameraId = mCameraManager!!.cameraIdList[0]
        }catch (e : CameraAccessException) {
            println("Erro camera $e");
        }

        btn_turn.setOnClickListener {
            turnOnFlash()
        }
    }

    private fun turnOnFlash() {
        try {
            mCameraManager?.setTorchMode(mCameraId!!, true)
        }catch (e : CameraAccessException) {
            println("Catch fun $e")
        }
    }
}