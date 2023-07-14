package com.hfad.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hfad.tasks.databinding.TaskItemBinding
import com.hfad.tasks.generated.callback.OnClickListener

class TaskItemAdapter(val clickListener: (taskID: Long) -> Unit) : ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallback()) {

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder =TaskItemViewHolder.inflateFrom(parent)

    class TaskItemViewHolder(val binding: TaskItemBinding) :RecyclerView.ViewHolder(binding.root){
        companion object{
            fun inflateFrom(parent: ViewGroup):TaskItemViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater,parent,false)
                return TaskItemViewHolder(binding)
            }
        }
        fun bind(item :Task,clickListener: (taskID: Long) -> Unit){
            binding.task = item
            binding.root.setOnClickListener{clickListener(item.taskId)}
        }
    }

}