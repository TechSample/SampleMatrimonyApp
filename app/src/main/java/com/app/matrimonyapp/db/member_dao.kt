package com.app.matrimonyapp.db

import androidx.room.*
import com.app.matrimonyapp.network.response.Results
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MemberListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMemberList(userList: List<Results>): Completable

    @Query("SELECT * FROM Member")
    fun getMemberList(): Single<List<Results>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMember(member: Results): Single<Int>

    @Query("SELECT * FROM Member WHERE status = 1")
    fun getAcceptedMembers(): Single<List<Results>>

    @Query("SELECT * FROM Member WHERE status = 2")
    fun getDeclinedMembers(): Single<List<Results>>

    @Query("DELETE from Member")
    fun deleteAll(): Completable
}
