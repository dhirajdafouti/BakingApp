package com.hellofresh.task2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.snackbar.Snackbar
import com.hellofresh.task2.R
import com.hellofresh.task2.error.RecipeResult
import com.hellofresh.task2.adapters.RecipeAdapter
import com.hellofresh.task2.databinding.FragmentRecipeListBinding
import com.hellofresh.task2.viewmodel.RecipeListViewModel
import com.hellofresh.task2.viewmodel.RecipeListViewModelFactory
import timber.log.Timber

/**
 * This class will display the Recipe Results to the Adapter class.
 */
class RecipeListFragment : RecipeBaseFragment() {

    //Instance of View Binding
    private lateinit var binding: FragmentRecipeListBinding

    //Instance of the adapter class.
    private lateinit var adapter: RecipeAdapter

    //View Model InStance creation lazily.
    private val viewModel: RecipeListViewModel by lazy {
        val activity = requireNotNull(this.activity).application
        val viewModelFactory = RecipeListViewModelFactory(activity)
        ViewModelProvider(this, viewModelFactory).get(RecipeListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeListBinding.inflate(inflater)
        //To use a LiveData object with your binding class, you need to specify a lifecycle owner to define the scope of the LiveData object.
        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        //request to get the Recipes List from the Server.
        viewModel.triggerRecipeRequestToService()

        adapter = RecipeAdapter()

        showProgressBar()

        // add dividers between RecyclerView's row items
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        binding.listItem.addItemDecoration(decoration)

        initAdapter()

        retryButton()

        return binding.root
    }

    private fun showProgressBar() {
        viewModel.progressBar.observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.statusLoadingWheel.visibility = View.VISIBLE
            } else {
                binding.statusLoadingWheel.visibility = View.GONE
            }
        })
    }

    private fun retryButton() {
        binding.buttonRetry.setOnClickListener {
            viewModel.retryRecipeRequestToService()
        }
    }


    /**
     * Initialize the Adapter.
     */

    private fun initAdapter() {

        binding.listItem.adapter = adapter

        viewModel.repoResult.observe(viewLifecycleOwner, Observer { it ->
            when (it) {
                is RecipeResult.Success -> {
                    showEmptyList(show = it.data.isEmpty())
                    with(adapter) { submitList(it.data) }
                }

            }
        })

        viewModel.repoResult.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RecipeResult.Error -> {
                    showSnackBar(it.error)
                }
            }
        })
    }
    private fun showSnackBar(error:String) {
        val snack = Snackbar.make(binding.root, error, Snackbar.LENGTH_INDEFINITE)
        snack.setAction(getText(R.string.tryagain)) {
           viewModel.retryRecipeRequestToService()
        }
        snack.show()
    }


    private fun showEmptyList(show: Boolean) {
        if (show) {
            Timber.d("Empty List is Received.. ")
            binding.emptyList.visibility = View.VISIBLE
            binding.buttonRetry.visibility = View.VISIBLE
            binding.listItem.visibility = View.GONE
        } else {
            binding.buttonRetry.visibility = View.GONE
            binding.emptyList.visibility = View.GONE
            binding.listItem.visibility = View.VISIBLE

        }
    }

}