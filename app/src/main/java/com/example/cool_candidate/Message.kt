package com.example.cool_candidate

data class Message(
    val contactNumber: String?,
    val contactName: String?,
    val myDisplayName: String?,
    val jobTittle: String?,
    val startDate: String?,
    val immediateStart: Boolean?,
    val includeJunior: Boolean?,
) : java.io.Serializable {

    fun getFullJobTittle() = if (includeJunior!!) "a Junior $jobTittle" else "$jobTittle"
    fun getStartImmediatly() = if (immediateStart!!) "immediately" else "on $startDate"
}
