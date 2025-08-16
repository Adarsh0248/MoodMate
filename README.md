
# 🧠 Welcome to MoodMate!

Hey there! Welcome to MoodMate, a little Java app we built to help people (like us!) get better at building habits, keeping an eye on their mood, and getting a bit of smart, personalized feedback along the way. We designed this whole thing with a big focus on solid Object-Oriented Programming (OOP) principles.

## ✨ What Can It Do?

MoodMate is packed with features for both everyday users and the admin running the show.

#### For You (The User)

* **Log In & Sign Up:** A secure and simple way to keep your personal progress private.
* **Track Your Habits:** Add, view, and check off your daily habits.
* **Get Motivated by Streaks:** We automatically track your consecutive day streaks and cheer you on when you hit milestones like 3, 7, 14, or even 30 days!
* **Log Your Mood:** Quickly jot down how you're feeling (Happy, Sad, Tired, etc.) and add any notes about your day.
* **Get Smart Suggestions:** Our simple "AI" looks for keywords in your notes and offers up a thoughtful suggestion.
* **Daily Dose of Inspiration:** Get a random quote tailored to your mood to give you a little boost.

#### For the Admin

* **See the Big Picture:** Check out a full list of all registered users and see who's an admin.
* **Check the Stats:** Get a quick look at how the app is being used, like the total number of users, habits, and moods logged.
* **Be the Inspirer:** Add new quotes to the app's collection.
* **Share the Power:** Promote a regular user to an Admin.

## 🛠️ How It's Built

We built this project from the ground up using core OOP ideas to keep our code clean, flexible, and easy to build upon.

* **Inheritance & Abstraction:** We started with an `abstract Person` class as a blueprint. Both `User` and `Admin` classes inherit from it, which means they share common traits but have their own unique menus and abilities.
* **Polymorphism:** We use a single `Person currentUser` variable to handle whoever is logged in. At runtime, we use `instanceof` to check if it's a `User` or an `Admin` and show the right set of options. It's like having one remote that can control two different devices.
* **Encapsulation:** We've kept our data safe! All the important variables in our classes are `private` or `protected`. The only way to interact with them is through `public` methods, which acts as a protective barrier.
* **Composition:** Our `User` class is built like a Lego set. It's "composed" of other objects, holding `ArrayLists` of `Habit` and `MoodLog` objects to keep all of a user's data neatly organized.

#### The Core Classes

* **`Person`**: The abstract blueprint for anyone in the system.
* **`User`**: You! This class holds your personal lists of habits and moods.
* **`Admin`**: The superuser with special privileges.
* **`Habit`**: The brains behind each habit, including all the logic for calculating streaks.
* **`MoodLog`**: A simple class to store your mood and notes for a given day.
* **`MoodAnalyzer`**: Our rule-based "AI" that scans your notes for keywords.
* **`QuoteManager`**: The little engine that loads and serves up daily quotes.
* **`DataManager`**: The unsung hero that saves and loads all your data so you never lose progress.

## 🚀 Getting Started

#### What You'll Need

* Java Development Kit (JDK) 21 or higher.
* A cool IDE like IntelliJ IDEA or VS Code.

#### Let's Get it Running

1.  **Clone the repo:**
    ```bash
    git clone [https://github.com/Adarsh0248/MoodMate-Java-Project.git](https://github.com/Adarsh0248/MoodMate-Java-Project.git)
    ```
2.  **Open the project** in your IDE.
3.  **Find the main file** at `src/com/moodmate/main/ModeMateApp.java`.
4.  **Hit the run button** on the `main()` method to start the app!

#### First-Time Login

* When you first launch the app, we've already created one default admin account for you to play with.
* **Email:** `admin@moodmate.com`
* **Password:** `admin123`

## 💻 Tech We Used

* **Language:** Java
* **Core Concepts:** Object-Oriented Programming, Data Structures & Algorithms
* **Tools:** Git, GitHub, IntelliJ IDEA
* **Libraries:** JUnit 5 (for testing)

