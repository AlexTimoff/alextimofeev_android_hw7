package com.example.alextimofeev_android_hw7_.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.alextimofeev_android_hw7_.R
import com.example.alextimofeev_android_hw7_.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()

    // Создаем View для фрагмента из файла разметки.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }


    //Вызывается системой для уничтожения созданной View фрагмента и освобождения памяти
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showScore()

        binding.tryAgain.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_quizFragment)
        }
    }

    private fun showScore(){
        val maxScores = args.possibleScore
        val scoredPoints = args.pointsScored
        val res = "Your result $scoredPoints/$maxScores"
        binding.result.text = res
    }
}