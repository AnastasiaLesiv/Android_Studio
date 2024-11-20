package com.example.lab_2.ui.transition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lab_2.databinding.FragmentTransitionBinding
import com.example.lab_2.R

class TransitionFragment : Fragment() {

    private var _binding: FragmentTransitionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransitionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*binding.textTransition.setOnClickListener {
            Toast.makeText(requireContext(), "Натиснуто текст", Toast.LENGTH_SHORT).show()
            // Переходимо до OtherActivity при натисканні на текст
            val intent = Intent(requireContext(), TabbedActivity::class.java)
            startActivity(intent)
        }*/
        binding.textTransition.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_to_tabbed_activity) // Використання глобальної дії
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
