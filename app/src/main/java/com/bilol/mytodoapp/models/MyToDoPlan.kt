package com.bilol.mytodoapp.models


data class MyToDoPlan(
    var name: String = "",
    var description: String = "",
    var degree:User? = null,
    var createData:String = "",
    var dedline:String = "",
    var level:String = "",

)