## 🧑‍💻 The Team

This project was proudly brought to life by:

* **Adarsh Kumar** - System Architect
    * Find me on GitHub: [Adarsh0248](https://github.com/Adarsh0248)
* **Aman Kumar Jha** - User Experience & Data Integrator
    * Find me on GitHub: [amanxsays](https://github.com/amanxsays)
=======
🧠 Welcome to MoodMate!
Hey there! Welcome to MoodMate, a little Java app we built to help people (like us!) get better at building habits, keeping an eye on their mood, and getting a bit of smart, personalized feedback along the way. We designed this whole thing with a big focus on solid Object-Oriented Programming (OOP) principles.

✨ What Can It Do?
MoodMate is packed with features for both everyday users and the admin running the show.

For You (The User)
Log In & Sign Up: A secure and simple way to keep your personal progress private.

Track Your Habits: Add, view, and check off your daily habits.

Get Motivated by Streaks: We automatically track your consecutive day streaks and cheer you on when you hit milestones like 3, 7, 14, or even 30 days!

Log Your Mood: Quickly jot down how you're feeling (Happy, Sad, Tired, etc.) and add any notes about your day.

Get Smart Suggestions: Our simple "AI" looks for keywords in your notes and offers up a thoughtful suggestion.

Daily Dose of Inspiration: Get a random quote tailored to your mood to give you a little boost.

For the Admin
See the Big Picture: Check out a full list of all registered users and see who's an admin.

Check the Stats: Get a quick look at how the app is being used, like the total number of users, habits, and moods logged.

Be the Inspirer: Add new quotes to the app's collection.

Share the Power: Promote a regular user to an Admin.

🛠️ How It's Built
We built this project from the ground up using core OOP ideas to keep our code clean, flexible, and easy to build upon.

Inheritance & Abstraction: We started with an abstract Person class as a blueprint. Both User and Admin classes inherit from it, which means they share common traits but have their own unique menus and abilities.

Polymorphism: We use a single Person currentUser variable to handle whoever is logged in. At runtime, we use instanceof to check if it's a User or an Admin and show the right set of options. It's like having one remote that can control two different devices.

Encapsulation: We've kept our data safe! All the important variables in our classes are private or protected. The only way to interact with them is through public methods, which acts as a protective barrier.

Composition: Our User class is built like a Lego set. It's "composed" of other objects, holding ArrayLists of Habit and MoodLog objects to keep all of a user's data neatly organized.

The Core Classes
Person: The abstract blueprint for anyone in the system.

User: You! This class holds your personal lists of habits and moods.

Admin: The superuser with special privileges.

Habit: The brains behind each habit, including all the logic for calculating streaks.

MoodLog: A simple class to store your mood and notes for a given day.

MoodAnalyzer: Our rule-based "AI" that scans your notes for keywords.

QuoteManager: The little engine that loads and serves up daily quotes.

DataManager: The unsung hero that saves and loads all your data so you never lose progress.

🚀 Getting Started
What You'll Need
Java Development Kit (JDK) 21 or higher.

A cool IDE like IntelliJ IDEA or VS Code.

Let's Get it Running
Clone the repo:

git clone https://github.com/Adarsh0248/MoodMate-Java-Project.git

Open the project in your IDE.

Find the main file at src/com/moodmate/main/ModeMateApp.java.

Hit the run button on the main() method to start the app!

First-Time Login
When you first launch the app, we've already created a default admin account for you to play with.

Email: admin@moodmate.com

Password: admin123

💻 Tech We Used
Language: Java

Core Concepts: Object-Oriented Programming, Data Structures & Algorithms

Tools: Git, GitHub, IntelliJ IDEA

Libraries: JUnit 5 (for testing)

🧑‍💻 The Team
This project was proudly brought to life by:

Adarsh Kumar - System Architect

Find me on GitHub: Adarsh0248

Aman Kumar Jha - User Experience & Data Integrator

Find me on GitHub: amanxsays

