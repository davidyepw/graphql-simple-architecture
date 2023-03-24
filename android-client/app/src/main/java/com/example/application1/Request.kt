package com.example.application1

import com.google.gson.annotations.SerializedName

class Request(
    var id: String,
    var name: String,
    var edad: Int,
    //val accounts: List<String>
    var accounts: List<Account>
    //var rates: Currency

)