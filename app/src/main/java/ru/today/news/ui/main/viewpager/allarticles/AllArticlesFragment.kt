package ru.today.news.ui.main.viewpager.allarticles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import ru.today.news.R
import ru.today.news.ui.main.viewpager.ArticlesFragment
import ru.today.news.ui.main.viewpager.ArticlesView

class AllArticlesFragment : ArticlesFragment<IAllArticlesViewModel>(), ArticlesView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.reloadData() }
        if (savedInstanceState == null) { binding.swipeRefreshLayout.isRefreshing = true }
        viewModel.reloadData()
    }


    // View

    override fun onRefresh(success: Boolean) {
        super.onRefresh(success)

        if (!success) {
            Snackbar.make(binding.recyclerView, "Could not load countries", Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.snackbar_action_retry) { viewModel.reloadData() }
                .show()
        }
    }
}