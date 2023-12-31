package com.example.appdrawertest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appdrawertest.core.service.Repositories
import com.example.appdrawertest.core.request.CheckUpdateRequest
import com.example.appdrawertest.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onResume() {
        super.onResume()

        GlobalScope.launch(Dispatchers.Main) {

            Repositories.getCheckAppVersion(request = CheckUpdateRequest("https://monitorps.sardegnasalute.it/monitorps/app/versionCheck?versionCode=1.1"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}