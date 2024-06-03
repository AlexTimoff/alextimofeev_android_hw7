package com.example.alextimofeev_android_hw7_.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alextimofeev_android_hw7_.R
import com.example.alextimofeev_android_hw7_.databinding.FragmentQuizBinding
import com.example.alextimofeev_android_hw7_.quiz.QuizStorage


class QuizFragment : Fragment() {
    // Создаем nullable переменную для binding
    private var _binding: FragmentQuizBinding? = null

    //Геттер для переменной
    private val binding get() = _binding!!


    // Создаем View для фрагмента из файла разметки. Обязательное правило при работе с фрагментами.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentQuizBinding.inflate(inflater,container, false)
        return binding.root
    }

    //Вызывается системой для уничтожения созданной View фрагмента и освобождения памяти
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Заполняем опросник
        fillAllQuestions()

        //
        binding.buttonContinue.setOnClickListener {
            val questionList=QuizStorage.createArray()
            questionList.add(QuizStorage.quest1)
            questionList.add(QuizStorage.quest2)
            questionList.add(QuizStorage.quest3)
            questionList.add(QuizStorage.quest4)

            val numberQuestions = questionList.size
            val correctAnswers = countCorrectAnswers()

            val action = QuizFragmentDirections.actionQuizFragmentToResultFragment(correctAnswers,numberQuestions)
            findNavController().navigate(action)
        }

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_quizFragment_to_welcomeFragment)
        }
    }

    //Заполнение всего опросника
    private fun fillAllQuestions(){
        binding.question1.addAllData(QuizStorage.quest1)
        binding.question2.addAllData(QuizStorage.quest2)
        binding.question3.addAllData(QuizStorage.quest3)
        binding.question4.addAllData(QuizStorage.quest4)
    }

    //Функция подсчета правильных ответов
    private fun countCorrectAnswers():Int{
        var count=0
        if (binding.question1.isCorrectAnswer()) count++
        if (binding.question2.isCorrectAnswer()) count++
        if (binding.question3.isCorrectAnswer()) count++
        if (binding.question4.isCorrectAnswer()) count++
        return count
    }


}