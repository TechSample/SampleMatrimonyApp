package com.app.matrimonyapp.user_list

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.matrimonyapp.R
import com.app.matrimonyapp.databinding.ItemUserBinding
import com.app.matrimonyapp.network.response.Results
import com.bumptech.glide.Glide

class UserListAdapter(
    val context: Context,
    private val viewModel: UserListViewModel,
    private val showMemberStatus: Boolean = true
) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    var userList = ArrayList<Results>()
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemUserBinding = ItemUserBinding.inflate(mInflater, parent, false)
        return UserViewHolder(itemUserBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var item = userList[position]
        holder.itemBinding.user = item
        holder.itemBinding.tvName.text = item.name!!.title + ". " + item.name!!.first + " "+item.name!!.last + " , " + item.dob!!.age + " , "+item.gender
        holder.itemBinding.tvLocation.text = item.location!!.city+" , "+ item.location!!.country + " , "+item.location!!.postcode
      //  holder.itemBinding.showBookmark = showBookmark
        if(this.showMemberStatus){
           holder.itemBinding.txtAccept.visibility = View.VISIBLE
           holder.itemBinding.txtDecline.visibility = View.VISIBLE
        }else{
            holder.itemBinding.txtAccept.visibility = View.GONE
            holder.itemBinding.txtDecline.visibility = View.GONE
        }
        if(item.status == 1){
            holder.itemBinding.txtAccept.text = context.getString(R.string.member_accepted)
            holder.itemBinding.txtDecline.setBackgroundDrawable(context.resources.getDrawable(R.drawable.disabled_rounded_corner))
            holder.itemBinding.profileImage.borderColor = context.resources.getColor(R.color.colorPrimary)

        }else if(item.status == 2){
            holder.itemBinding.txtDecline.text = context.getString(R.string.member_declined)
            holder.itemBinding.txtAccept.setBackgroundDrawable(context.resources.getDrawable(R.drawable.disabled_rounded_corner))
            holder.itemBinding.profileImage.borderColor = context.resources.getColor(R.color.colorBlue)


        }
        Glide.with(context).load(item.picture!!.large).error(R.drawable.ic_default_pic).into(holder.itemBinding.profileImage)
        holder.itemBinding.txtAccept.setOnClickListener {
            if (item.status == 0) {
                item.status = 1
                viewModel.changeMemberAcceptStatus(item)
                holder.itemBinding.txtAccept.text = context.getString(R.string.member_accepted)
                holder.itemBinding.txtDecline.setBackgroundDrawable(context.resources.getDrawable(R.drawable.disabled_rounded_corner))

            }
//            } else {
//              //  item.status = 0
//              //  holder.itemBinding.txtAccept.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
//            }
        }
        holder.itemBinding.txtDecline.setOnClickListener {
            if (item.status == 0) {
                item.status = 2
                viewModel.changeMemberDeclineStatus(item)
                holder.itemBinding.txtDecline.text = context.getString(R.string.member_declined)
                holder.itemBinding.txtAccept.setBackgroundDrawable(context.resources.getDrawable(R.drawable.disabled_rounded_corner))

            }
//            } else {
//               // item.status = 0
//              //  holder.itemBinding.txtDecline.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
//            }
        }
    }

    override fun getItemId(position: Int) = position.toLong()
    override fun getItemViewType(position: Int) = position

    fun updateList(userList: ArrayList<Results>) {
        this.userList.clear()
        this.userList.addAll(userList)
        notifyDataSetChanged()
    }

    override fun getItemCount() = userList.size


    class UserViewHolder(val itemBinding: ItemUserBinding) : RecyclerView.ViewHolder(itemBinding.root)
}