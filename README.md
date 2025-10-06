# QuizWiz - Interactive Flashcard App

## App Overview
QuizWiz is a vibrant, interactive Android flashcard application built with Kotlin that helps users test their knowledge across various subjects through an engaging true/false quiz format. The app provides instant feedback, score tracking, and comprehensive review features to enhance the learning experience. Designed with modern Android development practices, QuizWiz offers a seamless user journey from welcome screen to final results with educational value at every step.

![image alt](https://github.com/tramsahai/Quiz-Wiz/blob/df45af1281c8f7803dc7db0ccd3d30fd3ae7dbf0/Screenshot%202025-10-06%20002710.png)

## Assignment Requirements Fulfilled

### User Interface Requirements
The application successfully implements all required user interface components. The Welcome Screen provides a beautiful introduction with clear app description and an intuitive start button. The Flashcard Question Screen displays questions cleanly with True/False buttons and immediate visual feedback. The Score Screen presents the final results with personalized feedback based on performance, while the Review Screen offers complete question-and-answer review functionality for learning reinforcement.

### Application Logic Requirements
QuizWiz meets all specified logic requirements through its well-structured codebase. The Welcome Screen Logic handles smooth navigation to the quiz upon button click. The Flashcard Question Logic manages sequential question iteration, answer selection with immediate feedback, score counter for correct answers, and progress tracking through the entire question series. The Score Screen Logic calculates total scores, provides personalized feedback based on performance levels, and enables comprehensive review functionality.

### Technical Requirements
Built as a native Android application using Kotlin within Android Studio, QuizWiz demonstrates modern architecture principles with Material Design components and clean code structure. The project is version control ready with comprehensive documentation for GitHub integration, following professional development standards throughout the implementation.

## Project Structure
The QuizWiz application follows a well-organized Android project structure within the app directory. At the core of the application logic is `MainActivity.kt`, located in the `java/com/example/quizwiz/` path, which contains all the Kotlin code that drives the quiz functionality, screen navigation, and user interaction handling.

The resource management is structured through several key directories. The layout folder houses four essential XML files that define the user interface screens:
- `activity_main.xml` creates the welcoming introduction screen
- `question_screen.xml` builds the interactive quiz interface
- `score_screen.xml` designs the results display
- `review_screen.xml` constructs the answer review functionality

The values directory contains crucial configuration files where:
- `colors.xml` defines the application's complete color palette and scheme
- `themes.xml` configures the overall visual theme and styling properties

Completing the project architecture is the `build.gradle.kts` file, which serves as the module-level build configuration. This file specifies all project dependencies, compilation settings, and build instructions that ensure the proper compilation, packaging, and functionality of the Android application throughout the development lifecycle.

## Features & Functionality

### Welcome Experience
QuizWiz provides an engaging introduction with eye-catching design that clearly communicates the app's purpose. The interface features intuitive start mechanics where a single tap begins the quiz journey, supported by consistent brand identity through coordinated color scheme and typography that establishes professional credibility from the first interaction.

### Interactive Quiz System
The application includes 10 diverse questions covering mathematics, science, geography, history, and pop culture with a clear category system for organized content presentation. Progress tracking features provide clear indication of current question position within the series, while instant feedback mechanisms deliver both visual and textual responses to user answers, creating an engaging learning environment.

### Smart Answer Validation
- Color-coded feedback systems use green for correct responses and red for incorrect answers
- Visual indicators showing correct answers through button color changes
- Prevention mechanisms disable buttons after selection to prevent multiple submissions
- Timed progression controls automatically reveal the next button after a brief delay, ensuring smooth gameplay flow

### Comprehensive Scoring
- Real-time tracking maintains live score updates throughout the quiz experience
- Percentage-based performance analysis
- Personalized feedback systems provide encouraging messages tailored to performance tiers:
  - 90% and above: "Outstanding! You're a quiz master!"
  - 75-89%: "Excellent! Great job!"
  - 60-74%: "Good Work! Well done!"
  - Below 60%: "Keep Practicing! You'll get better!"
  ![image alt](https://github.com/tramsahai/Quiz-Wiz/blob/46cdbc822c12f514900e11eaedeed80ea9a6f734/Screenshot%202025-10-06%20002802.png)

### Educational Review System
- Complete answer history with all questions and correct answers displayed
- Organized, categorized format by subject with clear labels
- Easy navigation enables seamless transition between review and score screens
- Allows users to learn from their mistakes and reinforce knowledge effectively

![image alt](https://github.com/tramsahai/Quiz-Wiz/blob/f4d9db29d882e99f7f5eb8f6457aecee2c782307/Screenshot%202025-10-06%20002823.png)

## Technical Implementation

### MainActivity.kt Core Logic
The application utilizes a structured data class for flashcard organization and implements key functions including:
- `setupWelcomeScreen()` for initializing the welcome interface
- `showQuestionScreen()` for displaying current questions
- `checkAnswer()` for validating user input
- `showScoreScreen()` for calculating and displaying results
- `showReviewScreen()` for presenting all questions and answers in review mode

### UI Components and Layouts
- Modern Material Design cards create elevated UI elements
- Responsive layouts using ConstraintLayout for adaptive design across various screen sizes
- Strategic color psychology enhances user experience
- Clear typography hierarchy ensures organized information presentation and readability

### State Management
Efficient state management tracks:
- Quiz progression through `currentQuestionIndex`
- Accumulates correct answers in the `score` variable
- Prevents duplicate submissions using the `answered` flag
- Ensures smooth gameplay and accurate scoring throughout the user experience

## User Journey
The application guides users through a structured learning path:
1. **Welcome Screen**: Presents app description and purpose
2. **Quiz Initiation**: Users tap start button to begin
3. **Question Interaction**: Reading questions and selecting True/False responses
4. **Immediate Feedback**: Visual and textual feedback after each answer
5. **Progression**: Continuing through all 10 questions
6. **Results**: Viewing final score and personalized performance message
7. **Review**: Optional access to review all questions and answers
8. **Restart**: Ability to begin a new quiz session

## Setup and Installation

### Prerequisites
- Android Studio (Arctic Fox or later version)
- Android SDK API 24 (Nougat) or higher for compatibility
- Kotlin plugin installed within the development environment

![image alt](https://github.com/tramsahai/Quiz-Wiz/blob/49d3d118b6e40cab9ce8382bf13fb510653bd20c/Screenshot%202025-10-06%20002613.png)

![image alt](https://github.com/tramsahai/Quiz-Wiz/blob/927cfb957b416be94a911288495cb8fa0ee94865/Screenshot%202025-10-06%20002644.png)

### Build Instructions
1. Clone the repository or create a new Android project
2. Replace default files with the provided application code
3. Synchronize Gradle dependencies to resolve all required libraries
4. Build the project using the Make Project functionality
5. Run the application on either an emulator or physical device

### Gradle Dependencies
Essential dependencies include:
- AndroidX Core KTX for Kotlin extensions
- AppCompat for backward compatibility
- Material Design components for modern UI elements
- ConstraintLayout for responsive interface design

## Learning Objectives Achieved

### Android Development Skills
- Comprehensive activity lifecycle management
- Dynamic UI updates using `setContentView()`
- Proper event handling with click listeners
- Efficient resource management for layouts, colors, and strings
- Successful Material Design implementation following Google's design guidelines

### Kotlin Programming
- Data classes for structured data organization
- List operations and iteration for question management
- Conditional logic and state management for game flow
- Proper function organization with separation of concerns

### User Experience Design
- Intuitive navigation flow between screens
- Immediate feedback systems for user actions
- Progressive disclosure of information appropriate to context
- Accessibility considerations for inclusive design practices

## Extension Possibilities

### Potential Enhancements
- Expandable question database for varied content
- Multiple difficulty levels with easy/medium/hard question sets
- Timed challenges with countdown functionality
- Achievement systems with performance badges
- Sound effects for audio feedback
- Theme options with light/dark mode toggle capabilities

### Advanced Features
- Cloud integration for progress synchronization across devices
- Social features for score sharing and friend challenges
- Analytics for tracking learning progress over time
- Custom question creation for user-generated content expansion

## Performance Considerations
- Memory efficiency through minimal object creation during runtime
- Smooth transitions with optimized layout changes
- Responsive design compatibility across various screen sizes
- Battery-friendly operation without background processes

## Troubleshooting

### Common Issues
- **Build failures**: Verify all layout file creation
- **Runtime errors**: Check package name consistency
- **UI glitches**: Validate color resource references
- **Navigation issues**: Ensure correct button ID referencing

### Testing Checklist
- [ ] Successful app launch
- [ ] Correct welcome screen display
- [ ] Sequential quiz question loading
- [ ] Immediate answer feedback functionality
- [ ] Accurate score calculation
- [ ] Complete review screen content presentation
- [ ] Proper restart functionality reset behavior

## Developer Notes
This application demonstrates fundamental Android development principles while providing an engaging user experience. The code is intentionally well-commented to serve as both a functional application and educational resource. Each component follows Android best practices and can be easily extended for more complex features. The app successfully balances educational value with entertainment, making learning an enjoyable experience through gamification and immediate feedback mechanisms.

## License and Attribution
This project was developed as an educational assignment demonstrating Android development with Kotlin. The code and structure are provided for learning purposes and may be freely used, modified, and extended for educational and personal development projects.

---

**Happy Learning with QuizWiz!**

