package com.example.lwork35

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lwork35.databinding.FragmentFirstBinding
import java.util.*

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Навігація до другого фрагмента
        binding.btnToSecond.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        // Зміна мови на англійську
        binding.buttonEnglish.setOnClickListener {
            setLocale("en")
        }

        // Зміна мови на українську
        binding.buttonUkrainian.setOnClickListener {
            setLocale("uk")
        }
    }

    // Функція для зміни мови
    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)

        requireActivity().resources.updateConfiguration(config, requireActivity().resources.displayMetrics)
        requireActivity().recreate() // Перезавантаження фрагмента для відображення змін
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
