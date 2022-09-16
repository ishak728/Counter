package com.ishak.ileriyonlusayac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.ishak.ileriyonlusayac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var runnable= Runnable {  }
    var handler=Handler()
    var sayac=0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }


    fun onClick(view: View){
        when(view.id){
            binding.textStart.id->{
                binding.textStart.isEnabled=false
                run()
            }
            binding.textStop.id->{
                handler.removeCallbacks(runnable)
                binding.textTime.text=sayac.toString()
                binding.textStart.isEnabled=true
            }
            binding.textResert.id->{
                handler.removeCallbacks(runnable)
                binding.textTime.text="0"
                binding.textStart.isEnabled=true
                sayac=0
            }

        }
    }


    fun run(){
        runnable=object: Runnable {
            override fun run() {
                sayac++
                binding.textTime.text=sayac.toString()
                handler.postDelayed(runnable,1000)

            }

        }
        handler.post(runnable)

    }


}