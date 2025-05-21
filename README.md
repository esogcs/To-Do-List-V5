# To-Do List Android Application

A comprehensive Android application that combines event management, location tracking, and calculator functionality.

## Features

- **Event Management**
  - Create and edit events
  - Store events in Room database
  - View events in a list format
  - Mark events as complete

- **Location Features**
  - Record event locations
  - View events on Google Maps
  - Location-based event tracking

- **Calculator**
  - Basic arithmetic operations
  - Double-tap navigation from home screen
  - Accessible from navigation drawer

- **Navigation**
  - Bottom navigation bar
  - Navigation drawer
  - Double-tap to calculator
  - Smooth transitions between screens

## Technical Details

- Built with Kotlin and Jetpack Compose
- Uses Room for local database
- Implements Google Maps integration
- Includes Mockito unit testing
- Material Design 3 components

## Installation

1. Clone the repository:
```bash
git clone https://github.com/esogcs/to-do-list-v5.git
```

2. Open the project in Android Studio

3. Build and run the application:
```bash
./gradlew assembleDebug
```

## Testing

The application includes unit tests using Mockito:
- Calculator functionality tests
- Double-tap navigation tests
- Event handling tests

## Requirements

- Android Studio Arctic Fox or newer
- Android SDK 34 or higher
- Google Play Services
- Google Maps API Key

## Author

[Your Name]

## License

This project is licensed under the MIT License - see the LICENSE file for details
