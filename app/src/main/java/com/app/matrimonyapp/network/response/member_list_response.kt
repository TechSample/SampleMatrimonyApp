package com.app.matrimonyapp.network.response

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MemberListResponse (

    @Expose @SerializedName("results") val results : List<Results>,
    @Expose @SerializedName("info") val info : Info
) : Parcelable

@Entity(tableName = "Member")
@Parcelize
data class Results (

    @Expose @SerializedName("gender") val gender : String?,
    @Expose @SerializedName("name") @Embedded(prefix = "name_") val name : Name ?,
    @Expose @SerializedName("location") @Embedded(prefix = "location_") val location : Location ?,
    @Expose @SerializedName("email") val email : String?,
    @Expose @SerializedName("login") @Embedded(prefix = "login_") val login : Login ?,
    @Expose @SerializedName("dob") @Embedded(prefix = "dob_") val dob : Dob ?,
    @Expose @SerializedName("registered") @Embedded(prefix = "registered_") val registered : Registered ?,
    @Expose @SerializedName("phone") val phone : String?,
    @Expose @SerializedName("cell") val cell : String?,
    @Expose @SerializedName("id") @Embedded(prefix = "id_") val id : Id ?,
    @Expose @SerializedName("picture") @Embedded(prefix = "picture_") val picture : Picture ?,
    @Expose @SerializedName("nat") val nat : String?,
    var status : Int = -1,
    @PrimaryKey(autoGenerate = true)
    var mid : Int

) : Parcelable

@Parcelize
data class Info (

    @Expose @SerializedName("seed") val seed : String?,
    @Expose @SerializedName("results") val results : Int,
    @Expose @SerializedName("page") val page : Int,
    @Expose @SerializedName("version") val version : Double
) : Parcelable

@Parcelize
data class Coordinates(

    @Expose @SerializedName("latitude") val latitude : Double,
    @Expose @SerializedName("longitude") val longitude : Double
) : Parcelable

@Parcelize
data class Dob (

    @Expose @SerializedName("date") val date : String?,
    @Expose @SerializedName("age") val age : Int
) : Parcelable

@Parcelize
data class Id (

    @Expose @SerializedName("name") val name : String?,
    @Expose @SerializedName("value") val value : String?
) : Parcelable

@Parcelize
data class Location (

    @Expose @SerializedName("street") @Embedded(prefix = "street_") val street : Street ?,
    @Expose @SerializedName("city") val city : String?,
    @Expose @SerializedName("state") val state : String?,
    @Expose @SerializedName("country") val country : String?,
    @Expose @SerializedName("postcode") val postcode : Int,
    @Expose @SerializedName("coordinates") @Embedded(prefix = "coordinates_") val coordinates : Coordinates ?,
    @Expose @SerializedName("timezone") @Embedded(prefix = "timezone_") val timezone : Timezone ?
) : Parcelable

@Parcelize
data class Login (

    @Expose @SerializedName("uuid") val uuid : String?,
    @Expose @SerializedName("username") val username : String?,
    @Expose @SerializedName("password") val password : String?,
    @Expose @SerializedName("salt") val salt : String?,
    @Expose @SerializedName("md5") val md5 : String?,
    @Expose @SerializedName("sha1") val sha1 : String?,
    @Expose @SerializedName("sha256") val sha256 : String?
) : Parcelable

@Parcelize
data class Name (

    @Expose @SerializedName("title") val title : String ?,
    @Expose @SerializedName("first") val first : String ?,
    @Expose @SerializedName("last") val last : String ?
) : Parcelable

@Parcelize
data class Picture (

    @Expose @SerializedName("large") val large : String ?,
    @Expose @SerializedName("medium") val medium : String ?,
    @Expose @SerializedName("thumbnail") val thumbnail : String ?
) : Parcelable

@Parcelize
data class Registered (

    @Expose @SerializedName("date") val date : String ?,
    @Expose @SerializedName("age") val age : Int
) : Parcelable

@Parcelize
data class Street (

    @Expose @SerializedName("number") val number : Int,
    @Expose @SerializedName("name") val name : String ?
) : Parcelable

@Parcelize
data class Timezone (

    @Expose @SerializedName("offset") val offset : String ?,
    @Expose @SerializedName("description") val description : String ?
) : Parcelable
