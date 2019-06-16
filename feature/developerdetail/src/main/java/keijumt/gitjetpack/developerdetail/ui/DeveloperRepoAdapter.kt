package keijumt.gitjetpack.developerdetail.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import keijumt.gitjetpack.developerdetail.databinding.ItemDeveloperRepoBinding
import keijumt.gitjetpack.model.Repo

class DeveloperRepoAdapter : ListAdapter<Repo, DeveloperRepoAdapter.DeveloperRepoViewHolder>(RepoDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeveloperRepoViewHolder {
        val binding = ItemDeveloperRepoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DeveloperRepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeveloperRepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DeveloperRepoViewHolder(
        private val binding: ItemDeveloperRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: Repo) {
            binding.repo = repo
            binding.executePendingBindings()
        }
    }

    private object RepoDiff : DiffUtil.ItemCallback<Repo>() {
        override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
            return oldItem == newItem
        }
    }
}