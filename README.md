# SharedPreferences Android App

## Aim
To develop an Android application using Kotlin that stores and retrieves user data persistently using SharedPreferences in Android Studio.

## Description
This application demonstrates how to store user information locally on an Android device using SharedPreferences. The app automatically saves the user's name, email, and phone number whenever the input fields are modified. The saved data is retrieved automatically when the application is reopened.

## Technologies Used
- **Language:** Kotlin
- **IDE:** Android Studio
- **UI Design:** XML
- **Storage:** SharedPreferences
- **Android Component:** AppCompatActivity

## Features
- Automatically saves user input.
- Stores name, email, and phone number locally.
- Retrieves previously saved data when the app launches.
- Displays the saved user details.
- Provides a button to retrieve stored information.
- Provides a button to clear all saved data.
- Maintains data across application restarts.

## Project Structure

```text
SharedPreferencesApp/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/sharedpreferencesapp/
│           │       └── MainActivity.kt
│           └── res/
│               └── layout/
│                   └── activity_main.xml
├── build.gradle.kts
└── README.md
```

## Implementation

### 1. SharedPreferences
SharedPreferences is an Android storage mechanism used to save small amounts of data in key-value pairs.

### 2. Automatic Data Saving
The `TextWatcher` interface detects changes in the input fields and saves the updated values automatically.

### 3. Data Retrieval
The `getString()` method retrieves previously stored values when the application starts.

### 4. Data Clearing
The `clear()` method removes all entries from the application's preferences file.

## Important Methods

| Method | Description |
|---|---|
| `getSharedPreferences()` | Opens the preferences file |
| `edit()` | Begins editing preferences |
| `putString()` | Stores a string value |
| `getString()` | Retrieves a string value |
| `apply()` | Saves changes asynchronously |
| `clear()` | Removes all entries from the preferences file |

## Screenshot

<img width="1216" height="2640" alt="WhatsApp Image 2026-10-15 at 11 36 51 AM" src="https://github.com/user-attachments/assets/0923254a-d25c-4d6e-8242-cb827ae73f63" />


## Procedure
1. Create a new Android project using Kotlin in Android Studio.
2. Design the user interface using XML.
3. Create input fields for name, email, and phone number.
4. Implement SharedPreferences in `MainActivity.kt`.
5. Use `TextWatcher` to save data automatically.
6. Implement data retrieval and clearing functionality.
7. Run the application on an emulator or Android device.
8. Verify that the data persists after closing and reopening the application.

## Expected Output
The application displays input fields for the user's name, email, and phone number. When the user enters or modifies information, it is saved automatically. The previously saved details are restored when the app is reopened.

## Result
Thus, an Android application was developed successfully using Kotlin and SharedPreferences to store, retrieve, and clear user data persistently.

## Conclusion
This experiment demonstrates local data persistence in Android using SharedPreferences. It helps understand key-value storage, automatic data saving, and retrieval of data across application restarts.

## Note
SharedPreferences data is generally removed when the application is uninstalled or its storage is cleared. It should not be used to store passwords or other sensitive information without an appropriate security mechanism.
