package com.example.challenge.presentation.screen.log_in

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.challenge.data.mapper.base.BaseFragment
import com.example.challenge.databinding.FragmentLogInBinding
import com.example.challenge.presentation.extension.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LogInFragment : BaseFragment<FragmentLogInBinding>(FragmentLogInBinding::inflate) {

    private val viewModel: LogInViewModel by viewModels()

    override fun bind() {

    }

    override fun bindViewActionListeners() {
        binding.btnLogIn.setOnClickListener {
            logIn()
        }
    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.logInState.collect {
                    handleLogInState(logInState = it)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEvent.collect {
                    handleNavigationEvents(event = it)
                }
            }
        }
    }

    private fun logIn() {
        viewModel.onEvent(
            LogInEvent.LogIn(
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString()
            )
        )
    }

    private fun handleLogInState(logInState: LogInState) {
        binding.loaderInclude.loaderContainer.isVisible = logInState.isLoading
    }

    private fun handleNavigationEvents(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.NavigateToConnections -> findNavController().navigate(
                LogInFragmentDirections.actionLogInFragmentToConnectionsFragment()
            )

            is LoginUiEvent.ShowError -> {
                binding.root.showSnackBar(message = event.message)
            }
        }
    }
}
