package com.example.quizwiz

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // =============================================
    // QUIZ DATA - All our flashcard questions
    // =============================================
    private val questions = listOf(
        Flashcard("🔢 Math Magic", "2 + 2 equals 4", true),
        Flashcard("🌍 World Wonders", "The capital of France is Paris", true),
        Flashcard("💻 Code Quest", "Kotlin is a programming language", true),
        Flashcard("🧪 Science Lab", "Water boils at 100°C at sea level", true),
        Flashcard("🌍 Planet Earth", "The Earth is flat", false),
        Flashcard("📜 History Hunt", "The Titanic sank in 1912", true),
        Flashcard("🧠 Brain Teaser", "Humans have five senses", true),
        Flashcard("🔢 Number Ninja", "π equals exactly 3.14", false),
        Flashcard("🐾 Animal Kingdom", "Penguins can fly", false),
        Flashcard("🎬 Movie Mania", "The Matrix was released in 1999", true)
    )

    // =============================================
    // GAME STATE VARIABLES - Track progress & score
    // =============================================
    private var currentQuestionIndex = 0  // Which question we're on
    private var score = 0                 // Player's correct answers
    private var answered = false          // Prevent double-answering

    // =============================================
    // APP STARTUP - First thing that runs
    // =============================================
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupWelcomeScreen()  // Show the welcome screen first
    }

    // =============================================
    // WELCOME SCREEN - App introduction
    // =============================================
    private fun setupWelcomeScreen() {
        setContentView(R.layout.activity_main)  // Load welcome screen layout

        val startButton = findViewById<Button>(R.id.startButton)

        // When start button clicked, begin the quiz
        startButton.setOnClickListener {
            showQuestionScreen()
        }
    }

    // =============================================
    // QUESTION SCREEN - Show current flashcard
    // =============================================
    private fun showQuestionScreen() {
        setContentView(R.layout.question_screen)  // Load question screen layout

        // Check if we have more questions
        if (currentQuestionIndex < questions.size) {
            // Find all our UI elements
            val categoryText = findViewById<TextView>(R.id.categoryText)
            val questionText = findViewById<TextView>(R.id.questionText)
            val progressText = findViewById<TextView>(R.id.progressText)
            val trueButton = findViewById<Button>(R.id.trueButton)
            val falseButton = findViewById<Button>(R.id.falseButton)
            val nextButton = findViewById<Button>(R.id.nextButton)
            val feedbackText = findViewById<TextView>(R.id.feedbackText)

            val currentQuestion = questions[currentQuestionIndex]

            // Update UI with current question data
            categoryText.text = currentQuestion.category
            questionText.text = currentQuestion.question
            progressText.text = "Question ${currentQuestionIndex + 1}/${questions.size}"

            // Reset UI state for new question
            feedbackText.text = ""
            feedbackText.visibility = View.GONE
            nextButton.visibility = View.GONE
            trueButton.isEnabled = true
            falseButton.isEnabled = true
            answered = false

            // Set button colors
            trueButton.setBackgroundColor(Color.parseColor("#2ED573"))  // Bright Green
            falseButton.setBackgroundColor(Color.parseColor("#FF4757")) // Bright Red

            // True button click listener
            trueButton.setOnClickListener {
                if (!answered) {
                    checkAnswer(true)  // User thinks answer is True
                }
            }

            // False button click listener
            falseButton.setOnClickListener {
                if (!answered) {
                    checkAnswer(false)  // User thinks answer is False
                }
            }

            // Next button click listener
            nextButton.setOnClickListener {
                currentQuestionIndex++  // Move to next question
                showQuestionScreen()    // Show the next question
            }
        } else {
            // No more questions - show final score
            showScoreScreen()
        }
    }

    // =============================================
    // CHECK ANSWER - Validate user's response
    // =============================================
    private fun checkAnswer(userAnswer: Boolean) {
        answered = true  // Prevent multiple answers

        // Get UI elements
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)

        val correctAnswer = questions[currentQuestionIndex].answer

        // Disable buttons after answering
        trueButton.isEnabled = false
        falseButton.isEnabled = false

        // Check if user got it right
        if (userAnswer == correctAnswer) {
            score++  // Increase score for correct answer
            feedbackText.text = "Correct! 🎉"  // Positive feedback
            feedbackText.setTextColor(Color.parseColor("#2ED573"))  // Green text

            // Highlight the correct button
            if (userAnswer) {
                trueButton.setBackgroundColor(Color.parseColor("#2ED573"))  // Keep green
            } else {
                falseButton.setBackgroundColor(Color.parseColor("#2ED573"))  // Turn green
            }
        } else {
            feedbackText.text = "Wrong! ❌"  // Negative feedback
            feedbackText.setTextColor(Color.parseColor("#FF4757"))  // Red text

            // Show which was wrong and which was correct
            if (userAnswer) {
                trueButton.setBackgroundColor(Color.parseColor("#FF4757"))  // Turn red (wrong)
                falseButton.setBackgroundColor(Color.parseColor("#2ED573"))  // Turn green (correct)
            } else {
                falseButton.setBackgroundColor(Color.parseColor("#FF4757"))  // Turn red (wrong)
                trueButton.setBackgroundColor(Color.parseColor("#2ED573"))  // Turn green (correct)
            }
        }

        // Show feedback message
        feedbackText.visibility = View.VISIBLE

        // Show next button after a short delay
        Handler(Looper.getMainLooper()).postDelayed({
            nextButton.visibility = View.VISIBLE
        }, 500)
    }

    // =============================================
    // SCORE SCREEN - Show final results
    // =============================================
    private fun showScoreScreen() {
        setContentView(R.layout.score_screen)  // Load score screen layout

        // Get UI elements
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText = findViewById<TextView>(R.id.finalFeedbackText)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val restartButton = findViewById<Button>(R.id.restartButton)

        // Calculate percentage score
        val percentage = (score * 100) / questions.size

        // Display score
        scoreText.text = "$score/${questions.size}"

        // Give personalized feedback based on performance
        when {
            percentage >= 90 -> feedbackText.text = "Outstanding! 🏆\nYou're a quiz master!"
            percentage >= 75 -> feedbackText.text = "Excellent! 🌟\nGreat job!"
            percentage >= 60 -> feedbackText.text = "Good Work! 👍\nWell done!"
            else -> feedbackText.text = "Keep Practicing! 💪\nYou'll get better!"
        }

        // Review button - show all questions and answers
        reviewButton.setOnClickListener {
            showReviewScreen()
        }

        // Restart button - reset game and go back to start
        restartButton.setOnClickListener {
            currentQuestionIndex = 0  // Reset to first question
            score = 0                 // Reset score
            setupWelcomeScreen()      // Go back to welcome screen
        }
    }

    // =============================================
    // REVIEW SCREEN - Show all questions & answers
    // =============================================
    private fun showReviewScreen() {
        setContentView(R.layout.review_screen)  // Load review screen layout

        val reviewText = findViewById<TextView>(R.id.reviewText)
        val backButton = findViewById<Button>(R.id.backButton)

        // Build review content with all questions and answers
        var reviewContent = "📚 Review Your Answers\n\n"
        questions.forEachIndexed { index, flashcard ->
            val result = if (flashcard.answer) "✓ True" else "✗ False"
            val emoji = if (flashcard.answer) "✅" else "❌"
            reviewContent += "${emoji} ${flashcard.category}\n" +
                    "Q: ${flashcard.question}\n" +
                    "A: $result\n\n"
        }

        reviewText.text = reviewContent

        // Back button - return to score screen
        backButton.setOnClickListener {
            showScoreScreen()
        }
    }

    // =============================================
    // DATA CLASS - Structure for our flashcards
    // =============================================
    data class Flashcard(
        val category: String,   // Question category (Math, Science, etc.)
        val question: String,   // The actual question text
        val answer: Boolean     // Correct answer (true/false)
    )
}