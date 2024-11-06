package com.example.examatejetpackcomposetask.screens.questions.data

import com.example.examatejetpackcomposetask.screens.questions.domain.Question
import com.example.examatejetpackcomposetask.screens.questions.domain.QuestionRepository
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor() : QuestionRepository {
    override suspend fun getOralQuestions(): List<Question> {
        return listOf(
            Question(
                "Events",
                "Task 2",
                "Je suis votre collègue, je participe chaque année à un événement culturel dans notre ville. C'est une excellente occasion pour nous de célébrer la diversité et d'apprendre de nouvelles choses sur différentes cultures. Cela me permet aussi de rencontrer des gens intéressants et de partager des expériences enrichissantes.",
                "13 May 2023",
                11,
                100
            ),
            Question(
                "Technology",
                "Task 3",
                "Quand quelqu'un quitte son pays pour s'installer à l'étranger, il doit souvent faire face à de nombreux défis. Par exemple, il doit s'adapter à une nouvelle culture, apprendre une nouvelle langue et faire face à des différences dans le mode de vie. Ce processus peut être à la fois passionnant et difficile, car il implique de laisser derrière soi des amis et des membres de la famille.",
                "13 May 2023",
                12,
                70
            ),
            Question(
                "Health",
                "Task 4",
                "La santé mentale est tout aussi importante que la santé physique. De nos jours, de plus en plus de gens prennent conscience de l'importance de prendre soin de leur bien-être mental. Cela inclut des pratiques telles que la méditation, l'exercice régulier et la discussion de ses sentiments avec des amis ou des professionnels. En investissant dans notre santé mentale, nous pouvons améliorer notre qualité de vie et notre capacité à faire face au stress.",
                "13 May 2023",
                13,
                80
            ),
            Question(
                "Education",
                "Task 5",
                "L'éducation est un pilier fondamental de notre société. Elle joue un rôle crucial dans le développement personnel et professionnel des individus. De nos jours, l'éducation ne se limite pas seulement à l'apprentissage en classe, mais englobe également des compétences essentielles telles que la pensée critique, la créativité et la collaboration. Ces compétences sont indispensables pour réussir dans un monde en constante évolution.",
                "13 May 2023",
                14,
                90
            )
        )
    }

    override suspend fun getWritingQuestions(): List<Question> {
        return listOf(
            Question("Voyage", "10 sur 10 Questions", "Progress 100%", "13 May 2023", 5, 100),
            Question("Art et Culture", "5 sur 10 Questions", "Progress 50%", "13 May 2023", 7, 50),
            Question("Technology", "7 sur 10 Questions", "Progress 70%", "10 May 2023", 6, 70),
            Question("Environment", "3 sur 10 Questions", "Progress 30%", "9 May 2023", 4, 30),
            Question("Travel", "8 sur 10 Questions", "Progress 80%", "11 May 2023", 7, 80),
            Question("Immigration", "6 sur 10 Questions", "Progress 60%", "12 May 2023", 5, 60)
        )
    }
}
