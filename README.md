# Eyoj Satellites Information App

https://github.com/user-attachments/assets/1e558a63-34e9-4a09-b1ae-59b8086d819f


## Description
The **Eyoj Satellites Information App** is a Compose Multiplatform (CMP) application designed to display information about satellites. The app allows users to:

- View a list of satellites with their active/inactive status.
- Search for satellites by name.
- Access detailed information about a specific satellite.
- Track real-time satellite positions.

This app is implemented using **Compose Multiplatform** and supports Android, iOS, and Desktop platforms.

---

## Features

- **Satellite List Screen**: Displays satellites with their current status (active/inactive).
- **Search Feature**: Filter the satellite list by name.
- **Satellite Detail Screen**: View detailed information about a specific satellite.
- **Real-time Tracking**: Observe the position and movement of satellites.

---

## Screenshots

| Feature                | Screenshot |
|------------------------|------------|
| Satellite List Screen  | <img src="https://github.com/user-attachments/assets/a1aae115-1b9f-47f3-bb99-65425e0d99c0" width="200" height="400" /> |
| Satellite Detail Screen| <img src="https://github.com/user-attachments/assets/0b7da477-3233-4294-81d7-c9f4b9c8952a" width="200" height="400" /> |

---

## Technologies Used

### Framework
- **Compose Multiplatform (CMP)**

### Libraries
- **Koin**: Dependency injection for managing app components.
- **Kotlinx Serialization**: JSON parsing and serialization.
- **StateFlow**: UI state management.

### Architecture
- **Clean Architecture**: Modular, maintainable, and scalable code structure.
- **MVVM**: Model-View-ViewModel for UI logic.

---

## Project Structure

### Modules

#### 1. **Common Module**
- **Purpose**: Contains shared logic and resources for all platforms.
- **Structure**:
  - `composeResources`: Shared resources like JSON files and drawable assets.
  - `core`: Business logic, domain models, and use cases.
  - `satellites`: Satellite list and search functionality.
  - `satellitedetail`: Satellite detail and position tracking.

#### 2. **Android Module**
- Platform-specific implementations for Android (e.g., JSON reading).

#### 3. **Desktop Module**
- Platform-specific implementations for Desktop (e.g., window management).

#### 4. **iOS Module**
- Platform-specific implementations for iOS.

### Key Folders

| Folder                 | Description                                            |
|------------------------|--------------------------------------------------------|
| `commonMain`           | Shared code across platforms.                          |
| `androidMain`          | Android-specific implementations.                      |
| `desktopMain`          | Desktop-specific implementations.                      |
| `iosMain`              | iOS-specific implementations.                          |

---

## How to Build and Run

### Prerequisites

1. **Install Kotlin Multiplatform Plugin**: Ensure that you have Kotlin Multiplatform plugin installed in your IDE.
2. **Supported Platforms**:
   - Android: Minimum API 21 (Lollipop).
   - iOS: Minimum iOS 14.
   - Desktop: JVM 11 or higher.

### Clone the Repository
```bash
git clone https://github.com/EyoJneSinE/EyojSatellitesInformationC.git
cd EyojSatellitesInformationC
```

### Run on Android
1. Open the project in Android Studio.
2. Select the Android target.
3. Click "Run".

### Run on iOS
1. Open the `iosApp` module in Xcode.
2. Select a simulator or device target.
3. Click "Run".

### Run on Desktop
1. Execute the following command in the `composeApp` directory:
```bash
gradlew :composeApp:desktopRun
```

---

## Contact

For any inquiries or contributions, please contact:
- **Name**: Enis Kaner
- **GitHub**: [EyoJneSinE](https://github.com/EyoJneSinE)



