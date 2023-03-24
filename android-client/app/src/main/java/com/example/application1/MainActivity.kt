package com.example.application1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.application1.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL
import java.net.HttpURLConnection


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("TAG", "b4 fetchstart")
        fetchCurrencyData().start()
    }

    private fun fetchCurrencyData(): Thread
    {

        return Thread {
            Log.d("TAG", "inside fetchstart")
            val url = URL("http://10.0.2.2:8086/getpersonaccount?name=11111111")
            val urlAddress = URL("http://10.0.2.2:8085/getpersonaddress?name=11111111")
            Log.d("TAG", "after URL set value")
            val connection  = url.openConnection()  as HttpURLConnection
            Log.d("TAG", connection.responseCode.toString())


            if(connection.responseCode == 200)
            {
                //Log.d("TAG", "Inside if connection == 200");

                val inputSystem = connection.inputStream
                val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")
                val request = Gson().fromJson(inputStreamReader, Request::class.java)
                updateUI(request)
                inputStreamReader.close()
                inputSystem.close()


            }
            else
            {
                Log.d("TAG", connection.responseCode.toString())
                binding.baseCurrency.text = "Failed Connection"
            }

            val connectionAddress  = urlAddress.openConnection()  as HttpURLConnection
            if(connectionAddress.responseCode == 200)
            {
                //Log.d("TAG", "Inside if connection == 200");

                val inputSystemAddress = connectionAddress.inputStream
                val inputStreamReaderAddress = InputStreamReader(inputSystemAddress, "UTF-8")
                val requestAddress = Gson().fromJson(inputStreamReaderAddress, RequestAddress::class.java)
                updateUIAddress(requestAddress)
                inputStreamReaderAddress.close()
                inputSystemAddress.close()


            }
            else
            {
                Log.d("TAG", connection.responseCode.toString())
                binding.baseCurrency.text = "Failed Connection"
            }
        }

    }



    private fun updateUI(request: Request)
    {
        runOnUiThread {
            kotlin.run {
                binding.lastUpdated.text = request.name
                binding.nzd.text = buildString {
                    append("DNI: ")
                    append(request.id)
                }
                binding.baseCurrency.text = buildString {
                    append("edad: ")
                    append(request.edad.toString())
                }

                binding.cuentas.text = buildString {
                    append("cuentas: ")
                    request.accounts.forEach { s -> Log.d("TAG", "accounts: ${s.accountNum}") }
                    //append(request.accounts)
                    //Log.d("TAG", request.dataMap[1].accountNum)
                    //request.accounts.forEach { s -> append(s.accountNum)  }
                    request.accounts.forEach { s -> append("\n" +
                             s.accountNum)  }

                }

// BOTTOM PANEL
//                binding.gbp.text = request.name

 //               binding.usd.text = buildString {
 //                   append("Direcciones: ")
 //                   append(request.name)

  //              }

                //binding.gbp.text = String.format("GBP: %.2f", request.rates.GBP)
            }
            }
    }
    private fun updateUIAddress(requestAddress: RequestAddress)
    {
        runOnUiThread {
            kotlin.run {

// BOTTOM PANEL
                binding.gbp.text = requestAddress.name

                binding.usd.text = buildString {
                    append("Direcciones: ")
                    requestAddress.address.forEach { s -> append("\n" +
                            s.descripcion)  }

                }

                //binding.gbp.text = String.format("GBP: %.2f", request.rates.GBP)
            }
        }
    }
}
