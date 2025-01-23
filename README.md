# ShowSpotter - The Movies App

**ShowSpotter** is an Android application designed to help users discover and explore movies seamlessly. 

---


## Features

- **Movie Discovery:**
  - Browse a wide range of movies and web series fetched from the TMDB (The Movie Database) API.
  - Discover trending, popular, and top-rated content effortlessly.

- **Search Functionality:**
  - Find movies by entering keywords in the search bar.
  - Enjoy quick, accurate results to discover your favorite titles.

- **Detailed Movie Information:**
  - View details such as title, rating, release year, and more for each movie.
  - View comprehensive details for each movie and web series, including:
  - **Title**
  - **Rating**
  - **Release Year**
  - **Synopsis**
  - **Genre**

- **Favorite List and Watchlist:**
 - Save your favorite movies and web series to revisit them anytime.
 - Add movies and web series to your personalized watchlist to keep track of what to watch next.

---

## Designs
![Alt text](app/src/main/res/drawable/app_interface.png)

## App Workflow
![Alt text](app/src/main/res/drawable/app_workflow.png)


## Technical Details

- **Programming Language:** Kotlin
- **Framework:** Jetpack Compose
- **Networking:** Retrofit
- **Architecture:** MVVM (Model-View-ViewModel)
- **Authentication:** Firebase Authentication
- **Data Storage:** Firebase Realtime Database

---

## Important Note

The TMDB API is not accessible in India. To run this application within India, please use a VPN service (e.g., Turbo VPN) to connect to a server outside of India.

---

## Installation

To run this application locally, follow these steps:

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/ivikashgorai/ShowSpotter-The-Movies-App.git
   ```

2. **Open in Android Studio:**
   - Open Android Studio.
   - Navigate to the cloned repository folder and select it.

3. **Build the Project:**
   - Sync the Gradle files.
   - Build the project using `Build > Make Project`.

4. **Run the App:**
   - Connect an Android device or start an emulator.
   - Click the `Run` button or use `Shift + F10`.

---

## API Key Setup

This app uses the TMDB API to fetch movie data. To access the API, you need to obtain an API key from TMDB.

1. **Obtain an API Key:**
   - Register for an account at [TMDB](https://www.themoviedb.org/).
   - Navigate to your account settings and generate a new API key.

2. **Configure the API Key in the App:**
   - Locate the `Constants.kt` file in the project.
   - Replace the placeholder with your actual API key:

     ```kotlin
     const val API_KEY = "your_api_key_here"
     ```

---

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes.
4. Push your branch and create a Pull Request.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

For any queries or suggestions, feel free to reach out:

- **GitHub:** [ivikashgorai](https://github.com/ivikashgorai)
- **Email:** [vikashwork321@gmail.com]

---

Thank you for checking out ShowSpotter! If you like this project, consider giving it a star! ⭐

