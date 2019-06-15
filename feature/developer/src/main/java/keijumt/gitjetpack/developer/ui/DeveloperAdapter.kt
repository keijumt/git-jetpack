package keijumt.gitjetpack.developer.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import keijumt.gitjetpack.developer.databinding.ItemDeveloperBinding
import keijumt.gitjetpack.model.Owner

class DeveloperAdapter : ListAdapter<Owner, DeveloperAdapter.DeveloperViewHolder>(OwnerDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeveloperViewHolder {
        val binding = ItemDeveloperBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DeveloperViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeveloperViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DeveloperViewHolder(
        private val binding: ItemDeveloperBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(owner: Owner) {
            binding.owner = owner
            binding.executePendingBindings()
        }
    }

    private object OwnerDiff : DiffUtil.ItemCallback<Owner>() {
        override fun areItemsTheSame(oldItem: Owner, newItem: Owner): Boolean {
            return oldItem.login == newItem.login
        }

        override fun areContentsTheSame(oldItem: Owner, newItem: Owner): Boolean {
            return oldItem == newItem
        }
    }
}