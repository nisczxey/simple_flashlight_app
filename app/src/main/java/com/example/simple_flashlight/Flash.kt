package com.example.simple_flashlight

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager

data class Flash(
    val context: Context
) {
    private var flashStatusOn: Boolean = false

    fun flashOn() {
        activateFlash(true)
    }

    fun flashOff() {
        activateFlash(false)
    }

    fun isFlashStatusOn(): Boolean {
        return flashStatusOn
    }

    private fun activateFlash(isToggleFlashOn: Boolean) {
        val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            val cameraId = cameraManager.cameraIdList[BACK_CAMERA_ID]
            cameraManager.setTorchMode(cameraId, isToggleFlashOn)
            flashStatusOn = isToggleFlashOn
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    companion object{
        const val BACK_CAMERA_ID = 0
    }
}